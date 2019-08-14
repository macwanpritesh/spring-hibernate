<%@ page language="java"  isELIgnored="false"   contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>examid</td>
		<td>Date</td>
		<td>Duration</td>
		<td>ExamCode</td>
		<td>Title</td>
		<td>TotalMarks</td>
		<td colspan="2">Action</td>
	</tr>
<f:forEach items="${examList}" var="i">
	<tr>
		<td>${i.examid}</td>
		<td>${i.date}</td>
		<td>${i.duration}</td>
		<td>${i.examCode}</td>
		<td>${i.title}</td>
		<td>${i.totalMarks}</td>
		<td><a href="deleteExam/${i.examid}">Delete</a></td>
		<td><a href="editExam/${i.examid}">Edit</a></td>
	</tr>
</f:forEach>	


</table>
</body>
</html>