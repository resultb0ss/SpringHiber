<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About user</title>
</head>
<body>
<h2>User info</h2>
<br>
<form:form action="saveNewUser" modelAttribute="user">

  <form:hidden path="id"/>

  Name <form:input path="name"/>
  <br><br>
  Surname <form:input path="surname"/>
  <br><br>
  Department <form:input path="department"/>
  <br><br>
  Salary <form:input path="salary"/>
  <br><br>
  <input type="submit" value="OK"/>

</form:form>

</body>
</html>
