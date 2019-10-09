
function getCookie(objName){//获取指定名称的cookie的值

    var arrStr = document.cookie.split("; ");

    for(var i = 0;i < arrStr.length;i ++){
        var temp = arrStr[i].split("=");
        // console.log("temp[0]:"+temp[0])
        // console.log("objName:"+objName)
        if(temp[0] == objName) return (temp[1]);
    }
}

function addCookie(objName,objValue,objHours){//添加cookie   escape

    var str = objName + "=" + objValue;
    if(objHours > 0){//为0时不设定过期时间，浏览器关闭时cookie自动消失
        // console.log("运行锅")
        var date = new Date();
        var ms =24*60*60*1000; //自己设置cookie时间
        date.setTime(date.getTime() + ms); //注意为毫秒值
        str += "; expires=" + date.toGMTString();
        // console.log(str)
    }
    document.cookie = str;
}

function deleteCookie(key) { //删除cookie方法
    var date = new Date(); //获取当前时间
    date.setTime(date.getTime() - 10000); //将date设置为过去的时间
    document.cookie = key + "=v; expires =" + date.toGMTString();//设置cookie
    return tips;
}