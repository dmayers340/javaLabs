import java.sql.*;

public class MainJDBC 
{
	//make connection	
	private static Connection connection = null;
	public static void main(String[] args)
	{
		
		JDBCGUI gui = new JDBCGUI();
		gui.showGUI(); 
		gui.setVisible(true);
		
		
		String databaseName = "m_17_2067887m";
		String userName = "m_17_2067887m";
		String password = "2067887m";
		
		//attempt to connect to database
		try 
		{
			connection =
			DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/" +
			databaseName,userName, password);
		}
		
		catch (SQLException e) 
		{
			System.err.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		//determine if connection was successful
		if(connection != null)
		{
			System.out.println("Connection Successful!");
		}
		else
		{
			System.err.println("Failed to make connection!");
		}
		
		//First: View all courses, instructor teaching, capacity of course, no members booked on
		Statement stmt = null;
		String query = "SELECT gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname, COUNT(gym.booking.membershipnumber) FROM gym.course LEFT JOIN gym.instructor ON gym.course.instructorid = gym.instructor.instructorid INNER JOIN gym.booking ON gym.course.courseid = gym.booking.courseid GROUP BY gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname";
		try
		{
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) 
			{
				String course_name = rs.getString("coursename");
				String maxplace = rs.getString("maxplaces");
				String instructorid = rs.getString("instructorid");
				String fname = rs.getString("fname");
				String sname = rs.getString("sname");
				String bookedpeople = rs.getString("membershipnumber");
				
				String[] data = {course_name, maxplace, instructorid, fname, sname, bookedpeople};
				
				//get other cols
				System.out.println(course_name);
				System.out.println(maxplace);
				System.out.println(instructorid);
				System.out.println(fname);
				System.out.println(sname);
				System.out.println(bookedpeople);
				
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.err.println("error executing query " + query);
		}
		
		//second: view all members booked on course (name/id) and name of course
		Statement stmt2 = null;
		String query2 = "SELECT gym.gymmember.membershipnumber, gym.gymmember.fname, gym.gymmember.sname, gym.course.coursename, gym.booking.membershipnumber FROM gym.gymmember INNER JOIN gym.booking ON gym.gymmember.membershipnumber = gym.booking.membershipnumber INNER JOIN gym.course ON gym.course.courseid = gym.booking.courseid";
		try
		{
			stmt2 = connection.createStatement();
			ResultSet rs2 = stmt.executeQuery(query);
			while(rs2.next()) 
			{
				String membernumber = rs2.getString("membershipnumber");
				String memberfname = rs2.getString("fname");
				String membersname = rs2.getString("sname");
				String coursename2 = rs2.getString("coursename");
				
				System.out.println(membernumber);
				System.out.println(memberfname);
				System.out.println(membersname);
				System.out.println(coursename2);	
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.err.println("error executing query " + query2);
		}
		
		//third: book member on course
//		Statement stmt3 = null;
//		String query3 = "INSERT";
//		try
//		{
//			stmt3 = connection.createStatement();
//			ResultSet rs3 = stmt.executeQuery(query);
//			while(rs.next()) 
//			{
//				
//			
//				
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//			System.err.println("error executing query " + query2);
//		}
//		
		//close out system
		try 
		{
			connection.close();
			System.out.println("System Closed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Connection could not be closed-SQL exception");
		}
		
		public static String[] getData()
		{
			return data;
		}
		
		
	}

}