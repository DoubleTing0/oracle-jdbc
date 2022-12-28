<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MODIFY MEMBER</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>회원정보 수정</h1>
			</div>
			
			<div>
				<form action = "${pageContext.request.contextPath }/member/modifyMember" method = "post">
					<div>
						<table border = "1">
							<tr>
								<th>memberId</th>
								<td>
									<input type = "text" name = "memberId" id = "memberId" value = "${loginMember.memberId }" readonly = "readonly">
								</td>
							</tr>
							<tr>
								<th>memberName</th>
								<td>
									<input type = "text" name = "memberName" id = "memberName" value = "${loginMember.memberName }">
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