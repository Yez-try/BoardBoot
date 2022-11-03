<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
	<h1>List Page</h1>
	<hr>
	</form>
	<div class="container">
		<sec:authorize access="isAuthenticated()">
			<a class="btn btn-danger" href="./add" >Write</a>
		 </sec:authorize>
		<div class="row">
			<form action="./list" method="get">
			<input type="text" name="search" id="search"><button type="submit">검색</button>
		
		</div>
		<div class="row">
			<div class="col">
				<table border=1 class="table table-hover">
					<thead>
						<tr>
							<th>num</th>
							<th>title</th>
							<th>hit</th>
							<th>date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lst}" var="list">
							<tr>
								<td><a href="./detail?num=${list.num}">${list.num}</a></td>
								<td><a href="./detail?num=${list.num}">${list.title}</a></td>
								<td>${list.hit}</td>
								<td>${list.regDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			</div>
		</div>
	</div>
		<nav aria-label="Page navigation">
		  <ul class="pagination justify-content-center">
			<c:forEach begin="1" end="${pager.lastPage}" var="i">
			    <li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}">${i}</a></li>
			</c:forEach>
			</ul>
		</nav>

</body>
</html>