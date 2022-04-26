<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>
	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>
	
	<label>조회수</label>
	${view.board_want_viewCnt} <br/>
	
	<label>좋아요</label>
	${view.board_want_like} <br/>
	
	<label>제목</label>
	${view.board_want_title} <br/>
		
	<label>작성자</label>
	${view.board_want_writer} <br/>
	
	<label>목적지</label>
	${view.board_want_destination} <br/>
	
	<label>내용</label>
	${view.board_want_content} <br/>
	
	<label>인원수</label>
	${view.board_want_people} <br/>
	
	<label>출발일</label>
	<fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" /> <br/>
	
	<label>도착일</label>
	<fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" /> <br/>
	
	<div>
		<a href="/want_board/want_modify?want_board_bno=${view.board_want_bno}">게시글 수정</a>
		<a href="/want_board/want_delete?want_board_bno=${view.board_want_bno}">게시글 삭제</a>
	</div>
	
	<!-- 댓글 시작 -->
	<hr/>
	
	<ul>
		<c:forEach items="${reply}" var="reply">
			<li>
				<div>
					<p>${reply.reply_writer} / <fmt:formatDate value="${reply.reply_regDate}" pattern="yyyy-MM-dd"/></p>
					<p>${reply.reply_content}</p>
				</div>
			</li>	
		</c:forEach>
	</ul>
	
	<div>
		<form method="post" action="/reply/write">
			<p>
				<label>댓글 작성자</label> <input type="text" name="reply_writer">
			</p>
			<p>
				<textarea rows="5" cols="50" name="reply_content"></textarea>
			</p>
			<p>
				<input type="hidden" name="board_bno" value="${view.board_bno}">
				<button type="submit">댓글 작성</button>
			</p>
		</form>
		
	</div>
	
	<!-- 댓글 끝 -->
	
	<input type="button" value="이전" onclick="history.go(-1)">
</body>
</html>