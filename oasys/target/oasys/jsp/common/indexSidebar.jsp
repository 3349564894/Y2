<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="taglib.jsp" %>
<div class="nav" id="nav">
    <div class="t"></div>
    <dl class="open">
        <dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤</dt>
        <dd><a href="jsp/attendance/attendance_record.jsp">每日打卡</a></dd>
    </dl>
    <dl>
        <dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工档案</dt>
        <dd><a href="control/employee?opr=detail&id=${sessionScope.employee.id}">查看个人信息</a></dd>
        <dd><a href="jsp/user/empl_modify.jsp">修改信息</a></dd>
        <dd><a href="jsp/user/password_edit.jsp">重置密码</a></dd>
    </dl>

    <c:if test="${sessionScope.employee.position eq '人事专员' || (sessionScope.employee.department eq '人力资源部' && sessionScope.employee.position eq '部门经理')}">
        <dl>
            <dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工管理</dt>
            <dd><a href="jsp/user/empl_add.jsp">新增员工</a></dd>
            <dd><a href="control/employee?opr=list">员工列表</a></dd>
        </dl>
        <dl>
            <dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤管理</dt>
            <dd><a href="control/attendance?opr=list">考勤记录</a></dd>
        </dl>
    </c:if>
</div>
