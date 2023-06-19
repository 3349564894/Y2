package com.yq.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationFilter implements Filter {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (httpServletRequest.getSession().getAttribute("loginUser") == null) {
            httpServletResponse.setContentType("text/html;charset");
            PrintWriter out = httpServletResponse.getWriter();
            out.print("<script>alert('功能受限,请先登录');location.href='" + httpServletRequest.getContextPath() + "/login.jsp'</script>");
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
