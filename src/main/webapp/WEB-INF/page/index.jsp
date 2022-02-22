<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:directive.page import="java.util.Date"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<head>
    <title>模板页面</title>
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
    </style>
</head>
<body>
<h1 style="color: blue;" onclick="hello()">hello world</h1>
<h1 style="color: red;cursor: pointer;" onclick="postTest()">POST REQUEST</h1>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        // alert("hello world");
    });

    function hello() {
        console.log("这个是 JSP 模板页面");
        alert("这个是 JSP 模板页面");
    }

    function postTest() {
        // debugger;
        $.ajax({
            type: "post",
            url: "<%=path%>/test/testPost",// 跳转到 action
            data: {
                "userId": "userId123456"
            },
            dataType: "json",
            success: function (data) {
                // debugger;
                console.log("进入成功回调", data);
            },
            error: function (data) {
                // debugger;
                console.log("进入失败回调", data);
            }
        });
    }

    /*ajax 测试*/
    function testAjax() {
        var positionid = "abcdefg";
        $.ajax({
            type: "post",
            url: "<%=path%>/org/admin/adminUserMgAction!queryForFastPermissionSettion.do",// 跳转到 action
            data: {
                "dto['positionid']": positionid
            },
            dataType: "json",
            success: function (data) {
                alert("进入成功回调");
            },
            error: function () {
                alert("进入失败回调");
            }
        });
    }

</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
