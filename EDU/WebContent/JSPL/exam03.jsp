<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPL/exam03.jsp</title>
</head>
<body>
	<h3>JSP Standard Tag Library</h3>
	<cc:set var="num" value="${70 }"></cc:set>
	<cc:out value="${num }"></cc:out>
	
	<cc:if test="${num >= 60 }">합격입니다.</cc:if>
	<cc:if test="${num < 60 }">불합격입니다.</cc:if>
	
	<cc:choose>
		<cc:when test="${num >= 90 }">A학점입니다.</cc:when>
		<cc:when test="${num >= 80 }">B학점입니다.</cc:when>
		<cc:when test="${num >= 70 }">C학점입니다.</cc:when>
		<cc:otherwise>F학점</cc:otherwise>
	</cc:choose>
</body>
</html>