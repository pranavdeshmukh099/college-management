<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Teacher</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" style="margin-left: 50px;">College Management System</a>
  <form class="form-inline">
    <a class="btn btn-danger my-2 my-sm-0" href="http://localhost:8080/CollegeManagement/index.jsp" style="color: white;">Log Out</a>
  </form>
</nav>
<a href="dashboard.jsp"> << Back </a>
<div style="">
    <div class="text-info text-center txt-md"><h2>Registration form for teachers</h2></div>   
    <div class="container">
        <table class="table table-hover">
            <form action="http://localhost:8080/CollegeManagement/AddTeachers" class="form" method="POST" >
                <tr>
                   <td><label class="label">Teacher name:</label></td>
                   <td><input type="text" class="form-control" id="stud_name" name="teacher_name"  maxlength="32"></td>
                </tr>
                <tr>
                   <td><label class="label">Mobile number:</label></td>
                   <td><input type="number" class="form-control" id="mobile_no" name="mobile_no" pattern="[0-9]{10}" oninvalid="please enter 10 digit number"></td>
                </tr>  
                <tr>
                   <td><label class="label">Email id:</label></td>
                   <td><input type="text" class="form-control" id="email_id" name="email_id" pattern=".+@gmail\.com" oninvalid="please enter valid mail id."></td>
                </tr>  
                <tr>
                   <td><label class="label">Address:</label></td>
                   <td><input type="text" class="form-control" id="address" name="address" required></td>
                </tr>   
         
                <tr>
                   <td><label class="label">Education:</label></td>
                   <td><input type="text" class="form-control" id="t_education" name="t_education" required></td>
                </tr>  
                <tr>
                   <td><label>Gender:</label></td>
                   <td> <input type="radio" id="gender" name="gender" value="male">Male
                        <input type="radio" id="gender" name="gender" value="female">Female
                   </td>
                </tr> 
                <tr>
                   <td><label class="label">Join Date:</label></td>
                   <td><input type="date" class="form-control" id="join_date" name="join_date" required></td>
                </tr>   
                <tr>
                   <td><label>Profile pic:</label></td>
                   <td><input type="file" id="profile_pic" name="file" id="file"> </td>
                </tr>   
                <tr>
                  <div class="container col-lg-6 ">
                     <td><input type="submit" name="submit" value="Submit" class="btn btn-success"></td>
                     <td><input type="button" name="reset" value="Reset" class="btn btn-danger"></td>

                  </div>
                </tr>   
            </form>
        </table>
    </div>
</div>

</body>
</html>