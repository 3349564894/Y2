<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>登录 微博-点滴生活，精彩每一天</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/login.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script src="../script/trim.js" type="text/javascript"></script>
    <script src="../script/login.js" type="text/javascript"></script>
    <script type="text/javascript">
        function doLogin() {
            if (checkForm()) {
                $.post("../control/login",
                    {
                        "userId": $("#userId").val(),
                        "passWord": $("#passWord").val(),
                        "checkbox": $("#checkbox").attr("checked")
                    },
                    function callback(data) {
                        if (data == 1) {
                            //打开我的首页页面
                            window.location.href = "home.jsp";
                        } else {
                            alert("登录账号与密码不匹配，请重新输入！");
                        }
                    }
                );
            }
        }
    </script>
</head>
<body>
<!--页面整体-->
<div id="container">
    <!-- top部分DIV -->
    <div id="top">
        <!-- top部分的LogoDIV -->
        <div id="topLogo">
            <!-- topLogo部分的icoDIV -->
            <div id="topLogoIco"><img src="../images/logo.png" width="177" height="72" alt=""/>
            </div>
        </div>
        <!-- top部分的LogoDIV结束 -->
        <!-- top部分的文字导航 -->
        <div id="topWordMenu">
            <ul>
                <li>已有账号，<a href="../pages/login.jsp">请登录</a></li>
                <li><a href="#">帮助</a></li>
            </ul>
        </div>
        <!-- top部分的文字导航结束 -->
    </div>
    <!-- top部分结束 -->
    <!-- 页面主体 -->
    <div id="banner">
        <!-- 页面左部 -->
        <div id="left">
            <!--页面左部表单设置-->
            <form id="LoginForm" action="" method="post" onsubmit="">
                <table width="565" border="0" cellspacing="0" cellpadding="0">
                    <tr class="lb">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="le"></td>
                        <td class="ld"><label for="userId">手机</label></td>
                        <td class="if"><input name="userId" type="text" class="la" id="userId"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="le"></td>
                        <td class="ld"><label for="passWord">密码</label></td>
                        <td class="if"><input name="passWord" type="password" class="la" id="passWord"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="le"></td>
                        <td class="ld"><label for="checkbox"></label></td>
                        <td><input name="checkbox" type="checkbox" id="checkbox" checked="checked"/>
                            记住我
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="le"></td>
                        <td class="ld"></td>
                        <td><a href="#">
                            <input name="button" type="button" class="lc" id="button" value="登  录"
                                   onclick="doLogin()"/>
                        </a></td>
                        <td></td>
                    </tr>
                </table>
            </form>
            <!--页面左部表单结束-->
        </div>
        <!-- 页面右部 -->
        <div id="right">
            <!--页面右部文字及按钮设置-->
            <div class="bs">
                还没有微博？
            </div>
            <div class="cs">
                赶快来注册一个吧
            </div>
            <div class="ds"><a href="register.jsp"><img src="../images/anniu.gif" alt="立即注册" width="155"
                                                        height="48" title="在这注册"/></a>
            </div>
        </div>
    </div>
    <!--页面右部文字及按钮设置结束-->
    <%@ include file="page_element/footer.jsp" %>
</div>
</body>
</html>
