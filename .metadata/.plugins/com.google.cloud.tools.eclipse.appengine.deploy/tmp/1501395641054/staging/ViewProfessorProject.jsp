<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Read It</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>
<body>
 	<a href="Table" class="btn btn-default" role="button">Go back to Main Menu</a><br/>

	<h1>This is ${name}'s Projects</h1>
	<c:if test="${empty projects}">
		<div class="jumbotron">
			<h1>Oh no! <small>This professor has no projects.</small></h1>
		</div>
	</c:if>

	<c:if test="${not empty projects}">
		<c:forEach items="${projects}" var="project">
 			<div class="pane panel-default">
				 <div class = "pane panel-heading"><h1>Project#${project.projectNum} ${project.sponsorName} | Start: ${project.startingDate}  End: ${project.endingDate}</h1></div>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>