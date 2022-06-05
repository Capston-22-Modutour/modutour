<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 조회</title>
	
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

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
	
	<!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
</head>
<style>
	img {
		margin: 20px 0;
	}
</style>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	
	<!-- 게시글 내용 Start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
				<form class="form" role="form" method="post" autocomplete="off" action="/order/purchase">
					<div class="section-title mb-0">
						<h4 class="m-0 text-uppercase font-weight-bold">${view.sell_title}</h4>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
							<fmt:formatDate value="${view.sell_regDate}" pattern="yyyy-MM-dd" />
						</p>
					</div>
					<div class="section-title mb-1">
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">${view.sell_writer}</p>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">조회수 ${view.sell_viewCnt}</p>
						
						<!-- 유저 이름과 게시글 작성자가 일치해야 게시글 수정, 삭제 가능 
							  하지만 동명이인 일시? 추후 id로 개선 필요함
						-->
						<c:if test="${company.com_name == view.sell_writer}">
							<div>
								<a href="/sell_board/sell_modify?sell_bno=${view.sell_bno}">게시글 수정</a>
								<a href="/sell_board/sell_delete?sell_bno=${view.sell_bno}">게시글 삭제</a>
							</div>
						</c:if>
					</div>
					<div class="bg-white border border-top-0 p-4 mb-3">
						<div class="mb-4">
							<label>요청자</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_writer}</p>
							<br/>
							
							<label>목적지</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_destination}</p>
							<br/>
							
							<label>제안사항</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_content}</p>
							<br/>
							
							<label>인원수</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_people}</p>
							<br/>
							
							<label>출발일</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
								<fmt:formatDate value="${view.sell_start}" pattern="yyyy-MM-dd" />
							</p>
							<br/>
							
							<label>도착일</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
								<fmt:formatDate value="${view.sell_end}" pattern="yyyy-MM-dd" />
							</p> <br/>
							
							<label>비용</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_price}원</p>
							<br/>
							
							<label>가이드 포함 여부</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_guide}</p>
							<br/>
							
							<label>항공사</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_air}</p>
							<br/>
							
							<c:if test="${view.sell_img != null}">
								<img src="${view.sell_img}" width="500px" height="500px">
							</c:if>
							
							<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
							<div class="text-center">
								<c:if test="${member != null}">
									<div style="margin-right: 1px;">
										<button type="submit" class="btn btn-warning">구매하기</button>
									</div>
								</c:if>
							</div>
							
							<input type="text" name="sell_bno" value="${view.sell_bno}" hidden="hidden">
							<input type="text" name="user_num" value="${member.user_num}" hidden="hidden">
							<input type="text" name="order_title" value="${view.sell_title}" hidden="hidden">
							<input type="text" name="order_writer" value="${view.sell_writer}" hidden="hidden">
							<input type="text" name="order_destination" value="${view.sell_destination}" hidden="hidden">
							<input type="text" name="order_price" value="${view.sell_price}" hidden="hidden">
							<input type="text" name="order_people" value="${view.sell_people}" hidden="hidden">
							<input type="text" name="order_guide" value="${view.sell_guide}" hidden="hidden">
							<input type="text" name="order_air" value="${view.sell_air}" hidden="hidden">
							<input type="text" name="order_start" value="<fmt:formatDate value="${view.sell_start}" pattern="yyyy-MM-dd" />" hidden="hidden">
							<input type="text" name="order_end" value="<fmt:formatDate value="${view.sell_end}" pattern="yyyy-MM-dd" />" hidden="hidden">
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 게시글 내용 end -->
	
	<!-- 댓글 start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="bg-white border border-top-0 p-4 mb-3">
						<div class="mb-4">
							<form method="post" action="/want_reply/want_write">
								<!-- 회원이 아닐 시 댓글 작성 불가 -->
								<c:if test="${member == null && company == null}">
									<p>로그인이 필요한 서비스 입니다</p>
								</c:if>

								<c:choose>
									<c:when test="${member != null || company != null}">
										<c:if test="${member != null}">
											<!-- 일반 회원 댓글 -->
											<p>
												<input type="text" name="board_want_reply_writer" value="${member.user_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="board_want_reply_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="board_want_bno" value="${view.board_want_bno}">
												<button type="submit" class="btn btn-warning">댓글 작성</button>
											</p>
										</c:if>
										
										<!-- 기업 회원 댓글 -->
										<c:if test="${company != null}">
											<p>
												<input type="text" name="board_want_reply_writer" value="${company.com_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="board_want_reply_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="board_want_bno" value="${view.board_want_bno}">
												<button type="submit" class="btn btn-warning">댓글 작성</button>
											</p>
										</c:if>
									</c:when>
								</c:choose>
								<%-- <c:if test="${member == null && company == null}">
									<p>로그인이 필요한 서비스 입니다</p>
								</c:if> --%>
							</form>
							
							<ul style="color: black;">
								<c:forEach items="${reply}" var="reply">
									<li>
										<div>
											<p>${reply.board_want_reply_writer} / ${reply.board_reply_rno}
												/
												<fmt:formatDate value="${reply.board_want_reply_regDate}" pattern="yyyy-MM-dd" />
												<c:if test="${member.user_name == reply.board_want_reply_writer}">
													<a href="/want_reply/want_modify?board_reply_rno=${reply.board_reply_rno}">댓글 수정</a>
													<a href="/want_reply/want_delete?board_reply_rno=${reply.board_reply_rno}">댓글 삭제</a>
												</c:if>
												
												<c:if test="${company.com_name == reply.board_want_reply_writer}">
													<a href="/want_reply/want_modify?board_reply_rno=${reply.board_reply_rno}">댓글 수정</a>
													<a href="/want_reply/want_delete?board_reply_rno=${reply.board_reply_rno}">댓글 삭제</a>
												</c:if>
											</p>
											<p>${reply.board_want_reply_content}</p>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 댓글 end -->
	
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
</body>
</html>