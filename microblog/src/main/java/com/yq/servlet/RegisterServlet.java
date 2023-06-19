package com.yq.servlet;

import com.yq.entity.User;
import com.yq.service.UserService;
import com.yq.service.impl.UserServiceImpl;
import com.yq.util.DateUtil;
import com.yq.util.RLSMSUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "RegisterServlet", urlPatterns = "/control/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = -5691917997491659197L;
    private static final String DEFAULT_HEAD_IMG = "images/headicon1.jpg";
    private static final String CODE_VALID_TIME = "1";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String opr = request.getParameter("opr");
        PrintWriter out = response.getWriter();
        if (opr.equals("checkUser")) {
            String userTel = request.getParameter("userTel").trim();
            User user = new User();
            user.setUserId(userTel);
            UserService userService = new UserServiceImpl();
            try {
                boolean used = userService.findUsers(userTel);
                out.print(used);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("getCode")) {
            String phone = request.getParameter("phone");
            //生成6位验证码
            String verifyCode = String.valueOf(new Random().nextInt(8999) + 1000);
            Map result = RLSMSUtil.sendSMS(phone, "0000", CODE_VALID_TIME);
            if ("000000".equals(result.get("statusCode"))) {
                //将验证码和开始时间存储在Session中
                session.setAttribute("verifyCode", verifyCode);
                session.setAttribute("verifyCodeStartTime", new Date());
                out.println("{\"result\":1}");
            } else {
                out.println("{\"result\":0}");
            }
        } else if (opr.equals("register")) {
            //检查验证码是否有效
            String verifyCode = request.getParameter("verify");
            if (!isValidCode(verifyCode, session)) {
                //验证码无效
                out.println("{\"result\":0,\"message\":\"验证码无效，请重新获取验证码！\"}");
                return;
            }
            String userTel = request.getParameter("userTel").trim();
            String nickname = request.getParameter("nickName").trim();
            String realName = request.getParameter("realName").trim();
            String email = request.getParameter("userMail").trim();
            String userPass = request.getParameter("userPass").trim();
            String region1 = request.getParameter("region1");
            String region2 = request.getParameter("region2");
            String region3 = request.getParameter("region3");
            String location = region1 + "&nbsp;" + ((region3 != null) ? region2 + "&nbsp;" + region3 : region2);
            int year = Integer.parseInt(request.getParameter("year"));
            int month = Integer.parseInt(request.getParameter("month"));
            int date = Integer.parseInt(request.getParameter("date"));
            Date birthday = DateUtil.setDate(year, month, date);
            User user = new User();
            user.setUserId(userTel);
            user.setNickname(nickname);
            user.setName(realName);
            user.setEmail(email);
            user.setPassword(userPass);
            user.setAddress(location);
            user.setBirthday(birthday);
            user.setImage(DEFAULT_HEAD_IMG);
            //注册新用户
            UserService userService = new UserServiceImpl();
            try {
                int result = userService.register(user);
                if (result > 0) {
                    //注册成功
                    out.println("{\"result\":1,\"message\":\"注册成功！\"}");
                } else {
                    //注册失败
                    out.println("{\"result\":0,\"message\":\"注册失败！\"}");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }

    private boolean isValidCode(String verifyCode, HttpSession session) {
        String realVerifyCode = (String) session.getAttribute("verifyCode");
        Date createTime = (Date) session.getAttribute("verifyCodeStartTime");
        Date now = new Date();
        long diff = now.getTime() - createTime.getTime(); //毫秒数
        if (verifyCode.equals(realVerifyCode) && diff < (Integer.parseInt(CODE_VALID_TIME)) * 60 * 1000) {
            return true;
        } else {
            return false;
        }
    }
}
