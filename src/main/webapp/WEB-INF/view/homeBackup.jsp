<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HOME</title>
	</head>
	
	<body>
		<div>
			<c:choose>
				<c:when test="${loginMember == null }">
					<!-- logoutMenu -->
					<div>
						<jsp:include page = "/WEB-INF/inc/logoutMenu.jsp"></jsp:include>
					</div>
				</c:when>
				
				<c:otherwise>
					<!-- loginMenu -->
					<div>
						<jsp:include page = "/WEB-INF/inc/loginMenu.jsp"></jsp:include>
					</div>
				
					<div>
						<h1>${loginMember.memberName}님 어서오세요!</h1>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>