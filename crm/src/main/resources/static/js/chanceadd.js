function submitChecked() {
    var chc_cust_name = $("[name=chc_cust_name]").text(); //公司名称
    var chc_linkman = $("[name=chc_linkman]").text(); //负责人
    var chc_tel = $("[name=chc_tel]").text(); //公司电话
    var chc_title = $("[name=chc_title]").text(); //概要
    var chc_source = $("[name=chc_source]").text(); //机会来源
    var chc_rate = $("[name=chc_rate]").text(); //成功几率
    var chc_due_data = $("[name=chc_due_data]").text(); //指派时间
    var chc_due_id = $("[name=chc_due_id]").text(); //指派给
    var chc_desc = $("[name=chc_desc]").text(); //机会描述
    var phonePt = /^[1389]\d{10}$/;
    if (!phonePt.test(chc_tel)) {
        alert("手机号格式不正确")
    } else if (typeof chc_rate != "number") {
        alert("成功几率需为数字")
    } else {
        $("#form").submit();
    }
}
