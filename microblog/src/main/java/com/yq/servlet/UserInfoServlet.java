package com.yq.servlet;

import com.yq.entity.User;
import com.yq.service.BlogService;
import com.yq.service.FollowService;
import com.yq.service.impl.BlogServiceImpl;
import com.yq.service.impl.FollowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet", urlPatterns = "/control/userInfo")
public class UserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = -3090207605107005719L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer uid = ((User) session.getAttribute("user")).getId();
        BlogService blogService = new BlogServiceImpl();
        FollowService followService = new FollowServiceImpl();
        try {
            StringBuffer json = new StringBuffer("{");
            json.append("\"blogCount\":" + blogService.getBlogCount(uid) + ",");
            json.append("\"followerCount\":" + followService.getFollowedCount(uid) + ",");
            json.append("\"fansCount\":" + followService.getFansCount(uid));
            json.append("}");
            PrintWriter out = response.getWriter();
            out.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
