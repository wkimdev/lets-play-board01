<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	
	<h1>MEMBER REMOVE Page</h1>
	
	<form:form action="${cp}/members/remove" method="post" commandName="memberVO">
		<input type="hidden" name="memId" value="${memberVO.memId}">
		<table>
			<tr>
				<td>ID</td>
				<td>${memberVO.memId}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Remove" ></td>
			</tr>
		</table>
	</form:form>
	
	<a href="${cp}/">MAIN</a>
</body>
</html>