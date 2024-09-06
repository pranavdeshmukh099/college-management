package college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends GenericServlet {
	
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
			
			
			String teaid=""+rq.getParameter("teaid");
			out.print("studId is "+teaid);
			String sql= "DELETE FROM `teachers` WHERE id='"+teaid+"';";
			stmt.executeUpdate(sql);
			out.println("<html><head><title></title></head><body>  ");
			out.println("<script>alert(\"Teacher Record Deleted\");location.replace(\"http://localhost:8080/CollegeManagement/viewTeachers\"); </script>");
			out.println("</body></html>");
			
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		
		
	}
}
