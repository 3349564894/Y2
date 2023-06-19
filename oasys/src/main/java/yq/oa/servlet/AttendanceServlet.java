package yq.oa.servlet;

import yq.oa.entity.Employee;
import yq.oa.service.AttendanceService;
import yq.oa.service.impl.AttendanceServiceImpl;
import yq.oa.util.DateUtil;
import yq.oa.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AttendanceServlet", urlPatterns = "/control/attendance")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 5957464950687626962L;
    private static final int ATTENDANCE_NUMBERS_PER_PAGE = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opr = request.getParameter("opr");
        HttpSession session = request.getSession();
        Employee emp = (Employee) request.getSession().getAttribute("employee");
        PrintWriter out = response.getWriter();
        AttendanceService attendanceService = new AttendanceServiceImpl();
        if (opr.equals("signIn")) {
            String now = DateUtil.now();
            try {
                int result = attendanceService.addSignInByEmployeeId(emp.getId(), now);
                if (result > 0) {
                    //提示打卡成功
                    request.setAttribute("message", "打卡成功！");
                    request.getRequestDispatcher("../message.jsp").forward(request, response);
                } else if (result == 0) {
                    //提示上班已打卡，不允许重复打卡
                    out.println("<script type='text/javascript'>");
                    out.println("alert('您已完成今日上班打卡，请不要重复操作！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                } else {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('上班打卡失败，请稍后重试或联系系统管理员！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("signOut")) {
            String now = DateUtil.now();
            try {
                int result = attendanceService.addSignOutByEmployeeId(emp.getId(), now);
                if (result > 0) {
                    //提示打卡成功
                    request.setAttribute("message", "打卡成功！");
                    request.getRequestDispatcher("../message.jsp").forward(request, response);
                } else if (result == 0) {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('您今日未完成上班打卡操作，不能进行下班打卡。请先执行上班打卡操作！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                } else if (result == -2) {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('您已完成今日下班打卡，请不要重复操作！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                } else {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('下班打卡失败，请稍后重试或联系系统管理员！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("list")) {
            try {
                String name = (request.getParameter("empName") != null) ? request.getParameter("empName").trim() : "";
                String searchDate = (request.getParameter("searchDate"));
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
                pageObj.setPageSize(ATTENDANCE_NUMBERS_PER_PAGE);    // 设置每页显示条数
                attendanceService.getAttendancesByPage(name, searchDate, pageObj);
                request.setAttribute("list", pageObj.getAttendanceList());
                request.setAttribute("pageObj", pageObj);
                request.setAttribute("searchName", name);
                request.setAttribute("searchDate", searchDate);
                System.out.println(request.getContextPath());
                request.getRequestDispatcher("../jsp/attendance/attendance_list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
