<%@ page import="com.yq.entity.User" %>
<%@ page import="com.yq.service.UserService" %>
<%@ page import="com.yq.service.impl.UserServiceImpl" %>
<%
    //验证用户访问权限
    User user = (User) session.getAttribute("user");
    if (user == null) {
        //检查Cookie
        Cookie[] cookies = request.getCookies();
        String userId = "";
        String password = "";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("userId")) {
                    userId = cookies[i].getValue();
                }
                if (cookies[i].getName().equals("password")) {
                    password = cookies[i].getValue();
                }
            }
            if (!userId.equals("") && !password.equals("")) {
                UserService userService = new UserServiceImpl();
                try {
                    user = userService.findUser(userId, password);//验证用户是否存在
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (cookies != null && user != null) {
            //自动登录成功，将用户信息写入session
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 60);
        } else {
            response.sendRedirect("../pages/login.jsp");
            return;
        }
    }
%>
