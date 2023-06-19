<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>微博-点滴生活，精彩世界</title>
    <link href="styles/index.css" type="text/css" rel="stylesheet"/>
    <link href="styles/global.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="script/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="script/trim.js"></script>
    <script src="script/index.js" type="text/javascript"></script>
</head>
<!-- 总容器 continer DIV 开始 -->
<body>
<div id="continer">
    <!-- top部分DIV -->
    <div id="top">
        <!-- top部分的LogoDIV -->
        <div id="topLogo">
            <!-- topLogo部分的icoDIV -->
            <div id="topLogoIco"><a href="index.html"><img src="images/logo.png" width="177" height="72" alt=""/></a>
            </div>
            <!-- topLogo部分的icoDIV结束 -->
        </div>
        <!-- top部分的LogoDIV结束 -->

        <!-- top部分的文字导航 -->
        <div id="topWordMenu">
            <ul>
                <li>已有账号，<a href="pages/login.jsp">请登录</a></li>
                <li><a href="#">帮助</a></li>
            </ul>
        </div>
        <!-- top部分的文字导航结束 -->
    </div>
    <!-- top部分结束 -->

    <!-- 下部容器 main DIV 开始 -->
    <div id="main">
        <!-- 下部容器头部注内 DIV 开始 -->
        <div id="mainTop">
            <!--下部容器头部注册内容 DIV 开始 -->
            <div id="mainTopContent">
                <!-- 字体DIV 开始 -->
                <div id="topWord" class="topWord"> 点击生活，精彩世界，快来加入微博吧</div>
                <!-- 字体DIV 结束 -->
                <!-- 注册按钮 DIV 开始 -->
                <div id="ZCButton"><img src="images/ZCButton.gif" onclick="quickZC()" alt=""/></div>
                <!-- 注册按钮 DIV 结束-->
            </div>
            <!-- 下部容器头部注内容册 DIV 结束 -->
        </div>
        <!-- 下部容器头部注内 DIV 结束 -->
        <!--下部容器左侧mainBanner DIV 开始 -->
        <div id="mainBanner">
            <!-- 左侧内容 DIV 开始 -->
            <div id="mainBannerContent">
                <!--id="mainBannerTitle 首页-->
                <div id="mainBannerTitle">
                    <!--id="mainBannerTitleWord"-->
                    <div id="mainBannerTitleWord">热门微博</div>
                    <div id="mainBannerTitleWord2">
                        <form action="" method="get">
                            <label for="textfield1"></label><input type="text" name="textfield" id="textfield1"/>
                            <a href="#"><img src="images/search.gif" alt="" width="27" height="25"
                                             style="border: none; vertical-align: middle;" title=""/></a>
                        </form>
                    </div>
                </div>
                <!--不同人的内容-->
                <div id="mainBannerContent">
                    <!--个人展示，自己发表的-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img
                                            src="images/MainRightFirstLineTitle.gif" alt="" width="48" height="48"></a>
                                    </td>
                                    <td width="380"><a href="#">DarkDemon</a><img src="images/1.gif"
                                                                                  style="border:none;vertical-align:middle;"
                                                                                  alt="">&nbsp;哈喽~，艾瑞巴蒂~
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow"></div>
                        <div class="stateShowtime"> 9月16日 13:47</div>
                        <div class="stateOp"><a class="opState" onclick="javascript:;">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示，关注的-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img src="images/face/16.jpg"
                                                                                                alt="" width="48"
                                                                                                height="48"/></a></td>
                                    <td width="380"><a href="#">娱乐探神</a><img src="images/1.gif"
                                                                             style="border:none;vertical-align:middle;"
                                                                             alt=""/>华为的股权结构真的很厉害，任正非最大个人股东，占比0.88%。其余10万员工占99.12%。离职自动回收，只分红不能转让，真心厉害！
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow"><img src="images/state1.jpg" alt=""/></div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a class="opState" onclick="javascript:;">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img
                                            src="images/mainBannerContent2People1Img.gif" width="54" height="54" alt=""
                                            title=""/></a></td>
                                    <td width="380"><a href="#">时间的朋友</a><img src="images/1.gif"
                                                                              style="border:none;vertical-align:middle;"
                                                                              alt=""/>【库克和郭台铭直接傻眼，印度竟没签RCEP。富士康当初去印度建厂，本就是看中优惠补贴和低廉的劳动力去的，没成想印度来这么一出，说不签就不签了。要知道这个RCEP就是东盟国家和印度等大力推行的，本来富士康在印度就因为工人效率低，交通也不便利白白烧了不少钱，但盘算着以后有了RCEP，关税上的大大降低留在这还是省一大笔钱的。如今呢，苹果不可能放弃几乎覆盖全球1/3的人口，占世界GDP32.7%的RCEP参与国的巨大市场，那商人逐利天经地义，中国成功签署RCEP，还有着印度远远赶不上的效率交通市场等硬件条件，选择不言自明。郭台铭后悔也来不及了国内苹果早先就已经把大部分份额转移给比亚迪和立讯了，美国的建厂苹果不给补贴也是遥遥无期，这下印度的“退群”又无疑给倚靠苹果的郭台铭当头一棒
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow"><img src="images/SCT.gif" width="34" height="166" alt="" title=""/>
                        </div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a onclick="javascript:;" class="opState">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img
                                            src="images/mainBannerContent2People2Img.gif" width="54" height="54" alt=""
                                            title=""/></a></td>
                                    <td width="380"><a href="#">乡下妹</a><img src="images/1.gif"
                                                                            style="border:none;vertical-align:middle;"
                                                                            alt=""/>没有婚姻是4年一次的
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow">
                            <img src="images/SCT.gif" width="34" height="166" alt="" title=""/></div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a onclick="javascript:;" class="opState">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img
                                            src="images/mainBannerContent2People3Img.gif.gif" width="54" height="54"
                                            alt="" title=""/></a></td>
                                    <td width="380"><a href="#">经典微博语录</a><img src="images/1.gif"
                                                                               style="border:none;vertical-align:middle;"
                                                                               alt=""/>新媒体、新趋势
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow">
                            <img src="images/people2.gif" alt=""/></div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a onclick="javascript:;" class="opState">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img
                                            src="images/mainBannerContent2People1Img.gif" width="54" height="54" alt=""
                                            title=""/></a></td>
                                    <td width="380"><a href="#">漂流瓶</a><img src="images/1.gif"
                                                                            style="border:none;vertical-align:middle;"
                                                                            alt=""/>“伊万卡夫妇是藤校出身、依赖全球化的精英，却选择把自己的命运和她父亲的命运捆绑在一起，选择搭她父亲的便车，选择看看这样能带他们走多远，最终成为他身边最光鲜亮丽的骗子。是时候付出代价了。”
                                        —-《纽约时报》
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow"></div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a onclick="javascript:;" class="opState">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                    <!--个人展示-->
                    <div class="stateShow" onmouseover="stateMouseOver(this)" onmouseout="stateMouseOut(this)"
                         onclick="go2login()">`````
                        <div class="stateShowWord">
                            <table width="450" border="0" cellpadding="0" cellspacing="0" class="stateTable">
                                <tr>
                                    <td width="70" align="center" valign="top"><a href="#"><img src="images/state2.jpg"
                                                                                                alt="" width="48"
                                                                                                height="48"/></a></td>
                                    <td width="380"><a href="#">家人杂志</a><img src="images/1.gif"
                                                                             style="border:none;vertical-align:middle;"
                                                                             alt=""/>分享图片:二十多年前,林青霞和邓丽君在法国戛纳.当时最红的两位女子定格在一起,她们陪伴多少人走过那段流金岁月?
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="stateImgShow">
                            <img src="images/state3.jpg" alt=""/></div>
                        <div class="stateShowtime"> 07月31日 08:02</div>
                        <div class="stateOp"><a onclick="javascript:;" class="opState">回复 1000</a><a class="opState">转发
                            1000</a><a class="opState" onclick="">赞 1000</a></div>
                        <div class="huifu"></div>
                    </div>
                    <!--个人展示结束-->
                </div>
            </div>
        </div>
        <!--下部容器左侧mainBanner DIV 结束 -->
        <!--下部容器右侧mainRight DIV 开始 -->
        <div id="mainRight">
            <!--下部容器右侧mainRight1Banner DIV 开始 -->
            <div id="mainRightBanner">
                <!--下部容器右侧mainRight1BannerMenu DIV 开始 -->
                <div id="mainRightBannerMenu">
                    <!--下部容器右侧mainRight1BannerMenuTop DIV 开始 -->
                    <div id="mainRightBannerMenuTop"><b>今日发布最多的用户</b>
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuTop DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg1.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">雨中人87</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>332</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg2.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">莪程</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>308</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg3.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">每日热点</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>272</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg4.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">江南水玲</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>246</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg5.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">萧萧雨歇</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>243</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg6.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">住无边慧</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>238</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg7.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">阿奎力斯</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>236</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg8.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">仿织公</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>194</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg9.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">花国宝</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>185</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg10.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">ZGONGGUODAYE</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>166</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                </div>
                <!--下部容器右侧mainRight1BannerMenu DIV 结束 -->
                <div id="mainRightBannerMenu">
                    <!--下部容器右侧mainRight1BannerMenuTop DIV 开始 -->
                    <div id="mainRightBannerMenuTop"><b>今日转发 1000最多的用户</b>
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuTop DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg5.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">萧萧雨歇</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>431</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg11.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">无名花飘香</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>420</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg9.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">花国宝</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>386</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg8.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">仿织公</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>286</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg2.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">莪程</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>232</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg12.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">射京办主任</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>215</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg13.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">王金法</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>207</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg14.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">我是猫人</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>198</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg15.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">拿着傻瓜机的菜鸟</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>180</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 开始 -->
                    <div id="mainRightBannerMenuPeople">
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleImg"><a href="#"><img
                                src="images/mainRight1BannerMenuPeopleImg16.gif" alt="" style="vertical-align:middle;"
                                title=""/></a>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleImg DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord1"><a href="#">张铁</a><br/>
                            <a href="#">加关注
                            </a></div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord1 DIV 结束 -->
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 开始 -->
                        <div id="mainRightBannerMenuPeopleWord2"><b>153</b>
                        </div>
                        <!--下部容器右侧mainRight1BannerMenuPeopleWord2 DIV 结束 -->
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuPeople DIV 结束 -->
                </div>
                <!--下部容器右侧mainRight1BannerMenu DIV 结束 -->
                <div id="mainRightBannerMenu"> <!--下部容器右侧mainRight1BannerMenuTop DIV 开始 -->
                    <div id="mainRightBannerMenuTop"><b><span class="customerWord2"
                                                              style="font-size:medium;">今日热门话题</span></b>
                    </div>
                    <!--下部容器右侧mainRight1BannerMenuTop DIV 结束 -->
                    <!--下部容器右侧mainRight1BannerMenuRank DIV 开始 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">1</span>&nbsp;<a
                            href="#">中超</a>&nbsp;（3042）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">2</span>&nbsp;<a
                            href="#">暴雨</a>&nbsp;（9200）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">3</span>&nbsp;<a
                            href="#">伊伊</a>&nbsp;（1333）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">4</span>&nbsp;<a
                            href="#">变形金刚</a>&nbsp;（3209）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">5</span>&nbsp;<a
                            href="#">情人节</a>&nbsp;（8129）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">6</span>&nbsp;<a
                            href="#">双色球</a>&nbsp;（1711）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">7</span>&nbsp;<a
                            href="#">哈利波特</a>&nbsp;（715）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">8</span>&nbsp;<a
                            href="#">还珠格格</a>&nbsp;（1418）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">9</span>&nbsp;<a
                            href="#">味千拉面</a>&nbsp;（812）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                    <div id="mainRightBannerMenuRank"><span class="customerWord2" style="font-size:large;">10</span>&nbsp;<a
                            href="#">上座率</a>&nbsp;（1746）
                    </div>
                    <!--下部容器右侧mainRight1BannerRank DIV 结束 -->
                </div>
                <!--下部容器右侧mainRight1BannerMenu DIV 结束 -->
            </div>
            <!--下部容器右侧mainRight1Banner DIV 结束 -->
        </div>
        <!--下部容器左侧mainRight DIV 结束 -->
    </div>
    <!-- 下部容器 main DIV 结束 -->
    <!-- 脚部footer DIV 开始 -->
    <div id="footer">
        <!-- footer网站链接部分 -->
        <div id="footerLink">
            <ul>
                <li><a href="#" class="a2">介绍</a></li>
                <li><a href="#" class="a2">广告服务</a></li>
                <li><a href="#" class="a2">API</a></li>
                <li><a href="#" class="a2">诚征英才</a></li>
                <li><a href="#" class="a2">保护隐私权</a></li>
                <li><a href="#" class="a2">免责条款</a></li>
                <li><a href="#" class="a2">法律顾问</a></li>
                <li><a href="#" class="a2">意见反馈</a></li>
            </ul>
        </div>
        <!-- footer网站链接部分结束 -->
        <!-- footer网站版权信息 -->
        <div id="footerCopy">
            Copyright&copy;2011-2012 版权所有
        </div>
        <!-- footer网站版权信息结束 -->
    </div>
    <!-- 脚部footer DIV 开始 -->

</div>
<!-- 总容器 continer DIV 结束 -->
<p id="backtop"><a id="backtop1" href="#totop"><span>回到顶部</span></a></p>
</body>
</html>
