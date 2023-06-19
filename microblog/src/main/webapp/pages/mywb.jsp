<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微博-点滴生活，精彩世界</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/mywb.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="../script/trim.js"></script>
    <script type="text/javascript" src="../script/detail.js"></script>
    <script type="text/javascript">
        function deleteBlog(id) {
            if (confirm('确定要删除吗?')) {
                $.getJSON("../control/blog", "opr=delete&id=" + id, afterDelete);
            }
        }

        function afterDelete(data) {
            if (data.result == 1) {
                //删除成功
                alert(data.message);
                initBlogList(1);
                initUserInfo();
            } else {
                //删除失败
                alert(data.message);
            }
        }

        function initBlogList(pageIndex) {
            $.getJSON("../control/blog", "opr=myBlogList&keyword=" + $("#keyword").val() + "&pageIndex=" + pageIndex, processBlogsList);
        }

        function processBlogsList(data) {
            //微博列表
            var blogDiv = $("#mainBannerContent").empty();
            $(data.blogsList).each(function () {
                var htmlStr = "<div class=\"stateOp\"><a class=\"opState\" href=\"\" onclick=\"javascript:deleteBlog(" + this.id + ")\">删除</a></div>";
                htmlStr += "<div class=\"stateShow\" onmouseover=\"stateMouseOver(this)\" onmouseout=\"stateMouseOut(this)\" onclick=\"go2detail(" + this.id + "," + ((this.uId == ${sessionScope.user.id}) ? 1 : 0) + ")\">" +
                    "<div class=\"stateShowWord\"><table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"stateTable\"><tr>" +
                    "<td width=\"70\" align=\"center\" valign=\"top\"><a href=\"#\"><img src=\"../${sessionScope.user.image}\" alt=\"\" width=\"48\" height=\"48\"></a></td>" +
                    "<td width=\"380\"><a href=\"#\">${sessionScope.user.nickname}</a><img src=\"../images/1.gif\" style=\"border:none;vertical-align:middle;\" alt=\"\">&nbsp;" + this.content +
                    "</td></tr>";
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
                blogDiv.append(htmlStr);
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

        $(document).ready(function () {
            initBlogList(1);
            initUserInfo();
        })
    </script>
</head>
<%@ include file="../control/login_control.jsp" %>
<body>
<%@ include file="page_element/top.jsp" %>
<!-- 内容总容器 mainDIV 开 始-->
<div id="main">
    <!-- 左侧mainBannerDIV 开始 -->
    <div id="mainBanner">
        <!-- 左侧mainBannerTopDIV 开始 -->
        <div id="mainBannerTop">
            <!-- 左侧mainBannerTopImgDIV 开始 -->
            <div id="mainBannerTopImg">
            </div>
            <!-- 左侧mainBannerTopImgDIV 结束 -->
            <!-- 左侧mainBannerToWordDIV 开始 -->
            <div id="mainBannerTopWord"><span style="color: #330000"><b>${blog.nickname}</b></span><br/>
                <a href="#">${user.mysite ne null ? user.mysite:""}</a>
            </div>
            <!-- 左侧mainBannerTopWordDIV 结束 -->
        </div>
        <!-- 左侧mainBannerTopDIV 结束 -->
        <!-- 左侧mainBannerMenuDIV 开始 -->
        <div id="mainBannerMenu">
            <!-- 左侧mainBannerMenuTopDIV 开始 -->
            <div id="mainBannerMenuTop">
                <!-- 左侧mainBannerMenuTopWord1DIV 开始 -->
                <div id="mainBannerMenuTopWord1"><b>我自己</b>
                </div>
                <!-- 左侧mainBannerMenuTopWord1DIV 结束-->
                <!-- 左侧mainBannerMenuTopWord2DIV 开始 -->
                <div id="mainBannerMenuTopWord2">
                    <form id="form2" name="form2" method="post" action="">
                        <a href="home.jsp"><img src="../images/mainBannerMenuTopWord2.gif" title="" alt=""/>发微博</a>
                        <div id="search">
                            <input type="text" name="keyword" id="keyword" value=""/>
                            <img src="../images/sousuo1.gif" alt="" width="27" height="25"
                                 style="vertical-align: middle;" onClick="javascript:initBlogList(1)"/>
                        </div>
                    </form>
                </div>
                <!-- 左侧mainBannerMenuTopWord2DIV 结束 -->
            </div>
            <!-- 左侧mainBannerMenuTopDIV 结束-->
        </div>
        <!-- 左侧mainBannerMenu DIV 结束-->
        <!--自己发微博的地方-->
        <div id="mainBannerContent">
        </div>
        <!--自己发微博的地方结束-->
        <!--分页-->
        <p align="center" id="pageDiv">
        </p>
    </div>
    <!-- 左侧mainBannerDIV 结束 -->
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

            <!-- 右侧mainRightPostionSeventhLine DIV 开始 -->
            <div id="mainRightPostionSixthLine">
                <div id="mainRightPositionSixthLineContent">
                    微博的成长，离不开你们。<br/>
                    <span class="style2"><a href="#" class="a1">有意见要提（点击） </a><br/><br/>
                    <a href="#" class="a1" onclick="set()">不良信息举报中心</a></span>
                </div>
            </div>
            <!-- 右侧mainRightPostionSixthLine DIV 结束 -->
        </div>
    </div>
</div>
<!-- 内容总容器 mainDIV 结束-->
<%@ include file="page_element/footer.jsp" %>
</div>
<!--总容器 container结束-->
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</body>
</html>
