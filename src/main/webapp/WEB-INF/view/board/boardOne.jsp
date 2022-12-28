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
						<th>수정</th>
						<th>삭제</th>
					</tr>
					
					<tr>
						<td>${board.boardNo }</td>
						<td>${board.boardTitle }</td>
						<td>${board.boardContent }</td>
						<td>${board.memberId }</td>
						<td>${board.updatedate }</td>
						<td>${board.createdate }</td>
						<td>
							<a href = "${pageContext.request.contextPath }/ModifyBoardController?boardNo=${board.boardNo }">수정</a>
						</td>
						<td>
							<a href = "${pageContext.request.contextPath }/RemoveBoardController?boardNo=${board.boardNo }">삭제</a>
						</td>
					</tr>
							
				
				</table>
			
			</div>
		
		
		</div>
	</body>
</html>