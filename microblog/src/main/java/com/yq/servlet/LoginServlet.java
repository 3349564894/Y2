package com.yq.servlet;

import com.yq.entity.User;
import com.yq.service.UserService;
import com.yq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/control/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -6452860145577170667L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String contextPath = request.getContextPath();
        HttpSession session = request.getSession();
        String userId = request.getParameter("userId").trim();
        String password = request.getParameter("passWord").trim();
        String checkbox = request.getParameter("checkbox");
        boolean isAutoLogin = false;
        if (checkbox != null && checkbox.equals("checked")) {
            isAutoLogin = true;
        }
        UserService userService = new UserServiceImpl();
        User user = null;
        try {
            user = userService.findUser(userId, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        if (user == null) {
            out.print(0);
        } else {
            //设置登录用户信息
            session.setAttribute("user", user);
            //设置session过期时间
            session.setMaxInactiveInterval(60 * 60);
            //检查用户是否选择自动d登录
            if (isAutoLogin) {
                // 如果选择自动登录，则设置cookie并发送客户端
                Cookie cookie1 = new Cookie("userId", userId);
                Cookie cookie2 = new Cookie("password", password);
                //设置过期时间为1天
                cookie1.setMaxAge(60 * 60 * 24);
                cookie2.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            } else {
                // 如果没有选择自动登录，则删除cookie
                Cookie[] cookies = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userId")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                    if (cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
            //登录成功
            out.print(1);
        }
    }
}
