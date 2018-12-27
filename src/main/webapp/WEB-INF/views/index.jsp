<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main Board page!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%-- <P> ${} 님 환영합니다.</P> --%>

<!-- db에 있는 id list 가져오기 -->

	<c:if test="${empty memberVO}">
		<a href="${cp}/members/memberJoin">memberjoin form</a> &nbsp;&nbsp;
		<a href="${cp}/members/loginForm">LOGIN</a> &nbsp;&nbsp;
	</c:if> 
	
	<c:if test="${!empty memberVO}">
		<a href="${cp}/members/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/members/modifyForm">modify form</a> &nbsp;&nbsp;
		<a href="${cp}/members/memberRemoveForm">remove form</a> &nbsp;&nbsp;
	</c:if> 
</body>
</html>
