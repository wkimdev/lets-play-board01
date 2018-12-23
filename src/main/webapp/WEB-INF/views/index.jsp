<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main page!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<%-- <P> ${} 님 환영합니다.</P> --%>
<P>login button</P>
<P>join button</P>
<p>member list</p>
<!-- db에 있는 id list 가져오기 -->
ID : ${member.memId} </br> 
</body>
</html>
