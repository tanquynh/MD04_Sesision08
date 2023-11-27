<%--
  Created by IntelliJ IDEA.
  User: Mak
  Date: 11/10/2023
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            padding: 5%;
        }
    </style>
</head>
<body>
<h1 class="text-center">Students List</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">StudentCode</th>
        <th scope="col">StudentName</th>
        <th scope="col">Age</th>
        <th scope="col">Sex</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${list}" var="student">
    <tr>
        <td>${student.studentCode}</td>
        <td>${student.studentName}</td>
        <td>${student.age}</td>
        <td>${student.sex ? "Nam" : "Nữ"}</td>
        <td>
            <a href="student-servlet?action=edit&studentCode=${student.studentCode}" class="btn btn-success">Edit</a>
            <a href="student-servlet?action=delete&studentCode=${student.studentCode}" class="btn btn-danger">Delete</a>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table>
<a href="/views/student-add.jsp" class="btn btn-primary">Add new Student</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
