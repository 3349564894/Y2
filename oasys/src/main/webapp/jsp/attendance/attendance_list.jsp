<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<div class="action  divaction">
    <div class="t">考勤列表</div>
    <div class="pages">
        <div class="forms">
            <form action="../control/attendance" name="" method="get">
                <label>姓名</label>
                <input id="name" name="empName" value="${requestScope.searchName}"/>
                <label>日期</label>
                <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" id="searchDate" name="searchDate"
                       value="${requestScope.searchDate}"/>
                <input type="hidden" name="opr" value="list"/>
                <input type="hidden" name="pageIndex" value="1"/>
                <input type="submit" cssClass="submit_01" value="查询"/>

            </form>
        </div>
        <!--列表  开始-->
        <table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
            <tr class="even">
                <td>编号</td>
                <td>工号</td>
                <td>姓名</td>
                <td>上班打卡时间</td>
                <td>下班打卡时间</td>
            </tr>
            <c:forEach items="${requestScope.list}" var="attendance">
                <tr>
                    <td><a href="">${attendance.id}</a></td>
                    <td>${attendance.employee.employeeNo}</td>
                    <td>${attendance.employee.name}</td>
                    <td>${util:getFormatTime(attendance.signInTime)}</td>
                    <td>${util:getFormatTime(attendance.signOutTime)}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="7" align="center">
                    <c:import url="../common/rollPage.jsp" charEncoding="UTF-8">
                        <c:param name="formName" value="document.forms[0]"/>
                        <c:param name="totalRecordCount" value="${requestScope.pageObj.totalCount}"/>
                        <c:param name="totalPageCount" value="${requestScope.pageObj.totalPageCount}"/>
                        <c:param name="currentPageNo" value="${requestScope.pageObj.currPageNo}"/>
                    </c:import>
                </td>
            </tr>
        </table>
        <!--列表 结束-->
    </div>
</div>
