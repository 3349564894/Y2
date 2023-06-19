<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 信息查看</span>
    </div>
    <div class="supplierView">
        <p><strong>商品编码： </strong><span>${storage.srCode }</span></p>
        <p><strong>商品名称：</strong><span>${storage.goodsName }</span></p>
        <p><strong>商品类型：</strong><span>${storage.goodsDesc}</span></p>
        <p><strong>商品单价：</strong><span>${storage.goodsCount}</span></p>
        <p><strong>商品总价：</strong><span>${storage.totalAmount}</span></p>
        <p><strong>创建时间：</strong><span>${storage.createdTime}</span></p>
        <div class="supplierAddBtn">
            <input type="button" id="back" name="back" onclick="history.go(-1)" value="返回">
        </div>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/storageRecord/view.js"></script>
