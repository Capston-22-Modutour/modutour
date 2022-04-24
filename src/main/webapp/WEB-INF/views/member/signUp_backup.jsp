<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<!-- 제이쿼리 CDN -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
	<h2>회원가입</h2>
	<form role="form" method="post" autocomplete="off">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="user_id" name="user_id"></td>
				<td><button type="button" class="idCheck">아이디 중복 확인</td>
				<p class="result">
					<span class="msg">아이디를 확인하세요</span>
				</p>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pw" size="10"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="user_name" size="10"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="user_gender" value="m" checked>남성
					<input type="radio" name="user_gender" value="f">여성</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="user_birth"></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><select name="user_phone1">
						<option>010</option>
				</select> - <input type="text" name="user_phone2" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"> - <input
					type="text" name="user_phone3" size='4' maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"><br /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="user_address"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="user_email"></td>
			</tr>
			<td><button type="submit" id="submit" disabled="disabled">가입하기</td>
			<td><input type="button" value="취소"
				onClick="javascript:location.href='index.jsp'""></td>
		</table>

	</form>
	<script>
		$(".idCheck").click(function() {

			var query = {
				user_id : $("#user_id").val()
			};

			$.ajax({
				url : "/member/idCheck",
				type : "post",
				data : query,
				success : function(data) {

					if (data == 1) {
						$(".result .msg").text("사용 불가");
						$(".result .msg").attr("style", "color:#f00");

						$("#submit").attr("disabled", "disabled");
					} else {
						$(".result .msg").text("사용 가능");
						$(".result .msg").attr("style", "color:#00f");

						$("#submit").removeAttr("disabled");
					}
				}
			}); // ajax 끝
		});

		$("#user_id").keyup(function() {
			$(".result .msg").text("아이디를 확인해주십시오.");
			$(".result .msg").attr("style", "color:#000");

			$("#submit").attr("disabled", "disabled");

		});
	</script>
</body>
</html>