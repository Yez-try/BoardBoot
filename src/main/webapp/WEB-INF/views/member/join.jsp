<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/memberJoin.js"></script>
</head>
<body>
<div class="container">
	<div class="row my-5">
		<div class="col text-center">
			<h3>회원가입</h3>
		</div>
	</div>
	<form id="joinForm" action="/member/join" method="post">
		<div class="row justify-content-center mt-2">
			<div class="col-2">
				<label for="id">아이디</label>
			</div>
			<div class="col-5">
				<input name="id" id="id" class="valid" type="text">
			</div>
		</div>
		<div class="row justify-content-center mt-2">
			<div class="col-2">
				<label for="password">비밀번호</label>
			</div>
			<div class="col-5">
				<input name="password" id="password" class="valid" type="password">
			</div>
		</div>
		<div class="row justify-content-center mt-2">
			<div class="col-2">
				<label for="name">이름</label>
			</div>
			<div class="col-5">
				<input name="name" id="name" class="valid" type="text">
			</div>
		</div>
		<div class="row justify-content-center mt-2">
			<div class="col-2">
				<label for="email">이메일</label>
			</div>
			<div class="col-5">
				<input name="email" id="email" class="valid" type="text">
			</div>
		</div>
		<div class="row justify-content-center mt-2">
			<div class="col-2">
				<button type="submit" id="joinButton" class="btn btn-success">회원가입</button>
			</div>
		</div>
	</form>

</div>

</body>
</html>