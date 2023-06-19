package com.yq.servlet;

import com.yq.entity.User;
import com.yq.service.UserService;
import com.yq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/control/updateUser")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1435597868232539590L;
    // 允许的图片类型
    private String ALLOW_IMG_TYPE = "image/png;image/jpg;image/jpeg;image/gif";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opr = request.getParameter("opr");
        HttpSession session = request.getSession();
        UserService userService = new UserServiceImpl();
        if (opr.equals("updateImg")) {
            //更新用户头像
            String uploadFilePath = request.getSession().getServletContext()
                    .getRealPath("upload/");
            String message = "";
            try {
                //如果上传路径不存在，则新建目录
                File fileSaveDir = new File(uploadFilePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                //获取Part对象
                Part part = request.getPart("fileField");
                String contentType = part.getContentType();
                List<String> allowTypes = Arrays.asList(ALLOW_IMG_TYPE.split(";"));
                //类型在允许的范围内
                if (!(contentType == null || "".equals(contentType.trim()))
                        && allowTypes.contains(contentType)) {
                    //提取文件名
                    String fileName = extractFileName(part);
                    String suffix = getSuffix(fileName);
                    String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;//名字避免重复使用UUID+后缀
                    //将文件写入指定目录
                    String location = uploadFilePath + File.separator + newFileName;
                    part.write(location);

                    //更新数据库
                    User user = ((User) session.getAttribute("user")).clone();
                    user.setImage("upload/" + newFileName);
                    int result = userService.updateUser(user);
                    if (result > 0) {
                        //更新session
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getHeader("Referer"));//返回并刷新
                    } else {
                        //更新失败
                        out.println("<script type='text/javascript'>");
                        out.println("alert('头像更新失败！请重试！');");
                        out.println("window.history.back(-1);");
                        out.println("</script>");
                    }
                } else {
                    out.println("<script type='text/javascript'>");
                    out.println("alert('上传失败，文件类型只能是gif格式、jpg格式和png格式！');");
                    out.println("window.history.back(-1);");
                    out.println("</script>");
                }

            } catch (IllegalStateException e) {
                //文件超出限制
                out.println("<script type='text/javascript'>");
                out.println("alert('上传文件失败！上传文件大小必须在2MB以内！');");
                out.println("window.history.back(-1);");
                out.println("</script>");
            } catch (Exception e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        } else if (opr.equals("updateAccount")) {
            //更新用户账户信息
            String nickname = request.getParameter("textfield1");
            String realname = request.getParameter("textfield2");
            String email = request.getParameter("textfield3");
            String mysite = request.getParameter("textfield4");
            String sign = request.getParameter("textfield5");
            String ispublic = request.getParameter("sec");
            StringBuffer json = new StringBuffer("{");
            if (nickname != null && !nickname.equals("") && realname != null && !realname.equals("") && email != null && !email.equals("")) {
                try {
                    User user = ((User) session.getAttribute("user")).clone();
                    user.setNickname(nickname.trim());
                    user.setName(realname.trim());
                    user.setEmail(email.trim());
                    user.setMysite(mysite.trim());
                    user.setSign(sign.trim());
                    user.setIspublic(ispublic);

                    int result = userService.updateUser(user);
                    if (result > 0) {
                        //更新session
                        session.setAttribute("user", user);
                        //更新成功
                        json.append("\"result\":1,\"message\":\"账户信息更新成功！\"");
                    } else {
                        //更新失败
                        json.append("\"result\":0,\"message\":\"账户信息更新失败！请重试！\"");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //提示输入必要信息
                json.append("\"result\":0,\"message\":\"请填写完整信息！\"");
            }
            json.append("}");
            out.print(json);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
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
}
