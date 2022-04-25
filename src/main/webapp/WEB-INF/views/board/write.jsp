<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 작성</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport">

	<!-- Favicon -->
	<link rel="stylesheet" href="<c:url value='/resources/img/favicon.ico'/>">
	
	<!-- Google Web Fonts -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">

	<!-- Font Awesome -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"	rel="stylesheet">

	<!-- Libraries Stylesheet -->
	<link rel="stylesheet" href="<c:url value='/resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">
	
	<!-- Customized Bootstrap Stylesheet -->
	<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />

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
	
	<%------------ footer section  ------------%>
	<jsp:include page="../fix/footer.jsp" />

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-square back-to-top"><i class="fa fa-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    <script src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='/resources/lib/easing/easing.min.js'/>"></script>
    <script src="<c:url value='/resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

    <!-- Template Javascript -->
    <script src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>