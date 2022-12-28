<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>boardList.jsp</title>
		
		<!-- jQuery -->
		<!-- CDN 주소 추가 방식 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		
		<!-- Bootstrap CDN 시작 -->
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Bootstrap CDN 끝 -->
		
		<script>
			$(document).ready(function() {
				$('#rowPerPage').change(function() {
					$('#pageForm').submit();
					alert('change');
				});
			});
		</script>
		
		
		
	</head>
	
	<body>
		<div>
			<div>
				<h1>BOARD LIST</h1>
			</div>
		
			
			
			<form method = "get" id = "pageForm" action = "${pageContext.request.contextPath }/BoardListController">
				<select name = "rowPerPage" id = "rowPerPage">
					<c:if test="${rowPerPage == 10 }">
						<option value = "10" selected = "selected">10</option>
						<option value = "20">20</option>
						<option value = "30">30</option>
					</c:if>
					<c:if test="${rowPerPage == 20 }">
						<option value = "10">10</option>
						<option value = "20" selected = "selected">20</option>
						<option value = "30">30</option>
					</c:if>
					<c:if test="${rowPerPage == 30 }">
						<option value = "10">10</option>
						<option value = "20">20</option>
						<option value = "30" selected = "selected">30</option>
					</c:if>
				</select>
				
			</form>
			
			
			
			<table border = "1">
				<tr>
					<th>boardNo</th>
					<th>boardTitle</th>
					<th>createdate</th>
				</tr>
				<c:forEach var="b" items="${boardList }">
					<tr>
						<td>${b.boardNo }</td>
						<td>
							<a href = "${pageContext.request.contextPath }/BoardOneController?boardNo=${b.boardNo}">
								${b.boardTitle }
							</a>
						</td>
						<td>${b.createdate }</td>
					</tr>
				</c:forEach>
			</table>
			
			<div>&nbsp;</div>
			
			
			
			<form method = "get" action = "${pageContext.request.contextPath }/BoardListController">
				<div>
					<input type = "text" name = "searchText" id = "searchText">
					<button type = "submit" >검색</button>
				</div>
			</form>
			
			
			
			<div>&nbsp;</div>
			
			<!-- 게시판 페이징 처리 시작 -->
			<div>
				<ul class="pagination justify-content-center">
					
					<!-- 페이지 처음 -->
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=1">
							<span>처음</span>
						</a>
					</li>
					
					<!-- 페이지 이전(-10의 1페이지) -->
					<c:if test="${previousPage > 0}">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${previousPage}">
								<span>이전</span>
							</a>
						</li>
					</c:if>
			
					<!-- 페이지 1 ~ 10 -->
					<c:forEach var="i" items="${pageList }">
						<!-- 현재페이지 active 속성 부여 -->
						<c:choose>
							<c:when test="${currentPage == i}">
								<li class = "page-item active">
							</c:when >
							<c:otherwise>
								<li class = "page-item">
							</c:otherwise>
						</c:choose>
					
						<!-- 마지막 페이지 까지만 출력 -->
						<c:if test="${i <= lastPage }">
							<a class="page-link" href="${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${i}">
								<span>${i }</span>
							</a>
						</c:if>
						
								</li>
						
					</c:forEach>
			
					<!-- 페이지 다음(+10의 1페이지) -->
					<c:if test="${nextPage <= lastPage }">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${nextPage}">
								<span>다음</span>
							</a>
						</li>
					</c:if>
			
					<!-- 페이지 마지막 -->
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${lastPage}">
							<span>마지막</span>
						</a>
					</li>
				</ul>
			</div>
			<!-- 게시판 페이징 처리 -->
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
	</body>
</html>