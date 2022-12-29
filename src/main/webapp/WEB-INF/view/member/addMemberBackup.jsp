<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ADD Member</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>회원가입</h1>
			</div>
			
			<div>
				<form action = "${pageContext.request.contextPath }/member/addMember" method = "post">
					<div>
						<table border = "1">
							<tr>
								<th>ID</th>
								<td>
									<input type = "text" name = "memberId" id = "memberId">
								</td>
							</tr>
							
							<tr>
								<th>Password</th>
								<td>
									<input type = "password" name = "memberPw" id = "memberPw">
								</td>
							</tr>
							
							<tr>
								<th>Name</th>
								<td>
									<input type = "text" name = "memberName" id = "memberName">
								</td>
							</tr>
						</table>
					</div>
					
					<div>
						<button type = "submit">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>