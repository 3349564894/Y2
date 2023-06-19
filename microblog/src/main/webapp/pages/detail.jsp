<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微博-点滴生活，精彩世界</title>
    <link href="../styles/detail.css" type="text/css" rel="stylesheet"/>
    <link href="../styles/global.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="../script/trim.js"></script>
    <script src="../script/detail.js" type="text/javascript"></script>
    <script type="text/javascript">
        function check() {
            var content = document.getElementById("ta1");

            if (content.value == "") {
                alert("请输入回复内容！！");
                content.focus();
                return false;
            }
            return true;
        }

        function initBlog() {
            $.ajax({
                "url": "../control/blog",
                "type": "GET",
                "data": "opr=detail&id=" +${param.id},
                "dataType": "json",
                "success": showBlogDetail
            });
        }

        function showBlogDetail(data) {
            var blogDiv = $(".stateShowWord").empty();
            var htmlStr = "<table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"stateTable\">" +
                "<tr>" + "<td width=\"70\" align=\"center\" valign=\"top\"><a href=\"#\"><img src=" + data.user.image + "\"..\" width=\"54\" height=\"54\" alt=\"\" title=\"\"></a></td>" +
                "<td width=\"380\"><a href=\"#\" id=\"blogWriter\">" + data.user.nickname + "</a><img src=\"../images/1.gif\" style=\"border:none;vertical-align:middle;\" alt=\"\"/>" +
                "<div class=\"stateOp\">";
            if (!data.user.followed) {
                htmlStr += "<a class=\"opDone\" onclick=\"changeOpState(this);follow(" + data.uId + ")\">+&nbsp;关注</a>";
            }
            htmlStr += "</div><div id=\"blogContent\">" + data.content + "</div></td></tr>";
            if (data.state == 2) {
                if (data.origin != null) {
                    htmlStr += " <tr><td></td><td width=\"380\">@" + data.origin.user.nickname + ":" + data.origin.content + "</td></tr>";
                } else {
                    htmlStr += "<tr><td></td><td width=\"380\">原始微博已无法显示！</td></tr>";
                }
            }
            htmlStr += "</table>";
            blogDiv.append(htmlStr);
            var blogImg = $("#blogImg").empty();
            if (data.state == 1) {
                if (data.images != null) {
                    blogImg.append("<img src=" + data.images + "\"..\" width=\"34\" title=\"\" />");
                }
            } else {
                if (data.origin != null && data.origin.images != null) {
                    blogImg.append("<img src=" + data.origin.images + "\"..\" width=\"34\" title=\"\" />");
                }
            }

            $(".stateShowtime").empty().append(data.time);
            var staticDiv = $("#staticDiv").empty();
            htmlStr = "<a onclick=\"reXianShi(this,1)\" class=\"opDone\" href=\"#\">回复 " + data.commentCount + "</a>";
            htmlStr += "<a href=\"#\" class=\"opState\" onclick=\"reXianShi(this,2)\">转发 " + data.forwardCount + "</a>";
            if (!data.liked) {
                htmlStr += "<a href=\"#\" class=\"opState\" onclick=\"changeOpState(this);addOrCancelLikes(" + data.id + ");\">赞 " + data.likesCount + "</a>";
            } else {
                htmlStr += "<a href=\"#\" class=\"opDone\" onclick=\"changeOpState(this);addOrCancelLikes(" + data.id + ");\">赞 " + data.likesCount + "</a>";
            }
            if (!data.collected) {
                htmlStr += "<a class=\"opState\" onclick=\"changeOpState(this);addOrCancelCollection(" + data.id + ")\" href=\"#\">收藏 " + data.collectionCount + "</a>";
            } else {
                htmlStr += "<a class=\"opDone\" onclick=\"changeOpState(this); if(confirm('确定取消收藏吗?')){addOrCancelCollection(" + data.id + ")}\" href=\"#\">收藏 " + data.collectionCount + "</a>";
            }
            staticDiv.append(htmlStr);
            //显示右侧个人信息
            htmlStr = "<a href=\"#\"><img src=" + data.user.image + "\"..\" alt=\"\" width=\"48\" height=\"48\" style=\"vertical-align: middle;border: none;\" title=\"\" /></a>";
            $("#mainRightPostionFirstLineIcon").empty().append(htmlStr);
            htmlStr = "<span style=\"color: #005DC3;\"><b><a href=\"#\" class=\"a1\">" + data.user.nickname + "</a></b></span><br />&nbsp;" + data.user.address;
            $("#mainRightPostionFirstLineWord1").empty().append(htmlStr);
            changeDivHeight();
        }

        function initBlogComments(pageIndex) {
            $.ajax({
                "url": "../control/comment",
                "type": "GET",
                "data": "opr=commentList&pageIndex=" + pageIndex + "&id=" +${param.id},
                "dataType": "json",
                "success": showBlogComments
            });
        }

        function showBlogComments(data) {
            //显示评论列表
            var commentDiv = $("#comments").empty();
            $(data.commentList).each(function () {
                var htmlStr = "<div class=\"stateRshow\"><div class=\"stateRshowWord\"><table width=\"380\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"stateTable\">";
                htmlStr += "<tr><td width=\"70\" align=\"center\" valign=\"top\"><a href=\"#\"><img src=" + this.uImage + "\"..\" alt=\"\" width=\"48\" height=\"48\"></a></td>";
                htmlStr += "<td width=\"310\"><a href=\"#\">" + this.uNickname + "</a><img src=\"../images/1.gif\" style=\"vertical-align:middle;border:none;\" alt=\"\"/>" + this.content + "</td>";
                htmlStr += "</tr></table></div><div class=\"stateRimgShow\"></div><div class=\"stateRshowtime\">" + this.time + "</div></div>";
                commentDiv.append(htmlStr);
            });

            //显示分页
            var pageDiv = $("#pageDiv").empty(); //显示分页的父容器
            pageDiv.append("当前页数:[" + data.currPageNo + "/" + data.totalPageCount + "]&nbsp;");
            if (data.currPageNo > 1) {
                pageDiv.append("<a href=\"javascript:initBlogComments(1)\">首页</a>&nbsp;");
                pageDiv.append("<a href=\"javascript:initBlogComments(" + (data.currPageNo - 1) + ")\">上一页</a>&nbsp;");
            }
            if (data.currPageNo < data.totalPageCount) {
                pageDiv.append("<a href=\"javascript:initBlogComments(" + (data.currPageNo + 1) + ")\">下一页</a>&nbsp;");
                pageDiv.append("<a href=\"javascript:initBlogComments(" + (data.totalPageCount) + ")\">末页</a>");
            }
            changeDivHeight();
        }

        function forward() {
            windowClose(document.getElementById("closeForwardBtn"));
            $.ajax({
                "url": "../control/blog",
                "type": "POST",
                "data": "opr=forward&content=" + $("#ta2").val() + "&blogId=" +${param.id},
                "dataType": "json",
                "success": forwardSuccess
            });
        }

        function forwardSuccess(data) {
            alert(data.message);
            if (data.result == 1) {
                //刷新微博信息
                initBlog();
            }
        }

        function sendComment() {
            if (check()) {
                windowClose(document.getElementById("closeCommentBtn"));
                var $commentInputs = $("#wt1").find(":input");
                var queryString = $commentInputs.serialize();
                $.post("../control/comment", queryString + "&opr=add&id=" +${param.id}, sendCommentSuccess, "json");
            }
        }

        function sendCommentSuccess(data) {
            alert(data.message);
            if (data.result == 1) {
                //刷新
                initBlog();
                initBlogComments(1);
            }
        }

        function follow(id) {
            $.getJSON("../control/follow", "opr=follow&id=" + id,
                function (data) {
                    alert(data.message);
                    if (data.result == 1) {
                        initBlog();
                    }
                });
        }

        function addOrCancelLikes(id) {
            $.getJSON("../control/likes", "opr=likeOrCancel&id=" + id,
                function (data) {
                    alert(data.message);
                    if (data.result == 1) {
                        initBlog();
                    }
                }
            );
        }

        function addOrCancelCollection(id) {
            $.getJSON("../control/collection", "opr=collectOrCancel&id=" + id,
                function (data) {
                    alert(data.message);
                    if (data.result == 1) {
                        initBlog();
                    }
                });
        }

        $(document).ready(function () {
            initBlog();
            initBlogComments(1);
        });
    </script>
