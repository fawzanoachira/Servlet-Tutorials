<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Import Module</title>
</head>
<body>
<% ArrayList a = new ArrayList();
	a.add(1);
	a.add("fawzan");
	
	out.println(a);%>

</body>
</html>