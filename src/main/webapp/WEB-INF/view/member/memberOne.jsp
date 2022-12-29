<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MEMBER ONE</title>
	</head>
	
	<body>
		<div>
			<div>
				<h1>회원 정보</h1>
			</div>
		
		
			<div>
				<a href = "${pageContext.request.contextPath }/member/checkPassword?targetUrl=/member/modifyMember">1) 회원정보수정</a>
			</div>
			<div>
				<a href = "${pageContext.request.contextPath }/member/checkPassword?targetUrl=/member/removeMember">2) 회원탈퇴</a>
			</div>
			
			<div>
				<table border = "1">
					<tr>
						<th>memberID</th>
						<td>${loginMember.memberId }</td>
					</tr>
					<tr>
						<th>memberName</th>
						<td>${loginMember.memberName }</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>