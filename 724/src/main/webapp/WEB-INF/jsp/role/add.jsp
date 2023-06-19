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
              action="${pageContext.request.contextPath }/role/add">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label for="code">岗位编码：</label>
                <input type="text" name="code" id="code" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="roleName">类型名称：</label>
                <input type="text" name="roleName" id="roleName" value="">
                <font color="red"></font>
            </div>
            <div class="supplierAddBtn">
                <input type="submit" name="add" id="add" value="保存">
                <input type="button" id="back" onclick="history.go(-1)" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysRole/add.js"></script>

