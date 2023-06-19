package yq.oa.servlet;

import yq.oa.entity.Employee;
import yq.oa.service.EmployeeService;
import yq.oa.service.impl.DepartmentServiceImpl;
import yq.oa.service.impl.EmployeeServiceImpl;
import yq.oa.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/control/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 3355803028362645900L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        HttpSession session = request.getSession();
        String employeeNo = request.getParameter("employeeNo").trim();
        String password = request.getParameter("password").trim();
        EmployeeService employeeService = new EmployeeServiceImpl();
        try {
            Employee emp = employeeService.findEmployee(employeeNo, password);
            if (emp != null) {
                session.setAttribute("employee", emp);
                session.setAttribute("departmentList", new DepartmentServiceImpl().getAllDepartments());
                session.setAttribute("positionList", new PositionServiceImpl().getAllPositions());
                session.setMaxInactiveInterval(60 * 60);
                response.sendRedirect(contextPath + "/index.jsp");
            } else {
                String errorMsg = "登录账号与密码不匹配";
                session.setAttribute("error", errorMsg);
                response.sendRedirect(contextPath + "/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
