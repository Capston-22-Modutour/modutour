<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>마이페이지</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link rel="stylesheet" href="<c:url value='../resources/img/favicon.ico'/>">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
     <link rel="stylesheet" href="<c:url value='../resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

    <!-- Customized Bootstrap Stylesheet -->
    <link rel="stylesheet" href="<c:url value='../resources/css/style.css'/>">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<style>
	.sidebar {
		display:inline-block;
		width: 200px;
	    height: 300px;
	    background: var(--light);
	    transition: 0.5s;
	    z-index: 999;
	}
	
	@media (min-width: 992px) {
	    .sidebar {
	        margin-left: 0;
	    }
	
	    .sidebar.open {
	        margin-left: -250px;
	    }
	
	    .content {
	        width: calc(100% - 250px);
	    }
	}
	
	@media (max-width: 991.98px) {
	    .sidebar {
	        margin-left: -250px;
	    }
	
	    .sidebar.open {
	        margin-left: 0;
	    }
	}
	
	.sidebar .navbar .navbar-nav .nav-link {
	    padding: 7px 10px;
	    color: var(--dark);
	    font-weight: 500;
	    border-left: 3px solid var(--light);
	    border-radius: 0 30px 30px 0;
	    outline: none;
	}
	
	.sidebar .navbar .navbar-nav .nav-link:hover,
	.sidebar .navbar .navbar-nav .nav-link.active {
	    color: var(--primary);
	    background: #FFFFFF;
	    border-color: var(--primary);
	}
	
	.sidebar .navbar .navbar-nav .nav-link i {
	    width: 40px;
	    height: 40px;
	    display: inline-flex;
	    align-items: center;
	    justify-content: center;
	    background: #FFFFFF;
	    border-radius: 40px;
	}
	
	.sidebar .navbar .navbar-nav .nav-link:hover i,
	.sidebar .navbar .navbar-nav .nav-link.active i {
	    background: var(--light);
	}
	
	.sidebar .navbar .dropdown-toggle::after {
	    position: absolute;
	    top: 15px;
	    right: 15px;
	    border: none;
	    content: "\f107";
	    font-family: "Font Awesome 5 Free";
	    font-weight: 900;
	    transition: .5s;
	}
	
	.sidebar .navbar .dropdown-toggle[aria-expanded=true]::after {
	    transform: rotate(-180deg);
	}
	
	.sidebar .navbar .dropdown-item {
	    padding-left: 25px;
	    border-radius: 0 30px 30px 0;
	} 
</style>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />

				

	<!-- 일반 유저 정보 start -->
	<c:if test="${member != null}">
		<div class="container-fluid mt-5 pt-3" style="">
			<div class="container">
				<div class="row">
					<!-- 좌측 사이드바 start -->
					<div class="sidebar pe-4 pb-3 col-lg-2">
						<aside class="single_sidebar_widget post_category_widget">
							<nav class="navbar bg-light navbar-light">
								<div class="navbar-nav w-100">
									<div class="nav-item dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
											<i class="fa fa-laptop me-2"></i>회원정보
										</a>
										<div class="dropdown-menu bg-transparent border-0">
											<a href="/member/modify_member" class="dropdown-item">정보수정</a> 
											<a href="/member/delete_member" class="dropdown-item">회원탈퇴</a>
										</div>
									</div>
									<div class="nav-item dropdown">
										<a href="my_post" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
											<i class="fa fa-laptop me-2"></i>내게시글
										</a>
										<div class="dropdown-menu bg-transparent border-0">
											<a href="/my_freepost" class="dropdown-item">MY 자유 게시판</a> 
											<a href="/my_reviewpost" class="dropdown-item">MY 여행후기</a>
											<a href="/my_packageplan" class="dropdown-item">MY 패키지 설계</a>
										</div>
										<div class="nav-item dropdown">
											<a href="/my_purchase" class="dropdown-item">
												<i class="far fa-file-alt me-2"></i>&nbsp; 구매내역
											</a>
											<a href="/my_point" class="dropdown-item">
												<i class="far fa-file-alt me-2"></i>&nbsp; 포인트내역
											</a>
										</div>
									</div>
								</div>
							</nav>
						</aside>
					</div>
					<!-- 좌측 사이드바 end -->

					<div class="col-lg-10" style="float: right;">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">회원 정보</h4>
						</div>
						<div class="bg-white border border-top-0 p-4 mb-3">
							<div class="container">
								<div class="row">
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-id-card-alt text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">ID</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_id}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-signature text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">이름</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_name}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-genderless text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">성별</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_gender}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-birthday-cake text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">생일</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_birth}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-phone-alt text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">전화번호</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_phoneNum}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-map-marker-alt text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">주소</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_address}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-envelope-open text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">이메일</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;">${member.user_email}</p>
									</div>
									
									<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
										<i class="fa fa-calendar-check text-primary mr-2"></i>
										<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">가입일자</h5>
									</div>
									<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
										<p style="font-size: 20px; color: black; display: inline;"><fmt:formatDate value="${member.user_joinDate}" pattern="yyyy-MM-dd"/></p>
									</div>
								</div>
							</div>
							
							<div class="text-center">
								<button type="button" onclick="location.href='/member/modify_member'" class="btn btn-primary font-weight-semi-bold px-4">정보수정</button> &nbsp;
								<button type="button" onclick="location.href='/member/delete_member'" class="btn btn-delete font-weight-semi-bold px-4">회원탈퇴</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 일반 유저 정보 End -->

	<%------------ footer section  ------------%>
	<jsp:include page="../fix/footer.jsp" />

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-square back-to-top"><i class="fa fa-arrow-up"></i></a>

    <!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    <script src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/easing/easing.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

    <!-- Template Javascript -->
    <script src="<c:url value='../resources/js/main.js'/>"></script>
    
    <!-- 드롭박스 기능 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
<script>
	$(window).scroll(function(){
	  var scrT = $(window).scrollTop();
	  console.log(scrT); //스크롤 값 확인용
	};
	
	$(window).scroll(function(){
		  var scrT = $(window).scrollTop();
		  console.log(scrT); //스크롤 값 확인용
		  if(scrT == $(document).height() - $(window).height()){
		  	//스크롤이 끝에 도달했을때 실행될 이벤트
		  } else {
		  	//아닐때 이벤트
		  }
	};
</script>
</html>