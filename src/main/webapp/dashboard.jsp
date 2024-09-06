<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  	.table{
  		margin-left: 400px;
  		width: 50rem;
  	}
  </style>
</head>
<body>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" style="margin-left: 50px;">College Management System</a>
  <form class="form-inline">
  <a class="btn btn-danger my-2 my-sm-0" href="http://localhost:8080/CollegeManagement/index.jsp" style="color: white;">Log Out</a>
  </form>
</nav>
<center><h5>Welcome back</h5></center>
<br><br>
<center><h1>Dashboard</h1></center>
<br>
<table class="table table-striped table-bordered">
	<tr>
		<td>To add Students click here.</td>
		<td><a href="addStudents.jsp"><button class="btn btn-success">Add Students</button></a></td>
	</tr>
	<tr>
		<td>View Student Information.</td>
		<td><a href="http://localhost:8080/CollegeManagement/viewStudents"><button class="btn btn-outline-danger">Student Information</button></a></td>
	</tr>
	<tr>
		<td>To add Teachers click here.</td>
		<td><a href="addTeachers.jsp"><button class="btn btn-secondary">Add Teachers</button></a></td>
	</tr>
	<tr>
		<td>View techers information.</td>
		<td><a href="http://localhost:8080/CollegeManagement/viewTeachers"><button class="btn btn-outline-danger">Teachers Information</button></a></td>
	</tr>
</table>
</body>
</html>