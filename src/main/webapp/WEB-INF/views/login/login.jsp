<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="loginOK.jsp" method="post">
		아이디 : <input type="text" name="id"> <br>
		비밀번호 : <input type="password" name="pw"> <br>
		<input type="submit" value="로그인"> <br>
		<input type="button" value="회원가입" onClick="javascript:location.href='signUp.jsp'">
	</form>
	
	<a href="/board/write">글작성</a>
</body>