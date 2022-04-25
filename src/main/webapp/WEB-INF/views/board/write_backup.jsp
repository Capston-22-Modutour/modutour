<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
	<c:if test="${msg != 'login_error'}">
		<form method="post">
			<label>제목</label>
			<input type="text" name="board_title"> <br/>
			
			<label>작성자</label>
			<input type="text" name="board_writer" value="${member.user_name}" readonly="readonly"> <br/>
			
			<label>내용</label>
			<textarea cols="50" rows="5" name="board_content"></textarea> <br/>
			
			<label>희망 출발일</label>
			<input type="date" name="board_start"> <br/>
			
			<label>희망 도착일</label>
			<input type="date" name="board_end"> <br/>
			
			<button type="submit">작성</button>
		</form>
	</c:if>
	
	<c:if test="${msg == 'login_error'}">
		<p>로그인이 필요한 서비스 입니다</p>
		<p><a href="/">홈으로</a></p>
	</c:if>
	
	<input type="button" value="이전" onclick="history.go(-1)">
</body>
</html>