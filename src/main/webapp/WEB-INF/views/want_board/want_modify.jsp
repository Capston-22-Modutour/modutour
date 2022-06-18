<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>

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
	<form class="form" role="form" method="post" autocomplete="off">
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">
								<input type="text" size="50" name="board_want_title" value="${view.board_want_title}" />
							</h4>
						</div>
						<div class="bg-white border border-top-0 p-4 mb-3">
							<div class="mb-4">
								<input type="text" name="board_want_writer" value="${member.user_name}" hidden="hidden">
								<label>목적지</label> <br/> 
								<input type="text" style="color: black;" name="board_want_destination" class="m-0 text-uppercase font-weight-bold px-8" value="${view.board_want_destination}"> <br /> 
									
								<label>희망사항</label> <br/>
								<textarea cols="68" rows="5" name="board_want_content" class="m-0 text-uppercase font-weight-bold px-8" placeholder="${view.board_want_content}"></textarea>
								<br /> 
								
								<label>인원수</label> <br/> 
								<input type="number" style="color: black;" name="board_want_people" class="m-0 text-uppercase font-weight-bold px-8" value="${view.board_want_people}"> <br /> 
								
								<label>출발일</label> <br/>
								<input type="date" style="color: black;" name="board_want_start" class="m-0 text-uppercase font-weight-bold px-8" value="<fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" />">
								<br /> 
								
								<label>도착일</label> <br/>
								<input type="date" style="color: black;" name="board_want_end" class="m-0 text-uppercase font-weight-bold px-8" value="<fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" />">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-warning">수정하기</button> &nbsp; 
								<input type="button" class="btn btn-warning" value="취소" onclick="history.go(-1)">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- 게시글 내용 end -->
	
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