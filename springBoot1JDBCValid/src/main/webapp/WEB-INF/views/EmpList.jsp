<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>EmpList</h1>
    <!-- JSTL - implementing some common operations such as 
     looping, conditional formatting, and others. -->
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <ul>
    <c:forEach items="${empList}" var="e">
      <li>
        ${e.empno}, ${e.name}, ${e.salary}
      </li>
    </c:forEach>
  </ul> 
</body>
</html>