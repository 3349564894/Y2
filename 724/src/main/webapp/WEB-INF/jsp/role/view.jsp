<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 信息查看</span>
    </div>
    <div class="supplierView">
        <p><strong>岗位编码： </strong><span>${role.code }</span></p>
        <p><strong>类型名称：</strong><span>${role.roleName }</span></p>
        <p><strong>用户ID：</strong><span>${role.createdUserId}</span></p>
        <p><strong>创建时间：</strong><span>${role.createdTime}</span></p>
        <p><strong>修改用户ID：</strong><span>${role.updatedUserId}</span></p>
        <p><strong>修改时间：</strong><span>${role.updatedTime}</span></p>
        <div class="supplierAddBtn">
            <input type="button" id="back" name="back" onclick="history.go(-1)" value="返回">
        </div>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysRole/view.js"></script>
