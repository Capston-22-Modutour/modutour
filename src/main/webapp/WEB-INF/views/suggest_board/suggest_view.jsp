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
	
	.modal{ 
        position:fixed; 
        width:100%; height:100%; 
        background: rgba(0,0,0,0.2); 
        top:0; 
        left:0; 
        display:none;
    }

    .modal_content{
        background:#fff;
        position: fixed; 
        top:50%; 
        left:50%;
        transform : translate(-50%, -50%);
        text-align:center;
        box-sizing:border-box; 
        line-height:23px;
        border-style: solid;
        border-radius: 10px;
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
				<form class="form" role="form" method="post" autocomplete="off" action="/sell_board/sell_write">
					<div class="section-title mb-0">
						<h4 class="m-0 text-uppercase font-weight-bold">${view.suggest_title}</h4>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
							<fmt:formatDate value="${view.suggest_regDate}" pattern="yyyy-MM-dd" />
						</p>
					</div>
					<div class="section-title mb-1">
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">${view.suggest_writer}</p>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">조회수 ${view.suggest_viewCnt}</p>
						
						<!-- 유저 이름과 게시글 작성자가 일치해야 게시글 수정, 삭제 가능 
							  하지만 동명이인 일시? 추후 id로 개선 필요함
						-->
						<c:if test="${company.com_name == view.suggest_writer}">
							<div>
								<a href="/suggest_board/suggest_modify?suggest_bno=${view.suggest_bno}">게시글 수정</a>
								<a href="/suggest_board/suggest_delete?suggest_bno=${view.suggest_bno}">게시글 삭제</a>
							</div>
						</c:if>
					</div>
					<div class="bg-white border border-top-0 p-4 mb-3">
						<div class="mb-4">
							<label>요청자</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.board_want_writer}</p>
							<br/>
							
							<label>목적지</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.board_want_destination}</p>
							<br/>
							
							<label>희망사항</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.board_want_content}</p>
							<br/>
							
							<label>제안사항</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.suggest_content}</p>
							<br/>
							
							<label>인원수</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.board_want_people}</p>
							<br/>
							
							<label>출발일</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
								<fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" />
							</p>
							<br/>
							
							<label>도착일</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
								<fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" />
							</p> <br/>
							
							<label>비용</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.suggest_price}원</p>
							<br/>
							
							<label>가이드 포함 여부</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.suggest_guide}</p>
							<br/>
							
							<label>항공사</label>
							<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.suggest_air}</p>
							<br/>
							
							<img src="${view.suggest_img}"  width="500px" height="500px" />
							
							<%-- 구매 모달창 --%>
							<div class="modal">
								<div class="modal_content card" style="width:20rem; height:16rem;">
							    	<div class="card-body">
							            <h5>결제</h5>
							            <h6>안내사항</h6>
							            <p style="color: black;">낙찰 후 취소는<strong>불가능</strong>합니다.</p>
							            <p style="color: black;">정말 낙찰하시겠습니까?</p>
							            <button type="submit" id="suggestOK" class="btn btn-warning">예</button>
							            <button type="button" class="btn btn-delete" onclick="closeSuggestModal()">아니오</button>
							        </div>
							    </div>
							 </div>
							
							<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
							<div class="text-center">
								<c:if test="${member.user_name == view.board_want_writer}">
									
									<!-- SuggestBoardController에서 전송한 model, bid 값을 바탕으로 낙찰여부 확인 => 중복 낙찰 방지 -->
									<!-- bid == 0, sell_board에 중복되는 board_want_bno가 없으므로 낙찰 가능 -->
									<c:if test="${bid == 0}">
										<button type="button" onclick="openSuggestModal()" class="btn btn-warning">낙찰하기</button>
									</c:if>
									<!-- bid == 1, sell_board에 중복되는 board_want_bno가 있으므로 낙찰 불가능!!! -->
									<!-- 중복 낙찰 방지 위해 버튼 비활성화 -->
									<c:if test="${bid == 1}">
										<button type="button" class="btn btn-delete" disabled="disabled">낙찰이 종료되었습니다</button>
									</c:if>
								</c:if>
							</div>
							
							<input type="text" name="suggest_bno" value="${view.suggest_bno}" hidden="hidden">
							<input type="text" name="board_want_bno" value="${view.board_want_bno}" hidden="hidden">
							<input type="text" name="com_regiNum" value="${view.com_regiNum}" hidden="hidden">
							<input type="text" name="sell_writer" value="${view.suggest_writer}" hidden="hidden">
							<input type="text" name="sell_title" value="${view.suggest_title}" hidden="hidden">
							<input type="text" name="sell_destination" value="${view.board_want_destination}" hidden="hidden">
							<input type="text" name="sell_content" value="${view.suggest_content}" hidden="hidden">
							<input type="text" name="sell_start" value="<fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" />" hidden="hidden">
							<input type="text" name="sell_end" value="<fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" />" hidden="hidden">
							<input type="text" name="sell_price" value="${view.suggest_price}" hidden="hidden">
							<input type="text" name="sell_people" value="${view.board_want_people}" hidden="hidden">
							<input type="text" name="sell_guide" value="${view.suggest_guide}" hidden="hidden">
							<input type="text" name="sell_air" value="${view.suggest_air}" hidden="hidden">
							<input type="text" name="sell_img" value="${view.suggest_img}" hidden="hidden">
							<input type="text" name="sell_thumbnail" value="${view.suggest_thumbnail}" hidden="hidden">
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
							<form method="post" action="/suggest_reply/suggest_write">
								<!-- 회원이 아닐 시 댓글 작성 불가 -->
								<c:if test="${member == null && company == null}">
									<p>로그인이 필요한 서비스 입니다</p>
								</c:if>

								<c:choose>
									<c:when test="${member != null || company != null}">
										<c:if test="${member != null}">
											<!-- 일반 회원 댓글 -->
											<p>
												<input type="text" name="suggest_writer" value="${member.user_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="suggest_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="suggest_bno" value="${view.suggest_bno}">
												<button type="submit" class="btn btn-warning">댓글 작성</button>
											</p>
										</c:if>
										
										<!-- 기업 회원 댓글 -->
										<c:if test="${company != null}">
											<p>
												<input type="text" name="suggest_writer" value="${company.com_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="suggest_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="suggest_bno" value="${view.suggest_bno}">
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
											<p>${reply.suggest_writer} / ${reply.suggest_rno}
												/
												<fmt:formatDate value="${reply.suggest_regDate}" pattern="yyyy-MM-dd" />
												<c:if test="${member.user_name == reply.suggest_writer}">
													<a href="/suggest_reply/suggest_modify?suggest_rno=${reply.suggest_rno}">댓글 수정</a>
													<a href="/suggest_reply/suggest_delete?suggest_rno=${reply.suggest_rno}">댓글 삭제</a>
												</c:if>
												
												<c:if test="${company.com_name == reply.suggest_writer}">
													<a href="/suggest_reply/suggest_modify?suggest_rno=${reply.suggest_rno}">댓글 수정</a>
													<a href="/suggest_reply/suggest_delete?suggest_rno=${reply.suggest_rno}">댓글 삭제</a>
												</c:if>
											</p>
											<p>${reply.suggest_content}</p>
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
    
    <script>
 		var board_want_bno = ${view.board_want_bno};
 		var suggest_bno = ${view.suggest_bno};
 		
 		// 낙찰 모달창 열기
 		function openSuggestModal() {
 			$(".modal").fadeIn();
 		}
 		
 		// 낙찰 모달창 닫기
 		function closeSuggestModal() {
 			$(".modal").fadeOut();
 		}
 		
 		// 외부영역 클릭 시 팝업 닫기
 		$(function(){ 
 					$(document).mouseup(function (e){
 					var modal_content = $(".modal_content");
 					if(modal_content.has(e.target).length === 0){
 					closeSuggestModal();
 				}
 			});
 		});
 		
    </script>
</body>
</html>