<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Form2 - Emp form</h1>
<h2>${error}</h2>

<form:form action="Form2Submit" modelAttribute="emp">
  <h2>
    Enter Emp no : <form:input path="empno" /><form:errors path="empno"></form:errors> <br/>
    Enter name : <form:input path="name" /> <form:errors path="name"></form:errors> <br/>
    Enter salary : <form:input path="salary" />
  </h2>
  <h2>
    <input type="submit" />
  </h2>
</form:form>

</body>
</html>