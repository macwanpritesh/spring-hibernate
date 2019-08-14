<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="insertUser" modelAttribute="userBean" method="post">
		<table>
		
			<tr>
				<td><b>Name</td>
				<td><f:input path="name"/></td>
			</tr>
			
			<tr>
				<td><b>Email-Id</td>
				<td><f:input path="emailId"/></td>
			</tr>
			
			<tr>
				<td><b>Password</td>
				<td><f:password path="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="LogIn"></td>
			</tr>
		</table>
	</f:form>
</body>
</html>