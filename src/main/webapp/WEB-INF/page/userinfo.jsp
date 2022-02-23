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
    </style>
</head>
<body>
<div>跳转信息：${message}</div>
<div>用户信息</div>
<div>用户名：${user.username}</div>
<div>用户编码：${user.usercode}</div>
<a href="<%=path%>/page/index">BACK TO INDEX</a>
</body>
</html>
<script type="text/javascript">

</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
