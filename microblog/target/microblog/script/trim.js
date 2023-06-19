// JavaScript Document
/* 字符串前后空格去除 */
function trim(str) {
    str = str.replace(/^\s+/g, ""); //去前空格
    str = str.replace(/\s+$/g, ""); //去后空格
    return str;
}

/* 去除元素子节点中的文本节点 */
function clearWhitespace(element) {
    var children = element.childNodes;
    for (var i = 0; i < children.length; ++i) {
        var node = children[i];
        if (node.nodeType == 3 && !/\S/.test(node.nodeValue)) {
            element.removeChild(node);
        }
    }
    return element;
}