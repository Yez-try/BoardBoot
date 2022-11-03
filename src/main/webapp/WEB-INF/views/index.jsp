<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- 다국어 설정 taglib jsp 에서 spring message를 사용할 수 있도록 함 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	
	<h1>index</h1>
	<hr>
	<sec:authorize access="isAuthenticated()">
		<a href="./logout">로그아웃</a>
	</sec:authorize>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="./member/join">회원가입</a>
		<a href="./member/login">로그인</a>
	</sec:authorize>
	
	
	<hr>
	<a href="./qna/list">qna List</a>



</body>
</html>