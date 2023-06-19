<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>当前位置:</strong>
        <span>供货商管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/role/wher">
            <span>岗位编码：</span>
            <input name="queryRoleCode" type="text" value="${querySupCode }">

            <span>岗位名称：</span>
            <input name="queryRoleName" type="text" value="${querySupName }">
            <input type="hidden" name="pageIndex" value="1"/>
            <input value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath }/role/toAdd">添加</a>
        </form>
    </div>
    <!--供货商操作表格-->
    <table class="supplierTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">岗位编码</th>
            <th width="20%">类型名称</th>
            <th width="10%">用户ID</th>
            <th width="10%">创建时间</th>
            <th width="10%">修改用户ID</th>
            <th width="10%">修改时间</th>
            <th width="30%">操作</th>
        </tr>
        <c:forEach var="role" items="${roleList }" varStatus="status">
            <tr>
                <td>
                    <span>${role.code }</span>
                </td>
                <td>
                    <span>${role.roleName }</span>
                </td>
                <td>
                    <span>${role.createdUserId}</span>
                </td>
                <td>
                    <span>${role.createdTime}</span>
                </td>
                <td>
                    <span>${role.updatedUserId}</span>
                </td>
                <td>
					<span>
                            ${role.updatedTime}
                    </span>
                </td>
                <td>
                    <span><a class="viewSupplier"
                             href="${pageContext.request.contextPath}/role/view?id=${role.id }&name=查看"
                             roleId=${role.id } roleName=${role.roleName }><img
                            src="${pageContext.request.contextPath }/statics/images/view.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifySupplier"
                             href="${pageContext.request.contextPath}/role/view?id=${role.id }&name=修改"
                             roleId=${role.id } roleName=${role.roleName }"roleId=${role.id }
                             roleName=${role.roleName }><img
                            src="${pageContext.request.contextPath }/statics/images/upd.png" alt="修改"
                            title="修改"/></a></span>
                    <span><a class="deleteRole" href="${pageContext.request.contextPath}/role/del1?id=${role.id }"
                             roleId=${role.id } roleName=${role.roleName }><img
                            src="${pageContext.request.contextPath }/statics/images/del.png" alt="删除"
                            title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>--%>
    <%--    <c:import url="/WEB-INF/jsp/sysRole/rollpage.jsp">--%>
    <%--        <c:param name="totalCount" value="${totalCount}"/>--%>
    <%--        <c:param name="currentPageNo" value="${currentPageNo}"/>--%>
    <%--        <c:param name="totalPageCount" value="${totalPageCount}"/>--%>
    <%--    </c:import>--%>
    <%--</div>--%>
    </section>

    <!--点击删除按钮后弹出的页面-->
    <div class="zhezhao"></div>
    <div class="remove" id="removeRole">
        <div class="removerChid">
            <h2>提示</h2>
            <div class="removeMain">
                <p>确定删除该供货商吗？</p>
                <a href="#" id="yes">是</a>
                <a href="#" id="no">否</a>
            </div>
        </div>
    </div>

    <%@include file="/jsp/common/foot.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysRole/list.js"></script>
