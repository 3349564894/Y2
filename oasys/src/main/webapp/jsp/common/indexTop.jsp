<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<div class="top">
    <div class="global-width">
        <label class="titlearea">北青云尚自动化办公系统</label>
    </div>
</div>

<div class="status">
    <div class="global-width">
        <span class="usertype">【职位：${sessionScope.employee.position}】</span>${sessionScope.employee.name}你好！欢迎访问北青云尚自动化办公系统！
        <span><a href="logout">【退出系统】</a></span>
    </div>
</div>
