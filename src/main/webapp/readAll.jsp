<%@ page import="application.services.impl.StudentService" %>
<%@ page import="application.services.interfaces.StudentServiceInt" %>
<%@ page import="application.dto.StudentDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        background: url(images/img2.jpg);
    }
    TABLE {
        width: 75%;
        margin-bottom: 20px;
        border: 3px solid #dddddd;
        border-collapse: collapse;
    }
    TD {
        border: 2px solid #dddddd;
        padding: 10px;
    }
    TH {
        font-weight: bold;
        padding: 5px;
        background: #d2e0b4;
        border: 2px solid #dddddd;
    }
</style>
<head>
    <title>allStudents</title>
</head>
<body>
<h1> <p align="center" style="color:#77ff9e;font-size: 55px"> Все студенты </h1>
<br>
<table border="5" cellspacing="4" align="center">
    <tr>
        <th> name </th>
        <th> surname </th>
        <th> age </th>
        <th> mark </th>
        <th> address </th>
    </tr>
    <%
        StudentServiceInt studentService = StudentService.getINSTANCE();
        for (StudentDTO l : studentService.getAllStudents()) {

    %>
    <tr>
        <td><%= l.getName() %>
        </td>
        <td><%= l.getSurname() %>
        </td>
        <td><%= l.getAge() %>
        </td>
        <td><%= l.getMark() %>
        </td>
        <td><%= l.getAddress() %>
        </td>
        <% } %>
    </tr>
</table>
</body>
</html>