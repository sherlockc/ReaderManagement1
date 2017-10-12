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
<div align="center">
<h3>编辑</h3>
<form action="/ReaderServlet" method="post">
    <input type = "hidden" name = "method" value = "edit">
    <input type = "hidden" name = "id" value = ${Reader.id}>
    <div>姓名<input type = "text" name = "name" value = "${Reader.name}"/></div>
    <div>
        <c:if test="${Reader.gender eq 'male'}">
       <select name = "gender">
           <option value = "male" selected="selected">男</option>
           <option value = "female">女</option>
       </select>
        </c:if>
        <c:if test="${Reader.gender eq 'female'}">
        <select name = "gender">
            <option value = "male" >男</option>
            <option value = "female" selected="selected">女</option>
        </select>
        </c:if>
    </div>
    <div>电话<input type = "text" name = "phone" value = "${Reader.phone}"/></div>
    <div>邮箱<input type = "text" name = "email" value = "${Reader.email}"/></div>
    <div>信息<input type = "text" name = "description" value = "${Reader.description}"/></div>
    <div>
        <button type = "submit">提交</button>
        <button type = "reset">重置</button>
    </div>
</form>
</div>
</body>
</html>