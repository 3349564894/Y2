<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>注册 微博-点滴生活，精彩每一天</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet">
    <link href="../styles/register.css" type="text/css" rel="stylesheet">
    <script src="../script/trim.js" type="text/javascript"></script>
    <script src="../script/sitedata_bas.js" type="text/javascript"></script>
    <script src="../script/datecreate.js" type="text/javascript"></script>
    <script src="../script/register.js" type="text/javascript"></script>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript">
        function checkUserTelExist(imgobj, textobj) {
            $.post("/microblog/control/register", "opr=checkUser&userTel=" + $("#userTel").val(), callBack); //发送请求
            //响应成功时的回调函数
            function callBack(data) { //参数表示响应结果
                if (data == "true") {
                    $("#userTeltip").html("手机号已被注册！");
                    userTeltip.style.visibility = "visible";
                    textobj.style.backgroundColor = "#B9E3AB";//设置出错背景色
                    imgobj.src = "../images/err.png";//设置出错状态图
                    telExist = true;
                    return false;
                } else {
                    userTeltip.style.visibility = "hidden";
                    textobj.style.backgroundColor = "#fff";
                    imgobj.src = "../images/ok.png";
                    telExist = false;
                    return true;
                }
            }
        }

        var InterValObj; //timer变量，控制时间
        var count = 60 * 1; //间隔函数，1秒执行
        var curCount;//当前剩余秒数
        function setTimer() {
            curCount = count;
            $("#getCodeBtn").attr("disabled", "true");
            $("#getCodeBtn").val(curCount + "秒后可重新发送");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器
        }

        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $("#getCodeBtn").removeAttr("disabled");//启用按钮
                $("#getCodeBtn").val("重新发送验证码");
            } else {
                curCount--;
                $("#getCodeBtn").val(curCount + "秒后可重新发送");
            }
        }

        //获取短信验证码
        var sms = "";

        function getVerifyCode() {
            if ($("#userTel").val() != "") {
                //ajax请求
                $.getJSON("../control/register", "opr=getCode&phone=" + $("#userTel").val(), function (data) {
                    //当成功发送验证码后，开始倒计时
                    if (data.result == 1) {
                        setTimer();
                    } else {
                        alert("获取验证码失败！");
                    }
                });
            } else {
                alert("请输入手机号！");
                return false;
            }
        }

        //注册用户
        function register() {
            if (!$('#checkbox').is(':checked')) {
                alert("请阅读并勾选《使用协议》！");
                return;
            }
            if (checkForm()) {
                var $registerInputs = $("#registerForm").find(":input");//获取所有表单元素
                var paramsArray = $registerInputs.serializeArray();     //将表单编码成数组格式
                var queryString = $.param(paramsArray);                 //将数据序列化成请求字符串
                $.post("../control/register",
                    "opr=register&" + queryString,
                    function updateSuccess(data) {
                        alert(data.message);
                        if (data.result == 1) {
                            //注册成功
                            window.location.href = "login.jsp";
                        }
                    },
                    "JSON");
            }
        }
    </script>
</head>
<body>
<div id="container">
    <!-- top部分DIV -->
    <div id="top">
        <!-- top部分的LogoDIV -->
        <div id="topLogo">
            <!-- topLogo部分的icoDIV -->
            <div id="topLogoIco"><img src="../images/logo.png" width="177" height="72" alt=""/>
            </div>
        </div>
        <!-- topLogo部分的wordDIV -->
    </div>
    <!-- top部分的LogoDIV结束 -->

    <!-- top部分的文字导航 -->
    <div id="topWordMenu">
        <ul>
            <li>已有账号，<a href="login.jsp">请登录</a></li>
            <li><a href="../index.jsp">微博首页</a></li>
            <li><a href="#">帮助</a></li>
        </ul>
    </div>
    <!-- top部分的文字导航结束 -->
