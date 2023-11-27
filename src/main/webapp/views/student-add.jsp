<%--
  Created by IntelliJ IDEA.
  User: Mak
  Date: 11/10/2023
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>Add new Student</h1>
<form action="<%=request.getContextPath()%>/student-servlet" method="post">
    <div class="mb-3">
        <label for="studentName" class="form-label fs-4">Student Name</label>
        <input type="text" class="form-control" id="studentName" name="studentName" placeholder="Nguyễn Văn A">
    </div>
    <div class="mb-3">
        <label for="age" class="form-label fs-4">Age</label>
        <input type="text" class="form-control" id="age" name="age" placeholder="18">
    </div>
    <p class="fs-4">Sex</p>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sex" id="male" value="male" checked>
        <label class="form-check-label" for="male">
            Male
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="sex" id="female" value="female">
        <label class="form-check-label" for="female">
            Female
        </label>
    </div>
    <button class="btn btn-primary" type="submit">Add</button>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
