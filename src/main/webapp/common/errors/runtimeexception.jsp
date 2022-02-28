<%@ page language="java" pageEncoding="UTF-8" %>
<%
    // 这儿可以写Java代码
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);

    //自定义前端资源路径及版本控制
    String $FaceVersion = "face1.0.0";
    request.setAttribute("$FaceVersion", $FaceVersion);
    String facePath = basePath + "common/resource/" + $FaceVersion + "/";
    request.setAttribute("facePath", facePath);
%>
<jsp:directive.page import="java.util.Date"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<head>
    <title>这是一个jsp模板页面</title>
    <%--
    <%@ include file="/common/inc.jsp" %>
    --%>

    <%-- 引入css 方式 --%>
    <%--<link rel="stylesheet" type="text/css" href="<%=facePath%>lib/ColorPicker/css/colpick.css"/>--%>

    <%-- 引入js 方式 --%>
    <%--<script src="<%=facePath%>lib/ColorPicker/js/colpick.js" type="text/javascript"></script>--%>
    <style>
        #hello {
            width: 100px;
        }
    </style>
</head>
<body>
<h1> 兜底异常 RuntimeException</h1>
</body>
</html>
<script type="text/javascript">

    $(document).ready(function () {
        console.log("$(document).ready... called...")
    });

    function hello() {
        console.log("这个是 JSP 模板页面");
    }
</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
