package com.yq.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yq.entity.Comment;
import com.yq.entity.User;
import com.yq.service.CommentService;
import com.yq.service.impl.CommentServiceImpl;
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

@WebServlet(name = "CommentServlet", urlPatterns = "/control/comment")
public class CommentServlet extends HttpServlet {
    private static final long serialVersionUID = -3241702177161042009L;
    private static final int COMMENT_NUMBERS_PER_PAGE = 6;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String opr = request.getParameter("opr");
        int id = Integer.parseInt(request.getParameter("id")); //当前blog的Id
        CommentService commentService = new CommentServiceImpl();
        if (opr.equals("commentList")) {
            try {
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
                pageObj.setPageSize(COMMENT_NUMBERS_PER_PAGE);    // 设置每页显示条数
                commentService.getCommentsByPage(id, pageObj); //分页查询
                //评论列表
                List<Comment> list = pageObj.getCommentList();
                //生成json数据
                String commentsJson = JSON.toJSONStringWithDateFormat(pageObj, "yyyy年MM月dd日 HH:mm", SerializerFeature.WriteMapNullValue);
                PrintWriter out = response.getWriter();
                out.print(commentsJson);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("add")) {
            PrintWriter out = response.getWriter();
            String content = request.getParameter("ta1");
            StringBuffer json = new StringBuffer("{");
            if (content == null || content.equals("")) {
                json.append("\"result\":0,\"message\":\"回复不能为空！请重新填写回复！\"");
            } else {
                try {
                    Comment comment = new Comment();
                    comment.setUid(((User) session.getAttribute("user")).getId());
                    comment.setBid(id);
                    comment.setContent(content);
                    int result = commentService.addComment(comment);
                    if (result > 0) {
                        //添加成功
                        json.append("\"result\":1,\"message\":\"回复成功！\"");
                    } else {
                        //添加失败，给出提示
                        json.append("\"result\":0,\"message\":\"回复失败！请重新填写回复！\"");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            json.append("}");
            out.print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
