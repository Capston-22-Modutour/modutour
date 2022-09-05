<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>모두의 투어</title>
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
    
</head>
<body>
    
	<%------------ header section  ------------%>
	<jsp:include page="./fix/header.jsp" />
	
	<a href="/test">tab 테스트</a>
	
	<!-- Main News Slider Start -->
    <div class="container-fluid pt-5 mb-3">
        <div class="container">
        	<div class="row">
	            <div class="col-lg-7 px-0">
	                <div class="owl-carousel main-carousel position-relative">
	                    <div class="position-relative overflow-hidden" style="height: 500px;">
	                        <img class="img-fluid h-100" src="../resources/img/event01.jpg" style="object-fit: cover;">
	                        <div class="overlay">
	                            <div class="mb-2">
	                                <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/lowest_price">바로가기</a>
	                                <label class="text-white">2022-01-15</label>
	                            </div>
	                            <a class="h2 m-0 text-white text-uppercase font-weight-bold" href="/event/lowest_price">딱! 한달만 초특급 최저가</a>
	                        </div>
	                    </div>
	                    <div class="position-relative overflow-hidden" style="height: 500px;">
	                        <img class="img-fluid h-100" src="../resources/img/event02.jpg" style="object-fit: cover;">
	                        <div class="overlay">
	                            <div class="mb-2">
	                                <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/japan">바로가기</a>
	                                <label class="text-white">2022-02-24</label>
	                            </div>
	                            <a class="h2 m-0 text-white text-uppercase font-weight-bold" href="/event/japan">봄에 떠나는 여행 일본</a>
	                        </div>
	                    </div>
	                    <div class="position-relative overflow-hidden" style="height: 500px;">
	                        <img class="img-fluid h-100" src="../resources/img/event03.jpg" style="object-fit: cover;">
	                        <div class="overlay">
	                            <div class="mb-2">
	                                <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/danang">바로가기</a>
	                                <label class="text-white">2022-06-01</label>
	                            </div>
	                            <a class="h2 m-0 text-white text-uppercase font-weight-bold" href="/event/danang">요즘 왜이렇게 핫해? 다낭</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col-lg-5 px-0">
	                <div class="row mx-0">
	                    <div class="col-md-6 px-0">
	                        <div class="position-relative overflow-hidden" style="height: 250px;">
	                            <img class="img-fluid w-100 h-100" src="../resources/img/event04.jpg" style="object-fit: cover;">
	                            <div class="overlay">
	                                <div class="mb-2">
	                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/chungqing">바로가기</a>
	                                    <label class="text-white"><small>2022-07-12</small></label>
	                                </div>
	                                <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/chungqing">대륙의 숨결 충칭!</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-md-6 px-0">
	                        <div class="position-relative overflow-hidden" style="height: 250px;">
	                            <img class="img-fluid w-100 h-100" src="../resources/img/event05.jpg" style="object-fit: cover;">
	                            <div class="overlay">
	                                <div class="mb-2">
	                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/car_sleep">바로가기</a>
	                                    <label class="text-white"><small>2022-06-13</small></label>
	                                </div>
	                                <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/car_sleep">핫한 차박 바르게 즐기는 방법</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-md-6 px-0">
	                        <div class="position-relative overflow-hidden" style="height: 250px;">
	                            <img class="img-fluid w-100 h-100" src="../resources/img/event06.jpg" style="object-fit: cover;">
	                            <div class="overlay">
	                                <div class="mb-2">
	                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/camping">바로가기</a>
	                                    <label class="text-white"><small>2022-06-20</small></label>
	                                </div>
	                                <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/camping">[제휴] 미리 캠핑카로 떠나는 감성 캠핑</a>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="col-md-6 px-0">
	                        <div class="position-relative overflow-hidden" style="height: 250px;">
	                            <img class="img-fluid w-100 h-100" src="../resources/img/event07.jpg" style="object-fit: cover;">
	                            <div class="overlay">
	                                <div class="mb-2">
	                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/event07">바로가기</a>
	                                    <label class="text-white"><small>2022-06-07</small></label>
	                                </div>
	                                <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/event07">듣기만 해도 여행 떠나고 싶게 만드는 감성팝 100</a>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
        	</div>
        </div>
    </div>
    <!-- Main News Slider End -->
	
	
	<!-- 베스트 게시판 start -->
	<!-- 여행후기 베스트 현재시각 기준 일주일까지 추천수 20이상 -->
	<div class="container-fluid pt-5 mb-3">
        <div class="container">
            <div class="section-title">
                <h4 class="m-0 text-uppercase font-weight-bold">여행후기 베스트</h4>
                <a href="/review/review_listPageSearch?num=1">더 보기</a>
            </div>
				<table class="styled-table">
					<thead>
						<tr>
							<th width="5%">번호</th>
							<th width="10%">미리보기</th>
							<th width="20%">제목</th>
							<th width="10%">작성일</th>
							<th width="10%">작성자</th>
							<th width="5%" style="font-size: 16px;">추천수</th>
							<th width="5%" style="font-size: 16px;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rvlist}" var="rvlist">
							<tr class="active-row">
								<td>${rvlist.review_bno}</td>
								<td><img src="${rvlist.review_thumbnail}" width="100px" height="100px"></td>
								<td><a href="/review/review_view?review_bno=${rvlist.review_bno}">${rvlist.review_title}</a></td>
								<td><fmt:formatDate value="${rvlist.review_regDate}" pattern="yyyy-MM-dd"/></td>
								<td>${rvlist.review_writer}</td>
								<td>${rvlist.review_like}</td>
								<td>${rvlist.review_viewCnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
	<!-- 여행후기 베스트 end -->
	
	<!-- 패키지 설계 베스트 현재시각 기준 일주일까지 추천수 20이상 -->
	<div class="container-fluid pt-5 mb-3">
        <div class="container">
            <div class="section-title">
                <h4 class="m-0 text-uppercase font-weight-bold">패키지 설계 베스트</h4>
                <a href="/want_board/want_listPageSearch?num=1">더 보기</a>
            </div>
            <div class="styled-table">
				<table style="text-align: center;">
					<thead>
						<tr>
							<th width="5%">번호</th>
							<th width="10%">미리보기</th>
							<th width="20%">제목</th>
							<th width="10%">작성일</th>
							<th width="10%">작성자</th>
							<th width="5%" style="font-size: 16px;">추천수</th>
							<th width="5%" style="font-size: 16px;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${wtlist}" var="wtlist">
							<tr class="active-row">
								<td>${wtlist.board_want_bno}</td>
								<td><img src="${wtlist.board_want_thumbnail}" width="100px" height="100px"></td>
								<td><a href="/want_board/want_view?board_want_bno=${wtlist.board_want_bno}">${wtlist.board_want_title}</a></td>
								<td><fmt:formatDate value="${wtlist.board_want_regDate}" pattern="yyyy-MM-dd"/></td>
								<td>${wtlist.board_want_writer}</td>
								<td>${wtlist.board_want_like}</td>
								<td>${wtlist.board_want_viewCnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 패키지 설계 베스트 end -->
	
	<!-- 패키지 판매 베스트 현재시각 기준 일주일까지 추천수 20이상 -->
	<div class="container-fluid pt-5 mb-3">
        <div class="container">
            <div class="section-title">
                <h4 class="m-0 text-uppercase font-weight-bold">패키지 판매 베스트</h4>
                <a href="/want_board/want_listPageSearch?num=1">더 보기</a>
            </div>
            <div class="styled-table">
				<table style="text-align: center;">
					<thead>
						<tr>
							<th width="5%">번호</th>
							<th width="10%">미리보기</th>
							<th width="20%">제목</th>
							<th width="10%">작성일</th>
							<th width="10%">작성자</th>
							<th width="5%" style="font-size: 16px;">추천수</th>
							<th width="5%" style="font-size: 16px;">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${selist}" var="selist">
							<tr class="active-row">
								<td>${selist.sell_bno}</td>
								<td><img src="${selist.sell_thumbnail}" width="100px" height="100px"></td>
								<td><a href="/sell_board/sell_view?sell_bno=${selist.sell_bno}">${selist.sell_title}</a></td>
								<td><fmt:formatDate value="${selist.sell_regDate}" pattern="yyyy-MM-dd"/></td>
								<td>${selist.sell_writer}</td>
								<td>${selist.sell_like}</td>
								<td>${selist.sell_viewCnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 패키지 판매 베스트 end -->
	<!-- 베스트 게시판 end -->
		
    


    <!-- Featured News Slider Start -->
    <div class="container-fluid pt-5 mb-3">
        <div class="container">
            <div class="section-title">
                <h4 class="m-0 text-uppercase font-weight-bold">모두의 타임즈</h4>
            </div>
            <div class="owl-carousel news-carousel carousel-item-4 position-relative">
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event01.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/lowest_price">바로가기</a>
	                        <label class="text-white">2022-01-15</label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-bold" href="/event/lowest_price">딱! 한달만 초특급 최저가</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event02.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/japan">바로가기</a>
	                        <label class="text-white">2022-02-24</label>
						</div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-bold" href="/event/japan">봄에 떠나는 여행 일본</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event03.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/danang">바로가기</a>
	                    	<label class="text-white">2022-06-01</label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-bold" href="/event/danang">요즘 왜이렇게 핫해? 다낭</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event04.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/chungqing">바로가기</a>
	                        <label class="text-white"><small>2022-07-12</small></label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/chungqing">대륙의 숨결 충칭!</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event05.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/car_sleep">바로가기</a>
	                        <label class="text-white"><small>2022-06-13</small></label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/car_sleep">핫한 차박 바르게 즐기는 방법</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event06.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/camping">바로가기</a>
	                        <label class="text-white"><small>2022-06-20</small></label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/camping">[제휴] 미리 캠핑카로 떠나는 감성 캠핑</a>
                    </div>
                </div>
                <div class="position-relative overflow-hidden" style="height: 300px;">
                    <img class="img-fluid h-100" src="../resources/img/event07.jpg" style="object-fit: cover;">
                    <div class="overlay">
                        <div class="mb-2">
                            <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2" href="/event/event07">바로가기</a>
	                        <label class="text-white"><small>2022-06-07</small></label>
	                    </div>
	                    <a class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="/event/event07">듣기만 해도 여행 떠나고 싶게 만드는 감성팝 100</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Featured News Slider End -->

	<%------------ footer section  ------------%>
	<jsp:include page="./fix/footer.jsp" />

    <!-- Back to Top -->
    <a href="#" class="btn btn-primary btn-square back-to-top"><i class="fa fa-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    <script src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/easing/easing.min.js'/>"></script>
    <script src="<c:url value='../resources/lib/owlcarousel/owl.carousel.min.js'/>"></script>

    <!-- Template Javascript -->
    <script src="<c:url value='../resources/js/main.js'/>"></script>
</body>

</html>

<script>
	//Testimonials carousel
	$(".testimonial-carousel").owlCarousel({
	    autoplay: true,
	    smartSpeed: 1000,
	    items: 1,
	    dots: true,
    	loop: true,
	});
</script>