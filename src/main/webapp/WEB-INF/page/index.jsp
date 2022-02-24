<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:directive.page import="java.util.Date"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<head>
    <title>首页</title>
    <%@ include file="common/inc.jsp" %>

    <%-- 引入css 方式 --%>
    <%--<link rel="stylesheet" type="text/css" href="<%=facePath%>lib/ColorPicker/css/colpick.css"/>--%>

    <%-- 引入js 方式 --%>
    <%--<script src="<%=facePath%>lib/ColorPicker/js/colpick.js" type="text/javascript"></script>--%>
    <script src="<%=facePath%>/js/jquery-3.6.0.min.js" type="text/javascript"></script>

    <%-- 这里写css页面内嵌CSS样式 --%>
    <style>
        #hello-world {
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
<h1 class="item" onclick="consoleHelloWorld()">CONSOLE HELLO WORLD</h1>
<hr/>
<h1 class="item" onclick="gotoPage('userinfo')">userinfo</h1>
<h1 class="item" onclick="gotoPage('forward')">forward</h1>
<h1 class="item" onclick="gotoPage('forwardByRequestDispatcherForward')">forwardByRequestDispatcherForward</h1>
<h1 class="item" onclick="gotoPage('redirect')">redirect</h1>
<h1 class="item" onclick="gotoPage('redirectByResponseRedirect')">redirectByResponseRedirect</h1>

</body>
</html>
<script type="text/javascript">

    $(document).ready(function () {
        console.log("$(document).ready... 被执行");
        // alert("hello world");
    });

    function gotoPage(target) {
        if ("" == target) {
            alert("目标地址不能为空！");
            return;
        }
        // 跳转
        top.location.href = "<%=path%>/page/" + target;

    }

    /*
    *
    * 控制台输出 hello world
    *
    * */
    function consoleHelloWorld() {
        console.log("这个是 JSP 模板页面");
        alert("这个是 JSP 模板页面");
    }

    /*
    * jQuery POST 请求案例
    * */
    function jQueryPostRequestDemo() {
        // debugger;
        $.ajax({
            type: "POST",
            url: "<%=path%>/test/testPost",// 跳转到 action
            dataType: "text",
            data: {
                "userId": "userId123456"
            },
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

    /* jQuery 案例 */
    /*
      $.ajax({
          url: 'http://www.test.com',
          type: 'POST', //GET
          async: true,    //或false,是否异步
          data: {
              name: 'huang', age: 23
          },
          timeout: 5000,    //超时时间
          dataType: 'json',    //返回的数据格式：json/xml/html/script/jsonp/text
          beforeSend: function (xhr) {
              console.log(xhr)
              console.log('发送前')
          },
          success: function (data, textStatus, jqXHR) {
              console.log(data)
              console.log('成功')
              console.log(textStatus)
              console.log(jqXHR)
          },
          error: function (xhr, textStatus) {
              console.log('错误')
              console.log(xhr)
              console.log(textStatus)
          },
          complete: function () {
              console.log('结束')
          }
      });
      */

</script>
<%-- include jsp 文件的方式 --%>
<%--
<%@ include file="/ta/incfooter.jsp" %>
--%>
