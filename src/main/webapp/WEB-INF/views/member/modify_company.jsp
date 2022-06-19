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

	<!-- 회사 정보 수정 start -->
	<c:if test="${company != null}">
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">회원 정보</h4>
						</div>
						<form role="form" method="post" autocomplete="off">
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="mb-4">
									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-id-card-alt text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">ID</h6>
										</div>
										<p name="com_id" class="mb-4">${company.com_id}</p>
										<input name="com_id" type="text" value="${company.com_id}" hidden="hidden">
									</div>

									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-signature text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">이름</h6>
										</div>
										<p name="com_name" class="mb-4">${company.com_name}</p>
									</div>

									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-phone-alt text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">전화번호</h6>
										</div>
										<select name="com_phone1" value="${company.com_phone1}">
											<option>02</option>
											<option>031</option>
											<option>051</option>
										</select> - <input type="text" name="com_phone2" value="${company.com_phone2}" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> - 
										<input type="text" name="com_phone3" value="${company.com_phone3}" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"><br/>
									</div>

									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-map-marker-alt text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">주소</h6>
										</div>
										<input name="com_address" type="text" class="m-0" value="${company.com_address}">
									</div>

									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-envelope-open text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">이메일</h6>
										</div>
										<input name="com_email" type="text" class="m-0" value="${company.com_email}">
									</div>

									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-calendar-check text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">가입일자</h6>
										</div>
										<p name="com_joinDate" class="m-0"><fmt:formatDate value="${company.com_joinDate}" pattern="yyyy-MM-dd" />
										</p>
									</div>
									
									<div class="mb-3">
										<div class="d-flex align-items-center mb-2">
											<i class="fa fa-calendar-check text-primary mr-2"></i>
											<h6 class="font-weight-bold mb-0">비밀번호 확인</h6>
										</div>
										<input type="password" name="com_pw" class="m-0" required="required">
										</p>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary font-weight-semi-bold px-4">수정하기</button>
									&nbsp;
									<button type="button" onclick="history.go(-1)" class="btn btn-primary font-weight-semi-bold px-4">취소하기</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 회사 정보 수정 End -->
	
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