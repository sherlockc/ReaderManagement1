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
<div align="center"><h3>结果列表</h3></div>
    <table border = "1" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>信息</th>
            <th>操作</th>
        </tr>
        <c:forEach var="cstm" items="${pb.beanList}">
            <tr>
                <td>${cstm.id}</td>
                <td>${cstm.name}</td>
                <td>${cstm.gender}</td>
                <td>${cstm.phone}</td>
                <td>${cstm.email}</td>
                <td>${cstm.description}</td>

                <td>
                    <a href = "/ReaderServlet?method=preEdit&id=${cstm.id}"/>编辑
                    <a href = "/ReaderServlet?method=delete&id=${cstm.id}"/>删除
                </td>
            </tr>
        </c:forEach>
    </table>
    <!--<div>url:${pb.url}</div>-->
    <div align="center">
        <a href = "${pb.url}&pc=1">首页</a>

        <c:if test="${pb.pc>1}">
            <a href = "${pb.url}&pc=${pb.pc-1}">上一页</a>
        </c:if>

       <c:choose>
           <c:when test="${pb.tp <= 10}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pb.tp}"/>
           </c:when>
           <c:otherwise>
               <c:set var="begin" value="${pb.pc-4}"/>
               <c:set var="end" value="${pb.pc+5}"/>
               <c:if test="${begin<1}">
                   <c:set var="begin" value="1"/>
                   <c:set var="end" value="10"/>
               </c:if>
               <c:if test="${end>pb.tp}">
                   <c:set var="begin" value="${pb.tp-9}"/>
                   <c:set var="end" value="${pb.tp}"/>
               </c:if>
           </c:otherwise>
       </c:choose>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i eq pb.pc}">
                    [${i}]
                </c:when>
                <c:otherwise>
                    <a href="${pb.url}&pc=${i}">[${i}]</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test ="${pb.pc<pb.tp}">
            <a href ="${pb.url}&pc=${pb.pc+1}">下一页</a>
        </c:if>

        <a href = "${pageBean.url}&pc=${pageBean.tp}">尾页</a>
    </div>


</body>
</html>
