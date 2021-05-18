<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language (/el/exam01.jsp)</title>
</head>
<!-- 정규 표현식 -->
<body>
<%
	//String name = "Hello";
	//request.setAttribute("name",name);
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<%=name %>
<%=age %>
<br />
${param.name } / ${param["age"] }
<!-- Attribute 값을 읽어옴 -->
<h3>${empty name}</h3>
</body>
</html>