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
<h1>hello world</h1>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        alert("hello world");
    });

    function hello() {
        console.log("这个是 JSP 模板页面");
    }
</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
