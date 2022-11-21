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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link rel="stylesheet" href="<c:url value='../resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

    <!-- Customized Bootstrap Stylesheet -->
    <link rel="stylesheet" href="<c:url value='../resources/css/style.css'/>">

	<!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    
</head>
<style>
	.number-size {
		width: 70px;
	}
	
	[contenteditable] {
  border: solid 1px lightgreen;
  padding: 5px;
  border-radius: 3px;
}

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
	
	<!-- 게시글 내용 Start -->
	<div class="container-fluid mt-5 pt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="section-title mb-0">
						<h4 class="m-0 text-uppercase font-weight-bold">${view.board_want_title}</h4>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-8">
							<fmt:formatDate value="${view.board_want_regDate}" pattern="yyyy-MM-dd" />
						</p>
					</div>
					<div class="section-title mb-1">
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">${view.board_want_writer}</p>
						<p style="color: black;" class="m-0 text-uppercase font-weight-bold px-0">조회수 ${view.board_want_viewCnt}</p>
						
						<!-- 유저 이름과 게시글 작성자가 일치해야 게시글 수정, 삭제 가능 
							  하지만 동명이인 일시? 추후 id로 개선 필요함
						-->
						<c:if test="${member.user_name == view.board_want_writer}">
							<div>
								<a href="/want_board/want_modify?board_want_bno=${view.board_want_bno}">게시글 수정</a>
								<a href="/want_board/want_delete?board_want_bno=${view.board_want_bno}">게시글 삭제</a>
							</div>
						</c:if>
					</div>
					<div class="bg-white border border-top-0 p-4 mb-3">
					
						<div class="container">
							<div class="row">
						
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">목적지</h5>
								</div>
								<div class="col-lg-9" style="display: inline;">
									<p style="font-size: 20px; color: black; display: inline;">${view.board_want_destination}</p>
								</div>
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">희망사항</h5>
								</div>
								<div class="col-lg-9" style="display: inline;">
									<p style="font-size: 20px; color: black; display: inline;">${view.board_want_content}</p>
								</div>
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">인원수</h5>
								</div>
								<div class="col-lg-9" style="display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.board_want_people} 명</p>
								</div>
								<div class="col-lg-6" style="text-align: center; border-right: 1px solid gray; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold">출발일</h5> 
									<p style="font-size: 20px; color: black; display: inline;"><fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" /></p>
								</div>
								<div class="col-lg-6" style="text-align: center;">
									<h5 class="m-0 text-uppercase font-weight-bold">도착일</h5>
									<p style="font-size: 20px; color: black;"><fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" /></p>
								</div>
								
							</div>
						</div>
						
						<div class="container">
								<div class="row" style="text-align: center; margin-bottom: 30px;">
									<c:forEach var="list" items="${list}">
										<div class="col-lg-6 bigPicture" style="margin-bottom: 30px;">
											<img src="${list.img}" width="200px" height="200px" onerror="this.remove ? this.remove() : this.removeNode();"/>
										</div>
									</c:forEach>
								</div>
							</div>
						
						<%-- <div style="margin-bottom: 30px;">
							<c:if test="${view.board_want_img != null}">
								<img src="${view.board_want_img}" width="500px" height="500px"/> <br><br>
								첨부파일 : <a href="/fileDownload.do?file_name=${view.board_want_img}">${view.board_want_img}</a>
							</c:if>
						</div> --%>
						
						<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
						<div class="text-center">
							<c:if test="${member.user_id != null and member.user_name != dto.user_name}">
								<div style="margin-right: 1px;">
									<button type="button" class="btn btn-warning" id="like_btn" onclick="want_updateLike(); return false;">추천 ${view.board_want_like}</button>
								</div>
							</c:if>
							
							<c:if test="${company != null}">
								<div style="margin-right: 1px;">
									<button type="button" class="btn btn-warning" id="like_btn" onclick="want_updateLike(); return false;">추천 ${view.board_want_like}</button>
								</div>
							</c:if>
						</div>
							
					</div>
				</div>
				
				<c:if test="${company != null}">
				<!-- 여행사 제안 start -->
				<div class="col-lg-6">
					<div class="mb-3">
						<div class="section-title mb-0">
							<h4 class="m-0 text-uppercase font-weight-bold">제안합니다</h4>
						</div>
						<div class="bg-white border border-top-0 p-3">
							<form class="form" role="form" method="post" autocomplete="off" action="/suggest_board/suggest_write" enctype="multipart/form-data">
								<h4 class="m-0 text-uppercase font-weight-bold">
									<input type="text" size="35" name="suggest_title" placeholder="제목을 입력해 주세요" required="required"/>
								</h4>
								<br/>
								<!-- 게시글 내용 Start -->
								<div class="container">
									<div class="row">
										<input type="text" name="board_want_bno" value="${view.board_want_bno}" hidden="hidden">
										<input type="text" name="board_want_writer"	value="${view.board_want_writer}" hidden="hidden"> 
										<input type="text" name="com_regiNum" value="${company.com_regiNum}" hidden="hidden">
										<input type="text" name="suggest_writer" value="${company.com_name}" hidden="hidden">
										<input type="text" name="board_want_content" value="${view.board_want_content}" hidden="hidden">
										<input type="text" value="${view.board_want_destination}" name="board_want_destination" hidden="hidden">
										<input type="date" name="board_want_start" value="<fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" />"hidden="hidden">
										<input type="date" name="board_want_end" value="<fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" />"hidden="hidden">
												
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">목적지</h5>
										</div>
										<div class="col-lg-9" style="display: inline;">
											<p style="font-size: 20px; color: black; display: inline;">${view.board_want_destination}</p>
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">희망사항</h5>
										</div>
										<div class="col-lg-9" style="display: inline;">
											<p style="font-size: 20px; color: black; display: inline;">${view.board_want_content}</p>
										</div>
										<div class="col-lg-3" style="bottom: 50%; display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">제안사항</h5>
										</div>
										<div class="col-lg-9" style="display: inline; margin-bottom: 30px;">
										<!-- id='textarea'의 값을 받아 id='result'에 값 넘김 -->
										<textarea cols="25" rows="2" id="textarea" style="font-size: 20px; color: black; display: inline;" required="required"></textarea>
										<textarea id="result" name="suggest_content" hidden></textarea>
										<br>
											
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">인원수</h5>
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px; border-right: 1px solid gray;">
											<input type="number" name="board_want_people" class="number-size" style="font-size: 20px; color: black; display: inline;" min="1" required="required"><p style="display: inline; color: black;"> 명</p>
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">최소 출발</h5>
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<input type="number" name="min_people" class="number-size" style="font-size: 20px; color: black; display: inline;" required="required"><p style="display: inline; color: black;"> 명</p>
										</div>
										<div class="col-lg-6" style="text-align: center; border-right: 1px solid gray; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold">출발일</h5> 
											<p style="font-size: 20px; color: black; display: inline;"><fmt:formatDate value="${view.board_want_start}" pattern="yyyy-MM-dd" /></p>
										</div>
										<div class="col-lg-6" style="text-align: center;">
											<h5 class="m-0 text-uppercase font-weight-bold">도착일</h5>
											<p style="font-size: 20px; color: black;"><fmt:formatDate value="${view.board_want_end}" pattern="yyyy-MM-dd" /></p>
										</div>
												
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">가격</h5>
										</div>
										<div class="col-lg-9" style="display: inline;">
											<input type="number" name="suggest_price" style="font-size: 20px; color: black; display: inline;" required="required">
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">가이드 포함 여부</h5>
										</div>
										<div class="col-lg-9" style="display: inline;">
											<select name="suggest_guide" style="font-size: 20px; color: black; display: inline;">
												<option>O</option>
												<option>X</option>
											</select>
										</div>
										<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">항공사</h5>
										</div>
										<div class="col-lg-9" style="display: inline;">
											<select name="suggest_air" id="air" style="font-size: 20px; color: black; display: inline;">
												<option>대한항공</option>
												<option>아시아나항공</option>
												<option>에어부산</option>
												<option>티웨이</option>
											</select>
										</div>
										
										
										<div class="col-lg-12" style="margin-bottom: 10px;">
											<!-- tab title 생성 버튼 -->
											<p>
												<button id="btn-add-tab" type="button" class="btn btn-primary pull-right">탭 추가</button> 탭은 최대 6개 까지 생성가능합니다
											</p>
											<!-- tab title box -->
											<ul id="tab-list" class="nav nav-tabs" role="tablist">
												<li class="active"><a href="#tab1" role="tab" data-toggle="tab"> 
													<!-- <span>Tab 1 </span> <span class="fa fa-pencil fa-fw text-muted edit"></span> --> 
													<input type="text" class="text-size" name="tab_title_1" size="10" id="tab" placeholder="tab1">
												</a></li>
											</ul>
										</div>
										
										<div class="col-lg-12" style="margin-bottom: 30px;">
											<!-- tab content -->
											<div id="tab-content" class="tab-content">
												<!-- <div class="tab-pane fade in active" id="tab1">Tab 1 content</div> -->
												<div class="tab-pane fade in active" id="tab1">
													<!-- id='tab-textarea1'의 값을 받아 id='tab-result1'에 값 넘김 -->
													<textarea id="tab1-textarea" rows="10" cols="54" placeholder="tab1 내용을 입력해주세요"></textarea>
													<textarea id="tab1-result" name="tab_content_1" hidden></textarea>
													<br>
												</div>
											</div>
										</div>
										
										<div class="col-lg-12" style="margin-bottom: 30px; border-bottom: 1px solid rgb(132, 216, 255);">
											<h5 class="m-0 text-uppercase font-weight-bold" style="display: inline;">파일 업로드</h5> <br>
											<!-- <input type="file" id="file_img" name="file" required="required"/> -->
														
											<div class="form-group">
												<input class="form-control form-control-user" type="file" multiple="multiple"
												name="product_detail_image" id="review_img" onchange="setDetailImage(event);" required>
											</div>
											
											<div id="select_img" style="margin-bottom: 30px;"><img src=""></div>
											
										</div>
										<div class="col-lg-12">
											<div class="text-center">
												<button type="submit" class="btn btn-warning" onclick="getHtml();">응찰하기</button>
											</div>
										</div>
									</div>
								</div>
						</form>
					<!-- 게시글 내용 end -->
					</div>
					</div>
				</div>
				<!-- 여행사 제안 end -->
				</c:if>
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
<script>
//사용자가 선택한 이미지 보여줌
/* $("#file_img").change(function(){
	if(this.files && this.files[0]) {
		var reader = new FileReader;
		reader.onload = function(data) {
			$(".select_img img").attr("src", data.target.result).width(500);        
		}
		reader.readAsDataURL(this.files[0]);
	}
}); */

