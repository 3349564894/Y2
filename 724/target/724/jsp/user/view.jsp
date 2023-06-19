<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 信息查看</span>
    </div>
    <div class="supplierView">
        <p><strong>用户姓名： </strong><span>${user.realName }</span></p>
        <p><strong>用户性别：</strong><span>${user.sex==1?"男":"女"}</span></p>
        <p><strong>出生日期：</strong><span>${user.birthday}</span></p>
        <p><strong>联系电话：</strong><span>${user.phone}</span></p>
        <p><strong>用户地址：</strong><span>${user.address}</span></p>
        <p><strong>创建时间：</strong><span> ${user.createdTime}</span></p>

        <div class="supplierAddBtn">
            <input type="button" id="back" name="back" onclick="history.go(-1)" value="返回">
        </div>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/sysUser/view.js"></script>
