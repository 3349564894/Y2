package yq.oa.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "EncodeFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "encode", value = "utf-8")})
public class EncodeFilter implements Filter {
    private String encode = null;

    public void destroy() {
        encode = null;
    }

    // 对所有页面设置字符集
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encode);  //设置request的编码格式
            response.setContentType("text/html;charset=" + encode); //设置response字符编码
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encode");
        if (this.encode == null) {
            this.encode = encode;
        }
    }
}
