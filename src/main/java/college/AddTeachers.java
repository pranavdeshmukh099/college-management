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

@WebServlet("/AddTeachers")
public class AddTeachers extends HttpServlet {
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
			
			
			String teacher_name=""+rq.getParameter("teacher_name");
			String mobile_no=""+rq.getParameter("mobile_no");
			String email_id=""+rq.getParameter("email_id");
			String address=""+rq.getParameter("address");
			String t_education=""+rq.getParameter("t_education");
			String gender=""+rq.getParameter("gender");
			String join_date=""+rq.getParameter("join_date");
			String sql= "INSERT INTO teachers( `Name`, `mobile_no`, `email_id`, `address`, `education`, `gender`, `join_date`) VALUES ('"+teacher_name+"','"+mobile_no+"','"+email_id+"','"+address+"','"+t_education+"','"+gender+"','"+join_date+"');";
			stmt.executeUpdate(sql);
			out.println("<html><head><title></title></head><body>  ");
			out.println("<script>alert(\"Teacher Record Inserted\");location.replace(\"http://localhost:8080/CollegeManagement/addTeachers.jsp\"); </script>");
			out.println("</body></html>");
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
