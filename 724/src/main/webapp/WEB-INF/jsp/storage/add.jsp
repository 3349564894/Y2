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
              action="${pageContext.request.contextPath }/sys/storageRecord/add">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div class="">
                <label for="srCode1">商品编码：</label>
                <input type="text" name="srCode" id="srCode1" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="goodsName">商品名称：</label>
                <input type="text" name="goodsName" id="goodsName" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="goodsUnit">商品单位：</label>
                <input type="text" name="goodsUnit" id="goodsUnit" value="">
                <font color="red"></font>

            </div>
            <div>
                <label for="goodsCount">商品单价：</label>
                <input type="text" name="goodsCount" id="goodsCount" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="totalAmount">商品总价：</label>
                <input type="text" name="totalAmount" id="totalAmount" value="">
            </div>
            <div>
                <label for="supplierId">供货商id：</label>
                <input type="text" name="supplierId" id="supplierId" value="">
            </div>
            <div class="supplierAddBtn">
                <input type="submit" name="add" id="add1" value="保存">
                <input type="button" id="back1" name="back" value="返回">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/storageRecord/add.js"></script>

