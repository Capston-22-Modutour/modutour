<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Topbar Start -->
    <div class="container-fluid d-none d-lg-block">
        <div class="row align-items-center bg-dark px-lg-5">
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-sm bg-dark p-0">
                    <ul class="navbar-nav ml-n2">
                        <li class="nav-item border-right border-secondary">
                            <a class="nav-link text-body small" href="#">회사소개</a>
                        </li>
                        <li class="nav-item border-right border-secondary">
                            <a class="nav-link text-body small" href="#">이용약관</a>
                        </li>
                        <li class="nav-item border-right border-secondary">
                            <a class="nav-link text-body small" href="#">여행약관</a>
                        </li>
                        
                        <!-- 로그인 시 로그인, 회원가입 숨기기 시작 -->
                        <!-- c:choose문은 if else문과 같음 -->
                        <c:choose>
                        	<c:when test = "${member != null || company != null}">
					            <li class="nav-item border-right border-secondary">
		                            <a class="nav-link text-body small" href="/login/loginMain" hidden="hidden">로그인</a>
		                        </li>
		                        <li class="nav-item">
		                            <a class="nav-link text-body small" href="/member/signUpMain" hidden="hidden">회원가입</a>
		                        </li>
		                        
		                        <!-- 기업 회원이 아닐 시 일반 유저 환영문구 + 로그아웃 -->
		                        <c:if test="${company == null}">
		                        	<li class="nav-item">
		                        		<a class="nav-link text-body small">${member.user_name}님 환영합니다!</a>
		                        	</li>
		                        	<li class="nav-item">
			                        	<a class="nav-link text-body small" href="/member/logout_member">로그아웃</a>
			                        </li>
		                        </c:if>
		                        
		                        <!-- 일반 회원이 아닐 시 기업 유저 환영문구 + 로그아웃 -->
		                        <c:if test="${member == null}">
		                        	<li class="nav-item">
		                        		<a class="nav-link text-body small">${company.com_name}님 환영합니다!</a>
		                        	</li>
		                        	<li class="nav-item">
			                        	<a class="nav-link text-body small" href="/member/logout_company">로그아웃</a>
			                        </li>
		                        </c:if>
		                        
				       		</c:when>
				       		
				       		<c:when test = "${member == null || company == null}">
					            <li class="nav-item border-right border-secondary">
		                            <a class="nav-link text-body small" href="/login/loginMain">로그인</a>
		                        </li>
		                        <li class="nav-item">
		                            <a class="nav-link text-body small" href="/member/signUpMain">회원가입</a>
		                        </li>
				       		</c:when>
                        </c:choose>
                        <!-- 로그인 시 로그인, 회원가입 숨기기 끝 -->
                    </ul>
                </nav>
            </div>
        </div>
        <div class="row align-items-center bg-white py-3 px-lg-5">
            <div class="col-lg-4">
                <a href="/" class="navbar-brand p-0 d-none d-lg-block">
                    <h1 class="m-0 display-4 text-uppercase text-primary">모두의<span class="text-secondary font-weight-normal">투어</span></h1>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid p-0">
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-2 py-lg-0 px-lg-5">
            <a href="index.html" class="navbar-brand d-block d-lg-none">
                <h1 class="m-0 display-4 text-uppercase text-primary">Biz<span class="text-white font-weight-normal">News</span></h1>
            </a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between px-0 px-lg-3" id="navbarCollapse">
                <div class="navbar-nav mr-auto py-0">
                    <a href="/" class="nav-item nav-link">Home</a>
                    <a href="/review/review_listPageSearch?num=1" class="nav-item nav-link">여행후기</a>
                    <a href="/board/listPageSearch?num=1" class="nav-item nav-link">커뮤니티</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">게시판</a>
                        <div class="dropdown-menu rounded-0 m-0">
                            <a href="/want_board/want_listPageSearch?num=1" class="dropdown-item">패키지 설계</a>
                            <a href="/suggest_board/suggest_listPageSearch?num=1" class="dropdown-item">여행사 입찰</a>
                            <a href="/sell_board/sell_listPageSearch?num=1" class="dropdown-item">패키지 판매</a>
                        </div>
                    </div>
                    
                    <c:choose>
                        	<c:when test = "${member != null || company != null}">
                        		<!-- 일반 유저 -->
                        		<c:if test="${company == null}">
                        			<a href="/myPage" class="nav-item nav-link">마이페이지</a>
                        		</c:if>
                        		
                        		<!-- 회사 유저 -->
					            <c:if test="${member == null}">
                        			<a href="/myPage_com" class="nav-item nav-link">마이페이지</a>
                        		</c:if>
				       		</c:when>
                        </c:choose>
                </div>
            </div>
        </nav>
    </div>
    <!-- Navbar End -->
</body>
</html>