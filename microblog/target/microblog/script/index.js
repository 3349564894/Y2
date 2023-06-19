// JavaScript Document
/* 设置页面中的主题部分的左栏和右栏部分高度为自动 */
function initDivHeight(divObj1, divObj2) {
    divObj1.style.height = "auto";
    divObj2.style.height = "auto";
}

/* 设置主体部分的高度以实际高度高的那个为准 */
function changeDivHeight() {
    var mainBanner = document.getElementById("mainBanner");
    var rightBanner = document.getElementById("mainRightBanner");
    var mainRight = document.getElementById("mainRight");
    initDivHeight(mainBanner, mainRight);//设置高度为自动
    var height = mainBanner.offsetHeight > rightBanner.offsetHeight ? mainBanner.offsetHeight : rightBanner.offsetHeight;//获取高度高的值
    mainBanner.style.height = height + "px";//为他们的高度都赋高的那个值
    mainRight.style.height = height + "px";//
}

/* 加载函数 */
window.onload = function () {
    /*today = document.getElementsByName("today");//获取4个新闻DIV对象
    today[1].style.left = 523;					//放置后边3个DIV在容器后边使之不可见
    today[2].style.left = 523;
    today[3].style.left = 523;
    var topText =document.getElementById("topText");
    topText.onfocus = quickZC;
    newsmove();									//调用新闻移动函数
    getnum();*/
    changeDivHeight();
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

/* 快速注册 */
function quickZC() {
    window.open("pages/register.jsp");
}


/* 鼠标悬停时，设置背景为深色 */
function stateMouseOver(divObj) {
    divObj.style.backgroundColor = "#f9f9f9";
}

/* 鼠标离开时，设置背景为白色 */
function stateMouseOut(divObj) {
    divObj.style.backgroundColor = "#ffffff";
}

function go2login() {
    window.open("pages/login.jsp");
}

/* 注册收起函数 */
function hangUp() {
    var mainTop = document.getElementById("mainTop");
    document.getElementById("mainRight").style.top = "90px";
    mainTop.style.height = "80px";
    // var topTextDIV = document.getElementById("topTextDIV");
    var ZCButton = document.getElementById("ZCButton");
    // topTextDIV.style.display = "block" ;
    ZCButton.style.display = "block";
}

/* 检查用户的所有信息是否填写成功 */
function checkAll() {
    var a = (lastPassword == str);
    var b = (value == randomnum);
    if (mailresult == true && resultword == true && resultnum == true && resultsix == true && a == true && b == true) {
        window.open("customerindex.html");
    } else {
        window.alert("用户输入信息不全或不正确，无法注册！");
    }
}

/* 正则表达式提取left数值 */
function execRegleft(reg, str) {
    var result = reg.exec(str);
    return (result);
}

/* 正则表达式验证返回ture或flase */
function execReg(reg, str) {
    return result = reg.test(str);
}

/* 验证邮箱是否正确 */
function checkMail() {
    var mailInput = document.getElementById("mailInput");
    var str = mailInput.value;
    var reg = /^\w+@\w+\.\w+$/; 	// 判断邮箱格式正则
    mailresult = execReg(reg, str);
    mail3 = document.getElementById("mail3");
    if (mailresult) {															//格式正确
        mail3.innerHTML = '<img src="images/right.gif" alt="" />' + "正 确";
        mail3.style.backgroundColor = "transparent";
        mail3.style.borderColor = "transparent";
        document.getElementById("password13").style.visibility = "visible";
        document.getElementById("password13").style.backgroundColor = "#F2F2F2";
        document.getElementById("password13").style.borderColor = "#CCCCCC";
        document.getElementById("password13").style.border = "1px";
        document.getElementById("password13").style.borderStyle = "solid";
    } else {																//格式错误
        mail3.style.borderColor = "#EBB1B1";
        mail3.style.backgroundColor = "#FFD6D6";
        mail3.innerHTML = "请输入正确E-mail的地址";
    }
}

/* 验证密码是否符合标准 */
function checkPassword() {
    var passwordInput = document.getElementById("passwordInput");
    password13 = document.getElementById("password13");
    var str = passwordInput.value;
    var regnum = /[0-9]+/;
    var regword = /[a-zA-Z]+/;
    var regsix = /[a-zA-z0-9]{6,12}/;
    resultnum = execReg(regnum, str);	//验证是否有数字
    resultword = execReg(regword, str); 	//验证是否有字母
    resultsix = execReg(regsix, str);	//验证是否有6位
    if (resultword == true && resultnum == true && resultsix == true) {
        document.getElementById("password13").style.visibility = "visible";
        password13.innerHTML = '<img src="images/right.gif" alt="" />' + "正 确";
        password13.style.backgroundColor = "transparent";
        password13.style.borderColor = "transparent";
    } else {
        document.getElementById("password13").style.visibility = "visible";
        password13.style.borderColor = "#EBB1B1";
        password13.style.backgroundColor = "#FFD6D6";
        password13.innerHTML = "密码至少包含一个数字和字母且不能小于6位！";
    }
}

/* 验证2次密码是否一致 */
function isSame() {
    var passwordInput = document.getElementById("passwordInput");
    lastPassword = passwordInput.value;
    var passwordTwice = document.getElementById("passwordTwice");
    str = passwordTwice.value;
    var password23 = document.getElementById("password23");
    if (str == "") {
        document.getElementById("password23").style.visibility = "visible";
        password23.style.borderColor = "#EBB1B1";
        password23.style.backgroundColor = "#FFD6D6";
        password23.innerHTML = "密码不能为空！";
    } else if (lastPassword == str) {
        document.getElementById("password23").style.visibility = "visible";
        password23.innerHTML = '<img src="images/right.gif" alt="" />' + "正 确";
        password23.style.backgroundColor = "transparent";
        password23.style.borderColor = "transparent";
    } else {
        document.getElementById("password23").style.visibility = "visible";
        password23.style.borderColor = "#EBB1B1";
        password23.style.backgroundColor = "#FFD6D6";
        password23.innerHTML = "两次密码不一致！";
    }
}

/* 产生随机数 */
function getnum() {
    randomnum = Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
    document.getElementById("picyanzheng").innerHTML = randomnum;
}

/* 确定验证码是否正确 */
function checkIsRight() {
    var yangzhen3 = document.getElementById("yangzhen3");
    var checkIsRight = randomnum;
    var yangzhen = document.getElementById("yangzhen");
    value = yangzhen.value;
    if (value == randomnum) {
        document.getElementById("yangzhen3").style.visibility = "visible";
        yangzhen3.innerHTML = '<img src="images/right.gif" alt=""/>' + "正 确";
        yangzhen3.style.backgroundColor = "transparent";
        yangzhen3.style.borderColor = "transparent";
    } else {
        document.getElementById("yangzhen3").style.visibility = "visible";
        yangzhen3.style.borderColor = "#EBB1B1";
        yangzhen3.style.backgroundColor = "#FFD6D6";
        yangzhen3.innerHTML = "验证码不符！";
    }
}

/* 新闻移动函数 */
function newsmove() {
    i %= 4;												//代表上一个滚出新闻	i	i%4		j	  滚出	      滚入
    var j = (i + 1) % 4;								//代表下一个滚入新闻	1	 0		1	today[0]	today[1]
    if (isStop == 1) {									//					2	 1		2	today[1]	today[2]
        setTimeout("newsmove()", delay);					//					3	 2		3	today[2]	today[3]
        return;											//					4    3  	0	today[3]	today[0]
    }
    left--;
    today[i].style.left = left * 300 + "px";
    today[j].style.left = (523 + left * 300) + "px";
    var ling = 0 + "px";
    var reg = /^(?:-\d|\d)*/;						 	//提取left数值的正则表达式
    var leftvalue = execRegleft(reg, today[j].style.left);
    leftvalue = parseInt(leftvalue);
    if (leftvalue < 0) {									//判断下一则新闻是否已滚入到位
        today[j].style.left = 0;
        today[i].style.left = 523;
        i++;
        left = 0;
        setTimeout("newsmove()", stay);					//新闻再此停留3秒
        return;
    }
    setTimeout("newsmove()", delay);
}

/* 新闻停止 */
function ting() {
    isStop = 1;
}

/* 新闻继续 */
function goon() {
    isStop = 0;
}