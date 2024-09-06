package college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/viewTeachers")
public class viewTeachers extends GenericServlet {

	public void service(ServletRequest rq, ServletResponse rs) throws ServletException, IOException {
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
		
		out.print("<html>\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <title>View Teachers</title>\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
				+ "     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
				+ "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
				+ "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
				+ "    <script src=\"https://kit.fontawesome.com/006b0b0b8d.js\" crossorigin=\"anonymous\"></script>"
				+ "	<style type=\"text/css\">\r\n"
				+ "				@media print\r\n"
				+ "				{\r\n"
				+ "					body*{\r\n"
				+ "						visibility: hidden;\r\n"
				+ "					}\r\n"
				+ "					.print-container, .print-container *{\r\n"
				+ "						visibility: visible;\r\n"
				+ "					}\r\n"
				+ "					.print-container{\r\n"
				+ "						position: absolute;\r\n"
				+ "						left: 0;\r\n"
				+ "						top: 0;\r\n"
				+ "					}\r\n"
				+ "					a{\r\n"
				+ "						visibility: hidden;\r\n"
				+ "					}\r\n"
				+ "				}\r\n"
				+ "			</style> "
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<nav class=\"navbar navbar-light bg-light\">\r\n"
				+ "  <a class=\"navbar-brand\" style=\"margin-left: 50px;\">College Management System</a>\r\n"
				+ "  <form class=\"form-inline\">\r\n"
				+ "    <a class=\"btn btn-danger my-2 my-sm-0\" href=\"http://localhost:8080/CollegeManagement/index.jsp\" style=\"color: white;\">Log Out</a>"
				+ "  </form>\r\n"
				+ "</nav>\r\n"
				+ "<a href=\"dashboard.jsp\"> << Back </a>"
				+ "<div class=\"text-info text-center txt-md\"><h2>Teacher Details</h2></div>    "
				);
		out.print("<div style=\"margin-top:0px\">\r\n"
				+ "<div class=\"container\" style=\"padding-top: 3rem;\">\r\n"
				+ "<div class=\"container\">\r\n"
				+ "    <br>\r\n"
				+ "		<button type=\"button\" class=\"btn btn-outline-secondary\" onclick=\"window.print();\" style=\"\">Print</button> "
				+ "    <div class=\"table-responsive\" style=\"padding-right: 10px;\">\r\n"
				+ "    <table class=\"table table-bordered table-stripped table-hover\">\r\n"
				+ "        <tr>\r\n"
				+ "          <th>id</th>\r\n"
				+ "          <th>Name</th>\r\n"
				+ "          <th>Mobile No</th>\r\n"
				+ "          <th>Email ID</th>\r\n"
				+ "          <th>Address</th>\r\n"
				+ "          <th>Education</th>\r\n"
				+ "          <th>Gender</th>\r\n"
				+ "          <th>Joining Date</th>\r\n"
				+ "          <th>Action</th>\r\n"
				+ "        </tr>");
		String sql="select * from teachers;";
		ResultSet res=stmt.executeQuery(sql);
		
		while(res.next())
		{
			out.println(""
					
+"<tr>"
+"<td>"+res.getString(1)+"</td>"
+"<td>"+res.getString(2)+"</td>"
+"<td>"+res.getString(3)+"</td>"
+"<td>"+res.getString(4)+"</td>"
+"<td>"+res.getString(5)+"</td>"
+"<td>"+res.getString(6)+"</td>"
+"<td>"+res.getString(7)+"</td>"
+"<td>"+res.getString(8)+"</td>"
						
+"<td>"
	+"<form action=\"http://localhost:8080/CollegeManagement/Updateteacher\" method=\"post\">"
	+"<button type=\"submit\" style=\"border:none;\">"
		+"<i class=\"far fa-edit fa-sm\" style=\"color: blue;\"></i>"
		+"<input type=\"hidden\" name=\"teaid\" value="+res.getString(1)+">"
	+"</button></form>"

	+"<form action=\"http://localhost:8080/CollegeManagement/DeleteTeacher\" method=\"post\">"
	+"<button type=\"submit\" style=\"border:none;\">"
		+"<i class=\"fas fa-trash-alt fa-sm\" style=\"color: red;\"></i>"
		+"<input type=\"hidden\" name=\"teaid\" value='"+res.getString(1)+"'>"
	+"</button></form>"
+"</td>"
	
+"</tr>"  
					
					);
		
			System.out.println("<tr>"+res.getString(1)+" \t "+res.getString(2)+"</tr>");
		}
					
		conn.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
 
}
