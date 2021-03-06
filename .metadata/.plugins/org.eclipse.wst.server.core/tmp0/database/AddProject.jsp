<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Add Project</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>
<body>
 	<a href="Table" class="btn btn-default" role="button">Go back to Main Menu</a><br/>
	<h1>Add a new Project</h1>
	<form action="AddProject" method="post">
		Sponsor name <input type="text" class="form-control" id="sponsorName" name="sponsorName" placeholder="Enter sponsor's name">
		Starting date <input type="text" class="form-control" id="startingDate" name="startingDate" placeholder="Enter starting date">
		Ending date <input type="text" class="form-control" id="endingDate" name="endingDate" placeholder="Enter ending date">
		<br/>
		<button type="submit" class="btn btn-success btn-block">Add Project</button>
	</form>

</body>
</html>