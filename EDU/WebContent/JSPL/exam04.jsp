<%@page import="java.util.ArrayList"%>
<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPL/exam04.jsp</title>
</head>
<body>
	<%
	List<BookBean> bookList = new ArrayList<>();
	bookList.add(new BookBean("title1", "author1", "pub1"));
	bookList.add(new BookBean("title2", "author2", "pub2"));
	bookList.add(new BookBean("title3", "author3", "pub3"));
	request.setAttribute("list", bookList);
	//	for(BookBean book : bookList){
	//	out.print(book.getTitle());
	//	out.print(book.getAuthor());
	//out.print(book.getPublisher());
	//}

	//for(int i = 0; i<5; i++){

	//}
	%>
	<h3>forEach 반복문</h3>
	<c:forEach items="${list }" var="book">
		<p>${book.title }/ ${book.author } / ${book.publisher }</p>
	</c:forEach>
	<c:forEach begin="2" end="9" var="var">
		<c:forEach begin="1" end="9" var="num">
			<p>${var} * ${num } = ${var * num }</p>
		</c:forEach>
	</c:forEach>

</body>
</html>