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
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<style>
	/* .select_img img {
		margin: 20px 0;
	} */
	
	table {
	    margin-left:auto; 
	    margin-right:auto;
	}
	
	/* datepicker CSS */
	.ui-widget-header { border: 0px solid #dddddd; background: #fff; } 

	.ui-datepicker-calendar>thead>tr>th { font-size: 14px !important; } 
	
	.ui-datepicker .ui-datepicker-header { position: relative; padding: 10px 0; } 
	
	.ui-state-default,
	.ui-widget-content .ui-state-default,
	.ui-widget-header .ui-state-default,
	.ui-button,
	html .ui-button.ui-state-disabled:hover,
	html .ui-button.ui-state-disabled:active { border: 0px solid #c5c5c5; background-color: transparent; font-weight: normal; color: #454545; text-align: center; } 
	
	.ui-datepicker .ui-datepicker-title { margin: 0 0em; line-height: 16px; text-align: center; font-size: 14px; padding: 0px; font-weight: bold; } 
	.ui-datepicker { display: none; background-color: #fff; border-radius: 4px; margin-top: 10px; margin-left: 0px; margin-right: 0px; padding: 20px; padding-bottom: 10px; width: 300px; box-shadow: 10px 10px 40px rgba(0, 0, 0, 0.1); } 
	.ui-widget.ui-widget-content { border: 1px solid #eee; } 
	#datepicker:focus>.ui-datepicker { display: block; } 
	.ui-datepicker-prev,
	.ui-datepicker-next { cursor: pointer; } 
	.ui-datepicker-next { float: right; } 
	.ui-state-disabled { cursor: auto; color: hsla(0, 0%, 80%, 1); } 
	.ui-datepicker-title { text-align: center; padding: 10px; font-weight: 100; font-size: 20px; } 
	.ui-datepicker-calendar { width: 100%; } 
	.ui-datepicker-calendar>thead>tr>th { padding: 5px; font-size: 20px; font-weight: 400; } 
	.ui-datepicker-calendar>tbody>tr>td>a { color: #000; font-size: 12px !important; font-weight: bold !important; text-decoration: none;}
	.ui-datepicker-calendar>tbody>tr>.ui-state-disabled:hover { cursor: auto; background-color: #fff; } 
	.ui-datepicker-calendar>tbody>tr>td { border-radius: 100%; width: 44px; height: 30px; cursor: pointer; padding: 5px; font-weight: 100; text-align: center; font-size: 12px; } 
	.ui-datepicker-calendar>tbody>tr>td:hover { background-color: transparent; opacity: 0.6; } 
	
	.ui-state-hover,
	.ui-widget-content .ui-state-hover,
	.ui-widget-header .ui-state-hover,
	.ui-state-focus,
	.ui-widget-content .ui-state-focus,
	.ui-widget-header .ui-state-focus,
	.ui-button:hover,
	.ui-button:focus { border: 0px solid #cccccc; background-color: transparent; font-weight: normal; color: #2b2b2b; } 
	.ui-widget-header .ui-icon { background-image: url('./btns.png'); } 
	.ui-icon-circle-triangle-e { background-position: -20px 0px; background-size: 36px; } 
	.ui-icon-circle-triangle-w { background-position: -0px -0px; background-size: 36px; } 
	
	.ui-datepicker-calendar>tbody>tr>td:first-child a { color: red !important; } 
	.ui-datepicker-calendar>tbody>tr>td:last-child a { color: #0099ff !important; } 
	.ui-datepicker-calendar>thead>tr>th:first-child { color: red !important; } 
	.ui-datepicker-calendar>thead>tr>th:last-child { color: #0099ff !important; } 
	.ui-state-highlight,
	.ui-widget-content .ui-state-highlight,
	.ui-widget-header .ui-state-highlight { border: 0px; background: #f1f1f1; border-radius: 50%; padding-top: 10px; padding-bottom: 10px; } 
	
	.inp { padding: 10px 10px; background-color: #f1f1f1; border-radius: 4px; border: 0px; } 
	.inp:focus { outline: none; background-color: #eee; } 
	
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
	
	<%-- <c:if test="${company != null}">
		<p>일반 회원만 작성이 가능합니다</p>
	</c:if> --%>
	
	<!-- 회원이 아닐 시 게시글 작성 불가 -->
	<c:choose>
		<c:when test="${member == null}">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									일반 회원만 작성이 가능합니다
								</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		
		<c:when test="${company != null}">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-8">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									일반 회원만 작성이 가능합니다
								</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>
	
	<c:if test="${member != null}">
		<!-- 게시글 내용 Start -->
		<form class="form" role="form" method="post" autocomplete="off" enctype="multipart/form-data">
			<div class="container-fluid mt-5 pt-3">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="section-title mb-0">
								<h4 class="m-0 text-uppercase font-weight-bold">
									<input type="text" size="50" name="board_want_title" placeholder="제목을 입력해 주세요" required="required"/>
								</h4>
							</div>
							<div class="bg-white border border-top-0 p-4 mb-3">
								<div class="mb-4">
									<input type="text" name="board_want_writer" value="${member.user_name}" hidden="hidden">
										
										<div class="container">
							<div class="row" style="text-align: center;">
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">목적지</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<input type="text" style="font-size: 20px; color: black; display: inline;" name="board_want_destination" placeholder="목적지를 입력해 주세요" required="required">
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">희망사항</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<!-- id='textarea'의 값을 받아 id='result'에 값 넘김 -->
									<textarea cols="60" rows="5" id="textarea" style="font-size: 20px; color: black; display: inline;"></textarea>
									<textarea id="result" name="board_want_content" hidden></textarea>
									<br>
								</div>
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px; border-right: 1px solid gray;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">인원수</h5>
								</div>
								<div class="col-lg-9" style="display: inline; margin-bottom: 30px; text-align: left;">
									<input type="number" style="font-size: 20px; color: black; display: inline;" name="board_want_people" class="number-size" style="font-size: 20px; color: black; display: inline;" min="1" required="required"><p style="display: inline; color: black;"> 명
								</div>
								<div class="col-lg-6" style="border-right: 1px solid gray; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold">출발일</h5> <br/>
									<input type="text" style="font-size: 20px; color: black; display: inline;" name="board_want_start" id="datepicker" required="required">
								</div>
								<div class="col-lg-6" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold">도착일</h5> <br/>
									<input type="text" style="font-size: 20px; color: black; display: inline;" name="board_want_end" id="datepicker2" required="required">
								</div>
								
								<div class="col-lg-3" style="margin-bottom: 30px; border-bottom: 1px solid rgb(132, 216, 255);">
									<h5 class="m-0 text-uppercase font-weight-bold">파일 업로드</h5>
								</div>	
								<div class="col-lg-9" style="display: inline; margin-bottom: 30px;">
									<div class="form-group">
										<input class="form-control form-control-user" type="file" multiple="multiple"
										name="product_detail_image" id="review_img" onchange="setDetailImage(event);" required>
									</div>
									<!-- <input type="file" id="board_want_img" name="file" required="required"/> -->
								</div>
								<div class="col-lg-12">
									<div id="select_img" style="margin-bottom: 30px;"><img src=""></div>
								</div>
							</div>
						</div>
						
								    <!-- datepicker script -->
								    <script>
										// 이전 날짜들은 선택막기
										function noBefore(date){
										    if (date < new Date())
										        return [false];
										    return [true];
										}
								    
								        // 1) datepicker 공통 옵션 설정
								        $.datepicker.setDefaults({
								            dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
								            dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
								            monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
								            monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
								            yearSuffix: '년',
								            dateFormat: 'yy-mm-dd',
								            today: "오늘",
								            clear: "닫기",
								            autoclose: true,
								            calendarWeeks : true,
								            clearBtn: true,
								            showMonthAfterYear:true,
								            constrainInput: true    
								        });
								
								        // 2) datepicker 영역 선언
								        $("#datepicker").datepicker({beforeShowDay: initDate('tdoay')});
								        $("#datepicker2").datepicker({beforeShowDay: noBefore});
								
								        
								        function initDate(){
								        	  $('#datepicker').datepicker('option', 'minDate','0');//오늘이후 선택가능
								        	  $('#datepicker2').datepicker('option', 'minDate','0');//오늘이후 선택가능
								        	  $('#datepicker').datepicker("option", "onClose", function (selectedDate) {
								        	    var date = new Date(selectedDate);  
								        	    date.setDate(date.getDate() + 1);
								        	    var a = 0;
								        	    var nextDate = date.toLocaleString().replace(/ /gi, '').split('.').map(item =>{if(a < 3){ a++; return item} }).filter(Boolean).join('.');
								        	   $("#datepicker2").datepicker( "option", "minDate", nextDate );
								        	  });
								        	  $('#datepicker2').datepicker("option", "onClose", function ( selectedDate ) {
								        	    $("#datepicker").datepicker( "option", "maxDate", selectedDate );
								        	  });
								        	}
								        
								        // 3) 초기값 설정
								        // (today / -nD: n일전 / +nD: n일후 / -nM: n달전 / +nM: n달후 / -nY: n년전 / +nY: n년후)
								        $("#datepicker").datepicker('setDate', initDate('today'));
								        $("#datepicker2").datepicker('setDate', initDate('+1D'));
								
								    </script>
								</div>
								
								
		
								<div class="text-center">
									<button type="submit" class="btn btn-warning" onclick="getHtml();">작성하기</button> &nbsp; 
									<input type="button" class="btn btn-warning" value="취소" onclick="history.go(-1)">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- 게시글 내용 end -->
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