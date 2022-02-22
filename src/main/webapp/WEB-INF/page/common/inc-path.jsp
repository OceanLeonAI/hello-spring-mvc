<%@page language="java" pageEncoding="UTF-8" %>
<%
    // 这儿可以写Java代码
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    request.setAttribute("basePath", basePath);
    System.out.println("basePath ---> " + basePath);

    String facePath = basePath + "common/";
    request.setAttribute("facePath", facePath);
%>
