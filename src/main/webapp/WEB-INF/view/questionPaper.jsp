
<%@page import="java.util.ArrayList"%>
<%@ page language="java" isELIgnored="false"   contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
  <%@taglib prefix="j" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<f:form  action="finishExam" modelAttribute="userExam" method="post">

<table  border="1" align="center">
<tr><td><b>ExamCode:</td><td>${userExam.userExams[0].examBean.examCode}</td>
	<td><b>ExamName:</td><td>${userExam.userExams[0].examBean.title}</td>
	<td rowspan="2"><b>Marks:</td><td rowspan="2">${userExam.userExams[0].examBean.totalMarks}</td>
	
</tr>

<tr>
	<td><b>ExamDate:</td><td>${userExam.userExams[0].examBean.date}</td>
	<td><b>Duration:</td><td>${userExam.userExams[0].examBean.duration}mint</td>
</tr>
<j:forEach items="${userExam.userExams}" var="i" varStatus="status">
<tr>
	<td rowspan="2">${i.questionBean.queName}:</td>
	<td colspan="5">${i.questionBean.question}</td>
</tr>
<tr>	
	<input type="hidden" name="userExams[${status.index}].questionBean.queId" value="${i.questionBean.queId}"/>
	<input type="hidden" name="userExams[${status.index}].examBean.examid" value="${i.examBean.examid}"/>
	<input type="hidden" name="userExams[${status.index}].userBean.userId" value="${i.userBean.userId}"/>
	<input type="hidden" name="userExams[${status.index}].questionBean.answer" value="${i.questionBean.answer}"/>
	<td>${i.questionBean.opt1}<input type="radio" name="userExams[${status.index}].userAns" value="opt1"></td>
	<td>${i.questionBean.opt2}<input type="radio" name="userExams[${status.index}].userAns" value="opt2"></td>
	<td>${i.questionBean.opt3}<input type="radio" name="userExams[${status.index}].userAns" value="opt3"></td>
	<td colspan="2">${i.questionBean.opt4}<input type="radio" name="userExams[${status.index}].userAns" value="opt4"></td>
</tr>
</j:forEach>
<tr>
<td colspan="6" align="center">
<input type="submit" value="Submit">
</td>
</tr>
</table>
</f:form>

	
</body>
</html>