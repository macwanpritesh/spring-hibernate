<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="insertExam" modelAttribute="ExamBean" method="post">
	<table>
		<tr>
			<td><b>SubName:</td>
			<td><f:input path="title"/></td>
		</tr>	
		
		<tr>
			<td><b>Date:</td>
			<td><f:input path="date"/></td>
		</tr>	
	
		<tr>
			<td><b>TotalMarks:</td>
			<td><f:input path="totalMarks"/></td>
		</tr>
		
		<tr>
			<td><b>TimeDuration:</td>
			<td><f:input path="duration"/></td>
		</tr>
		
			<tr>
			<td><b>ExamCode:</td>
			<td><f:input path="examCode"/></td>
			
		</tr>
		
		
		<tr>
		<td><input type="submit" value="Submit"></td>
		</tr>
	
	
	
	</table>



</f:form>
</body>
</html>