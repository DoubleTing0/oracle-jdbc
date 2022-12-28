<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div>
	<a href = "${pageContext.request.contextPath }/member/logout">1) 로그아웃</a>
</div>
<div>
	<a href = "${pageContext.request.contextPath }/member/memberOne">2) 회원정보</a>
</div>
<div>
	<a href = "${pageContext.request.contextPath }/board/boardList">3) 게시판리스트</a>
</div>