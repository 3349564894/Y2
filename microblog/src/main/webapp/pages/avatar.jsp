<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>头像设置 - 微博</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/avatar.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
        function check() {
            var obj = document.getElementById("fileField");
            if (obj.value == "") {
                alert("请选择上传的文件！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<form action="../control/updateUser?opr=updateImg" method="post" enctype="multipart/form-data" name="form1" id="form1"
      onsubmit="return check()">
    <!-- container部分DIV -->
    <div id="container">
        <!-- banner部分DIV -->
        <div id="banner">
            <!-- banner部分的leftDIV -->
            <div class="left" id="left">
                <!-- bannerLeft部分的topDIV -->
                <div class="top" id="bannerTop">
                    <!-- bannerLeftTop部分的picDIV -->
                    <div class="pic1" id="bannerTopPic"><img src="../${user.image}" width="96" height="96"
                                                             style="filter: alpha(opacity=50); vertical-align: middle;"
                                                             alt=""/>
                    </div>
                    <!-- bannerLeftTop部分的picDIV结束 -->
                    <!-- bannerLeftTop部分的wordDIV -->
                    <div class="word" id="bannerTopWord">
                        <!-- 文件搜索区 -->
                        <label>
                            <input type="file" name="fileField" id="fileField"/>
                        </label>
                    </div>
                    <!-- 文件搜索区结束 -->
                    <!-- bannerLeftTop部分的wordDIV -->
                    <div class="left2" id="bannerLeftTopBtn">
                        <label>
                            <input name="button" type="submit" class="btn" id="button" value="提交"/>
                        </label>
                    </div>
                    <!-- bannerLfetTop部分的btnDIV -->
                </div>
                <!-- bannerLeft部分的topDIV结束 -->
            </div>
            <!-- banner_left部分DIV结束 -->
            <!-- banner_right部分DIV -->
            <div class="right" id="right">
                <p><strong>关于头像</strong></p>
                <p>头像是你展示自己的最好方式，再多的话也没一张头像对你的描述来得直接</p>
            </div>
            <!-- banner_right部分DIV结束 -->
        </div>
        <!-- banner部分DIV -->
    </div>
    <!-- container部分DI结束V -->
</form>
</body>
</html>
