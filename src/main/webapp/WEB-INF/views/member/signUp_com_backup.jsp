<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 회원가입</title>
</head>
<body>
<h2>기업 회원가입</h2>
<style>
	.outer{
		width:60%;
		min-width : 650px;
		background: rgb(248, 249, 250);
		box-shadow: rgba(0, 0, 0, 0.06) 0px 0px 4px 0px;
		margin:auto;
		margin-top : 70px;
		 margin-bottom : 70px;
	}
	
	#joinForm {
		width : 400px;
		margin: auto;
		padding: 10px;
	}
	
	#joinForm h1 {
		text-align:center;
	}
	

	.input_area {
	    border: solid 1px #dadada;
	    padding : 10px 10px 14px 10px;
	    background : white;
	}
	

	.input_area input:not([type=checkbox]) {
		width : 250px;
		height : 30px;
		border: 0px;
	}
	
	.btnArea {
		text-align:center;
		padding : 50px;
	}
	
	button {
		width : 100px;
		height : 35px;
		border : 0px;
		color:white;
		background:#282A35;
		margin : 5px;
	}
	
</style>
	
	<form role="form" method="post" autocomplete="off">
	    <!-- 사업자 번호: <input type="text" name="comNum"><br/> -->
	         아이디: <input type="text" name="com_id"><br/>
		
		비밀번호: <input type="password" name="com_pw"><br/>
		비밀번호 확인 : <input type="password" name="pwCheck">
		<button id="idCheck" type="button">확인</button><br/>
		
		이름: <input type="text" name="com_name"><br/><br/>
		
		전화번호:
		<select name="com_phone1">
			<option>02</option>
			<option>031</option>
			<option>051</option>
			<option>053</option>
			<option>062</option>
		</select>
		- <input type="text" name="com_phone2" size="4" maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
		- <input type="text" name="com_phone3" size="4" maxlength='4' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"><br/>
		
		<h4>주소</h4>
		<span class="input_area"><input type="text" name="com_address" class="postcodify_postcode5"></span> <br/>
				
		이메일: <input type="text" name="com_email"><br/>
		
		<button type="submit" id="postcodify_search_button">가입</button>
	</form>
</body>
</html>