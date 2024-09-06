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

@WebServlet("/Teacherupdate")
public class Teacherupdate extends HttpServlet {
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
			
	
			String teaid = ""			+rq.getParameter("teaid");
			String tea_name=""			+rq.getParameter("tea_name");
			String mobile_no=""			+rq.getParameter("mobile_no");
			String email_id=""			+rq.getParameter("email_id");
			String address=""			+rq.getParameter("address");
			String education=""			+rq.getParameter("education");
			String tea_gender=""		+rq.getParameter("tea_gender");
			String join_date=""	+rq.getParameter("join_date");
			
			String sql= "UPDATE `teachers` SET `Name`='"+tea_name+"',`mobile_no`='"+mobile_no+"',`email_id`='"+email_id+"',`address`='"+address+"',`education`='"+education+"',`gender`='"+tea_gender+"',`join_date`='"+join_date+"' WHERE `id` = "+teaid+";";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			out.println("<html><head><title></title></head><body>  ");
			out.println("<script>alert(\"Teacher Record updated\");location.replace(\"http://localhost:8080/CollegeManagement/viewTeachers\"); </script>");
			out.println("</body></html>");
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
