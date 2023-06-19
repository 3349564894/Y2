<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>

<div class="right">
    <div class="location">
        <strong>当前位置:</strong>
        <span>供货商管理页面 >> 供货商添加页面</span>
    </div>
    <div class="supplierAdd">
        <form id="userForm" name="userForm" enctype="multipart/form-data" method="post"
              action="${pageContext.request.contextPath }/user/updatePassword">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label for="oldpassword">旧密码：</label>
                <input type="text" name="oldpassword" id="oldpassword" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="newpassword">新密码：</label>
                <input type="text" name="newpassword" id="newpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="rnewpassword">确认新密码：</label>
                <input type="text" name="rnewpassword" id="rnewpassword" value="">
                <font color="red"></font>

            </div>
            <div class="supplierAddBtn">
                <input type="button" name="save" id="save" value="保存">
                <input type="button" id="back" name="back" onclick="history.go(-1)" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysUser/updatePassword.js"></script>

