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
              action="${pageContext.request.contextPath }/user/add">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label for="realName">用户姓名：</label>
                <input type="text" name="realName" id="realName" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="account">用户账号：</label>
                <input type="text" name="account" id="account" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="password">用户密码：</label>
                <input type="text" name="password" id="password" value="">
                <font color="red"></font>

            </div>
            <div>
                <label for="rpassword">确认密码：</label>
                <input type="text" name="rpassword" id="rpassword" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="phone">联系电话：</label>
                <input type="text" name="phone" id="phone" value="">
            </div>
            <div>
                <label for="birthday">出生日期：</label>
                <input type="text" name="birthday" id="birthday" value="">
            </div>
            <div class="supplierAddBtn">
                <input type="submit" name="save" id="save" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysUser/add.js"></script>

