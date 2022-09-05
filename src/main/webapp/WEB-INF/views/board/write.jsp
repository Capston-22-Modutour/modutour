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
	
	
	<!-- datepicker -->
    <!-- CSS CDN -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw==" crossorigin="anonymous" />
	<!-- jQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Datepicker CDN -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ==" crossorigin="anonymous"></script>
	<!-- 한글 제공 CDN -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js" integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ==" crossorigin="anonymous"></script>
 	<!-- <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script> -->
 	
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
 	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
</head>
<style>
	.select_img img {
		margin: 20px 0;
	}
</style>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	
	<c:if test="${member == null}">
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="section-title mb-0">
							<div class="text-center">
								<h4 class="m-0 text-uppercase font-weight-bold">
									로그인이 필요한 서비스 입니다<br />
								</h4>
								<a href="/login/loginMain">로그인하러가기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 회원이 아닐 시 게시글 작성 불가 -->
	
	<c:if test="${member != null}">
		<form class="form" role="form" method="post" autocomplete="off" enctype="multipart/form-data">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									<input type="text" size="81" name="board_title" placeholder="제목" required="required">
								</h4>
							</div>
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="mb-4">
									<input type="text" name="board_writer" value="${member.user_name}" hidden="hidden">
									<textarea cols="117" rows="10" name="board_content" placeholder="내용을 입력해 주세요" required="required"></textarea>
									<br>
									
									파일 업로드 <br/>
									<input type="file" id="file_img" name="file"/>
									
									<div class="select_img"><img src=""></div>
									
									<div class="text-center">
										<button type="submit" class="btn btn-warning">작성</button> &nbsp;
										<input type="button" class="btn btn-warning" value="취소" onclick="history.go(-1)">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		
    
	</c:if>
	

	<%-- <c:if test="${msg == 'login_error'}">
		<p>로그인이 필요한 서비스 입니다</p>
		<p><a href="/">홈으로</a></p>
	</c:if> --%>
	<c:if test="${company != null}">
		<form method="post">
				<label>제목</label>
				<input type="text" name="board_title"> <br/>
				
				<label>작성자</label>
				<input type="text" name="board_writer" value="${company.com_name}" readonly="readonly"> <br/>
				
				<label>내용</label>
				<textarea cols="50" rows="5" name="board_content"></textarea> <br/>
				
				<button type="submit">작성</button>
			</form>
	</c:if>
	
	<%------------ footer section  ------------%>
	<jsp:include page="../fix/footer.jsp" />

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-square back-to-top"><i class="fa fa-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    
    <script src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='/resources/lib/easing/easing.min.js'/>"></script>
    <script src="<c:url value='/resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

    <!-- Template Javascript -->
    <script src="<c:url value='/resources/js/main.js'/>"></script>
</body>
	<script>
		// 사용자가 선택한 이미지 보여줌
		$("#file_img").change(function(){
			if(this.files && this.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(500);        
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
		
		
		$(function(){
		    $('.datepicker').datepicker();
		  })
		  
		  
		  $(document).ready(function(){
			  $('.input-daterange').datepicker({
			  format: 'yyyy-dd-mm',
			  autoclose: true,
			  calendarWeeks : true,
			  clearBtn: true,
			  disableTouchKeyboard: true
			});
		});
	</script>
	
</html>