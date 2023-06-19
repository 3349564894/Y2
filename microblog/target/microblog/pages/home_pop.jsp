<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        function showFileUpload() {
            var obj = document.getElementById("fileUpload");
            obj.style.visibility = "visible";
        }

        function closeFileUpload(obj) {
            obj.parentNode.parentNode.style.visibility = "hidden";
        }

        function check() {
            var content = document.getElementById("textfield2");
            if (content.value == "") {
                alert("请输入微博内容！！");
                content.focus();
                return false;
            }
            return true;
        }

        function resetContent() {
            var txtObj = document.getElementById("textfield2");
            var hiddenTxtObj = document.getElementById("hiddenTextField");
            hiddenTxtObj.value = changetxt(txtObj.value);//替换文本框中的表情
        }

        function publishBlog() {
            if (check()) {
                resetContent();
                //获取表单数据
                var formData = new FormData($("#form1")[0]);
                formData.append("opr", "publish");
                $.ajax({
                    "url": "../control/blog",
                    "type": "POST",
                    "data": formData,
                    "async": false,
                    "cache": false,
                    "contentType": false,
                    "processData": false,
                    "dataType": "json",
                    "success": function (data) {
                        alert(data.message);
                        if (data.result == 1) {
                            //刷新数据
                            window.location.href = "home.jsp";
                        }
                    }
                });
            }
        }

        function initBlogList(pageIndex) {
            $.getJSON("../control/blog", "opr=popBlogList&keyword=" + $("#keyword").val() + "&pageIndex=" + pageIndex, processBlogsList);
        }

        function processBlogsList(data) {
            //显示微博列表
            var blogsDiv = $("#mainBannerContent").empty(); //微博列表父容器

            $(data.blogsList).each(function () {
                var htmlStr = "<div class=\"stateShow\" onmouseover=\"stateMouseOver(this)\" onmouseout=\"stateMouseOut(this)\" onclick=\"go2detail(" + this.id + "," + ((this.uId == ${sessionScope.user.id}) ? 1 : 0) + ")\">" +
                    "<div class=\"stateShowWord\"><div class=\"stateOp\">";
                if (this.uId != ${sessionScope.user.id} && this.user.followed == false) {
                    htmlStr += "<a class=\"opState\" onclick=\"changeOpState(this);follow(" + this.uId + ")\" >+&nbsp;关注</a>";
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
<%@ include file="../control/login_control.jsp" %>
<body style="filter:alpha(opacity=100)" id="totop">
<%@ include file="page_element/top.jsp" %>
<!-- 内容总容器 mainDIV 开 始-->
<div id="main">
    <!-- 左侧mainBannerDIV 开始 -->
    <div id="mainBanner">
        <!-- mainBannerTop DIV 开始 -->
        <div id="mainBannerTop">
            <!--id=mainBannerTopIssue 发布框-->
            <div id="mainBannerTopIssue">
                <!--id=mainBannerTopIssuePoint 提示-->
                <div id="mainBannerTopIssuePoint">正在发生的事情
                </div>
                <div style="float:right;">您还可以输入<span id="counter1">140</span>字！
                </div>
                <form action="" method="post" id="form1" enctype="multipart/form-data">
                    <div id="mainBannerTopIssueForm">
                        <!--id="mainBannerTopIssueFrame-->
                        <div id="mainBannerTopIssueFrame">
                            <label ur="textfield2"></label><textarea name="textfield1" rows="4" class="Size"
                                                                     id="textfield2"
                                                                     style="overflow:hidden;border:1px #0CF solid;"
                                                                     onkeyup="calNum(this,counter1,0)"></textarea>
                            <textarea name="hiddenTextField" id="hiddenTextField" hidden></textarea>
                        </div>
                        <!--id="mainBannerTopIssueInsert 插入链接-->
                        <div id="mainBannerTopIssueInsert">
                            <!--4个小div-->
                        </div>
                        <!--确认发布-->
                        <div id="mainBannerTopIssueSure">
                            <div id="mainBannerTopIssueSure2"><a href="javascript:showFileUpload()" class="a1">
                                <div id="mainBannerTopIssueInsert1"></div>
                                <div id="mainBannerTopIssueInsert2">插入图片</div>
                            </a>
                                <a href="javascript:biaoQingXianShi()" class="a1">
                                    <div id="mainBannerTopIssueInsert5"></div>
                                    <div id="mainBannerTopIssueInsert6">插入表情</div>
                                </a>
                                <div id="fileUpload"
                                     style="visibility:hidden;position: absolute;top:22px;left:70px;z-index: 2;background-color: #FFFFFF;border-style: solid;border-color: black;border-width: 1px">
                                    <div><img src="../images/hongcha1.gif" alt="" width="14" height="13"
                                              style="vertical-align: middle;" title=""
                                              onclick="javascript:closeFileUpload(this)"/></div>
                                    <div><input type="file" name="filefield" id="filefield"></div>
                                </div>
                                <input type="button" name="button1" id="button1" value="发布"
                                       style="background-color:#3295E6; border:none" onclick="publishBlog()"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 表情DIV -->
            <div id="biaoqing">
                <table width="200" border="1" cellspacing="0" cellpadding="0">
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
        </div>

        <!--id="mainBannerTitle 首页-->
        <div id="mainBannerTitle">
            <!--id="mainBannerTitleWord"-->
            <div id="mainBannerTitleWord"><a href="home.jsp"><b>首页</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<b>热门</b>
            </div>
            <div id="mainBannerTitleWord2">
                <form id="form2" name="form2" action="" method="post">
                    <div id="search">
                        <input type="text" name="keyword" id="keyword" value=""/>
                        <a href="#"><img src="../images/search.gif" alt="" width="27" height="25"
                                         style="border: none; vertical-align: middle;" title=""
                                         onClick="javascript:initBlogList(1)"/></a>
                    </div>
                </form>
            </div>
        </div>
        <!--不同人的内容-->
        <div id="mainBannerContent">
            <!--个人展示，热门-->
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
                    <a href="mycollection.jsp" class="a1"><span class="style3">我的收藏</span></a>
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
<!-- footer部分结束 -->

</div>
<!--总容器 container结束-->
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</body>
</html>