</div>
<!-- top部分结束 -->
<div id="banner">
    <div id="bannerTop">
        <div id="bannerWord1">加入微博</div>
        <div id="bannerWord2">如果你已经是注册用户，请直接<a href="login.jsp">登录微博</a></div>
    </div>
    <div id="main">
        <form action="" method="post" id="registerForm">
            <table width="765" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="userTel">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
                    </td>
                    <td align="center" valign="middle" class="a"><input name="userTel" type="text" class="form"
                                                                        id="userTel" onblur="checkUserTel(img3,this)"
                                                                        onfocus="getfocus(this,img3,userTeltip)"/></td>
                    <td align="left" valign="middle" class="wordright"><img name="img3" width="16" height="16" id="img3"
                                                                            alt="" src=""/>
                        <div class="registertip" id="userTeltip" style="visibility: hidden">
                            请输入您的手机号码，之后作为登录账号
                        </div>
                        <div class="registertip" id="existCheckTip" hidden></div>
                    </td>
                </tr>
                <tr>
                    <td width="71">&nbsp;</td>
                    <td width="86" align="center" valign="middle" class="wordleft"><label
                            for="realName">用&nbsp;户&nbsp;名</label></td>
                    <td width="189" align="center" valign="middle"><input name="realName" type="text" class="form"
                                                                          id="realName"
                                                                          onblur="checkRealName(img1,this)"
                                                                          onfocus="getfocus(this,img1,userIDtip)"/></td>
                    <td width="419" align="left" valign="middle" class="wordright"><img name="img1" width="16"
                                                                                        height="16" id="img1" alt=""
                                                                                        src=""/>
                        <div class="registertip" id="userIDtip" style="visibility: hidden">
                            请输入真实姓名，方便您的朋友与你联系
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="nickName">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
                    </td>
                    <td align="center" valign="middle"><input name="nickName" type="text" class="form" id="nickName"
                                                              onfocus="getfocus(this,img2,userNametip)"
                                                              onblur="checkNickName(img2,this)" maxlength="20"/></td>
                    <td align="left" valign="middle" class="wordright"><img name="img2" width="16" height="16" id="img2"
                                                                            alt="" src=""/>
                        <div class="registertip" id="userNametip" style="visibility: hidden">
                            请输入4到20位数字、字符、中文
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="userMail">电子邮箱</label></td>
                    <td align="center" valign="middle"><input name="userMail" type="text" class="form" id="userMail"
                                                              onblur="checkUserMail(img4,this)"
                                                              onfocus="getfocus(this,img4,userMailtip)"/></td>
                    <td align="left" valign="middle" class="wordright"><img name="img4" width="16" height="16" id="img4"
                                                                            alt="" src=""/>
                        <div class="registertip" id="userMailtip" style="visibility: hidden">
                            找回账户和密码用，如123@163.com
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="userPass">创建密码</label></td>
                    <td align="center" valign="middle"><input name="userPass" type="password" class="form" id="userPass"
                                                              onfocus="getfocus(this,img5,userPasstip)"
                                                              onblur="checkUserPass(img5,this)" maxlength="20"/></td>
                    <td align="left" valign="middle" class="wordright"><img name="img5" width="16" height="16" id="img5"
                                                                            alt="" src=""/>
                        <div class="registertip" id="userPasstip" style="visibility: hidden">
                            密码由6到20个字母、数字、特殊符号组成，字母区分大小写
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="userRpass">密码确认</label></td>
                    <td align="center" valign="middle"><input name="userRpass" type="password" class="form"
                                                              id="userRpass" onblur="checkUserRpass(img6,this)"
                                                              onfocus="getfocus(this,img6,userRpasstip)"
                                                              maxlength="20"/></td>
                    <td align="left" valign="middle" class="wordright"><img name="img6" width="16" height="16" id="img6"
                                                                            alt="" src=""/>
                        <div class="registertip" id="userRpasstip" style="visibility: hidden">请再次输入密码</div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="region1">所在城市</label></td>
                    <td colspan="2" valign="middle"><select name="region1" class="form1" id="region1">
                    </select
                    ><select name="region2" class="form4" id="region2">
                    </select
                    ><select name="region3" class="form4" id="region3">
                    </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="year">出生年月</label></td>
                    <td align="left" valign="middle"><select name="year" class="form2" id="year">
                    </select><select name="month" class="form3" id="month">
                    </select><select name="date" class="form3" id="date">
                    </select></td>
                    <td align="left" valign="middle" class="wordright">
                        <div class="registertip"></div>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td align="center" valign="middle" class="wordleft"><label for="userPass">验证码</label></td>
                    <td align="center" valign="middle"><input name="verify" type="text" class="form" id="verify"/></td>
                    <td align="left" valign="middle" class="wordright"><input type="button" name="button"
                                                                              id="getCodeBtn" value="获取验证码"
                                                                              class="button" onclick="getVerifyCode()">
                    </td>
                </tr>
                <tr>
                    <td height="35" colspan="4" align="center">
                        <input name="checkbox" type="checkbox" id="checkbox"/>
                        我已经看过
                        ，并同意<a href="#">《使用协议》</a></td>
                </tr>
                <tr>
                    <td colspan="4" align="center" valign="middle"><input type="button" name="button" id="button"
                                                                          value="立即注册" class="button"
                                                                          onclick="register()"/></td>
                </tr>
            </table>
        </form>
    </div>
    <!-- footer部分 -->
    <%@ include file="page_element/footer.jsp" %>
    <!-- footer部分结束 -->
</div>
</div>
</body>
</html>
