<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-11
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<div align="center">
<h3>添加</h3>
<form action="/ReaderServlet" method="post">
    <input type = "hidden" name = "method" value = "add">
    <div>姓名<input type = "text" name = "name"/></div>
    <div>
        <select name ="gender">
            <option value = "male">男</option>
            <option value = "female">女 </option>
        </select>
    </div>
    <div>电话<input type = "text" name = "phone"/></div>
    <div>邮箱<input type = "text" name = "email"/></div>
    <div>信息<input type = "text" name = "description"/></div>
    <div>
        <button type = "submit">提交</button>
        <button type = "reset">重置</button>
    </div>
</form>
</div>
</body>
</html>
