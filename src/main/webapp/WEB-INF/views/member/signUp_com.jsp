<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>기업 회원가입</title>
	
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
	<!-- 제이쿼리 CDN -->
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />

	<div id="signUp_com">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"	class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" role="form" method="post" autocomplete="off">
							<h3 class="text-center text-info">기업 회원가입</h3>
							<div class="form-group">
								<label for="com_id" class="text-info">ID</label> <br/> 
								<input type="text" name="com_id" id="com_id" required="required">
								<button type="button" class="companyIdCheck btn btn-delete"">아이디 중복 확인</button>
								<p class="result">
									<span class="msg">아이디를 확인하세요</span>
								</p>
							</div>
							<div class="form-group">
								<label for="com_pw" class="text-info">PW</label> <br/> 
								<input type="password" name="com_pw" id="com_pw" required="required">
							</div>
							<div class="form-group">
								<label for="com_name" class="text-info">이름</label> <br/> 
								<input type="text" name="com_name" id="com_name" required="required">
							</div>
							<div class="form-group">
								<label for="com_phoneNum" class="text-info">전화번호</label> <br/> 
								<select name="com_phone1">
									<option>02</option>
									<option>031</option>
									<option>051</option>
									<option>053</option>
									<option>062</option>
								</select> - 
								<input type="text" name="com_phone2" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required="required"> - 
								<input type="text" name="com_phone3" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1'	);" required="required"><br/>
							</div>
							<div class="form-group">
								<label for="com_address" class="text-info">주소</label> <br/> 
								<input type="text" name="com_address" id="com_address" class="form-control" required="required">
							</div>
							<div class="form-group">
								<label for="com_email" class="text-info">이메일</label> <br/> 
								<input type="text" name="com_email" id="com_email" class="form-control" required="required">
							</div>
							<div class="form-group">
								<button type="submit" id="submit" disabled="disabled" class="btn btn-info btn-md">가입하기</button>
							</div>
							<div id="register-link" class="text-right">
								<a href="/member/login_company" class="text-info">기업 로그인</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(".companyIdCheck").click(function() {

			var query = {
				com_id : $("#com_id").val()
			};

			$.ajax({
				url : "/member/companyIdCheck",
				type : "post",
				data : query,
				success : function(data) {

					if (data == 1) {
						$(".result .msg").text("사용 불가");
						$(".result .msg").attr("style", "color:#f00");

						$("#submit").attr("disabled", "disabled");
					} else {
						$(".result .msg").text("사용 가능");
						$(".result .msg").attr("style", "color:#00f");

						$("#submit").removeAttr("disabled");
					}
				}
			}); // ajax 끝
		});

		$("#com_id").keyup(function() {
			$(".result .msg").text("아이디를 확인해주십시오.");
			$(".result .msg").attr("style", "color:#000");

			$("#submit").attr("disabled", "disabled");

		});
	</script>
	
	<%------------ header section  ------------%>
	<jsp:include page="../fix/footer.jsp" />
</body>
</html>