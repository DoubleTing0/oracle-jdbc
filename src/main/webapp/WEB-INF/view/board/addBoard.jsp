<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시글 입력</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>게시글 입력</h1>
			</div>
		
			<div>
				<form action = "${pageContext.request.contextPath }/board/addBoard" method = "post">
					<div>
						<table border = "1">
							<tr>
								<th>boardTitle</th>
								<td>
									<input type = "text" name = "boardTitle" id = "boardTitle">
								</td>
							</tr>
								
							<tr>
								<th>memberId</th>
								<td>
									<input type = "text" name = "memberId" id = "memberid" value = "${loginMember.memberId }" readonly = "readonly">
								</td>
							</tr>	
							
							<tr>
								<th>boardContent</th>
								<td>
									<textarea rows = "8" cols = "50" name = "boardContent" id = "boardContent"></textarea>
								</td>
							</tr>	
						</table>
					</div>
				
					<div>
						<button type = "submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>