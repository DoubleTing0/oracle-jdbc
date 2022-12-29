<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>boardOne.jsp</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>BOARD ONE</h1>
			</div>
		
			<div>
				<table border = "1">
					<tr>
						<th>BoardNo</th>
						<th>BoardTitle</th>
						<th>BoardContent</th>
						<th>memberId</th>
						<th>updatedate</th>
						<th>createdate</th>
						<c:if test="${loginMember.memberId == board.memberId }">
							<th>수정</th>
							<th>삭제</th>
						</c:if>
					</tr>
					
					<tr>
						<td>${board.boardNo }</td>
						<td>${board.boardTitle }</td>
						<td>${board.boardContent }</td>
						<td>${board.memberId }</td>
						<td>${board.updatedate }</td>
						<td>${board.createdate }</td>
						<c:if test="${loginMember.memberId == board.memberId }">
							<td>
								<a href = "${pageContext.request.contextPath }/member/checkPassword?targetUrl=/board/modifyBoard?boardNo=${board.boardNo }">수정</a>
							</td>
							<td>
								<a href = "${pageContext.request.contextPath }/member/checkPassword?targetUrl=/board/removeBoard?boardNo=${board.boardNo }">삭제</a>
							</td>
						</c:if>
					</tr>
							
				
				</table>
			
			</div>
		
		
		</div>
	</body>
</html>