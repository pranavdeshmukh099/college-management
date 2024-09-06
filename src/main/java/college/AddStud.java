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

@WebServlet("/AddStud")
public class AddStud extends HttpServlet {
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
			
			
			String stud_name=""+rq.getParameter("stud_name");
			String enrl_no=""+rq.getParameter("enrl_no");
			String mobile_no=""+rq.getParameter("mobile_no");
			String email_id=""+rq.getParameter("email_id");
			String address=""+rq.getParameter("address");
			String stud_gender=""+rq.getParameter("stud_gender");
			String admission_date=""+rq.getParameter("admission_date");
			String dob=""+rq.getParameter("dob");
			
			
			String sql= "INSERT INTO students( `Name`, `Enrollment_no`, `mobile_no`, `email_id`, `address`, `gender`,`admission_date`,`dob`) VALUES('"+stud_name+"','"+enrl_no+"','"+mobile_no+"','"+email_id+"','"+address+"','"+stud_gender+"','"+admission_date+"','"+dob+"');";
			stmt.executeUpdate(sql);
			out.println("<html><head><title></title></head><body>  ");
			out.println("<script>alert(\"Student Record Inserted\");location.replace(\"http://localhost:8080/CollegeManagement/addStudents.jsp\"); </script>");
			out.println("</body></html>");
			out.close();
			conn.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
