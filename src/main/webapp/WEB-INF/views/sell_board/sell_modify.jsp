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
								<input type="text" size="50" name="sell_title" value="${view.sell_title}" />
							</h4>
						</div>
						<div class="bg-white border border-top-0 p-4 mb-3">
							<div class="mb-4">
								<input type="text" name="sell_writer" value="${view.sell_writer}" hidden="hidden"> <br /> 
								<label>요청자</label> <br/> 
								<label style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.board_want_writer}</label> <br/><br/>
							
								<input type="text" name="sell_destination" value="${view.sell_destination}" hidden="hidden">
								<label>목적지</label> <br/> 
								<label style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_destination}</label> <br/><br/>
								
								<input type="text" name="sell_content" value="${view.sell_content}" hidden="hidden">
								<label>희망사항</label> <br/>
								<label style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_content}</label> <br/><br/>
								
								<input type="text" name="sell_people" value="${view.sell_people}" hidden="hidden">
								<label>인원수</label> <br/> 
								<label style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">${view.sell_people}</label> <br/><br/>
								
								<label>출발일</label> <br/>
								<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
									<fmt:formatDate value="${view.sell_start}" pattern="yyyy-MM-dd" />
								</p>
								<input type="date" name="sell_start" value="<fmt:formatDate value="${view.sell_start}" pattern="yyyy-MM-dd" />" hidden="hidden">
								<br /> 
								
								<label>도착일</label> <br/>
								<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
									<fmt:formatDate value="${view.sell_end}" pattern="yyyy-MM-dd" />
								</p>
								<input type="date" name="sell_end" value="<fmt:formatDate value="${view.sell_end}" pattern="yyyy-MM-dd" />" hidden="hidden">
								<br/>
								
								<label>비용</label> <br/>
								<input type="text" name="sell_price" style="color: black;" class="m-0 text-uppercase font-weight-bold px-8" value="${view.sell_price}"> <br/><br/>
								
								<label>가이드 포함 여부</label> <br/> 
								<select name="sell_guide" style="color: black;" class="m-0 text-uppercase font-weight-bold px-8" value="${view.sell_guide}">
									<option>O</option>
									<option>X</option>
								</select> <br />
								<br/>
								
								<label>항공사</label> <br /> 
								<select name="sell_air" style="color: black;" class="m-0 text-uppercase font-weight-bold px-8" value="">
									<option>대한항공</option>
									<option>아시아나항공</option>
									<option>에어부산</option>
									<option>티웨이</option>
								</select> <br /> <br />

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