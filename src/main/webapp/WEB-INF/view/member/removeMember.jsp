<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 탈퇴</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>회원 탈퇴</h1>
			</div>
			
			<div>
				<form action = "${pageContext.request.contextPath }/member/removeMember" method = "post" >
					<div>
						<table border = "1">
							<tr>
								<th>Password</th>
								<td>
									<input type = "password" name = "memberPw" id = "memberPw">
								</td>
							</tr>
						</table>
					</div>
					
					<div>
						<button type = "submit">탈퇴</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>