<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookInput.jsp</title>
<!-- bookInput.jsp 사용자입력 -> bookProc.jsp(파라미터 읽어오고 디비에 입력) -> bookOut.jsp (처리결과) -->
</head>
<body>
<form action="BookProc.jsp" method="post">
	책 제목 : <input type="text" name="title"><br />
	책 저자 : <input type="text" name="author"><br />
	출판사 : <input type="text" name="publisher"><br />
	<input type="submit">
</form>

<a href="BookProc.jsp?title=정">상세정보</a>
</body>
</html>