</head>
<%@ include file="../control/login_control.jsp" %>
<body style="filter:alpha(opacity=100)" id="totop">
<%@ include file="page_element/top.jsp" %>
<!-- 内容总容器 mainDIV 开 始-->
<div id="main">
    <!-- 左侧mainBannerDIV 开始 -->
    <div id="mainBanner">
        <!--微博详情-->
        <div id="mainBannerContent">
            <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)">
                <div class="stateShowWord">
                    <!--微博信息-->
                </div>
                <div class="stateImgShow" id="blogImg"></div>
                <!--微博图片-->
                <div class="stateShowtime"><%--${util:getFormatTime(blog.time)}--%></div>
                <div class="stateOp" id="staticDiv">
                    <!--微博操作-->
                </div>
                <div class="huifu" id="comments">
                    <!--微博评论-->
                </div>
                <!--分页-->
                <p align="center" id="pageDiv">
                    <!--评论分页-->
                </p>
            </div>
            <!--回复 100DIV-->
            <div id="recieve">
                <div id="ff1" style="float:left;"><span style="font-size:16px; color:#FDFDFD"><label for="ta1">&nbsp;&nbsp;&nbsp;&nbsp;回&nbsp;&nbsp;复</label></span>
                </div>
                <div id="left" style="float:right; margin-top:10px; color:#FFF; margin-right:10px;">您还有可以输入<span
                        id="counter1" style="color:#ffffff;">140</span>字！&nbsp;&nbsp;&nbsp;<img
                        src="../images/hongcha1.gif" alt="" width="14" height="13" style="vertical-align: middle;"
                        title="" onclick="windowClose(this)" id="closeCommentBtn"/></div>
                <br/>
                <div id="wt1">
                    <form action="" method="post">
                            <textarea name="ta1" cols="" rows="" id="ta1" onkeyup="calNum(this,counter1,1)"
                                      style="overflow:hidden;border:1px #0CF solid;">
                            </textarea>
                        <br/>
                        <div style="float:right; margin-right:25px; margin-top:7px; text-align:right;">
                            <input name="" type="button" value=" 回 复 " id="sub1" onclick="sendComment()"/>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 回复 100DIV 结束 -->
            <!--转发 100DIV-->
            <div id="forward">
                <div id="ff2" style="float:left;"><span style="font-size:16px; color:#FDFDFD"><label for="ta1">&nbsp;&nbsp;&nbsp;&nbsp;转发 </label></span>
                </div>
                <div id="left" style="float:right; margin-top:10px; color:#FFF; margin-right:10px;">您还有可以输入<span
                        id="counter2" style="color:#ffffff;">140</span>字！&nbsp;&nbsp;&nbsp;<img
                        src="../images/hongcha1.gif" alt="" width="14" height="13" style="vertical-align: middle;"
                        title="" onclick="windowClose(this)" id="closeForwardBtn"/></div>
                <br/>
                <div id="wt2">
                    <form action="" method="post">
                            <textarea name="ta2" cols="" rows="" id="ta2" onkeyup="calNum(this,counter2,1)"
                                      style="overflow:hidden;border:1px #0CF solid;">
                            </textarea>
                        <br/>
                        <div style="float:right; margin-right:25px; margin-top:7px; text-align:right;">
                            <input name="" type="button" value=" 转 发 " id="sub2" onclick="forward()"/>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 转发 100DIV 结束 -->
        </div>
        <!--微博详情结束-->
    </div>
    <!-- 左侧mainBannerDIV 结束 -->
    <!-- 右侧mainRight DIV开始 -->
    <div id="mainRight">
        <div id="mainRight1">
            <!-- 右侧mainRightPostionFirstLine DIV 开始 -->
            <div id="mainRightPostionFirstLine">
                <!-- 右侧mainRightPostionFirstLineIcon DIV 开始 -->
                <div id="mainRightPostionFirstLineIcon">
                    <%--                    <a href="#"><img src="../${blog.user.image}" alt="" width="48" height="48" style="vertical-align: middle;border: none;" title="" /></a>--%>
                </div>
                <!-- 右侧mainRightPostionFirstLineIcon DIV 结束 -->
                <!-- 右侧mainRightPostionFirstLineWord1 DIV 开始 -->
                <div id="mainRightPostionFirstLineWord1">
                    <%--                    &nbsp;<span style="color: #005DC3;"><b><a href="#" class="a1">${blog.user.nickname}</a></b></span><br />--%>
                    <%--                    &nbsp;${blog.user.address}--%>
                </div>
                <!-- 右侧mainRightPostionFirstLineWord1 DIV 结束 -->

            </div>
            <!-- 右侧mainRightPostionFirstLine DIV 结束 -->

            <!-- 右侧mainRightPostionSeventhLine DIV 开始 -->
            <!--<div id="mainRightPostionSeventhLine">
                <div id="mainRightPositionSevenLineContent">
                微博的成长，离不开你们。<br />
                <span class="style2"><a href="#" class="a1">有意见要提（点击） </a><br /><br />
                <a href="#" class="a1" onclick="set()">不良信息举报中心</a></span>
                </div>
            </div>-->
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
