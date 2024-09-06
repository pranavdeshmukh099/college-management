package college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {

	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException{
		
		rs.setContentType("text/html");
		PrintWriter out=rs.getWriter();
		String username=""+rq.getParameter("uname");
		String password=""+rq.getParameter("psw");	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//Load the driver class
			String url="jdbc:mysql://localhost/collegemanagementdb";	//Create the connection
			String usern="root";
			String pasw="";
			Connection conn;
			conn = DriverManager.getConnection(url,usern,pasw);
			System.out.println("Connected To Database");
			Statement stmt= conn.createStatement(); 	//Create the statement object
//			String sql= "SELECT admin_name,password FROM admin WHERE admin_name='abhi'AND password='abhi';";
			String sql= "SELECT * FROM admin";
			ResultSet rs1=stmt.executeQuery(sql);
			boolean match = false;
			while(rs1.next())
			{
				String usn=rs1.getString(2);
				String pass=rs1.getString(3);
				if(username.equals(usn) && password.equals(pass))
				{
					match = true;
					break;
				}
				else {
					match = false;
				}
			}
			out.println("<html><head><title></title></head><body>  ");
			if(match)
			{
				out.println("<script type=\"text/javascript\"> "+
			"location.replace(\"http://localhost:8080/CollegeManagement/dashboard.jsp\"); </script>");
			}
			else {
				out.println("<script type=\"text/javascript\"> alert(\"Please enter valid name or password\"); "+
						"location.replace(\"http://localhost:8080/CollegeManagement/index.jsp\"); </script>");
			}
			
			out.println("</body></html>");
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		
		
	}
}
