<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>modifyBoardForm.jsp</title>
		
	</head>
	
	<body>
		<div>
			<div>
				<h1>글 수정</h1>
			</div>
			
			<div>
				<form action = "${pageContext.request.contextPath }/board/modifyBoard" method = "post">
					<div>
						<table>
							<!-- boardNo -->
							<tr>
								<th>boardNo</th>
								<td>
									<input type = "text" name = "boardNo" id = "boardNo" value = "${board.boardNo }" readonly = "readonly">
								</td>
							</tr>
							
							<!-- memberId -->
							<tr>
								<th>memberId</th>
								<td>
									<input type = "text" name = "memberId" id = "memberId" value = "${board.memberId }" readonly = "readonly">
								</td>
							</tr>
							
							<!-- boardTitle -->
							<tr>
								<th>boardTitle</th>
								<td>
									<input type = "text" name = "boardTitle" id = "boardTitle" value = "${board.boardTitle }">
								</td>
							</tr>
							
							<!-- boardContent -->
							<tr>
								<th>boardContent</th>
								<td>
									<textarea rows = "8" cols = "50" name = "boardContent">${board.boardContent }</textarea>
								</td>
							</tr>
						</table>
					</div>
					<div>
						<button type = "submit">수정</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>