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

	<h1>This the number of people working on this project. </h1>
	<c:if test="${empty count}">
		<div class="jumbotron">
			<h1>Oh no! <small>There is none.</small></h1>
		</div>
	</c:if>

	<c:if test="${not empty count}">
 			<div class="pane panel-default">
				 <div class = "pane panel-heading"><h1>${count}</h1></div>
			</div>
	</c:if>
</body>
</html>