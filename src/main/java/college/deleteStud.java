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

@WebServlet("/deleteStud")
public class deleteStud extends GenericServlet {
	
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
			
			
			String studId=""+rq.getParameter("studId");
			out.print("studId is "+studId);
			String sql= "DELETE FROM `students` WHERE id='"+studId+"';";
			stmt.executeUpdate(sql);
			out.println("<html><head><title></title></head><body>  ");
			out.println("<script>alert(\"Student Record Deleted\");location.replace(\"http://localhost:8080/CollegeManagement/viewStudents\"); </script>");
			out.println("</body></html>");
			
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		
		
	}
}
