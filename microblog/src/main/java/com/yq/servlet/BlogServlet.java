package com.yq.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yq.entity.Blog;
import com.yq.entity.Likes;
import com.yq.entity.User;
import com.yq.service.*;
import com.yq.service.impl.*;
import com.yq.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BlogServlet", urlPatterns = "/control/blog")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1464398363393974477L;
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    //微博列表每页显示的条数
    private static final int BLOG_NUMBERS_PER_PAGE = 5;
    // 允许的图片类型
    private String ALLOW_IMG_TYPE = "image/png;image/jpg;image/jpeg;image/gif";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String opr = request.getParameter("opr");
        BlogService blogService = new BlogServiceImpl();
        FollowService followService = new FollowServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        CollectionService collectionService = new CollectionServiceImpl();
        LikesService likesService = new LikesServiceImpl();
        Integer uid = ((User) session.getAttribute("user")).getId();
        if (opr.equals("myBlogList")) {
            //我的微博列表
            try {
                String keyword = (request.getParameter("keyword") != null) ? request.getParameter("keyword").trim() : "";
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
                blogService.getMyBlogsByPage(uid, keyword, pageObj); //分页查询

                List<Blog> myBlogList = pageObj.getBlogsList();
                for (Blog blog : myBlogList) {
                    blog.setCommentCount(commentService.getCommentCountByBid(blog.getId()));
                    blog.setCollectionCount(collectionService.getCollectionCountByBid(blog.getId()));
                    if (blog.getState() == 1) {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getId()));
                    } else {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getOrigin().getId()));
                    }
                    blog.setLikesCount(likesService.getLikeCountByBid(blog.getId()));
                }
                //序列化为JSON格式的数据
                String blogsJson = JSON.toJSONStringWithDateFormat(pageObj, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(blogsJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("allBlogList")) {
            //分页显示我的首页微博列表
            try {
                String keyword = (request.getParameter("keyword") != null) ? request.getParameter("keyword").trim() : "";
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
                blogService.getAllBlogsByPage(uid, keyword, pageObj); //分页查询微博
                List<Blog> allBlogList = pageObj.getBlogsList();
                for (Blog blog : allBlogList) {
                    blog.setCommentCount(commentService.getCommentCountByBid(blog.getId()));
                    blog.setCollectionCount(collectionService.getCollectionCountByBid(blog.getId()));
                    if (blog.getState() == 1) {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getId()));
                    } else {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getOrigin().getId()));
                    }
                    blog.setLikesCount(likesService.getLikeCountByBid(blog.getId()));
                }
                //序列化为JSON格式的数据
                String blogsJson = JSON.toJSONStringWithDateFormat(pageObj, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(blogsJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("popBlogList")) {
            //热门微博列表
            try {
                String keyword = (request.getParameter("keyword") != null) ? request.getParameter("keyword").trim() : "";
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
                blogService.getPopBlogsByPage(uid, keyword, pageObj);//分页查询
                List<Blog> popBlogList = pageObj.getBlogsList();
                for (Blog blog : popBlogList) {
                    blog.setCommentCount(commentService.getCommentCountByBid(blog.getId()));
                    blog.setCollectionCount(collectionService.getCollectionCountByBid(blog.getId()));
                    if (blog.getState() == 1) {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getId()));
                    } else {
                        blog.setForwardCount(blogService.getForwardCountByBid(blog.getOrigin().getId()));
                    }
                    blog.setLikesCount(likesService.getLikeCountByBid(blog.getId()));
                    blog.getUser().setFollowed(followService.isFollowed(uid, blog.getuId()));
                }
                //序列化为JSON格式的数据
                String blogsJson = JSON.toJSONStringWithDateFormat(pageObj, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(blogsJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("delete")) {
            //删除一条微博
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                int result = blogService.deleteBlog(id);
                StringBuffer json = new StringBuffer("{");
                if (result > 0) {
                    json.append("\"result\":1,\"message\":\"删除成功！\"");
                } else {
                    json.append("\"result\":0,\"message\":\"删除失败！请稍后再试! \"");
                }
                json.append("}");
                System.out.println(json);
                PrintWriter out = response.getWriter();
                out.print(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("publish")) {
            //发布一条新微博
            PrintWriter out = response.getWriter();
            Blog blog = new Blog();
            try {
                Collection<Part> parts = request.getParts();
                String encoding = request.getCharacterEncoding();
                for (Part part : parts) {
                    if (part.getName().equals("hiddenTextField")) {
                        String content = getValue(part, encoding);
                        if (content == null || content.equals("")) {
                            StringBuffer json = new StringBuffer("{\"result\":0,\"message\":\"微博内容不能为空，请重新填写！\"}");
                            out.print(json);
                            return;
                        }
                        blog.setContent(content);
                    } else if (part.getName().equals("filefield")) {
                        if (part.getSize() != 0) {
                            String uploadFilePath = request.getSession().getServletContext()
                                    .getRealPath("upload/");
                            //如果上传路径不存在，则新建目录
                            File fileSaveDir = new File(uploadFilePath);
                            if (!fileSaveDir.exists()) {
                                fileSaveDir.mkdir();
                            }
                            //验证文件格式
                            String contentType = part.getContentType();
                            List<String> allowTypes = Arrays.asList(ALLOW_IMG_TYPE.split(";"));
                            if (!(contentType == null || "".equals(contentType.trim()))
                                    && allowTypes.contains(contentType)) {
                                //提取文件名
                                String fileName = extractFileName(part);
                                String suffix = getSuffix(fileName);
                                //名字避免重复使用UUID+后缀
                                String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
                                //将文件写入指定目录
                                String location = uploadFilePath + File.separator + newFileName;
                                part.write(location);
                                blog.setImages("upload/" + newFileName);
                            } else {
                                //文件格式不符合要求
                                StringBuffer json = new StringBuffer("{\"result\":0,\"message\":\"上传失败，允许的文件格式为gif格式、jpg格式和png格式！\"}");
                                out.print(json);
                                return;
                            }
                        }
                    }
                }

                //添加微博到数据库
                blog.setuId(uid);
                int result = blogService.addNewBlog(blog);
                if (result > 0) {
                    //添加成功，刷新微博列表
                    String contextPath = request.getContextPath();
                    StringBuffer json = new StringBuffer("{\"result\":1,\"message\":\"发布成功！\"}");
                    out.print(json);
                } else {
                    //添加失败，给出提示
                    StringBuffer json = new StringBuffer("{\"result\":0,\"message\":\"发布失败！请重新填写！\"}");
                    out.print(json);
                }
            } catch (IllegalStateException e) {
                //文件超出限制
                StringBuffer json = new StringBuffer("{\"result\":0,\"message\":\"上传文件失败！上传文件大小必须在2MB以内！\"}");
                out.print(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("detail")) {
            int id = Integer.parseInt(request.getParameter("id")); //当前blog的Id
            try {
                Blog blog = blogService.getBlogById(id);
                blog.setCommentCount(commentService.getCommentCountByBid(blog.getId()));
                blog.setCollectionCount(collectionService.getCollectionCountByBid(blog.getId()));
                if (blog.getState() == 1) {
                    blog.setForwardCount(blogService.getForwardCountByBid(blog.getId()));
                } else {
                    blog.setForwardCount(blogService.getForwardCountByBid(blog.getOrigin().getId()));
                }
                blog.setLikesCount(likesService.getLikeCountByBid(blog.getId()));
                if (blog.getuId() != uid) {
                    //非当前用户发布的微博
                    if (blog != null) {
                        blog.getUser().setFollowed(followService.isFollowed(uid, blog.getuId()));
//                        org.microblog.entity.Collection collection = collectionService.findCollection(uid, blog.getId());
//                        blog.setCollected((collection != null) ? true : false);
                    }
                }
                Likes likes = likesService.findLikes(uid, blog.getId());
                blog.setLiked(likes != null);
                //生成JSON
                String blogJson = JSON.toJSONStringWithDateFormat(blog, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(blogJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("forward")) {
            //转发一条微博
            int forwardBlogId = Integer.parseInt(request.getParameter("blogId"));
            String content = request.getParameter("content");
            try {
                int result = blogService.forwardBlog(uid, content, forwardBlogId);
                StringBuffer json = new StringBuffer("{");
                if (result > 0) {
                    json.append("\"result\": 1,\"message\":\"转发成功！\"");
                } else {
                    json.append("\"result\": 0,\"message\":\"转发失败！请重试！\"");
                }
                json.append("}");
                PrintWriter out = response.getWriter();
                out.print(json);
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

    /**
     * 从HTTP header中提取上传文件的名称
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    /**
     * 获取文件后缀
     */
    private String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 返回给定part的文本内容
     */
    private String getValue(Part part, String encoding) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(part.getInputStream(), encoding));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }
}
