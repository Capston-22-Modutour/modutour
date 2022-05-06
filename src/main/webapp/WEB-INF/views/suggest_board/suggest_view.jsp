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
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	
	<!-- 게시글 내용 Start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
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
						<c:if test="${member.company_name == view.suggest_writer}">
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
							
							<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
							<div class="text-center">
								<c:if test="${member.user_id != null and member.user_id != dto.user_id}">
									<div style="margin-right: 1px;">
										<button type="button" class="btn btn-warning" id="like_btn" onclick="want_updateLike(); return false;">추천 ${view.board_want_like}</button>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 게시글 내용 end -->
	
	<!-- 댓글 start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
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
												<textarea rows="5" cols="74" name="board_want_reply_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
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
												<textarea rows="5" cols="74" name="board_want_reply_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
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
<script>
var board_want_bno = ${view.board_want_bno};
var user_num = ${member.user_num};

 function want_updateLike(){ 
     $.ajax({
            type : "POST",  
            url : "/want_board/want_updateLike",       
            dataType : "json",   
            data : {'board_want_bno' : board_want_bno, 'user_num' : user_num},
            error : function(){
               alert("통신 에러");
            },
            success : function(want_likeCheck) {
                
                    if(want_likeCheck == 0){
                    	alert("추천완료.");
                    	location.reload();
                    }
                    else if (want_likeCheck == 1){
                     alert("추천취소");
                    	location.reload();
                }
            }
        });
 }
</script>