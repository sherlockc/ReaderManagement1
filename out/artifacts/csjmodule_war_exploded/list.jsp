<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-10-12
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table border = "1" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>信息</th>
        </tr>
        <c:forEach var="cstm" items="${pageBean.beanList}">
            <tr>
                <td>${cstm.id}</td>
                <td>${cstm.name}</td>
                <td>${cstm.gender}</td>
                <td>${cstm.phone}</td>
                <td>${cstm.email}</td>
                <td>${cstm.description}</td>

                <td><a href = "/ReaderServlet?method=preEdit&id=${cstm.id}"/>编辑</td>
                <td><a href = "/ReaderServlet?method=delete&id=${cstm.id}"/>删除</td>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <a href = "${pageBean.url}&pc=1">首页</a>

        <c:if test="${pageBean.pc>1}">
            <a href = "${pageBean.url}&pc=${pageBean.pc-1}">上一页</a>
        </c:if>

        <c:if test ="${pageBean.pc<pageBean.tp}">
            <a href ="${pageBean.url}&pc=${pageBean.pc+1}">下一页</a>
        </c:if>

        <a href = "${pageBean.url}&pc=${pageBean.tp}">尾页</a>
    </div>
</body>
</html>
