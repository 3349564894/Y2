<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>当前位置:</strong>
        <span>供货商管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/user/wher">
            <span>账号：</span>
            <input name="userAccount" type="text" value="${querySupCode }">

            <span>用户名：</span>
            <input name="userName" type="text" value="${querySupName }">
            <input type="hidden" name="pageIndex" value="1"/>
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/user/add">添加</a>
        </form>
    </div>
    <!--供货商操作表格-->
    <table class="supplierTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">用户名</th>
            <th width="20%">用户性别</th>
            <th width="10%">出生日期</th>
            <th width="10%">联系电话</th>
            <th width="10%">地址</th>
            <th width="10%">创建时间</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach var="user" items="${sessionScope.userList }" varStatus="status">
            <tr>
                <td>
                    <span>${user.realName }</span>
                </td>
                <td>
                    <span>${user.sex==1?"男":"女"}</span>5
                </td>
                <td>
                    <span>${user.birthday}</span>
                </td>
                <td>
                    <span>${user.phone}</span>
                </td>
                <td>
                    <span>${user.address}</span>
                </td>
                <td>
					<span>
                            ${user.createdTime}
                    </span>
                </td>
                <td>
                    <span><a class="viewSupplier"
                             href="${pageContext.request.contextPath}/user/view?id=${user.id }&name=查看"
                             userid=${user.id } realName=${user.realName }><img
                            src="${pageContext.request.contextPath }/statics/images/view.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifySupplier"
                             href="${pageContext.request.contextPath}/user/view?id=${user.id }&name=修改;"
                             userid=${user.id } realName=${user.realName }><img
                            src="${pageContext.request.contextPath }/statics/images/upd.png" alt="修改"
                            title="修改"/></a></span>
                    <span><a class="deleteUser" href="javascript:;" userid=${user.id } realName=${user.realName }><img
                            src="${pageContext.request.contextPath }/statics/images/del.png" alt="删除"
                            title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <%--    <c:import url="/WEB-INF/jsp/sysRole/rollpage.jsp">--%>
    <%--        <c:param name="totalCount" value="${totalCount}"/>--%>
    <%--        <c:param name="currentPageNo" value="${currentPageNo}"/>--%>
    <%--        <c:param name="totalPageCount" value="${totalPageCount}"/>--%>
    <%--    </c:import>--%>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>确定删除该用户吗？</p>
            <a href="#" id="yes">是</a>
            <a href="#" id="no">否</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysUser/list.js"></script>
