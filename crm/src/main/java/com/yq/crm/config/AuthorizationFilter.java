package com.yq.crm.config;

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
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            httpServletRequest.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("UTF-8");
            httpServletResponse.setCharacterEncoding("text/html;charset=UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.print("<script>alert('功能受限,请先登录');location.href='" + httpServletRequest.getContextPath() + "/'</script>");
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
