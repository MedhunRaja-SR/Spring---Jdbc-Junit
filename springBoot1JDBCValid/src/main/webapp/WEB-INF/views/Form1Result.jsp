<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h1>Form1 Result</h1>
    <h2>name= <%=request.getParameter("name") %> - using scriplet</h2>
    <h2>name= ${param.name} - using Expression Language </h2>
    <h2> in caps = ${param.name.toUpperCase()}</h2>
    <h2> reverse = ${reverseName}</h2>
</body>
</html>