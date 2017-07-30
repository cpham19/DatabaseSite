<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Students</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>
<body>
 	<a href="Table" class="btn btn-default" role="button">Go back to Main Menu</a><br/>

	<h1>These are the students who are working on the project sponsored by ${sponsor} </h1>
	<c:if test="${empty students}">
		<div class="jumbotron">
			<h1>Oh no! <small>There are no students in this project.</small></h1>
		</div>
	</c:if>

	<c:if test="${not empty students}">
		<c:forEach items="${students}" var="student">
 			<div class="pane panel-default">
				 <div class = "pane panel-heading"><h1>${student.name}</h1></div>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>