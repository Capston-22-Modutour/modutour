<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행후기 게시판</title>

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
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	<br/>

	<!-- 여행후기 Start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title mb-0">
						<h4 class="m-0 text-uppercase font-weight-bold">여행후기</h4>
						<button type="button" class="btn btn-primary font-weight-semi-bold px-4" onclick="location.href='/review/review_write'">글 작성</button>
					</div>
						<div class="mb-4">
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
									<c:forEach items="${list}" var="list">
										<tr class="active-row">
											<td>${list.review_bno}</td>
											<td><img src="${list.board_thumbnail}" width="100px" height="100px"></td>
											<td><a href="/review/review_view?review_bno=${list.review_bno}">${list.review_title}</a></td>
											<td><fmt:formatDate value="${list.review_regDate}" pattern="yyyy-MM-dd"/></td>
											<td>${list.review_writer}</td>
											<td>${list.review_like}</td>
											<td>${list.review_viewCnt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<p class="mb-4" style="text-align: center; word-spacing: 5px;">
								<c:if test="${page.prev}">
									<span>[ <a
										href="/review/review_listPageSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">이전</a>]
									</span>
								</c:if>

								<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}"
									var="num">
									<span> <c:if test="${select != num}">
											<a
												href="/review/review_listPageSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
										</c:if> <c:if test="${select == num}">
											<b>${num}</b>
										</c:if>
									</span>
								</c:forEach>

								<c:if test="${page.next}">
									<span>[ <a
										href="/review/review_listPageSearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}">이전</a>]
									</span>
								</c:if>
							</p>
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="d-flex align-items-center mb-2" style="display: flex; justify-content: center;">
									<select name="searchType">
										<!--  jstl에서는 .equals(); 대신 eq 로 짧게 사용 -->
										<option value="title"
											<c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
										<option value="content"
											<c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
										<option value="title_content"
											<c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
										<option value="writer"
											<c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
									</select> &nbsp;&nbsp;
									<input type="text" size="50px" name="keyword" value="${page.keyword}" /> &nbsp;&nbsp;
									<button type="button" class="btn btn-primary font-weight-semi-bold px-4" id="searchBtn">검색</button>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 여행후기 End -->

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
	
	<script>
		document.getElementById("searchBtn").onclick = function() {
			
			let searchType = document.getElementsByName("searchType")[0].value;
			let keyword = document.getElementsByName("keyword")[0].value;
			
			/*
				location.href 해당 URL로 이동
				searchType 선택한 검색타입
				keyword 검색어
			*/
			location.href = "/review/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
		};
	</script>
</body>
</html>