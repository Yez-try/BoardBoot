<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/qnaAdd.js" type="text/javascript"></script>
</head>
<body>
	<div class="container mt-2">
	<h1>Board Write Page</h1>
	<hr>
		<form:form id="writeForm" action="./add" method="post" enctype="multipart/form-data" modelAttribute="qnaVO">
			<div class="row mt-2">
				<div class="col-1">
					<label for="title">제목</label>
				</div>
				<div class="col-5">
					<form:input cssClass="form-control" placeholder="제목을 입력해주세요" path="title" id="title"/>
				</div>
				<div class="col-4 text-danger" id="titleChk">
					<form:errors path="title"></form:errors>
				</div>
			</div>
			<div class="row mt-2">
				<div class="col-1">
					<label for="writer">작성자</label>
				</div>
				<div class="col-5">
					<form:input placeholder="작성자를 입력해주세요" cssClass="form-control" path="writer" id="writer"/>
				</div>
				<div class="col-4 text-danger" id="writerChk">
					<form:errors path="writer"></form:errors>
				</div>
			</div>
			<div class="row mt-2">
				<div>
					<form:textarea id="contents" path="contents"/>
				</div>
				<div class="text-danger" id="contentsChk">
					<form:errors path="contents"></form:errors>
				</div>
			</div>
			<div class="row mt-2">
				<div id="divFiles">
				</div>	
			
			</div>
			<div class="row mt-2">
				<div>
					<button type="button" id="fileAddBtn">FileAdd</button>
				</div>
				<button class="btn btn-success" type="button" id="writeBtn">작성하기</button>
			</div>
		</form:form>
	</div>
	<script>
      $('#contents').summernote({
        placeholder: '내용을 입력하세요',
        tabsize: 2,
        height: 100
      });
    </script>
</body>
</html>