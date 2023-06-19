<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微博-点滴生活，精彩世界</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/customerindex.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="../script/trim.js"></script>
    <script type="text/javascript" src="../script/customerindex.js"></script>
    <script type="text/javascript">
        function initBlogList(pageIndex) {
            $.getJSON("../control/collection", "opr=list&keyword=" + $("#keyword").val() + "&pageIndex=" + pageIndex, processBlogsList);
        }

        function processBlogsList(data) {
            var blogsDiv = $("#mainBannerContent").empty(); //微博列表父容器

            $(data.blogsList).each(function () {
                var htmlStr = "<div class=\"stateShow\" onmouseover=\"stateMouseOver(this)\" onmouseout=\"stateMouseOut(this)\" onclick=\"go2detail(" + this.id + "," + ((this.uId == ${sessionScope.user.id}) ? 1 : 0) + ")\">" +
                    "<div class=\"stateShowWord\"><div class=\"stateOp\">";
                if (this.uId != ${sessionScope.user.id} && this.user.followed == false) {
                    htmlStr += "<a class=\"opState\" onclick=\"changeOpState(this);follow(" + this.uId + ")\">+&nbsp;关注</a>";
                }

                htmlStr += "</div><table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"stateTable\"><tr>" +
                    "<td width=\"70\" align=\"center\" valign=\"top\"><a href=\"#\"><img src=" + this.user.image + "\"..\" alt=\"\" width=\"48\" height=\"48\"></a></td>" +
                    "<td width=\"380\"><a href=\"#\">" + this.user.nickname + "</a><img src=\"../images/1.gif\" style=\"border:none;vertical-align:middle;\" alt=\"\">&nbsp;" +
                    this.content + "</td></tr>";
                if (this.state == 2) {
                    if (this.origin != null) {
                        htmlStr += "<tr><td></td><td width=\"380\">@" + this.origin.user.nickname + " : " + this.origin.content + "</td></tr>";
                    } else {
                        htmlStr += "<tr><td></td><td width=\"380\">" + "原始微博已无法显示！" + "</td></tr>";
                    }
                }
                htmlStr += "</table></div>";
                if (this.state == 1) {
                    if (this.images != null) {
                        htmlStr += "<div class=\"stateImgShow\"><img src=" + this.images + "\"..\"  alt=\"\"/></div>";
                    }
                } else {
                    if (this.origin != null && this.origin.images != null) {
                        htmlStr += "<div class=\"stateImgShow\"><img src=" + this.origin.images + "\"..\"  alt=\"\"/></div>";
                    }
                }

                htmlStr += "<div class=\"stateShowtime\">" + this.time + "</div>" +
                    "<div class=\"stateOp\">" +
                    "<a class=\"opState\" onclick=\"javascript:;\" href=\"#\">收藏 " + this.collectionCount + "</a>" +
                    "<a class=\"opState\" onclick=\"javascript:;\" href=\"#\">回复 " + this.commentCount + "</a>" +
                    "<a class=\"opState\" href=\"#\">转发 " + this.forwardCount + "</a>" +
                    "<a class=\"opState\" onclick=\"\" href=\"#\">赞 " + this.likesCount + "</a>" +
                    "</div><div class=\"huifu\"></div></div>";
                blogsDiv.append(htmlStr);
            });

            //显示分页
            var pageDiv = $("#pageDiv").empty(); //显示分页的父容器
            pageDiv.append("当前页数:[" + data.currPageNo + "/" + data.totalPageCount + "]&nbsp;");
            if (data.currPageNo > 1) {
                pageDiv.append("<a href=\"javascript:initBlogList(1)\">首页</a>&nbsp;");
                pageDiv.append("<a href=\"javascript:initBlogList(" + (data.currPageNo - 1) + ")\">上一页</a>&nbsp;");
            }
            if (data.currPageNo < data.totalPageCount) {
                pageDiv.append("<a href=\"javascript:initBlogList(" + (data.currPageNo + 1) + ")\">下一页</a>&nbsp;");
                pageDiv.append("<a href=\"javascript:initBlogList(" + (data.totalPageCount) + ")\">末页</a>");
            }
            changeDivHeight();
        }

        function follow(id) {
            $.getJSON("../control/follow", "opr=follow&id=" + id,
                function (data) {
                    alert(data.message);
                    if (data.result == 1) {
                        initBlogList(1);
                        initUserInfo();
                    }
                });
        }

        $(document).ready(function () {
            initBlogList(1);
            initUserInfo();
        });
    </script>
</head>

<body style="filter:alpha(opacity=100)" id="totop">
<%@ include file="page_element/top.jsp" %>
<!-- 内容总容器 mainDIV 开 始-->
<div id="main">
    <!-- 左侧mainBannerDIV 开始 -->
    <div id="mainBanner">
        <!--id="mainBannerTitle 首页-->
        <div id="mainBannerTitle">
            <!--id="mainBannerTitleWord"-->
            <div id="mainBannerTitleWord"><b>我的收藏</b>
            </div>
            <div id="mainBannerTitleWord2">
                <form id="form2" name="form2" action="" method="post">
                    <input type="text" name="keyword" id="keyword" value=""/>
                    <img src="../images/search.gif" alt="" width="27" height="25" style="vertical-align: middle;"
                         onClick="javascript:initBlogList(1)"/>
                </form>
            </div>
        </div>
        <!--不同人的内容-->
        <div id="mainBannerContent">
        </div>
        <!--分页-->
        <p align="center" id="pageDiv">
        </p>
    </div>
    <!-- 左侧mainBanner DIV 结束-->
    <!-- 右侧mainRight DIV开始 -->
    <div id="mainRight">
        <div id="mainRight1">
            <%@ include file="page_element/userInfo.jsp" %>
            <!-- 右侧mainRightPostionSecondLine DIV 开始 -->
            <div id="mainRightPostionSecondLine">
                <!-- 右侧mainRightPositionSecondLineContent DIV 开始 -->
                <div id="mainRightPositionSecondLineContent">
                    <a href="home.jsp" class="a1"><span class="style3">首页</span></a>
                    <hr class="h1">
                    <a href="../pages/mycollection.jsp" class="a1"><span class="style3">我的收藏</span></a>
                    <hr class="h1">
                    <a href="mylike.jsp" class="a1"><span class="style3">我的赞</span></a>
                </div>
                <!-- 右侧mainRightPositionSecondLineContent DIV 开始 -->
            </div>
            <!-- 右侧mainRightPostionSecondLine DIV 结束 -->
            <!-- 右侧mainRightPostionSeventhLine DIV 开始 -->
            <div id="mainRightPostionSeventhLine">
                <div id="mainRightPositionSevenLineContent">
                    微博的成长，离不开你们。<br/>
                    <span class="style2"><a href="#" class="a1">有意见要提（点击） </a><br/><br/>
                        <a href="#" class="a1" onclick="set()">不良信息举报中心</a></span>
                </div>
            </div>
            <!-- 右侧mainRightPostionSeventhLine DIV 结束 -->
        </div>
    </div>
    <!-- 右侧mainRightDiv 结束 -->
</div>
<!-- 回复 100DIV 开始 -->
<!-- 内容总容器 mainDIV 结束-->

<%@ include file="page_element/footer.jsp" %>

</div>
<!--总容器 container结束-->
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</body>
</html>
