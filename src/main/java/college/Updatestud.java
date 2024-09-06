package college;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Updatestud")
public class Updatestud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		rs.setContentType("text/html");
		PrintWriter out=rs.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//Load the driver class
			String url="jdbc:mysql://localhost/collegemanagementdb";	//Create the connection
			String usern="root";
			String pasw="";
			Connection conn;
			conn = DriverManager.getConnection(url,usern,pasw);
			System.out.println("Connected To Database");
			Statement stmt= conn.createStatement(); 	//Create the statement object
			
			String studId=""+rq.getParameter("studId");
			String sql= "SELECT * FROM `students` WHERE id='"+studId+"';";
			System.out.print(sql);
			ResultSet res=stmt.executeQuery(sql);
			res.next();
			String stud_name=""			+res.getString(2);
			String enrl_no=""			+res.getString(3);
			String mobile_no=""			+res.getString(4);
			String email_id=""			+res.getString(5);
			String address=""			+res.getString(6);
			String stud_gender=""		+res.getString(7);
			String admission_date=""	+res.getString(8);
			String dob = ""				+res.getString(9); 
//			
//			
			
			
			
			out.print("<html>\r\n"
					+ "<head>\r\n"
					+ "	<meta charset=\"utf-8\">\r\n"
					+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "	<title>Add Students</title>\r\n"
					+ "	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<nav class=\"navbar navbar-light bg-light\">\r\n"
					+ "  <a class=\"navbar-brand\" style=\"margin-left: 50px;\">College Management System</a>\r\n"
					+ "  <form class=\"form-inline\">\r\n"
					+ "    <a class=\"btn btn-danger my-2 my-sm-0\" href=\"http://localhost:8080/CollegeManagement/index.jsp\" style=\"color: white;\">Log Out</a>\r\n"
					+ "  </form>\r\n"
					+ "</nav>\r\n"
					+ "<a href=\"dashboard.jsp\"> << Back </a>\r\n"
					+ "<div style=\"\">\r\n"
					+ "    <div class=\"text-info text-center txt-md\"><h2>Updation form for student</h2></div>   \r\n"
					+ "    <div class=\"container\">\r\n"
					+ "        <table class=\"table table-hover\">\r\n"
					+ "            <form action=\"http://localhost:8080/CollegeManagement/Stupdate\" class=\"form\" method=\"POST\">\r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">Student name:</label></td>\r\n"
					+ "                   <td><input type=\"text\" class=\"form-control\" id=\"stud_name\" name=\"stud_name\" value=\""+stud_name+"\"></td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">Enrollment number:</label></td>\r\n"
					+ "                   <td><input type=\"Mobile\" class=\"form-control\" id=\"mobile_no\" name=\"enrl_no\" value=\""+enrl_no+"\"></td>\r\n"
					+ "                </tr> \r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">Mobile number:</label></td>\r\n"
					+ "                   <td><input type=\"Mobile\" class=\"form-control\" id=\"mobile_no\" name=\"mobile_no\" value=\""+mobile_no+"\"></td>\r\n"
					+ "                </tr> \r\n"
					+ "                 <tr>\r\n"
					+ "                   <td><label class=\"label\">Email id:</label></td>\r\n"
					+ "                   <td><input type=\"Email\" class=\"form-control\" id=\"email_id\" name=\"email_id\" value=\""+email_id+"\"></td>\r\n"
					+ "                </tr>   \r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">Address:</label></td>\r\n"
					+ "                   <td><input type=\"address\" class=\"form-control\" id=\"address\" name=\"address\" value=\""+address+"\"></td>\r\n"
					+ "                </tr>  \r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label>Gender:</label></td>\r\n"
					+ "                   <td> <input type=\"radio\" id=\"stud_gender\" name=\"stud_gender\" value=\"male\" checked>Male\r\n"
					+ "                        <input type=\"radio\" id=\"stud_gender\" name=\"stud_gender\" value=\"female\">Female\r\n"
					+ "                   </td>\r\n"
					+ "                </tr> \r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">DOB:</label></td>\r\n"
					+ "                   <td><input type=\"date\" class=\"form-control\" id=\"dob\" name=\"dob\" value=\""+dob+"\"></td>\r\n"
					+ "                </tr>\r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label class=\"label\">Admission Date:</label></td>\r\n"
					+ "                   <td><input type=\"date\" class=\"form-control\" id=\"admission\" name=\"admission_date\" value=\""+admission_date+"\"></td>\r\n"
					+ "                </tr> \r\n"
					+ "                <tr>\r\n"
					+ "                   <td><label>Profile pic:</label></td>\r\n"
					+ "                   <td><input type=\"file\" id=\"profile_pic\" name=\"file\" id=\"file\"> </td>\r\n"
					+ "                </tr>   \r\n"
					+ "                <tr>\r\n"
					+ "                  <div class=\"container col-lg-6 \">\r\n"
					+ "                     <td><input type=\"submit\" name=\"submit\" value=\"Update\" class=\"btn btn-success\"></td>\r\n"
					+"							<input type=\"hidden\" name=\"studId\" value="+res.getString(1)+">"
					+ "                     <td><input type=\"reset\" name=\"reset\" value=\"Reset\" class=\"btn btn-danger\"></td>\r\n"
	
					+ "                  </div>\r\n"
					+ "                </tr>   \r\n"
					+ "            </form>\r\n"
					+ "        </table>\r\n"
					+ "    </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "</html>"
					+ ""
					+ "");
			
			
			
			
			
			
			
			
			
			
			
//			String sql= "INSERT INTO students( `Name`, `Enrollment_no`, `mobile_no`, `email_id`, `address`, `gender`,`admission_date`,`dob`) VALUES('"+stud_name+"','"+enrl_no+"','"+mobile_no+"','"+email_id+"','"+address+"','"+stud_gender+"','"+admission_date+"','"+dob+"');";
//			sql="UPDATE students set Name='"+stud_name+"'+',mobile_no='"+stud_name+"' ";
//			stmt.executeUpdate(sql);
//			out.println("<html><head><title></title></head><body>  ");
//			out.println("<script>alert(\"Student Record Updating\");location.replace(\"http://localhost:8080/CollegeManagement/addStudents.jsp\"); </script>");
			out.println("</body></html>");
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
