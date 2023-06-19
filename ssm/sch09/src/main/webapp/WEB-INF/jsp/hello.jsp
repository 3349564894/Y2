<%--
  Created by IntelliJ IDEA.
  User: lasAir
  Date: 2023/5/26
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <label>请输入account：</label><input id="account" type="text"/><br>
    <input type="button" onclick="x()" value="提交"/>
</form>
<script type="text/javascript">
    function x() {
        // location.href = "hello";
        location.href = "show?account=" + document.getElementById("account").value;
    }
</script>
</body>
</html>
