// JavaScript Document

var useridtmp = "";//用户id的恢复变量
/* 提交表单是检测输入的数据是否正确 */
function checkForm() {
    var userId = document.getElementById("userId");
    var userPass = document.getElementById("passWord");
    if (userId.value == "请输入正确的手机号码")//如果本身是提示语,则继续出错的提示
        return false;
    userId.value = trim(userId.value);//去除id框前后空格
    useridtmp = userId.value;//将输入id传给变量

    //进入手机号处理流程：如果手机是11位的纯手机号,则返回正确 */
    if (useridtmp.match(/[^\d]/g) == null && useridtmp.length == 11) {
        return true;
    } else {//否则进入出错提示
        if (useridtmp.match(/[^\d]/g) != null || useridtmp.length < 11) {
            userId.value = "请输入正确的手机号码"
            userId.style.backgroundColor = "#B9E3AB"
        }
        return false;
    }
}

/* 输入框获得焦点时,设置背景色,并且将原来的提示语放回到输入框中 */
function userIdfocus() {
    var userId = document.getElementById("userId");
    userId.style.backgroundColor = "#FFF"
    userId.value = useridtmp;
    userId.select();
}

/* 密码框获得焦点时,就全选里面内容 */
function userPassfocus() {
    document.getElementById("passWord").select();
}

/* 函数绑定,获得焦点事件,失去焦点事件,鼠标悬停事件,鼠标离开事件 */
window.onload = function () {
    document.getElementById("userId").onmouseover = userIdfocus;
    document.getElementById("userId").onfocus = userIdfocus;
    document.getElementById("userId").onblur = checkForm;
    document.getElementById("passWord").onmousemove = userPassfocus
}