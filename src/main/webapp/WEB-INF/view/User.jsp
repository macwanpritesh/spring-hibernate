<%@ page language="java" isELIgnored="false"    contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="enterExam"  modelAttribute="examBean" method="post">
	<table>
			<tr>
				<td><b>Enter a SubjectCode:
				<td><f:select path="examid">
							<f:options items="${examList}" itemLabel="examCode" itemValue="examid"/> 
					</f:select>
				</td>	
			</tr>
			
			<tr>
				<td><input type="submit" value="SUBMIT">
			</tr>
	</table>
</f:form>

</body>
</html>