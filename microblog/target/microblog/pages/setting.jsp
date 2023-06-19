<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>个人设置</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/setting.css" type="text/css" rel="stylesheet"/>
    <script src="../script/iframeauto.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="page_element/top.jsp" %>
<!-- header部分DIV -->
<div id="header">
    <ul>
        <li><a href="account.jsp" class="header" target="win">帐号设置</a></li>
        <li><a href="password.jsp" class="header" target="win">密码</a></li>
        <li><a href="avatar.jsp" class="header" target="win">头像</a></li>
    </ul>
</div>
<!-- header部分DIV结束 -->
<iframe src="account.jsp" id="win" width="765" scrolling="no" name="win" onload="SetWinHeight(this)"
        frameborder="0"></iframe>
<!-- banner部分的DIV结束 -->
<%@ include file="page_element/footer.jsp" %>
</div>
<!-- container部分结束 -->
</body>
</html>
