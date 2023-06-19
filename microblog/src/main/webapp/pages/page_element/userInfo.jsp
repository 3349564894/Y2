<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    function initUserInfo() {
        $.getJSON("../control/userInfo", showUserInfo);
    }

    function showUserInfo(data) {
        $("#blogCount").empty().append(data.blogCount);
        $("#followerCount").empty().append(data.followerCount);
        $("#fansCount").empty().append(data.fansCount)
    }
</script>
<!-- 右侧mainRightPostionFirstLine DIV 开始 -->
<div id="mainRightPostionFirstLine" onload="">
    <!-- 右侧mainRightPostionFirstLineIcon DIV 开始 -->
    <div id="mainRightPostionFirstLineIcon">
        <a href="#"><img src="../${sessionScope.user.image}" alt="" width="48" height="48"
                         style="vertical-align: middle;border: none;" title=""/></a>
    </div>
    <!-- 右侧mainRightPostionFirstLineIcon DIV 结束 -->
    <!-- 右侧mainRightPostionFirstLineWord1 DIV 开始 -->
    <div id="mainRightPostionFirstLineWord1">
        &nbsp;<span style="color: #005DC3;"><b><a href="../mywb.jsp"
                                                  class="a1">${sessionScope.user.nickname}</a></b></span><br/>
        &nbsp;${sessionScope.user.address}
    </div>
    <!-- 右侧mainRightPostionFirstLineWord1 DIV 结束 -->
    <!-- 右侧mainRightPostionFirstLineWord2 DIV 开始 -->
    <div id="mainRightPostionFirstLineWord2">
        <ul id="ul1">
            <li><a href="../mywb.jsp" class="a1"><span class="style1"
                                                       id="blogCount">${sessionScope.blogCount}</span><br/><span
                    class="style2">微博</span></a></li>
            <li><a href="../follower.jsp" class="a1"><span class="style1"
                                                           id="followerCount">${sessionScope.followerCount}</span><br/><span
                    class="style2">关注</span></a></li>
            <li><a href="../control/follow?opr=fansList" class="a1"><span class="style1"
                                                                          id="fansCount">${sessionScope.fansCount}</span><br/><span
                    class="style2">粉丝</span></a></li>
        </ul>
    </div>
    <!-- 右侧mainRightPostionFirstLineWord2 DIV 结束 -->
</div>
