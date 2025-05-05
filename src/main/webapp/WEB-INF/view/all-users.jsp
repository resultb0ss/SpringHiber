<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<h2>ALL USERS</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Last Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="usrId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="usrId" value="${user.id}"/>
        </c:url>


        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.department}</td>
            <td>${user.salary}</td>
            <td><input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"></td>
        </tr>

    </c:forEach>


</table>
<br>
<input type="button" value="Add" onclick="window.location.href = 'addNewUser' "/>


</body>
</html>
