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
			
			<form method = "get" action = "${pageContext.request.contextPath }/BoardListController">
				<div>
					<input type = "text" name = "searchText" id = "searchText">
					<button type = "submit" >검색</button>
				</div>
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
							<a href = "${pageContext.request.contextPath }/BoardOneController">
								${b.boardTitle }
							</a>
						</td>
						<td>${b.createdate }</td>
					</tr>
				</c:forEach>
			</table>
			
			
			
			
			<div>현재 페이지 : ${currentPage }</div>
			
			<div>
				<a href = "${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${currentPage - 1}">이전</a>
				<a href = "${pageContext.request.contextPath }/BoardListController?searchText=${searchText }&rowPerPage=${rowPerPage }&currentPage=${currentPage + 1}">다음</a>
			</div>
			
			
			
			<div>
				<c:forEach var="i" items="${pageList }">
					${i }
				</c:forEach>
			</div>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
	</body>
</html>