</script>

<!-- tab 관련 스크립트 tab 최대 생성수 6개 까지 -->	
<script>
var button = '<button class="close" type="button" title="Remove this page">×</button>';
var tabID = 1;
var i = $('#tab').length;

function resetTab() {
	var tabs = $("#tab-list li:not(:first)");
	var len = 1
	$(tabs).each(function(k, v) {
		len++;
		$(this).find('a').html('Tab ' + len + button);
	})
	tabID--;
}

$(document).ready(function() {
		$('#btn-add-tab').click(function() {
			++tabID;
			i++;
			/* $('#tab-list').append($('<li><a href="#tab' + tabID + '" role="tab" data-toggle="tab"><span>Tab ' + tabID + '</span> <span class="fa fa-pencil fa-fw text-muted edit"></span> <button class="close" type="button" title="Remove this page">×</button></a></li>')); */
			$('#tab-list').append($('<li><a href="#tab' + tabID + '" role="tab" data-toggle="tab"><input type="text" name="tab_title_'+tabID+'" size="10" id="tab" placeholder="tab'+tabID+'"> <button class="close" type="button" title="Remove this page">×</button></a></li>'));
				
			/* $('#tab-content').append($('<div class="tab-pane fade" id="tab' + tabID + '">Tab ' + tabID + ' content</div>')); */
			//$('#tab-content').append($('<div class="tab-pane fade" id="tab' + tabID + '"> ' + ' <textarea rows="10" cols="54" name="tab_content_'+tabID+'" placeholder="tab'+tabID+' 내용을 입력해주세요"></textarea></div>'));
			$('#tab-content').append($('<div class="tab-pane fade" id="tab' + tabID + '"> ' + ' <textarea id="tab' + tabID + '-textarea" rows="10" cols="54" placeholder="tab'+tabID+' 내용을 입력해주세요"></textarea></div>'));
			$('#tab-content').append($('<textarea id="tab' + tabID + '-result" name="tab_content_'+tabID+'" hidden></textarea>'));
			$(".edit").click(editHandler);
				
			if(i > 5) {
				alert("tab은 6개 까지만 생성 가능합니다.");
				$('#btn-add-tab').attr("disabled",true);
			} else if (i <= 5){
				$('#btn-add-tab').removeAttr("disabled");
			}
		});
			
		$('#tab-list').on('click', '.close', function() {
			i--;
			var tabID = $(this).parents('a').attr('href');
			$(this).parents('li').remove();
			$(tabID).remove();

			if(i > 5) {
				alert("tab은 6개 까지만 생성 가능합니다.");
				$('#btn-add-tab').attr("disabled",true);
			} else if (i <= 5){
				$('#btn-add-tab').removeAttr("disabled");
			}
		});
			
			

		var list = document.getElementById("tab-list");
	});

var editHandler = function() {
	var t = $(this);
	t.css("visibility", "hidden");
	$(this).prev().attr("contenteditable", "true").focusout(function() {
		$(this).removeAttr("contenteditable").off("focusout");
		t.css("visibility", "visible");
	});
};

$(".edit").click(editHandler);

//textarea 엔터키 <br>로 변환
function getHtml(){
	var html = $("#textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); //id='textarea'에서 엔터키를 인식해 <br>태그로 변환
	var html_tab1 = $("#tab1-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	var html_tab2 = $("#tab2-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	var html_tab3 = $("#tab3-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	var html_tab4 = $("#tab4-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	var html_tab5 = $("#tab5-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	var html_tab6 = $("#tab6-textarea").val().replace(/(?:\r\n|\r|\n)/g, '<br />'); 
	$("#result").html(html); //id='result'에 <br>태그로 변환된 내용 저장
	$("#tab1-result").html(html_tab1);
	$("#tab2-result").html(html_tab2);
	$("#tab3-result").html(html_tab3);
	$("#tab4-result").html(html_tab4);
	$("#tab5-result").html(html_tab4);
	$("#tab6-result").html(html_tab6);
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