<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>粉丝管理 微博-点滴生活，精彩每一天！</title>
    <link href="../styles/global.css" type="text/css" rel="stylesheet">
    <link href="../styles/friend.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="../script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="../script/trim.js"></script>
    <script type="text/javascript" src="../script/detail.js"></script>
</head>
<body>
<!-- 页面整体 -->
<%@ include file="page_element/top.jsp" %>
<!-- 页面主体 -->
<div id="main">
    <div id="mainBanner">
        <table width="765" border="0" cellpadding="0" cellspacing="0" id="tb1">
            <tr>
                <td width="21" rowspan="6" class="td1"></td>
                <td height="60" align="center" valign="middle" bgcolor="#FFFFFF" class="td2">
                    <img src="../images/MainRightFirstLineTitle.gif" width="48" height="48" alt=""/></td>
                <td height="60" class="td3"><span
                        style="color: #000000; font-size: medium;"><b>关注你的人（${sessionScope.fansCount}）</b></span>
                </td>
                <td rowspan="6" class="td1 height"></td>
            </tr>
            <tr>
                <td height="47" align="center" valign="middle" bgcolor="#e3f1fa" class="td2 font1">列表</td>
                <td height="47" align="center" valign="middle" bgcolor="#e3f1fa" class="td4 font1">
                    <form id="form2" name="form2" method="post" action="../control/follow?opr=fansList">
                        <div id="search">
                            <input type="text" name="keyword" id="keyword"
                                   value="${requestScope.keyword eq null? "":requestScope.keyword}"/>
                            <img src="../images/sousuo1.gif" alt="" width="27" height="25"
                                 style="vertical-align: middle" onclick="javascript:document.form2.submit()"/>
                        </div>
                    </form>
                </td>
            </tr>
            <c:if test="${requestScope.list ne null}">
                <c:forEach var="fans" items="${requestScope.list}">
                    <tr>
                        <td height="105" align="center" valign="middle" class="td2"><img src="../${fans.image}"
                                                                                         width="48" height="48" alt=""/>
                        </td>
                        <td height="105" align="left" valign="bottom" class="td3"><span
                                style="color: #005dc3; font-size: medium; font-family: 微软雅黑"><b>${fans.nickname}</b></span>
                            <img src="images/1.gif" width="17" height="15" alt=""/><br/><span
                                    style="color: #000000; font-size: small;">${fans.address}</span>
                            <br/><span
                                    style="color: #000000; font-size: small;">${fans.sign ne null ? fans.sign:""}</span>
                            <div id="focus1">
                                <c:choose>
                                    <c:when test="${fans.followed}">
                                        <img src="../images/isFollowed.png" alt="" width="55" height="23"
                                             style="vertical-align: bottom"
                                             onclick="javascript:window.location='../control/follow?opr=delete&id=${fans.id}'"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img src="../images/addFollow.png" alt="" width="55" height="23"
                                             style="vertical-align: bottom"
                                             onclick="javascript:window.location='../control/follow?opr=follow&id=${fans.id}'"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
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
</body>
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</html>
