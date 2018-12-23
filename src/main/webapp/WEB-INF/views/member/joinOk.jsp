<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> MEMBER JOIN OK </h1>
	
	ID : ${memberVO.memId} <br />
	PW : ${memberVO.memPw} <br />
	Mail : ${memberVO.memMail} <br />
	
	<a href="${cp}/"> MAIN </a>
</body>
</html>
