<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>모두의 투어</h1>

	<c:if test="${member == null}">
		<form role="form" method="post" autocomplete="off"
			action="/member/login">
			<label>ID</label> <input type="text" name="user_id" id="user_id" />
			&nbsp; <label>PW</label> <input type="password" name="user_pw"
				id="user_pw" /> <br />

			<button type="submit">로그인</button>
			<a href="/member/signUp">일반회원가입</a> <a href="/member/signUp_com">기업회원가입</a>
		</form>
	</c:if>

	<c:if test="${msg == false}">
		<p style="color: #f00;">로그인에 실패했습니다. 올바른 아이디 또는 패스워드를 입력해 주십시오</p>
	</c:if>

	<c:if test="${member != null}">
		<p>${member.user_name}님환영합니다!</p>

		<a href="member/modify">회원정보 수정</a>, 
		<a href="member/logout">로그아웃</a>
		<a href="member/delete">회원탈퇴</a>
	</c:if>


	<c:if test="${member == null}">
		<form role="form" method="post" autocomplete="off"
			action="/member/login_com">
			<label>ID</label> <input type="text" name="com_id" id="com_id" />
			&nbsp; <label>PW</label> <input type="password" name="com_pw"
				id="com_pw" /> <br />

			<button type="submit">로그인</button>
			<a href="/member/signUp">일반회원가입</a> <a href="/member/signUp_com">기업회원가입</a>
		</form>
	</c:if>

	<c:if test="${member != null}">
		<p>${member.com_name}님환영합니다!</p>

		<a href="/member/modify">회원정보 수정</a>, 
		<a href="/member/logout">로그아웃</a>
		<a href="/member/delete">회원탈퇴</a>
	</c:if>


	<p>
		<a href="/board/listPageSearch?num=1">게시물 목록</a>
	</p>
	<p>
		<a href="/board/write">게시물 작성</a>
	</p>
</body>
</html>
