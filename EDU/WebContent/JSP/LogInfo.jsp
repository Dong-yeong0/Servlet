<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// DB조회 후 가져온 Member 확인 후 이름 , 나이를 출력
	//					없으면 "해당 사용자 없음" 출력.
	MemberDAO dao = new MemberDAO();
	Member mem = new Member();
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	out.print(id + pwd);
	mem = dao.checkInfo(id, pwd);

	String name = mem.getMemberName();
	int age = mem.getMemberAge();

	if (name == null) {
		out.print("사용자 정보가 없습니다.");
	} else {
	%>
	<h3>
		이름 :
		<%=name%>
	</h3>
	<h3>
		나이 :
		<%=age%>
	</h3>
	<%
	}
	%>

</body>
</html>