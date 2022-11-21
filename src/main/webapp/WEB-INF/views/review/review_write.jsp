<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 작성</title>
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
<style>
	/* .select_img img {
		margin: 20px 0;
	}
	 */
	 
	/* 다중 이미지 업로드 */
	.inputFile,
	#Preview,
	#Preview li{
	    float:left
	}
	.inputFile{
	    margin-bottom: 10px;
	}
	.addImgBtn{
	    width: 80px !important;
	    height: 80px !important;
	    line-height: 71px !important;
	    background-color: #fff !important;
	    color: #b7b7b7 !important;
	    border: 2px solid #b7b7b7;
	    font-size: 35px !important;
	    padding: 0 !important;
	}
	
	#Preview{
	    margin-left: 20px;
	    width: 650px;
	}
	#Preview li{
	    margin-left: 10px;
	    margin-bottom: 10px;
	    position: relative;
	    border: 1px solid #ececec;
	    cursor:move
	}
	.delBtn{
	    position: absolute;
	    top: 0;
	    right: 0;
	    font-size: 13px;
	    background-color: #000;
	    color: #fff;
	    width: 18px;
	    height: 18px;
	    line-height: 16px;
	    display: inline-block;
	    text-align: center;
	    cursor: pointer;
	}
</style>
<body>
	<%------------ header section  ------------%>
	<jsp:include page="../fix/header.jsp" />
	<c:if test="${member == null}">
		
		<div class="container-fluid mt-5 pt-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<div class="section-title mb-0">
							<div class="text-center">
								<h4 class="m-0 text-uppercase font-weight-bold">
									로그인이 필요한 서비스 입니다<br />
								</h4>
								<a href="/login/loginMain">로그인하러가기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<!-- 회원이 아닐 시 게시글 작성 불가 -->
	
	<c:if test="${member != null}">
		<form class="form" role="form" method="post" autocomplete="off" enctype="multipart/form-data">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									<input type="text" size="81" name="review_title" placeholder="제목" required="required">
								</h4>
							</div>
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="mb-4">
									<input type="text" name="review_writer" value="${member.user_name}" hidden="hidden">
									
									<!-- id='textarea'의 값을 받아 id='result'에 값 넘김 -->
									<textarea cols="117" rows="10" id="textarea" placeholder="내용을 입력해 주세요" required="required"></textarea>
									<textarea id="result" name="review_content" hidden></textarea>
									<br>
									
									파일 업로드 <br/>
									<!-- <input type="file" id="review_img" name="file" required="required"/> -->
									<div class="form-group">
										<input class="form-control form-control-user" type="file" multiple="multiple"
										name="product_detail_image" id="review_img" onchange="setDetailImage(event);" required>
									</div>
									<div id="select_img" style="margin-bottom: 30px;"><img src=""></div>
									
									<div class="text-center">
										<button type="submit" id="submit" class="btn btn-warning" onclick="getHtml();">작성</button> &nbsp;
										<input type="button" class="btn btn-warning" value="취소" onclick="history.go(-1)">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</c:if>
	
	<c:if test="${company != null}">
		<form method="post">
			<label>제목</label>
			<input type="text" name="review_title"> <br/>
				
			<label>작성자</label>
			<input type="text" name="review_writer" value="${company.com_name}" readonly="readonly"> <br/>
				
			<label>내용</label>
			<textarea cols="50" rows="5" name="review_content"></textarea> <br/>
				
			<button type="submit">작성</button>
		</form>
	</c:if>
	
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
</body>
<script>
	// 사용자가 선택한 이미지 보여줌
	$("#review_img").change(function(){
		if(this.files && this.files[0]) {
			var reader = new FileReader;
			reader.onload = function(data) {
				$(".select_img img").attr("src", data.target.result).width(500);        
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	// textarea 엔터키 <br>로 변환
	function getHtml(){
		var html = $("#textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); //id='textarea'에서 엔터키를 인식해 <br>태그로 변환
		$("#result").html(html); //id='result'에 <br>태그로 변환된 내용 저장
	}
	
</script>
<script>
	function setDetailImage(event){
		
		var maxFileCnt = 5; //최대 업로드 가능 파일수
		var file_cnt = event.target.files.length; //첨부된 파일수
		
		
		if(file_cnt > maxFileCnt) {
			alert("첨부파일은 최대 " + maxFileCnt + "개 까지 첨부 가능합니다.");
			
			return false;
		} else {
		
			for(var image of event.target.files){
				var reader = new FileReader();
				
				reader.onload = function(event){
					var img = document.createElement("img");
					img.setAttribute("src", event.target.result);
					img.setAttribute("class", "col-lg-3");
					document.querySelector("div#select_img").appendChild(img);
				};
				
				console.log(image);
				reader.readAsDataURL(image);
				
			}
		}
	}
</script>
</html>