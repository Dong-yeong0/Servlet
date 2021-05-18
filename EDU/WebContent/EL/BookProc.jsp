<%@page import="com.edu.beans.BookDAO"%>
<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BookBean book = new BookBean();
	BookDAO dao = new BookDAO();
	
	if (request.getMethod().equals("POST")) {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		// DB에 입력처리 BookDAO dao = new BookDAO();
		
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setTitle(title);
		// DB에 입력처리
		dao.insertBook(book);
	} else {
		// 조회
		String title = request.getParameter("title");
		book = dao.getBook(title);
	}
	
	request.setAttribute("book", book);
	
	RequestDispatcher rd = request.getRequestDispatcher("BookOutput.jsp");
	rd.forward(request, response);
%>