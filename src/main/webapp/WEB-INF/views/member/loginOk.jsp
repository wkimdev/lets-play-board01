<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> MEMBER LOGIN OK CHECK </h1>
	
	ID : ${memberVO.memId}<br />
	PW : ${memberVO.memPw}<br />
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="${cp}/"> MAIN </a>
</body>
</html>