<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../common/taglib.jsp" %>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    function confirmDelete() {
        if (!confirm('确定删除该员工吗？')) return;
    }
</script>
<div class="action  divaction">
    <div class="t">员工列表</div>
    <div class="pages">
        <div class="forms">
            <form action="../control/employee" name="" method="get">
                <label>姓名</label>
                <input id="empName" name="empName" value="${requestScope.searchName}"/>
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
                <td>部门</td>
                <td>入职时间</td>
                <td>操作</td>
            </tr>
            <!--员工列表-->
            <c:forEach var="employee" items="${requestScope.list}">
                <tr>
                    <td><a href="">${employee.id}</a></td>
                    <td>${employee.employeeNo}</td>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.entryTime}</td>
                    <td>

                        <a href="../control/employee?opr=toModify&id=${employee.id}">
                            <img src="${images}/edit.gif" width="16" height="16"/>
                        </a>
                        <a onClick="return confirmDelete()" href="../control/employee?opr=delete&id=${employee.id}">
                            <img src="${images}/delete.gif" width="16" height="16"/>
                        </a>
                        <a href="../control/employee?opr=detail&id=${employee.id}">
                            <img src="${images}/search.gif" width="16" height="15"/>
                        </a>
                    </td>
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
