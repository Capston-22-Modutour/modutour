<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회사 정보 수정</title>

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

	<form role="form" method="post" autocomplete="off">
		<label>ID</label>
		<label name="user_id">${company.com_id}</label> <br>
	
		<label>이름</label>
		<label name="user_name">${company.com_name}</label> <br>
		
		<label>전화번호</label>
		<input type="text" name="user_phoneNum" value="${company.com_phoneNum}"> <br>
		
		<label>주소</label>
		<input type="text" name="user_address" value="${company.com_address}"> <br>
			
		<label>이메일</label>
		<input type="text" name="user_email" value="${company.com_email}"> <br>
		
		<!-- jstl:format 태그를 이용한 날짜 형식 변환 -->
		<label>가입일자</label>
		<fmt:formatDate value="${company.com_joinDate}" pattern="yyyy-MM-dd" /> <br>
		
		
		<label>새로운 패스워드</label>
		<input type="password" name="com_pw"> </br>
		
		<button type="submit">수정하기</button>
		<input type="button" value="이전" onclick="history.go(-1)">
	</form>
	
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