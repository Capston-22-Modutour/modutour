<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마이페이지</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link rel="stylesheet" href="<c:url value='/resources/img/favicon.ico'/>">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link rel="stylesheet" href="<c:url value='/resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

    <!-- Customized Bootstrap Stylesheet -->
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">

</head>
<style>
	.sidebar {
	    width: 400px;
	    height: 500px;
	    overflow-y: auto;
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

	<!-- 회사 유저 정보 -->
	<c:if test="${company != null}">
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<!-- 좌측 사이드바 start -->
					<div class="col-lg-2 sidebar pe-4 pb-3">
						<aside class="single_sidebar_widget post_category_widget">
							<nav class="navbar bg-light navbar-light">
								<div class="navbar-nav w-100">
									<div class="nav-item dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>회원정보</a>
										<div class="dropdown-menu bg-transparent border-0">
											<a href="/member/modify_company" class="dropdown-item"><i class="far fa-file-alt me-2"></i>&nbsp; 정보수정</a>
											<a href="/member/delete_company" class="dropdown-item"><i class="far fa-file-alt me-2"></i>&nbsp; 회원탈퇴</a>	
										</div>
									</div>
									<div class="nav-item dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>내게시글</a>
										<div class="dropdown-menu bg-transparent border-0">
											<a href="/sale_list" class="dropdown-item"><i class="far fa-file-alt me-2"></i>&nbsp; 판매 입찰 목록</a>	
											<a href="/package_offer_list" class="dropdown-item"><i class="far fa-file-alt me-2"></i>&nbsp; 패키지 제안 목록</a>	
										</div>
										<div class="nav-item dropdown">
											<a href="/order" class="dropdown-item"><i class="far fa-file-alt me-2"></i>&nbsp; 주문내역</a>
										</div>
									</div>
								</div>
							</nav>
						</aside>
					</div>
					<!-- 좌측 사이드바 end -->
					<div class="col-lg-10">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">회원 정보</h4>
						</div>
						<div class="bg-white border border-top-0 p-4 mb-3">
							<div class="mb-4">
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-id-card-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">ID</h6>
									</div>
									<p class="mb-4">${company.com_id}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-signature text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">이름</h6>
									</div>
									<p class="mb-4">${company.com_name}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-phone-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">전화번호</h6>
									</div>
									<p class="m-0">${company.com_phoneNum}</p>
								</div>

								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-map-marker-alt text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">주소</h6>
									</div>
									<p class="m-0">${company.com_address}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-envelope-open text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">이메일</h6>
									</div>
									<p class="m-0">${company.com_email}</p>
								</div>
								
								<div class="mb-3">
									<div class="d-flex align-items-center mb-2">
										<i class="fa fa-calendar-check text-primary mr-2"></i>
										<h6 class="font-weight-bold mb-0">가입일자</h6>
									</div>
									<p class="m-0"><fmt:formatDate value="${company.com_joinDate}" pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
							
							<div class="text-center">
								<button type="button" onclick="location.href='/member/modify_company'" class="btn btn-primary font-weight-semi-bold px-4">정보수정</button> &nbsp;
								<button type="button" onclick="location.href='/member/delete_company'" class="btn btn-primary font-weight-semi-bold px-4">회원탈퇴</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- Contact End -->

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

</html>