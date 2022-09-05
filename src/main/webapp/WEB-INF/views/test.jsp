<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link rel="stylesheet"
	href="<c:url value='../resources/img/favicon.ico'/>">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link rel="stylesheet"
	href="<c:url value='../resources/lib/owlcarousel/assets/owl.carousel.min.css'/>">

<!-- Customized Bootstrap Stylesheet -->
<link rel="stylesheet"
	href="<c:url value='../resources/css/style.css'/>">

<!-- JavaScript Libraries -->
<script
	src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
</head>
<style>
[contenteditable] {
	border: solid 1px lightgreen;
	padding: 5px;
	border-radius: 3px;
}

body {
	color: black;
	font-size: 20px;
}

/*tab css*/
.tab {
	float: left;
	width: 100%;
	height: 100%;
}

.tabnav {
	font-size: 0;
	width: 100%;
	border: 1px solid #ddd;
}

.tabnav li {
	display: inline-block;
	height: 46px;
	text-align: center;
	border-right: 1px solid #ddd;
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
	padding: 20px;
	border: 1px solid #ddd;
	border-top: none;
}
</style>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="bg-white border border-top-0 p-3">
					<form class="form" role="form" method="post" autocomplete="off"
						action="/test/write">
						<p>
							<button id="btn-add-tab" type="button" class="btn btn-primary pull-right">Add Tab</button>
						</p>
						<!-- Nav tabs -->
						<ul id="tab-list" class="nav nav-tabs" role="tablist">
							<li class="active"><a href="#tab1" role="tab" data-toggle="tab"> 
								<!-- <span>Tab 1 </span> <span class="fa fa-pencil fa-fw text-muted edit"></span> --> 
								<input type="text" class="text-size" name="tab_title_1" size="10" id="tab" placeholder="tab1">
							</a></li>
						</ul>

						<!-- Tab panes -->
						<div id="tab-content" class="tab-content">
							<!-- <div class="tab-pane fade in active" id="tab1">Tab 1 content</div> -->
							<div class="tab-pane fade in active" id="tab1">
								<textarea rows="10" cols="97" name="tab_content_1"
									placeholder="tab1 내용을 입력해주세요"></textarea>
							</div>

						</div>

						<button type="submit">작성</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%-- <c:forEach items="${list}" var="list">
		
		tab1 제목 : ${list.tab_title_1} / tab1 내용 : ${list.tab_content_1} <br>
		tab2 제목 : ${list.tab_title_2} / tab2 내용 : ${list.tab_content_2} <br>
		tab3 제목 : ${list.tab_title_3} / tab3 내용 : ${list.tab_content_3} <br>
		tab4 제목 : ${list.tab_title_4} / tab4 내용 : ${list.tab_content_4} <br>
		<hr>
	</c:forEach> --%>

	<div class="container">
		<div class="row">
			<div class="col-lg-12" style="margin-bottom: 30px;">
				<div class="tab">
					<c:forEach items="${list}" var="list">
						<ul class="tabnav">
							<li class="tabnaver-li"><a href="#tab00">${list.tab_title_1}</a></li>
							<li class="tabnaver-li"><a href="#tab01">${list.tab_title_2}</a></li>
							<li class="tabnaver-li"><a href="#tab02">${list.tab_title_3}</a></li>
							<li class="tabnaver-li"><a href="#tab03">${list.tab_title_4}</a></li>
							<li class="tabnaver-li"><a href="#tab04">${list.tab_title_5}</a></li>
							<li class="tabnaver-li"><a href="#tab05">${list.tab_title_6}</a></li>
						</ul>
						<div class="tabcontent">
							<div class="text-align" id="tab00">
								<table class="table text-align" style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_1}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_1}</div></td>
									</tr>
								</table>
							</div>
							<div class="text-align" id="tab01">
								<table class="table text-align"
									style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_2}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_2}</div></td>
									</tr>
								</table>
							</div>
							<div class="text-align" id="tab02">
								<table class="table text-align"
									style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_3}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_3}</div></td>
									</tr>
								</table>
							</div>
							<div class="text-align" id="tab03">
								<table class="table text-align"
									style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_4}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_4}</div></td>
									</tr>
								</table>
							</div>
							<div class="text-align" id="tab04">
								<table class="table text-align" style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_5}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_5}</div></td>
									</tr>
								</table>
							</div>
							<div class="text-align" id="tab05">
								<table class="table text-align" style="border: 1px solid #dddddd">
									<tr>
										<th style="background-color: #eeeeee; font-size: 20px;">${list.tab_title_6}</th>
									</tr>
									<tr>
										<td><div style="color: black; font-size: 20px; text-align: left;">${list.tab_content_6}</div></td>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript Libraries -->
	<script
		src="<c:url value='https://code.jquery.com/jquery-3.4.1.min.js'/>"></script>
	<script
		src="<c:url value='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'/>"></script>
</body>
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
				$('#tab-content').append($('<div class="tab-pane fade" id="tab' + tabID + '"> ' + ' <textarea rows="10" cols="97" name="tab_content_'+tabID+'" placeholder="tab'+tabID+' 내용을 입력해주세요"></textarea></div>'));
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
				//display first tab
				/* var tabFirst = $('#tab-list a:first');
				resetTab();
				tabFirst.tab('show'); */
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
</script>
<!-- tab -->
<script>
	$(function() {
		$('.tabcontent > div').hide();
		$('.tabnav a').click(function() {
			$('.tabcontent > div').hide().filter(this.hash).fadeIn();
			$('.tabnav a').removeClass('active');
			$(this).addClass('active');
			return false;
		}).filter(':eq(0)').click();

	});
</script>
</html>