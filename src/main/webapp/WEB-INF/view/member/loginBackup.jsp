<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LOG IN</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>LOG IN</h1>
			</div>
			
			<div>
				<form action = "${pageContext.request.contextPath }/member/login" method = "post">
					<div>
						<table border = "1">
							<!-- ID -->
							<tr>
								<th>ID</th>
								<td>
									<input type = "text" name = "memberId" id = "memberId">
								</td>
							</tr>
							
							<!-- Password -->
							<tr>
								<th>Password</th>
								<td>
									<input type = "Password" name = "memberPw" id = "memberPw">
								</td>
							</tr>
						</table>
					</div>
				
					<div>
						<button type = "submit">login</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>