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
<style>
	.select_img img {
		margin: 20px 0;
	}
</style>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	
	<%-- <c:if test="${company != null}">
		<p>일반 회원만 작성이 가능합니다</p>
	</c:if> --%>
	
	<!-- 회원이 아닐 시 게시글 작성 불가 -->
	<c:choose>
		<c:when test="${member == null}">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									일반 회원만 작성이 가능합니다
								</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		
		<c:when test="${company != null}">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									일반 회원만 작성이 가능합니다
								</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>
	
	<c:if test="${member != null}">
		<!-- 게시글 내용 Start -->
		<form class="form" role="form" method="post" autocomplete="off" enctype="multipart/form-data">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									<input type="text" size="81" name="board_want_title" placeholder="제목을 입력해 주세요"/>
								</h4>
							</div>
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="mb-4">
									<input type="text" name="board_want_writer" value="${member.user_name}" hidden="hidden">
									<label>목적지</label> <br/> 
									<input type="text" style="color: black;" name="board_want_destination" class="m-0 text-uppercase font-weight-bold px-8" placeholder="목적지를 입력해 주세요"> <br /> 
										
									<label>희망사항</label> <br/>
									<!-- id='textarea'의 값을 받아 id='result'에 값 넘김 -->
									<textarea cols="68" rows="5" id="textarea" class="m-0 text-uppercase font-weight-bold px-8" placeholder="희망사항을 입력해 주세요"></textarea>
									<textarea id="result" name="board_want_content" hidden></textarea>
									<br>
									<br /> 
										
									<label>인원수</label> <br/> 
									<input type="text" style="color: black;" name="board_want_people" class="m-0 text-uppercase font-weight-bold px-8" placeholder="인원수를 입력해 주세요"> <br /> 
										
									<label>출발일</label> <br/>
									<input type="date" style="color: black;" name="board_want_start" class="m-0 text-uppercase font-weight-bold px-8">
									<br /> 
										
									<label>도착일</label> <br/>
									<input type="date" style="color: black;" name="board_want_end" class="m-0 text-uppercase font-weight-bold px-8">
								</div>
								
								파일 업로드 <br/>
								<input type="file" id="sell_img" name="file"/>
									
								<div class="select_img"><img src=""></div>
		
								<div class="text-center">
									<button type="submit" class="btn btn-warning" onclick="getHtml();">작성하기</button> &nbsp; 
									<input type="button" class="btn btn-warning" value="취소" onclick="history.go(-1)">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- 게시글 내용 end -->
	</c:if>
	
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
<script>
	// 사용자가 선택한 이미지 보여줌
	$("#sell_img").change(function(){
		if(this.files && this.files[0]) {
			var reader = new FileReader;
			reader.onload = function(data) {
				$(".select_img img").attr("src", data.target.result).width(500);        
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	// textarea 엔터키 <br>로 변환
	function getHtml(){
		var html = $("#textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); //id='textarea'에서 엔터키를 인식해 <br>태그로 변환
		$("#result").html(html); //id='result'에 <br>태그로 변환된 내용 저장
	}
</script>
</html>