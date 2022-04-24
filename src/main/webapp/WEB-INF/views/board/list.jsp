<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="nav">
		<%@ include file="../include/nav.jsp" %>
	</div>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.board_bno}</td>
					<td>
						<a href="/board/view?board_bno=${list.board_bno}">${list.board_title}</a>
					</td>
					<td>
						<fmt:formatDate value="${list.board_regDate}" pattern="yyyy-MM-dd" />
					</td>
					<td>${list.board_writer}</td>
					<td>${list.board_viewCnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<input type="button" value="이전" onclick="history.go(-1)">
</body>
</html>