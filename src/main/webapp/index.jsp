
<!DOCTYPE html>
<html>
<style>
    body { background: url(images/img1.jpg); }
     button {
         background: #008EB0; /* ����� ���� ���� */
         color: #fff; /* ����� ���� ������ */
         border: none; /* ������� ����� */
         padding: 1rem 1.5rem; /* ���� ������ ������ */
         margin-bottom: 1rem; /* ������ ����� */
         font-size: 35px;
     }
    .red { background: #C1172C; }
    .orange { background: #F7941E; }
</style>
<head>
    <title>Java Web Project</title>
</head>

<%@ page language="java" contentType="text/html;charset=cp1251"%>
<body>
<div>
    <h1><p align="center" style="color:#ffee77;font-size: 55px"> Welcome to students web application </p></h1>
</div>

<div>       <!-- content -->
    <div>   <!-- buttons holder -->
        <button class="red" style="position: absolute;
        left: 150px; top: 250px;" onclick="location.href='/readAllStudents'">All students</button>
    </div>
    <div>
    <button class="orange" style="position: absolute;
        right: 150px; top: 250px;" onclick="location.href='/add'">Add student</button>
    </div>
</div>
</body>
</html>