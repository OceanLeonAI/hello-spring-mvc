<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:directive.page import="java.util.Date"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<head>
    <title>用户信息页面</title>
    <%@ include file="common/inc.jsp" %>

    <%-- 引入css 方式 --%>
    <%--<link rel="stylesheet" type="text/css" href="<%=facePath%>lib/ColorPicker/css/colpick.css"/>--%>

    <%-- 引入js 方式 --%>
    <%--<script src="<%=facePath%>lib/ColorPicker/js/colpick.js" type="text/javascript"></script>--%>
    <script src="<%=facePath%>/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <style>
        #hello {
            width: 100px;
        }

        .item {
            border: 1px solid #000000;
            width: 50%;
            cursor: pointer;
            border-radius: 5px;
            padding: 2px;
            text-align: center;
        }

        .item:hover {
            border: 3px solid #000000;
        }

        .button {
            width: 100px;
            height: 40px;
            line-height: 40px;
            cursor: pointer;
            border-radius: 5px;
            color: #ffffff;
            font-size: 20px;
            text-align: center;
            background-color: #4e6ef2;
        }

        .button:hover {
            background-color: #4662d9;
        }
    </style>
</head>
<body>
<a href="<%=path%>/page/index">BACK TO INDEX</a>
<div>跳转信息：${message}</div>
<div>用户信息</div>
<div>用户名：${user.username}</div>
<div>用户编码：${user.usercode}</div>
<div class="button" onclick="addUser();">add user</div>
</body>
</html>
<script type="text/javascript">

    function addUser() {

        var obj = {"username": "zhangsan"};

        $.ajax({
            url: '<%=path%>/user/insert',
            type: 'POST', //POST/GET
            async: true,    //或false,是否异步
            contentType: "application/json; charset=utf-8",
            // data: JSON.stringify(obj), // 后台用 @RequestBody形式接收参数，前台需要传递JSON字符串
            data: obj, // 模拟 http 400 Bad Request
            // timeout: 5000,    //超时时间
            dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend: function (xhr) {
                console.log('发送前')
                console.log(xhr)
            },
            success: function (data, textStatus, jqXHR) {
                // debugger;
                console.log('成功')
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
            },
            error: function (xhr, textStatus) {
                // debugger;
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete: function () {
                console.log('结束')
            }
        });
    }

</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
