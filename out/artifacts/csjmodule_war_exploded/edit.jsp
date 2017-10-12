<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-12
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h3>编辑</h3>
<form action="/ReaderServlet" method="post">
    <input type = "hidden" name = "method" value = "edit">
    <div>姓名<input type = "text" name = "name" value = "${Reader.name}"/></div>
    <div>
        <select name ="gender">
            <option value = "male" <c:if test="${Reader.gender = 'male'}"> selected="selected">男</option>
            <option value = "female" <c:if test="${Reader.gender = 'female'}"> selected="selected">女 </option>
        </select>
    </div>
    <div>电话<input type = "text" name = "phone" value = “${Reader.phone}”/></div>
    <div>邮箱<input type = "text" name = "email" value = "${Reader.email}"/></div>
    <div>信息<input type = "text" name = "description" value = "${Reader.description}"/></div>
    <div>
        <button type = "submit">提交</button>
        <button type = "reset">重置</button>
    </div>
</form>
</body>
</html>
