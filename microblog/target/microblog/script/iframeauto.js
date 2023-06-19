// JavaScript Document
function SetWinHeight(obj) {
    var win = obj;
    if (document.getElementById) {
        if (win && !window.opera) {
            if (win.contentDocument && win.contentDocument.body.offsetHeight)
                win.height = win.contentDocument.body.offsetHeight;
            else if (win.document && win.document.body.scrollHeight)
                win.height = win.document.body.scrollHeight;
        }
    }
} 
