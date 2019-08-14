<%@ page language="java"  isELIgnored="false"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<f:form action="insertQuestion" modelAttribute="questionBean" method="post">

<b>Select Sub</b>:
<f:select path="examid">
<f:options items="${examList}" itemLabel="title" itemValue="examid"/>	
</f:select>
QueName:<f:input path="QueName"/><br>
Que1:
<f:input path="question"/><br>
Options:
<f:input path="opt1"/><br>
<f:input path="opt2"/><br>
<f:input path="opt3"/><br>
<f:input path="opt4"/><br>
Answer:
<f:input path="answer"/><br>
<input type="submit" value="Submit"><br>
<a href="exit">Exit</a>
</f:form>

</body>
</html>