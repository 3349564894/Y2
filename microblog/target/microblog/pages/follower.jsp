<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>关注管理 微博-点滴生活，精彩每一天！</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet">
    <link href="../styles/friend.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="../script/trim.js"></script>
    <script type="text/javascript" src="../script/detail.js"></script>
    <script type="text/javascript">
        function initList() {
            $.getJSON("../control/follow", "opr=followList&keyword=" + $("#keyword").val(), processFollowerList);
        }

        function processFollowerList(data) {
            var tb = $("#tb1");
            $("#tb1 .follower").remove();
            var nums = data.length;
            $("#followerNum").empty().append("你关注的人（" + nums + "）");
            if (nums > 0) {
                $(data).each(function () {
                    var htmlStr = "<tr class=\"follower\">" +
                        "<td height=\"105\" align=\"center\" valign=\"middle\" class=\"td2\">" +
                        "<img src=" + this.image + "\"..\" width=\"54\" height=\"54\" " +
                        "alt=\"\" /></td>" +
                        "<td height=\"105\" align=\"left\" valign=\"bottom\" class=\"td3\">" +
                        "<span style=\"color: #005dc3; font-size: medium; " +
                        "font-family: 微软雅黑\"><b>" + this.nickname + "</b></span>\n" +
                        "    <img src=\"images/1.gif\" width=\"17\" height=\"15\" alt=\"\" />" +
                        "<br /><span style=\"color: #000000; font-size: small\">" +
                        this.address + "</span>" +
                        "<br /><span style=\"color: #000000; font-size: small\">" +
                        ((this.sign == null) ? "" : this.sign) + "</span>" +
                        "<div id=\"focus1\">" +
                        "<img src=\"../images/isFollowed.png\" alt=\"\" width=\"55\" " +
                        "height=\"23\" style=\"vertical-align: bottom\" onclick=\"javascript:unFollow(" + this.id + ")\"/>" +
                        "</div></td></tr>";
                    tb.append(htmlStr);
                });
            }
            changeDivHeight();
        }

        function unFollow(id) {
            //取消关注
            $.getJSON("../control/follow", "opr=delete&id=" + id,
                function (data) {
                    alert(data.message);
                    if (data.result == 1) {
                        initList();
                        initUserInfo();
                    }
                });
        }

        $(document).ready(function () {
            initList();
            initUserInfo();
        });
    </script>
</head>
<body>
<%@ include file="page_element/top.jsp" %>
<!-- 页面主体 -->
<div id="main">
    <div id="mainBanner">
        <table width="765" border="0" cellpadding="0" cellspacing="0" id="tb1">
            <tr>
                <td width="21" rowspan="7" class="td1"></td>
                <td height="60" align="center" valign="middle" bgcolor="#FFFFFF" class="td2">
                    <img src="../images/MainRightFirstLineTitle.gif" width="48" height="48" alt=""/></td>
                <td height="60" class="td3"><span style="color: #000000; font-size: medium"><b
                        id="followerNum"></b></span></td>
                <td rowspan="7" class="td1 height"></td>
            </tr>
            <tr>
                <td height="47" align="center" valign="middle" bgcolor="#e3f1fa" class="td2 font1">列表</td>
                <td height="45" align="center" valign="middle" bgcolor="#e3f1fa" class="td4 font1">
                    <form id="form2" name="form2" method="post" action="">
                        <div id="search">
                            <input type="text" name="keyword" id="keyword" value=""/>
                            <img src="../images/sousuo1.gif" alt="" width="27" height="25"
                                 style="vertical-align: middle" onclick="javascript:initList()"/>
                        </div>
                    </form>
                </td>
            </tr>

            <!--关注列表-->
        </table>
    </div><!--mainBanner結束-->
    <!-- 右侧mainRight DIV开始 -->
    <div id="mainRight">
        <div id="mainRight1">
            <%@ include file="page_element/userInfo.jsp" %>
            <!-- 右侧mainRightPostionFirstLine DIV 结束 -->
            <div id="mainRightPostionFifthLine">
                <div id="mainRightPositionFifthLineContent">
                    <a href="setting.jsp" onclick="" class="a1"><span class="style4">完善个人资料</span>
                        <img src="../images/rightarrow.gif" alt="" width="12" height="14"
                             style="horiz-align: right; border: 0;" title=""/></a>
                </div>
            </div>
            <div id="mainRightPostionSeventhLine">
                <div id="mainRightPositionSevenLineContent">
                    微博的成长，离不开你们。<br/>
                    <span class="style2"><a href="#" class="a1">有意见要提（点击） </a><br/><br/>
                    <a href="#" class="a1" onclick="set()">不良信息举报中心</a></span>
                </div>
            </div>
            <!-- 右侧mainRightPostionSixthLine DIV 结束 -->
        </div>
    </div>
</div>

<%@ include file="page_element/footer.jsp" %>
</div>
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</body>
</html>
