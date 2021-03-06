<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Add Student</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>
<body>
 	<a href="Table" class="btn btn-default" role="button">Go back to Main Menu</a><br/>
	<h1>Add a new Student</h1>
	<form action="AddStudent" method="post">
		SSN <input type="text" class="form-control" id="ssn" name="ssn" placeholder="Enter student's ssn">
		Name <input type="text" class="form-control" id="name" name="name" placeholder="Enter students's name">
		Age <input type="text" class="form-control" id="age" name="age" placeholder="Enter age">
		Gender <input type="text" class="form-control" id="gender" name="gender" placeholder="Enter gender">
		Degree program <input type="text" class="form-control" id="degree" name="degree" placeholder="Enter student's degree program">
		<br/>
		<button type="submit" class="btn btn-success btn-block">Add Project</button>
	</form>

</body>
</html>