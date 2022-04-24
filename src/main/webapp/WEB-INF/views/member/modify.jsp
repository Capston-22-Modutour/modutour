<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화원정보 수정</title>
</head>
<body>
	<form role="form" method="post" autocomplete="off">
		<label>ID</label>
		<input type="text" name="user_id" value="${member.user_id}" readonly="readonly"> <br>
	
		<label>이름</label>
		<input type="text" name="user_name" value="${member.user_name}"> <br>
		
		<label>생일</label>
		<input type="text" name="user_birth" value="${member.user_birth}" readonly="readonly"> <br>
		
		<label>전화번호</label>
		<input type="text" name="user_phoneNum" value="${member.user_phoneNum}"> <br>
		
		<label>주소</label>
		<input type="text" name="user_address" value="${member.user_address}"> <br>
			
		<label>이메일</label>
		<input type="text" name="user_email" value="${member.user_email}"> <br>
		
		<label>가입일자</label>
		<input type="text" name="user_joinDate" value="${member.user_joinDate}"> <br>
		
		
		<label>새로운 패스워드</label>
		<input type="password" name="user_pw"> </br>
		
		<button type="submit">수정하기</button>
		<input type="button" value="이전" onclick="history.go(-1)">
	</form>
	
	<p>
		<a href="/">처음으로</a>
	</p>
</body>
</html>