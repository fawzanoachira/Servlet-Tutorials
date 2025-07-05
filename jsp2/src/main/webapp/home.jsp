<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page errorPage="error.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Division</title>
</head>
<body>
	<%
	int firstNumber = Integer.parseInt(request.getParameter("first"));
	int secondNumber = Integer.parseInt(request.getParameter("second"));
	
	int result = firstNumber / secondNumber;
	
	out.println("Result is: "+ result);
	%>
</body>
</html>