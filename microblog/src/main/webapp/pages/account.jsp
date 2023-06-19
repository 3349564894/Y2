<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>账号设置 - 微博</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/account.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script src="../script/sitedata_bas.js" type="text/javascript"></script>
    <script type="text/javascript">
        function checkForm() {
            var nickname = document.getElementById("textfield1");
            var realname = document.getElementById("textfield2");
            var email = document.getElementById("textfield3");
            var strRegex = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
            //alert(!strRegex.test(email.value));
            if (nickname.value == "") {
                alert("请输入用户昵称！");
                nickname.focus();
                return false;
            } else if (realname.value == "") {
                alert("请输入真实姓名！");
                realname.focus();
                return false;
            } else if (email.value == "" || strRegex.test(email.value) == false) {
                alert("请输入正确的邮箱！");
                email.focus();
                return false;
            }
            return true;
        }

        function updateAccount() {
            if (checkForm()) {
                var $updateUserInputs = $("#container").find(":input");//获取所有表单元素
                var paramsArray = $updateUserInputs.serializeArray();  //将表单编码成数组格式
                var queryString = $.param(paramsArray);                //将数据序列化成请求字符串
                $.post("../control/updateUser",
                    "opr=updateAccount&" + queryString,
                    function updateSuccess(data) {
                        alert(data.message);
                    },
                    "JSON");
            }
        }
    </script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
    <!-- container部分DIV -->
    <div id="container">
        <!-- banner部分DIV -->
        <div id="banner">
            <!-- banner部分的leftDIV -->
            <div class="left" id="left">
                <table width="564" border="0" cellpadding="0" cellspacing="0" class="left">
                    <!-- 昵称 -->
                    <tr>
                        <td width="120" height="50" align="right"><strong>昵称</strong></td>
                        <td width="20" height="60">&nbsp;</td>
                        <td width="425" height="60"><label>
                            <input name="textfield1" type="text" class="n1" id="textfield1"
                                   value="${sessionScope.user.nickname}"/>
                            <br/>
                            您的昵称将显示在您的主页中</label></td>
                    </tr>
                    <!-- 真实姓名 -->
                    <tr>
                        <td width="120" height="50" align="right"><strong>真实姓名</strong></td>
                        <td width="20" height="60">&nbsp;</td>
                        <td width="425" height="60"><label>
                            <input name="textfield2" type="text" class="n1" id="textfield2"
                                   value="${sessionScope.user.name}"/>
                            <br/>
                            请输入真实姓名，方便您的朋友与你联系</label></td>
                    </tr>

                    <!-- 邮箱 -->
                    <tr>
                        <td width="120" height="49" align="right"><strong>邮箱</strong></td>
                        <td width="20" height="49">&nbsp;</td>
                        <td width="425" height="49"><label>
                            <input name="textfield3" type="text" class="n3" id="textfield3"
                                   value="${sessionScope.user.email}"/>
                        </label></td>
                    </tr>
                    <!-- 个人站点 -->
                    <tr>
                        <td width="120" height="68" align="right"><strong>个人站点</strong></td>
                        <td width="20" height="68">&nbsp;</td>
                        <td width="425" height="68"><label>
                            <input name="textfield4" type="text" class="n1" id="textfield4"
                                   value="${sessionScope.user.mysite eq null? "":sessionScope.user.mysite}"/>
                            <br/>
                            你的网站、博客地址，让大家更多地了解你</label></td>
                    </tr>
                    <!-- 个性签名 -->
                    <tr>
                        <td width="120" height="180" align="right"><strong>个性签名</strong></td>
                        <td width="20" height="180">&nbsp;</td>
                        <td width="425" height="180">
                            <div>
                                <label>
                                    <textarea name="textfield5" class="n4"
                                              id="textfield5">${sessionScope.user.sign eq null? "":sessionScope.user.sign}</textarea>
                                </label>
                            </div>
                        </td>
                    </tr>
                    <!-- 隐私 -->
                    <tr>
                        <td width="120" height="29" align="right"><strong>隐私</strong></td>
                        <td width="20" height="29">&nbsp;</td>
                        <td width="425" height="29"><label>
                            <c:choose>
                                <c:when test="${sessionScope.user.ispublic eq 'T'}">
                                    <input name="sec" type="radio" id="radio" value="T" checked="checked"/>所有人可见
                                    <input type="radio" name="sec" id="radio2" value="F"/>关注我的人可见
                                </c:when>
                                <c:otherwise>
                                    <input name="sec" type="radio" id="radio" value="T"/>所有人可见
                                    <input type="radio" name="sec" id="radio2" value="F" checked="checked"/>关注我的人可见
                                </c:otherwise>
                            </c:choose>
                        </label></td>
                    </tr>
                    <!-- 保存按钮 -->
                    <tr>
                        <td width="120" height="44" align="right">&nbsp;</td>
                        <td width="20" height="44">&nbsp;</td>
                        <td width="425" height="44"><label>
                            <input name="button" type="button" class="btn" id="button" value="保存"
                                   onclick="updateAccount()"/>
                        </label></td>
                    </tr>
                </table>
            </div>
            <!-- banner_left部分DIV结束 -->
            <!-- banner_right部分DIV -->
            <div class="right" id="right">
                <p>在这里
                    ，你可以设置你账号的基本信息，隐私信息等</p>
            </div>
            <!-- banner_right部分DIV结束 -->
        </div>
        <!-- banner部分DIV结束 -->
    </div>
    <!-- container部分DI结束V -->
</form>
</body>
</html>
