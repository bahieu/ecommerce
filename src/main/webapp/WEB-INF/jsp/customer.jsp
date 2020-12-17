<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 12/16/20
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/logout">Logout</a>
<br>
<h1>Page for Customer</h1>
<table border="1" width="80%">
    <tr>
        <th>Id</th>
        <th>Name</th>

    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
    </tr>
</table>
</body>
</html>