<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>member join page</title>
</head>
<body>

	<form action="" method="post" >
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memId" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="Name" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:input path="memPW" /></td>
			</tr>
			<tr>
				<td>Mail</td>
				<td><form:input path="Mail" /></td>
			</tr>
			
		</table>
	</form>

</body>
</html>
