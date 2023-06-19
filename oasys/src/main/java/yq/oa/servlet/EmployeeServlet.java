package yq.oa.servlet;

import yq.oa.entity.Employee;
import yq.oa.service.EmployeeService;
import yq.oa.service.impl.EmployeeServiceImpl;
import yq.oa.util.DateUtil;
import yq.oa.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/control/employee")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = -3939788861110647343L;
    private static final int EMPLOYEE_NUMBERS_PER_PAGE = 5;
    private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
    // 允许的图片类型
    private String ALLOW_IMG_TYPE = "image/png;image/jpg;image/jpeg;image/gif";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opr = request.getParameter("opr");
        PrintWriter out = response.getWriter();
        String contextPath = request.getContextPath();
        EmployeeService employeeService = new EmployeeServiceImpl();
        if (opr.equals("list")) {
            try {
                String name = (request.getParameter("empName") != null) ? request.getParameter("empName").trim() : "";
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
                Page pageObj = new Page();
                pageObj.setCurrPageNo(currPageNo);    // 设置当前页码
                pageObj.setPageSize(EMPLOYEE_NUMBERS_PER_PAGE);    // 设置每页显示条数
                employeeService.getEmployeesByPage(name, pageObj);
                request.setAttribute("list", pageObj.getEmployeeList());
                request.setAttribute("pageObj", pageObj);
                request.setAttribute("searchName", name);
                request.getRequestDispatcher("../jsp/user/empl_list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("toModify")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Employee empl = employeeService.getEmployeeById(id);
                request.setAttribute("employee", empl);
                request.getRequestDispatcher("../jsp/user/empl_modify.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("modify") || opr.equals("addNew")) {
            Employee emp = new Employee();
            if (opr.equals("modify")) {
                int id = Integer.parseInt(request.getParameter("id"));
                emp.setId(id);
            }
            try {
                Collection<Part> parts = request.getParts();
                String encoding = request.getCharacterEncoding();
                for (Part part : parts) {
                    if (part.getName().equals("name")) {
                        String name = getValue(part, encoding);
                        if (checkValue(out, name, "用户姓名")) {
                            emp.setName(name);
                        } else {
                            return;
                        }
                    } else if (part.getName().equals("employeeNo")) {
                        String employeeNo = getValue(part, encoding);
                        if (checkValue(out, employeeNo, "员工工号")) {
                            emp.setEmployeeNo(employeeNo);
                        } else {
                            return;
                        }
                    } else if (part.getName().equals("email")) {
                        emp.setEmail(getValue(part, encoding));
                    } else if (part.getName().equals("entryTime")) {
                        String entryTime = getValue(part, encoding);
                        System.out.println(entryTime);
                        if (checkValue(out, entryTime, "入职时间")) {
                            emp.setEntryTime(DateUtil.string2Date(entryTime));
                        } else {
                            return;
                        }
                    } else if (part.getName().equals("department")) {
                        emp.setDeptId(Integer.parseInt(getValue(part, encoding)));
                    } else if (part.getName().equals("position")) {
                        emp.setPositionId(Integer.parseInt(getValue(part, encoding)));
                    } else if (part.getName().equals("fileField")) {
                        if (part.getSize() != 0) {
                            String uploadFilePath = request.getSession().getServletContext()
                                    .getRealPath("upload/");
                            //如果上传路径不存在，则新建目录
                            File fileSaveDir = new File(uploadFilePath);
                            if (!fileSaveDir.exists()) {
                                fileSaveDir.mkdir();
                            }
                            //验证文件格式
                            String contentType = part.getContentType();
                            List<String> allowTypes = Arrays.asList(ALLOW_IMG_TYPE.split(";"));
                            if (!(contentType == null || "".equals(contentType.trim()))
                                    && allowTypes.contains(contentType)) {
                                //提取文件名
                                String fileName = extractFileName(part);
                                String suffix = getSuffix(fileName);
                                //名字避免重复使用UUID+后缀
                                String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
                                //将文件写入指定目录
                                String location = uploadFilePath + File.separator + newFileName;
                                part.write(location);
                                emp.setPhoto("upload/" + newFileName);
                            } else {
                                //文件格式不符合要求
                                out.println("<script type='text/javascript'>");
                                out.println("alert('上传失败，允许的文件格式为gif格式、jpg格式和png格式！');");
                                out.println("window.history.back(-1);");
                                out.println("</script>");
                                out.flush();
                                out.close();
                                return;
                            }
                        }
                    }
                }
                //更新数据库
                int result = 0;
                if (opr.equals("modify")) {
                    result = employeeService.updateEmployee(emp);
                    if (result > 0) {
                        request.setAttribute("message", "操作成功！");
                        request.getRequestDispatcher("../message.jsp").forward(request, response);
                    } else {
                        out.println("<script type='text/javascript'>");
                        out.println("alert('操作失败！请联系管理员！');");
                        out.println("window.history.back(-1);");
                        out.println("</script>");
                        out.flush();
                        out.close();
                        return;
                    }
                }
                if (opr.equals("addNew")) {
                    result = employeeService.addNewEmployee(emp);
                    if (result > 0) {
                        request.setAttribute("message", "操作成功！");
                        request.getRequestDispatcher("../message.jsp").forward(request, response);
                    } else if (result == -1) {
                        out.println("<script type='text/javascript'>");
                        out.println("alert('员工工号已存在，请重新填写！');");
                        out.println("window.history.back(-1);");
                        out.println("</script>");
                        out.flush();
                        out.close();
                        return;
                    } else {
                        out.println("<script type='text/javascript'>");
                        out.println("alert('操作失败！请联系管理员！');");
                        out.println("window.history.back(-1);");
                        out.println("</script>");
                        out.flush();
                        out.close();
                        return;
                    }
                }
            } catch (IllegalStateException e) {
                //文件超出限制
                out.println("<script type='text/javascript'>");
                out.println("alert('上传文件失败！上传文件大小必须在2MB以内！');");
                out.println("window.history.back(-1);");
                out.println("</script>");
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                int result = employeeService.deleteEmployeeById(id);
                if (result > 0) {
                    //删除成功
                    out.println("<script type='text/javascript'>");
                    out.println("alert('删除成功！');");
                    out.println("window.location=\"" + contextPath + "/control/employee?opr=list\";");
                    out.println("</script>");
                    out.flush();
                    out.close();
                } else {
                    //删除失败
                    out.println("<script type='text/javascript'>");
                    out.println("alert('删除失败！请稍后再试!');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("detail")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Employee empl = employeeService.getEmployeeById(id);
                request.setAttribute("employee", empl);
                request.getRequestDispatcher("../jsp/user/empl_view.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("updatePwd")) {
            Employee emp = (Employee) request.getSession().getAttribute("employee");
            String oldPwd = request.getParameter("oldPwd");
            String newPwd1 = request.getParameter("newPwd1");
            if (oldPwd.equals(emp.getPassword())) {
                //执行更新操作
                try {
                    int result = new EmployeeServiceImpl().updatePassword(emp.getId(), newPwd1);
                    if (result > 0) {
                        //更新成功
                        request.setAttribute("message", "密码更新成功！");
                        request.getRequestDispatcher("../message.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('原始密码错误，请重新输入!');");
                out.println("window.history.back(-1);");
                out.println("</script>");
                out.flush();
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 从HTTP header中提取上传文件的名称
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    /**
     * 获取文件后缀
     */
    private String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 返回给定part的文本内容
     */
    private String getValue(Part part, String encoding) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(part.getInputStream(), encoding));
        StringBuilder value = new StringBuilder();
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
            value.append(buffer, 0, length);
        }
        return value.toString();
    }

    private boolean checkValue(PrintWriter out, String val, String tip) {
        if (val == null || val.equals("")) {
            //返回当前页面并给出提示
            out.println("<script type='text/javascript'>");
            out.println("alert(\"请填写" + tip + "!\");");
            out.println("window.history.back(-1);");
            out.println("</script>");
            out.flush();
            out.close();
            return false;
        } else {
            return true;
        }
    }
}
