package yq.oa.servlet;


import yq.oa.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "LoginFilter", urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        //获取请求的URI
        String path = req.getRequestURI();
        //获取session中员工对象
        Employee emp = (Employee) req.getSession().getAttribute("employee");
        //登录页面不需要过滤
        if ("/oasys/login.jsp".equals(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            if (emp != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //跳转登录页面
                res.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {
    }
}
