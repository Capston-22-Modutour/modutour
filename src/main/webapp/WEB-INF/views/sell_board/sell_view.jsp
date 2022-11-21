<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>판매 게시글 조회</title>
	
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
	
	<!-- JavaScript Libraries -->
    <script src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
    
    <!-- datepicker -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="<c:url value='https://code.jquery.com/jquery-1.12.4.js'/>"></script>
	<script src="<c:url value='https://code.jquery.com/ui/1.12.1/jquery-ui.js'/>"></script>
	
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
        
        
        input[type="number"] {
  -webkit-appearance: textfield;
  -moz-appearance: textfield;
  appearance: textfield;
}

input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
  -webkit-appearance: none;
}

.number-input {
  border: 0;
  display: inline-flex;
}

.number-input,
.number-input * {
  box-sizing: border-box;
}

.number-input button {
  outline:none;
  -webkit-appearance: none;
  background-color: transparent;
  border: none;
  align-items: center;
  justify-content: center;
  width: 3rem;
  height: 3rem;
  cursor: pointer;
  margin: 0;
  position: relative;
  box-shadow: 0px 0px 1px #474747;
  border-radius: 50%;
}

.number-input button:before,
.number-input button:after {
  display: inline-block;
  position: absolute;
  content: '';
  width: 1rem;
  height: 2px;
  background-color: #212121;
  transform: translate(-50%, -50%);
}
.number-input button.plus:after {
  transform: translate(-50%, -50%) rotate(90deg);
}

