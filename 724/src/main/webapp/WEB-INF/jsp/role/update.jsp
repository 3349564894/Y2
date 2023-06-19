<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>当前位置:</strong>
        <span>供货商管理页面 >> 供货商添加页面</span>
    </div>
    <div class="supplierAdd">
        <form id="supplierForm" name="supplierForm" enctype="multipart/form-data" method="post"
              action="${pageContext.request.contextPath }/role/update">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="roleName">类型名称：</label>
                <input type="text" name="roleName" id="roleName" value="${role.roleName }">
                <font color="red"></font>
            </div>
            <input type="hidden" value="${role.id}" name="id">
            <div class="supplierAddBtn">
                <input type="submit" name="save" id="save" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysRole/update.js"></script>

