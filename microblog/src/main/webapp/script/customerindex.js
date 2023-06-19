// JavaScript Document
var bqvalue = new Array("(smile)", "(亲亲)", "(偷笑)", "(傲慢)", "(再见)", "(冷汗)", "(发呆)", "(发怒)", "(可怜)", "(可爱)", "(右哼哼)", "(吐)", "(吓)", "(呲牙)", "(咒骂)", "(哈欠)", "(嘘!)", "(困)", "(坏笑)", "(大兵)", "(大哭)", "(奋斗)", "(委屈)", "(害羞)", "(尴尬)", "(左哼哼)", "(得意)", "(快哭了)", "(惊恐)", "(惊讶)", "(憨笑)", "(扣鼻)", "(抓狂)", "(折磨)", "(撇嘴)", "(擦汗)", "(敲打)", "(晕)", "(流汗)", "(流泪)", "(疑问)", "(白眼)", "(睡)", "(糗大了)", "(色)", "(衰)", "(调皮)", "(鄙视)", "(酷)", "(闭嘴)", "(阴险)", "(难过)", "(饥饿)", "(骷髅)", "(鼓掌)", "(糗大了)");

var hfObj;
var srcUser;

/* 设置页面中的主题部分的左栏和右栏部分高度为自动 */
function initDivHeight(divObj1, divObj2) {
    divObj1.style.height = "auto";
    divObj2.style.height = "auto";
}

/* 设置主体部分的高度以实际高度高的那个为准 */
function changeDivHeight() {
    var mainBanner = document.getElementById("mainBanner");
    var mainRight = document.getElementById("mainRight");
    initDivHeight(mainBanner, mainRight);//设置高度为自动
    // var height = mainBanner.offsetHeight > mainRight.offsetHeight ? mainBanner.offsetHeight : mainRight.offsetHeight;//获取高度高的值
    // mainBanner.style.height = height + "px";//为他们的高度都赋高的那个值
    // mainRight.style.height = height+ "px";//
}

/* 动态的计算文本框里面已经输入的数量  */
function calNum(txtobj, divobj, fg) {
    var str = txtobj.value;
    var n = 140;//初始化数字
    var tmp = str.replace(/[^\w\s]/g, "");//将文本框里面的字符中的中文全部替换成空的
    if (tmp != null)
        n = n - (str.length - tmp.length) - Math.floor(0.5 * tmp.length);//计算，一个中文是1个字符，2个英文是1个
    else
        n = n - Math.floor(0.5 * str.length);//计算，一个中文是1个字符，2个英文是1个
    if (n < 0) {
        divobj.style.color = "#969";//设置如果超了，变背景色为红色
    } else {
        if (fg == 1)//如果标记为1设置白色
            divobj.style.color = "#FFF";
        else//如果标记为0 设置为黑色
            divobj.style.color = "#000";
    }
    /* 将计算好的数存入div中 */
    divobj.innerHTML = n;
}

/* 显示表情框 */
function biaoQingXianShi() {
    var divObj = document.getElementById("biaoqing");
    divObj.style.visibility = "visible";//设置表情框显示
}

/* 设置如果单击事件，就隐藏表情框 */
function judeState() {
    var divObj = document.getElementById("biaoqing");
    if (divObj.style.visibility == "visible") {
        divObj.style.visibility = "hidden";//隐藏表情框
    }
}

/* 初始化表情框里面的表情 */
function initImgFace() {
    var n = 1;
    var divObj = document.getElementById("biaoqing");
    var trObj = clearWhitespace(divObj).childNodes[0].rows;//取得tr对象数组
    for (var i = 0; i < trObj.length; i++) {
        var tdObj = trObj[i].cells;//取得相对tr的td对象数组
        for (var j = 0; j < tdObj.length; j++) {//将td里面填充出相应的图片
            tdObj[j].innerHTML = "<img src='../images/biaoqing/" + n + ".gif' width='24' height='24' alt='' title= '" + bqvalue[n - 1] + "'/>";
            n++;
        }
    }
}

/* 当点提交按钮时，对文本框里面的内容进行处理，并进行提交 */
function submitState() {
    var txtObj = document.getElementById("textfield2");
    txtObj.value = trim(txtObj.value);
    if (txtObj.value.length > 0) {
        var str = changetxt(txtObj.value);//替换文本框中的表情
        var time = inittime();//取出当前时间
        var innerht = "<div class='stateShow' onmouseover='stateMouseOver(this)' onmouseout='stateMouseOut(this)' onclick='go2detail()'><div class='stateShowWord'><table width='450' border='0' cellpadding='0' cellspacing='0' class='stateTable'><tr><td width='70' align='center' valign='top'><a href='#'><img src='../images/MainRightFirstLineTitle.gif' alt='' width='48' height='48' /></a></td><td width='380'><a href='#'>DarkDemon</a><img src='../images/1.gif' style='vertical-align:middle;border:none;' alt='' />&nbsp;" + str + "</td></tr></table></div><div class='stateImgShow'></div><div class='stateShowtime'>" + time + "</div><div class='stateOp'><a href='#' class='opState'>回复 0</a><a href='#' class='opState'>转发 0</a><a href='#' class='opState'>赞 0</a><a onclick='delState(this)' class='opState'>删除</a></div><div class='huifu'></div></div>";
        var divObj = document.getElementById("mainBannerContent");
        divObj.innerHTML = innerht + divObj.innerHTML;
    }
    txtObj.value = "";//清空文本框
    changeDivHeight();//重设页面高度
}


