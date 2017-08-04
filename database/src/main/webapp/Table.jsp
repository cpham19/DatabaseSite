<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
	<title>Faculty</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">	
</head>
<body>	
	<a href="AddFaculty.jsp" class="btn btn-primary" role="button">Add Faculty Member</a><a href="AddProject.jsp" class="btn btn-primary" role="button">Add Project</a><a href="AddStudent.jsp" class="btn btn-primary" role="button">Add Student</a>

	<h1>Table of Faculty Members</h1>
	<c:if test="${empty faculties}">
		<div class="jumbotron">
			<h1>Oh no! <small>There are no faculty members to display.</small></h1>
		</div>
	</c:if>
	
	<c:if test="${not empty faculties}">
		<c:forEach items="${faculties}" var="faculty">
			<div class="panel panel-default">
	 			<div class="panel-body">
					<h3>${faculty.name} (${faculty.res_spec}) 
					 <a href="ViewProfessorProject?name=${faculty.name}&ssn=${faculty.ssn}" class="btn btn-primary" role="button">View Projects</a><a href="DeleteFaculty?id=${faculty.id}&ssn=${faculty.ssn}" class="btn btn-danger" role="button">Delete Faculty</a>
					 <br/>
					</h3>
					<p>Gender: ${faculty.gender} | Age: ${faculty.age} | SSN : ${faculty.ssn}</p>
					<form action="AddProjectToProf" method="post">
							<input type="text" id="prof_ssn" name="prof_ssn" value="${faculty.ssn}"> 	
							<input type="text" id="proj_num" name="proj_num" placeholder="Enter project number"> 			
							<button type="submit" class="btn btn-success btn-block">Add Faculty to Project</button>
					</form>
			    </div>
			</div>
		</c:forEach>
	</c:if>

	<br/>
	<br/>
	<br/>
	<br/>

    <h1>Table of Projects</h1>
	<c:if test="${empty projects}">
		<div class="jumbotron">
			<h1>Oh no!<small>There are no projects to display.</small></h1>
		</div>
	</c:if>
	
	<c:if test="${not empty projects}">
		<c:forEach items="${projects}" var="project">
 			<div class="pane panel-default">
				 <div class = "pane panel-heading"><h1>Project#${project.projectNum} ${project.sponsorName} | Start: ${project.startingDate}  End: ${project.endingDate} <a href="ViewStudent?proj_num=${project.projectNum}&spon_name=${project.sponsorName}" class="btn btn-primary" role="button">View Students</a><a href="ViewNumberOfPeople?proj_num=${project.projectNum}" class="btn btn-success" role="button">View Number</a><a href="DeleteProject?id=${project.projectNum}" class="btn btn-danger" role="button">Delete Project</a></h1></div>
			</div>
		</c:forEach>
	</c:if>
	
	<br/>
	<br/>
	<br/>
	<br/>

    <h1>Table of Students</h1>
	<c:if test="${empty students}">
		<div class="jumbotron">
			<h1>Oh no!<small>There are no projects to display.</small></h1>
		</div>
	</c:if>
	
	<c:if test="${not empty students}">
		<c:forEach items="${students}" var="student">
 			<div class="pane panel-default">
				 <div class = "pane panel-heading">
				 		<h3>${student.name}
				 			<a href="DeleteStudent?id=${student.id}&ssn=${student.ssn}" class="btn btn-danger" role="button">Delete Student</a>	 
				 		</h3>
				 		<p>Gender: ${student.gender} | Age: ${student.age} | SSN : ${student.ssn}</p>
				 		<form action="AddProjectToStud" method="post">
								<input type="text" id="stud_ssn" name="stud_ssn" value="${student.ssn}"> 	
								<input type="text" id="proj_num" name="proj_num" placeholder="Enter project number"> 			
								<button type="submit" class="btn btn-success btn-block">Add Student to Project</button>
						</form>
				 </div>
			</div>
		</c:forEach>
	</c:if>

</body>
</html>