.number-input input[type=number] {
  font-family: sans-serif;
  max-width: 5rem;
  padding: .5rem;
  border: none;
  border-width: 0 2px;
  font-size: 2rem;
  height: 3rem;
  font-weight: bold;
  text-align: center;
  color:#9be3df;
}

	.tabnaver {font-size: 0; width: 100%;}
	.tabnaver li {}
	/*tab css*/
	.tab{float:left; width:100%; height:100%;}
	.tabnav{font-size:0; width:100%; border:1px solid #ddd;}
	.tabnav li{display: inline-block; height:46px; text-align:center; border-right:1px solid #ddd;}
	.tabnav li a:before{content:""; position:absolute; left:0; top:0px; width:100%; height:3px; }
	.tabnav li a.active:before{background:rgb(95, 204, 255, 0.8);}
	.tabnav li a.active{border-bottom:1px solid #fff;}
	.tabnav li a{ position:relative; display:block; background: #f8f8f8; color: #000; padding:0 30px; line-height:46px; text-decoration:none; font-size:16px;}
	.tabnav li a:hover,
	.tabnav li a.active{background:#fff; color:rgb(95, 204, 255, 0.8); font-weight: 800;}
	.tabcontent{padding: 20px; border:1px solid #ddd; border-top:none;}


/*tab css*/
.tab {

	text-align:left;
	height: 100%;
}

.tabnav {
	font-size: 0;
	border: 1px solid #ddd;
}

.tabnav li {
	display: inline-block;
	height: 100%;
}

.tabnav li a:before {
	content: "";
	position: absolute;
	left: 0;
	top: 0px;
	width: 100%;
	height: 3px;
}

.tabnav li a.active:before {
	background: rgb(95, 204, 255, 0.8);
}

.tabnav li a.active {
	border-bottom: 1px solid #fff;
}

.tabnav li a {
	position: relative;
	display: block;
	background: #f8f8f8;
	color: #000;
	padding: 0 30px;
	line-height: 46px;
	text-decoration: none;
	font-size: 16px;
}

.tabnav li a:hover, .tabnav li a.active {
	background: #fff;
	color: rgb(95, 204, 255, 0.8);
	font-weight: 800;
}

.tabcontent {
	text-align:center;
	padding: 20px;
	border: 1px solid #ddd;
	border-top: none;
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
						
						<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
						<div class="text-center">
							<c:if test="${member.user_id != null and member.user_id != dto.user_id}">
								<div style="margin-right: 1px;">
									<button type="button" class="btn btn-warning" id="like_btn" onclick="sell_updateLike(); return false;">추천 ${view.sell_like}</button>
								</div>
							</c:if>
						</div>
						
						<!-- 유저 이름과 게시글 작성자가 일치해야 게시글 수정, 삭제 가능 
							  하지만 동명이인 일시? 추후 id로 개선 필요함
						-->
						<c:if test="${company.com_name == view.sell_writer}">
							<div>
								<a href="/sell_board/sell_delete?sell_bno=${view.sell_bno}">게시글 삭제</a>
							</div>
						</c:if>
					</div>
					<div class="bg-white border border-top-0 p-4 mb-3">
						<div class="container">
							<div class="row" style="text-align: center;">
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">판매자</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_writer}</p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">목적지</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_destination}</p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">내용</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_content}</p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline;">판매인원</h5> <br><br>
									<h5 class="m-0 text-uppercase font-weight-bold">현재예약</h5>
								</div>
								<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px; border-right: 1px solid gray;">
									<p style="font-size: 20px; color: black; display: inline;">${peopleCnt} 명</p> <br><br>
									<p style="font-size: 20px; color: black; display: inline;">${peopleCnt - view.sell_people} 명</p>
								</div>
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">남은인원</h5> <br><br>
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">최소출발</h5>
								</div>
								<div class="col-lg-3" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_people} 명</p> <br><br>
									<p style="font-size: 20px; color: black; display: inline;">${view.min_people} 명</p>
								</div>
								
								<div class="col-lg-6" style="border-right: 1px solid gray; margin-bottom: 50px;">
									<h5 class="m-0 text-uppercase font-weight-bold">출발일</h5> 
									<p style="font-size: 20px; color: black; display: inline;"><fmt:formatDate value="${view.sell_start}" pattern="yyyy-MM-dd" /></p>
								</div>
								<div class="col-lg-6" style="">
									<h5 class="m-0 text-uppercase font-weight-bold">도착일</h5>
									<p style="font-size: 20px; color: black;"><fmt:formatDate value="${view.sell_end}" pattern="yyyy-MM-dd" /></p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">비용</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;"><fmt:formatNumber type="number" pattern="###,###,###" value="${view.sell_price}"/> 원</p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">가이드 포함 여부</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_guide}</p>
								</div>
								
								<div class="col-lg-3" style="display: inline; margin-bottom: 30px;">
									<h5 class="m-0 text-uppercase font-weight-bold" style="display:inline">항공사</h5>
								</div>
								<div class="col-lg-9" style="text-align: left; display: inline; margin-bottom: 30px;">
									<p style="font-size: 20px; color: black; display: inline;">${view.sell_air}</p>
								</div>
								
								
								<div class="col-lg-12" style="margin-bottom: 30px;">
									<div class="tab">
										<c:forEach items="${tabList}" var="tabList">
											<ul class="tabnav">
												<li class="tabnaver-li"><a href="#tab00">${tabList.tab_title_1}</a></li>
												<li class="tabnaver-li"><a href="#tab01">${tabList.tab_title_2}</a></li>
												<li class="tabnaver-li"><a href="#tab02">${tabList.tab_title_3}</a></li>
												<li class="tabnaver-li"><a href="#tab03">${tabList.tab_title_4}</a></li>
												<li class="tabnaver-li"><a href="#tab04">${tabList.tab_title_5}</a></li>
												<li class="tabnaver-li"><a href="#tab05">${tabList.tab_title_6}</a></li>
											</ul>
											<div class="tabcontent">
												<div class="text-align" id="tab00">
													<table class="table text-align" style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_1}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_1}</div></td>
														</tr>
													</table>
												</div>
												<div class="text-align" id="tab01">
													<table class="table text-align"
														style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_2}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_2}</div></td>
														</tr>
													</table>
												</div>
												<div class="text-align" id="tab02">
													<table class="table text-align"
														style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_3}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_3}</div></td>
														</tr>
													</table>
												</div>
												<div class="text-align" id="tab03">
													<table class="table text-align"
														style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_4}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_4}</div></td>
														</tr>
													</table>
												</div>
												<div class="text-align" id="tab04">
													<table class="table text-align" style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_5}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_5}</div></td>
														</tr>
													</table>
												</div>
												<div class="text-align" id="tab05">
													<table class="table text-align" style="border: 1px solid #dddddd">
														<tr>
															<th style="background-color: #eeeeee; font-size: 20px;">${tabList.tab_title_6}</th>
														</tr>
														<tr>
															<td><div style="color: black; font-size: 20px; text-align: left;">${tabList.tab_content_6}</div></td>
														</tr>
													</table>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
								
								
								<%-- <c:if test="${view.sell_img != null}">
									<img src="${view.sell_img}" width="500px" height="500px" style="margin: 0 auto; margin-bottom: 30px;">
								</c:if> --%>
								
								<div class="container">
								<div class="row" style="text-align: center; margin-bottom: 30px;">
									<c:forEach var="list" items="${list}">
										<div class="col-lg-6 bigPicture" style="margin-bottom: 30px;">
											<img src="${list.img}" width="500px" height="500px" onerror="this.remove ? this.remove() : this.removeNode();"/>
										</div>
									</c:forEach>
								</div>
							</div>
								
							</div>
						</div>
					
						<div class="mb-4">
							<!-- 로그인이 되어있고, 본인 글이 아닐경우에만 추천할 수 있도록 버튼을 출력 -->
							<div class="text-center">
								<c:if test="${member != null}">
								
									<%-- 구매 모달창 --%>
									<div class="modal">
							        	<div class="modal_content card" style="width:20rem; height:26rem;">
								            <div class="card-body">
								                <h5>결제</h5>
								                <h6>안내사항</h6>
								                <p style="color: black;">인원수를 선택해 주세요</p>
								                <div class="number-input" style="margin-bottom: 10px;">
													<button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="down"></button>
														<input class="order_people" id="order_people" min="1" name="order_people" value="1" type="number" required>
													<button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
												</div>
												
								               	<div style="margin-bottom: 10px; color: black;">
								               		보유 포인트 <p style="font-size:20px; display: inline;"><fmt:formatNumber type="number" pattern="###,###,###" value="${member.user_point}"/></p> 점
								               	</div>
								               	<div style="margin-bottom: 10px; color: black;">
								               		사용 포인트 <p style="font-size: 20px; display: inline;"><input id="use_point" onkeyup='usePoint()' style="width: 100px;" type="number" value="0" name="point" required min="0"></p> 점
								               	</div>
								               	
								               	<div style="color: black; margin-bottom: 10px;">
									               	총 비용은 <p class="totalCost" id="totalCost" style="font-size: 20px; font-weight:800; display: inline;"></p>원 입니다
								               	</div>
								               	
								                <p style="color: black;">단순 변심으로 환불은 <strong>불가능</strong>합니다</p>
								                <p style="color: black;">정말 구매하시겠습니까?</p>
								                <button type="submit" id="purchaseOK" class="btn btn-warning">예</button>
								                <button type="button" class="btn btn-delete" onclick="closePurchaseModal()">아니오</button>
								            </div>
								        </div>
								    </div>
									
									<div style="margin-right: 1px;">
									
										<!-- 구매 여부 확인 purchased == 1 시 구매 O,	purchased == 0 시 구매 X -->
										<c:if test="${purchased == 1}">
											<button type="button" class="btn btn-delete" disabled="disabled">이미 구매하신 상품입니다</button>
										</c:if>
										<c:if test="${purchased == 0}">
											<button type="button" id="purchase" onclick="openPurchaseModal()" class="btn btn-primary mb-3">구매하기</button>
										</c:if>
									</div>
									
								</c:if>
							</div>
							
							<input type="text" name="sell_bno" value="${view.sell_bno}" hidden="hidden">
							<input type="text" name="user_num" value="${member.user_num}" hidden="hidden">
							<input type="text" name="order_title" value="${view.sell_title}" hidden="hidden">
							<input type="text" name="order_writer" value="${view.sell_writer}" hidden="hidden">
							<input type="text" name="order_destination" value="${view.sell_destination}" hidden="hidden">
							<input type="text" name="order_price" value="${view.sell_price}" hidden="hidden">
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
							<form method="post" action="/sell_reply/sell_write">
								<!-- 회원이 아닐 시 댓글 작성 불가 -->
								<c:if test="${member == null && company == null}">
									<p>로그인이 필요한 서비스 입니다</p>
								</c:if>

								<c:choose>
									<c:when test="${member != null || company != null}">
										<c:if test="${member != null}">
											<!-- 일반 회원 댓글 -->
											<p>
												<input type="text" name="sell_writer" value="${member.user_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="sell_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="sell_bno" value="${view.sell_bno}">
												<button type="submit" class="btn btn-warning">댓글 작성</button>
											</p>
										</c:if>
										
										<!-- 기업 회원 댓글 -->
										<c:if test="${company != null}">
											<p>
												<input type="text" name="sell_writer" value="${company.com_name}" hidden="hidden">
												<textarea rows="5" cols="117" name="sell_content" placeholder="회원간의 따뜻한 댓글 부탁드립니다"></textarea>
											</p>
											<p>
												<input type="hidden" name="board_want_bno" value="${view.sell_bno}">
												<button type="submit" class="btn btn-warning">댓글 작성</button>
											</p>
										</c:if>
									</c:when>
								</c:choose>
							</form>
							
							<ul style="color: black;">
								<c:forEach items="${reply}" var="reply">
									<li>
										<div>
											<p>${reply.sell_writer} / ${reply.sell_rno}
												/
												<fmt:formatDate value="${reply.sell_regDate}" pattern="yyyy-MM-dd" />
												<c:if test="${member.user_name == reply.sell_writer}">
													<a href="/sell_reply/sell_modify?sell_rno=${reply.sell_rno}">댓글 수정</a>
													<a href="/sell_reply/sell_delete?sell_rno=${reply.sell_rno}">댓글 삭제</a>
												</c:if>
												
												<c:if test="${company.com_name == reply.sell_writer}">
													<a href="/sell_reply/sell_modify?sell_reply_rno=${reply.sell_rno}">댓글 수정</a>
													<a href="/sell_reply/sell_delete?sell_reply_rno=${reply.sell_rno}">댓글 삭제</a>
												</c:if>
											</p>
											<p>${reply.sell_content}</p>
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
	var sell_bno = ${view.sell_bno};
	var suggest_bno = ${view.suggest_bno};
	var user_num = ${member.user_num};
	var sell_people = ${view.sell_people};
	var totalCost = ${view.sell_price};
	var input_point = ${member.user_point};
	var order_people = document.getElementById('order_people').value;
	const purchaseOK = document.getElementById('purchaseOK');
	const purchase = document.getElementById('purchase');
	var max;
	var total_price;
	
	function sell_updateLike(){ 
	    $.ajax({
	           type : "POST",  
	           url : "/sell_board/sell_updateLike",       
	           dataType : "json",   
	           data : {'sell_bno' : sell_bno, 'user_num' : user_num},
	           error : function(){
	              alert("통신 에러");
	           },
	           success : function(sell_likeCheck) {
	                   if(sell_likeCheck == 0){
		                   alert("추천완료.");
		                   location.reload();
	                   }
	                   else if (sell_likeCheck == 1){
		                   alert("추천취소");
		                   location.reload();
	               }
	           }
	       });
	}
	 
	// 구매요청 모달창 열기
	function openPurchaseModal() {
		$(".modal").fadeIn();
	}
	
	// 구매요청 모달창 닫기
	function closePurchaseModal() {
		$(".modal").fadeOut();
	}
	
	// 외부영역 클릭 시 팝업 닫기
	$(function(){ 
				$(document).mouseup(function (e){
				var modal_content = $(".modal_content");
				if(modal_content.has(e.target).length === 0){
				closePurchaseModal();
			}
		});
	});
	
	//포인트 입력 실시간 감지
	function usePoint() {
		const use_point = document.getElementById('use_point').value;
		const user_point = ${member.user_point};
		var sell_price = ${view.sell_price};
		var order_people = document.getElementById('order_people').value;
		
		max = sell_price * order_people - use_point;
		
		if(use_point > user_point || use_point > sell_price * order_people){
			purchaseOK.disabled = true; // 포인트초과시 버튼 비활성화
			purchaseOK.innerText = "포인트초과"; // 포인트초과시 버튼 명칭 변경
		} else if(sell_people - order_people == 0) { 
			purchaseOK.disabled = false;
			purchaseOK.innerText = "예";
			
			purchase.disabled = true;
			purchase.innerText = "매진되었습니다";
		} else if(use_point < 0) {
			purchaseOK.disabled = true; // 포인트 음수 입력시 버튼 비활성화
			purchaseOK.innerText = "사용불가"; // 포인트 음수 입력시 버튼 명칭 변경
		}
		else {
			purchase.disabled = false;
			purchase.innerText = "구매하기";
			
			purchaseOK.disabled = false;
			purchaseOK.innerText = "예";
			purchase.innerText = "구매하기";
		}
		
		total_price = sell_price * order_people - use_point;
		var tmp = 0;
		// 20명 이상 단체 주문 시 할인
		if(order_people >= 20) {
			tmp = (sell_price * order_people) / 10; //패키지 가격 * 인원의 10%
			var discount_price = total_price - tmp; //총액에 10% 할인 적용
			
			total_price = discount_price; //total_price에 할인된 가격 대입
			
			if(total_price < 0) {
				total_price *= (-1);
				
				if(use_point > sell_price * order_people - tmp) { //사용 포인트가 총액 넘어갈시 표시되는 가격 제한
					total_price = sell_price * order_people;
					use_point = total_price;
				}
			} else {
				discount_price *= 1;
			}
		} else {
			if(total_price < 0) {
				total_price *= (-1);
				
				if(use_point > sell_price * order_people) {
					total_price = sell_price * order_people;
					use_point = total_price;
				}
			} else {
				total_price *= 1;
			}
		}
	}
	
	// 인원수 체크 함수
	setInterval(function () {
		
		var order_people = document.getElementById('order_people').value;
		var sell_price = ${view.sell_price};
		const totalCostText = document.getElementById('totalCost');
		
		const priceText = document.getElementById('price');
		const priceTotal = (totalCost * order_people - input_point);
		
		if(sell_people - order_people < 0) { // 구매 인원 > 패키지 인원 == 패키지 인원 초과시 구매 버튼 비활성화
			purchaseOK.disabled = true; // 인원초과 시 예 버튼 비활성화
			purchaseOK.innerText = "인원초과"; // 인원초과 시 버튼 명칭 변경
			
			purchase.disabled = true; // 인원초과 시 구매하기 버튼 비활성화
			purchase.innerText = "매진되었습니다"; // 인원초과 시 구매하기 버튼 명칭 변경
		} else {
			usePoint();
		} 
		
		//숫자3 자리마다 콤마(,) 삽입
		const conversionComma = (total_price).toLocaleString('ko-KR');
		totalCostText.innerText = conversionComma;
		
	}, 0);
	
	</script>
	
	<!-- tab -->
	<script>
		$(function(){
			$('.tabcontent > div').hide();
			$('.tabnav a').click(function () {
				$('.tabcontent > div').hide().filter(this.hash).fadeIn();
				$('.tabnav a').removeClass('active');
				$(this).addClass('active');
				return false;
			}).filter(':eq(0)').click();
			
			
		});
	</script>
</body>
</html>