/* 生成当前的时间 */
function inittime() {
    var today = new Date();
    var month = today.getMonth() + 1;
    var day = today.getDate();
    var hour = today.getHours();
    var minits = today.getMinutes();
    /* 对数字中不到2位数的处理，前面加0 */
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minits < 10) {
        minits = "0" + minits;
    }
    return " " + month + "月" + day + "日 " + hour + ":" + minits;//拼出时间字符串并返回
}

/* 转换文本框里面的内容,将所有的图像的值,替换为相应的imghtml语言,并且返回 */
function changetxt(str) {
    var ustr = new Array();
    var reg = /\([^()\s]+\)/;//正则匹配图像的值
    var strtmp = str;
    while (strtmp.match(reg) != null) {//匹配是否有符合图像值的
        var temp = strtmp.match(reg);
        var repstr = createImg(temp);
        if (repstr != null) {
            strtmp = strtmp.replace(temp, repstr);//将值和生成的值相应的html语言替换
        } else {//如果匹配不到就替换成特定的字符，并保存原来的值，避免进入死循环
            strtmp = strtmp.replace(temp, "#$#");
            ustr.push(temp);
        }
    }
    /* 将原来匹配出来的不符合 图像的值替换回去 */
    if (ustr != null && ustr.length > 0) {
        for (var i = 0; i < ustr.length; i++) {
            strtmp = strtmp.replace("#$#", ustr[i]);
        }
    }
    return strtmp;//返回已经替换之后的记过
}

/* 单击图像之后,为输入框添加图像相应的值并且设置焦点为文本框 */
function addImg() {
    var txtObj = document.getElementById("textfield2");
    var imgObj = event.srcElement;
    txtObj.value = txtObj.value + imgObj.title;//将图像的值写入文本框
    txtObj.focus();//设置文本框焦点
}

/* 通过传进去的图像的含义，从而生成图像的路径，并且生成img的代码 */
function createImg(title) {
    /* 通过设置的图像值,挨个匹配寻找路径 */
    for (var i = 0; i < bqvalue.length; i++) {
        if (title == bqvalue[i]) {
            break;
        }
    }
    /* 如果找不到值就返回null */
    if (i == bqvalue.length)
        return null;
    /* 如果找到值就拼出img标记并且返回 */
    var str = "<img src='../images/biaoqing/" + (i + 1) + ".gif' width='24' height='24' alt='' style='vertical-align: middle;' title= ''/>"
    return str;
}

/* 删除状态 */
function delState(divObj) {
    event.stopPropagation();
    divObj = divObj.parentNode.parentNode;
    var fg = confirm("确认删除吗？");
    if (fg == true) {
        divObj.parentNode.removeChild(divObj);
        changeDivHeight();
    }
}

/* 取消收藏 */
function removeFromCollection(divObj) {
    event.stopPropagation();
    divObj = divObj.parentNode.parentNode;
    var fg = confirm("确认取消收藏吗？");
    if (fg == true) {
        divObj.parentNode.removeChild(divObj);
        changeDivHeight();
    }
}

/* 取消点赞 */
function unlike(divObj) {
    event.stopPropagation();
    divObj = divObj.parentNode.parentNode;
    var fg = confirm("确认取消点赞吗？");
    if (fg == true) {
        divObj.parentNode.removeChild(divObj);
        changeDivHeight();
    }
}

/*改变关注、赞、收藏的状态*/
function changeOpState(srcobj) {
    event.stopPropagation();
    if (srcobj.className == "opState")
        srcobj.className = "opDone";
    else
        srcobj.className = "opState";
}

/* 鼠标悬停时，设置背景为深色 */
function stateMouseOver(divObj) {
    divObj.style.backgroundColor = "#f9f9f9";
}

/* 鼠标离开时，设置背景为白色 */
function stateMouseOut(divObj) {
    divObj.style.backgroundColor = "#ffffff";
}

function go2detail(id, val) {
    if (val == 0) {
        window.open("../pages/detail.jsp?id=" + id);
    }
    if (val == 1) {
        window.open("../pages/mydetail.jsp?id=" + id);
    }
    //window.open("../control/comment?opr=commentList&id="+id);
}

/* 函数绑定*/
window.onload = function () {
    changeDivHeight();//开始的时候设置左栏和右栏的高度

    if (document.getElementById("biaoqing")) {
        initImgFace();//初始化表情图像
        document.onclick = judeState;//设置单击取消显示
        var imgObj = document.getElementById("biaoqing").getElementsByTagName("img");//为biaoqingDIV下的所有img设置单击事件
        for (var i = 0; i < imgObj.length; i++) {
            imgObj[i].onclick = addImg;//绑定单击事件
        }
    }

    //隐藏 #back-top 回到顶部按钮
    $("#backtop").hide();
    // 滚动条距顶100px显示 #back-top
    $(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $('#backtop').fadeIn();
            } else {
                $('#backtop').fadeOut();
            }
        });
        // 点击事件 回到顶部
        $('#backtop a').click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 600);
            return false;
        });
    });
};