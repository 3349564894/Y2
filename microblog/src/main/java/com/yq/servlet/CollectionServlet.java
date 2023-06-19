package com.yq.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yq.entity.Blog;
import com.yq.entity.Collection;
import com.yq.entity.User;
import com.yq.service.*;
import com.yq.service.impl.*;
import com.yq.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CollectionServlet", urlPatterns = "/control/collection")
public class CollectionServlet extends HttpServlet {
    private static final long serialVersionUID = -7206414254869542548L;
    //每页显示的条数
    private static final int BLOG_NUMBERS_PER_PAGE = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        HttpSession session = request.getSession();
        String opr = request.getParameter("opr");
        int userId = ((User) session.getAttribute("user")).getId();
        CollectionService collectionService = new CollectionServiceImpl();
        if (opr.equals("collectOrCancel")) {
            int id = Integer.parseInt(request.getParameter("id")); //当前blog的Id
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //收藏一条微博
            try {
                if (collectionService.findCollection(userId, id) == null) {
                    //收藏一条微博
                    Collection collection = new Collection();
                    collection.setUid(userId);
                    collection.setBid(id);
                    int result = collectionService.addCollection(collection);
                    if (result > 0) {
                        //收藏成功
                        out.println("{\"result\":1,\"message\":\"收藏成功! \"}");
                    } else {
                        //收藏失败
                        out.println("{\"result\":0,\"message\":\"收藏失败！请重试！ \"}");
                    }
                } else {
                    //提示取消收藏
                    Collection collection = new Collection();
                    collection.setUid(userId);
                    collection.setBid(id);
                    int result = collectionService.deleteCollection(collection);
                    if (result > 0) {
                        //取消收藏成功
                        out.println("{\"result\":1,\"message\":\"取消收藏成功! \"}");
                    } else {
                        //取消收藏失败
                        out.println("{\"result\":0,\"message\":\"取消收藏失败！请重试！ \"}");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("list")) {
            String keyword = (request.getParameter("keyword") != null) ? request.getParameter("keyword").trim() : "";
            try {
                BlogService blogService = new BlogServiceImpl();
                FollowService followService = new FollowServiceImpl();
                CommentService commentService = new CommentServiceImpl();
                LikesService likesService = new LikesServiceImpl();
                String pageIndex = request.getParameter("pageIndex");//获得当前页数
                if (pageIndex == null
                        || (pageIndex = pageIndex.trim()).length() == 0) {
                    pageIndex = "1";
                }
                int currPageNo = Integer.parseInt(pageIndex);
                // 对首页与末页进行控制
                if (currPageNo < 1) {
                    currPageNo = 1;
                }
                // 总页数需要查询记录总数后计算得到，故末页控制在业务方法中进行
                Page pageObj = new Page();
                pageObj.setCurrPageNo(currPageNo);    // 设置当前页码
                pageObj.setPageSize(BLOG_NUMBERS_PER_PAGE);    // 设置每页显示条数
                collectionService.getCollectionsByPage(userId, keyword, pageObj);//分页查询

                //我收藏的微博列表
                List<Blog> collectBlogList = pageObj.getBlogsList();
                for (Blog blog : collectBlogList) {
                    blog.setCommentCount(commentService.getCommentCountByBid(blog.getId()));
                    blog.setCollectionCount(collectionService.getCollectionCountByBid(blog.getId()));
                    if (blog.getState() == 1) {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getId()));
                    } else {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getOrigin().getId()));
                    }
                    blog.setLikesCount(likesService.getLikeCountByBid(blog.getId()));
                    blog.getUser().setFollowed(followService.isFollowed(userId, blog.getuId()));
                }
                //序列化为JSON格式的数据
                String blogsJson = JSON.toJSONStringWithDateFormat(pageObj, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(blogsJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
