package college;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Neww {

	public static void main(String[] args)throws Exception {
	
			Class.forName("com.mysql.cj.jdbc.Driver");	//Load the driver class
			String url="jdbc:mysql://localhost/collegemanagementdb";	//Create the connection
			String usern="root";
			String pasw="";
			Connection conn;
			conn = DriverManager.getConnection(url,usern,pasw);
			System.out.println("Connected To Database");
			Statement stmt= conn.createStatement(); 	//Create the statement object
			String sql="select * from teachers;";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(""+rs.getString(1)+" \t "+rs.getString(2));
			}
						
			conn.close();
	}

}
