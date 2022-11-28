<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회사 소개</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link rel="stylesheet"
	href="<c:url value='/resources/img/favicon.ico'/>">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link rel="stylesheet"
	href="<c:url value='/resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

<!-- Customized Bootstrap Stylesheet -->
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />


	<%-- 소개 --%>
	<div class="card no-gutter container">
		<div class="row">
			<div class="mt-2 mx-auto" style="margin-bottom: 50px;">
				<div style="margin-bottom: 50px;">
					<img src="/resources/img/1.jpg" align="middle" style="float: left; margin-right: 20px; margin-bottom: 10px; width: 500px; height: 500px;" />
				</div>
				<div style="margin-bottom: 50px; padding-right: 20px;">
					<h2 style="text-align: center; margin-bottom: 30px;">여행사업</h2>

					<h5 style="">
						모두의투어는 국내 대표 여행기업을 넘어 <br> k글로벌 관광레저그룹으로 도약하고 있습니다
					</h5>

					<h5 style="">여행 준비, 항공, 숙박, 현지 교통, 현지 경험
						(투어, 티켓, 특가여행, 패키지) 등 모든 여행 경험을 연결하여 새로운 여행 방식을 만들어갑니다</h5>
				</div>



				<%-- 소개말 --%>
				<div class="card no-gutter container">
					<div class="card-image-center picture svg-img ">
						<img loading="eager" src="/resources/img/2.png" style="float: left; width: 400px; height: 400px;"> 

						<div class="card-body container text-gray">
							<h3 class="card-title text-m">대표이사 홍선기</h3>
							<!--add new text field for job/title/role -->
							<div class="card-description">
								<p>
									항상 한결같이 화합과 전진으로 <br>대한민국 여행업의 희망이 됩니다.
								</p>

								<img loading="eager" src="/resources/img/3.jpg" style="float: left; width: 380px; height: 380px;">
								<div class="card-body container text-gray">
									<h3 class="card-title text-m">CEO 전수현</h3>
									<!--add new text field for job/title/role -->
									<div class="card-description">
										<p>
											새로운 변화와 혁신으로 <br>미래를 향한 힘찬 발걸음을 시작합니다.
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%-- 강점 --%>
				<div class="intro_wrap int_type02" style="margin-top: 30px; padding-left: 20px;">
					<h2 class="intro_title">모두의 투어의 강점	</h2>
					<br>
					<ul>
						<li class="numb01">
							<h4>고객 만족 증대</h4>
							<p style="color: blue;">상품 기획자가 직접 상담하여 전문적 신뢰형성</p>
						</li>
						<li class="numb02">
							<h4>시장 지배력과 가능성</h4>
							<p style="color: blue;">400여명의 해외여행 전문가집단으로 구성된 상품개발팀 운영</p>
						</li>
						<li class="numb03">
							<h4>영업력 &amp; 노하우</h4>
							<p style="color: blue;">전문 인력 구성 및 체계적인 Network 구성</p>
						</li>
						<li class="numb04">
							<h4>체계적인 재무구조</h4>
							<p style="color: blue;">삼천리자전거 가족회사 2017년 49만명 송출 코스닥 상장기업</p>
						</li>
						<li class="numb05">
							<h4>가치있는 요금</h4>
							<p style="color: blue;">상품 기획자가 직접 상담하여 전문적 신뢰형성</p>
						</li>
					</ul>
				</div>

			</div>
		</div>
	</div>

	<%------------ footer section  ------------%>
	<jsp:include page="../fix/footer.jsp" />

	<!-- Back to Top -->
	<a href="#" class="btn btn-primary btn-square back-to-top"> <i
		class="fa fa-arrow-up"></i>
	</a>

	<!-- JavaScript Libraries -->
	<script
		src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
	<script
		src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
	<script src="<c:url value='/resources/lib/easing/easing.min.js'/>"></script>
	<script
		src="<c:url value='/resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value='/resources/js/main.js'/>"></script>
</body>
</html>

<!-- 드롭박스 기능 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>