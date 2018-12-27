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

<h1>member modify</h1>

<form:form action="${cp}/members/modify" method="post" commandName="memberVO">
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
			<td>MAIL</td>
			<td><form:input path="memMail" value="${memberVO.memMail}" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Modify"></td>
		</tr>	
	</table>
</form:form>

</body>
</html>