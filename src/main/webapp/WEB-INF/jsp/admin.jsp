<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 12/16/20
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/logout">Logout</a>
<br>
<h1>Page for Admin</h1>
<table border="1" width="80%">
    <tr>
        <th>Id</th>
        <th>Name</th>

    </tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>