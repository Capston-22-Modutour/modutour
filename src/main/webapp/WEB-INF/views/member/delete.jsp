<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	
	<form role="form" method="post" autocomplete="off">
		<label>ID</label>
		<input type="text" name="user_id" value="${member.user_id}"/> </br>
		
		<label>PW</label>
		<input type="password" name="user_pw"/> </br>
		
		<button type="submit">탈퇴하기</button>
		<input type="button" value="이전" onclick="history.go(-1)">
	</form>
	
	<p>
		<a href="/">처음으로</a>
	</p>
	
	<c:if test="${msg == false}">
		<p>입력한 비밀번호가 잘못되었습니다</p>
	</c:if>
</body>
</html>