package com.yq.web;

import com.mysql.cj.Session;
import com.yq.entity.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Interceptor extends HandlerInterceptorAdapter {
    private Logger logger = Logger.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws IOException {
        logger.debug("进入自定义拦截器==》Interceptor");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (null == User.class) {
            response.sendRedirect(request.getContextPath() + "/401.jsp");
            return false;
        }
        return true;
    }
}
