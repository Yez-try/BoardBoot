<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/boot.jsp"></c:import>
	
	<div class="container">
		<div class="row">
			<div class="col-10">
				<div>${qnaVO.title}</div>
			</div>
			<div class="col-2">
				<div>${qnaVO.regDate}</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div>${qnaVO.contents}</div>
			</div>
		</div>
		<c:forEach items="${qnaVO.qnaFileVOs}" var="file">
		<div class="row">
			<div>보여주기</div>
			<div><img alt="" src="/resources/upload/qna/${file.fileName}"></div>
		</div>
		<div class="row">
			<div>다운로드 하기</div>
			<div><a href="/resources/down/qna?fileNum=${file.fileNum}">${file.oriName}</a></div>
		</div>
		</c:forEach>
			
	</div>


</body>
</html>