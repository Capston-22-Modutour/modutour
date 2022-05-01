<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>일반 회원 가입</title>
	
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

	<div id="signUp">
		<h3 class="text-center text-white pt-5"></h3>
		<div class="container">
			<div id="login-row"	class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" role="form" method="post" autocomplete="off">
							<h3 class="text-center text-info">일반 회원가입</h3>
							<div class="form-group">
								<label for="user_id" class="text-info">ID</label> <br/> 
								<input type="text" name="user_id" id="user_id">
								<button type="button" class="memberIdCheck">아이디 중복 확인</button>
								<p class="result">
									<span class="msg">아이디를 확인하세요</span>
								</p>
							</div>
							<div class="form-group">
								<label for="user_pw" class="text-info">PW</label> <br/> 
								<input type="password" name="user_pw" id="user_pw">
							</div>
							<div class="form-group">
								<label for="user_name" class="text-info">이름</label> <br/> 
								<input type="text" name="user_name" id="user_name">
							</div>
							<div class="form-group">
								<label for="user_gender" class="text-info">성별</label> <br/> 
								<input type="radio" name="user_gender" id="user_gender" value="m" checked>남성
								<input type="radio" name="user_gender" id="user_gender" value="f">여성
							</div>
							<div class="form-group">
								<label for="user_birth" class="text-info">생일</label> <br/> 
								<input type="date" name="user_birth" id="user_birth" class="form-control">
							</div>
							<div class="form-group">
								<label for="user_phoneNum" class="text-info">전화번호</label> <br/> 
								<select name="user_phone1">
									<option>010</option>
								</select> - 
								<input type="text" name="user_phone2" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> - 
								<input type="text" name="user_phone3" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"><br/>
								<input type="text" name="user_phoneNum" value=(user_phone1+user_phone2+user_phone3) hidden="hidden">
							</div>
							<div class="form-group">
								<label for="user_address" class="text-info">주소</label> <br/> 
								<input type="text" name="user_address" id="user_address" class="form-control">
							</div>
							<div class="form-group">
								<label for="user_email" class="text-info">이메일</label> <br/> 
								<input type="text" name="user_email" id="user_email" class="form-control">
							</div>
							<div class="form-group">
								<button type="submit" id="submit" disabled="disabled" class="btn btn-info btn-md">가입하기</button>
							</div>
							<div id="register-link" class="text-right">
								<a href="/member/login_member" class="text-info">일반 로그인</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		$(".memberIdCheck").click(function() {

			var query = {
				user_id : $("#user_id").val()
			};

			$.ajax({
				url : "/member/memberIdCheck",
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

		$("#user_id").keyup(function() {
			$(".result .msg").text("아이디를 확인해주십시오.");
			$(".result .msg").attr("style", "color:#000");

			$("#submit").attr("disabled", "disabled");

		});
	</script>
	
	<%------------ header section  ------------%>
	<jsp:include page="../fix/footer.jsp" />
</body>
</html>