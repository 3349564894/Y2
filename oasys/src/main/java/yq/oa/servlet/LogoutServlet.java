package yq.oa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = -582569515583657522L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁会话
        request.getSession().invalidate();
        //跳转到登录
        PrintWriter out = response.getWriter();
        out.println("<script language=\"javascript\">");
        out.println("if(window.opener==null){" +
                "window.top.location.href=\"login.jsp\";}");
        out.println("else{" +
                "window.opener.top.location.href=\"login.jsp\";" +
                "window.close();}");
        out.println("</script>");
        out.flush();
        out.close();
    }
}
