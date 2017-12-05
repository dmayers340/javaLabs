import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStuff
{	
	//make connection	
	private static Connection connection = null;
	JDBCGUI gui = new JDBCGUI();
	
	public DatabaseStuff()
	{
		connectDB();
	}
	
	public void connectDB()
	{
		this.makeConnection();
	}
	public void makeConnection()
	{
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
	}
	public void closeConnection()
	{
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
	}
	
	public String returnCourses()
	{
		String returnCourses = "";
		//TODO: Make a function 
			//First: View all courses, instructor teaching, capacity of course, no members booked on
			Statement stmt = null;
			String query = "SELECT gym.course.courseid, gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname, COUNT(gym.booking.membershipnumber) FROM gym.course LEFT JOIN gym.booking ON gym.course.courseid = gym.booking.courseid INNER JOIN gym.instructor ON gym.course.instructorid = gym.instructor.instructorid GROUP BY gym.course.courseid, gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname"; //try this on
			//String query = "SELECT gym.course.courseid, gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname, COUNT(gym.booking.membershipnumber) FROM gym.course LEFT JOIN gym.instructor ON gym.course.instructorid = gym.instructor.instructorid INNER JOIN gym.booking ON gym.course.courseid = gym.booking.courseid GROUP BY gym.course.courseid, gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname";
			try
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) 
				{
					String courseID = rs.getString("courseid");
					String courseName = rs.getString("coursename");
					String maxplace = rs.getString("maxplaces");
					String instructorid = rs.getString("instructorid");
					String fname = rs.getString("fname");
					String sname = rs.getString("sname");
					String bookedpeople = rs.getString("count");
					
//					String returnCourses = "";
					returnCourses = returnCourses + "Course ID: " + courseID +", Course Name: " + courseName + ", Maximum Places: " + maxplace + ", Instructor ID: " + instructorid + ", Instructor First Name: " + fname + ", Instructor Last Name: " + sname + ", Number of people on course: " + bookedpeople; 
					
					System.out.println(returnCourses);
					
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			return returnCourses;
	}
	
	public String members()
	{
		String courses = "";
		//TODO make a function
		//second: view all members booked on course (name/id) and name of course
		Statement stmt2 = null;
		String query2 = "SELECT gym.gymmember.membershipnumber, gym.gymmember.fname, gym.gymmember.sname, gym.course.coursename, gym.booking.membershipnumber FROM gym.gymmember INNER JOIN gym.booking ON gym.gymmember.membershipnumber = gym.booking.membershipnumber INNER JOIN gym.course ON gym.course.courseid = gym.booking.courseid";
		try
		{
			stmt2 = connection.createStatement();
			ResultSet rs2 = stmt2.executeQuery(query2);
			while(rs2.next()) 
			{
				String membernumber = rs2.getString("membershipnumber");
				String memberfname = rs2.getString("fname");				
				String membersname = rs2.getString("sname");
				String coursename2 = rs2.getString("coursename");
				
//				String courses = "";
				courses = courses + "Membership Number: " + membernumber +", Member First Name: " + memberfname + ", Member Last Name:" + membersname + ", Course Name: " + coursename2;
				
				System.out.println(courses);	
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.err.println("error executing query " + query2);
		}
		return courses;
	}
	
	public void booking()
	{
		try
		{
			//PreparedStatement st = null;
			String query3 = "INSERT INTO gym.booking(bookingnumber, membershipnumber, courseid, coursename, instructorid, maxplaces, coursetime, coursedate, cost) VALUES ('?,?,?,?,?,?,?,?,?')";
			PreparedStatement st = connection.prepareStatement(query3);

			String userInput1 = gui.getUserInput1();
			String userInput2 = gui.getUserInput2();
			String userInput3 = gui.getUserInput3();
			String userInput4 = gui.getUserInput4();
			String userInput5 = gui.getUserInput5();
			String userInput6 = gui.getUserInput6();
			String userInput7 = gui.getUserInput7();
			String userInput8 = gui.getUserInput8();
			String userInput9 = gui.getUserInput9();

			st.setString(1, userInput1);
			st.setString(2, userInput2);
			st.setString(3, userInput3);
			st.setString(4, userInput4);
			st.setString(5, userInput5);
			st.setString(6, userInput6);
			st.setString(7, userInput7);
			st.setString(8, userInput8);
			st.setString(9, userInput9);
			st.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		//third: book member on course
		//Statement stmt3 = null;
		//String query3 = "INSERT INTO gym.booking VALUES(userInput1, userInput2, userInput3, userInput4, userInput5, userInput6, userInput7, userInput8, userInput9)";
		//try
		//{
			//stmt3 = connection.createStatement();
			//ResultSet rs3 = stmt.executeQuery(query);
			
		//}
		//catch (SQLException e)
		//{
		//	e.printStackTrace();
		//	System.err.println("error executing query " + query2);
		//}
	//	String query3 = "INSERT INTO gym.booking (" + "bookingnumber," + "membershipnumber,"+"courseid,"+"coursename,"+"instructorid,"+"maxplaces,"+"coursetime,"+"coursedate,"+"cost,) VALUES (?, ?, ?, ?, ?, ?,?,?)";
//		//try this
//		try
//		{
//			PreparedStatement st = connection.prepareStatement(query3);
//			//st.setValues(userInput1, userInput2, userInput3, userInput4, userInput5, userInput6, userInput7, userInput8, userInput9);
//			String userInput1 = gui.getUserInput1();
//			String userInput2 = gui.getUserInput2();
//			String userInput3 = gui.getUserInput3();
//			String userInput4 = gui.getUserInput4();
//			String userInput5 = gui.getUserInput5();
//			String userInput6 = gui.getUserInput6();
//			String userInput7 = gui.getUserInput7();
//			String userInput8 = gui.getUserInput8();
//			String userInput9 = gui.getUserInput9();
//
//			st.setString(1, userInput1);
//			st.setString(2, userInput2);
//			st.setString(3, userInput3);
//			st.setString(4, userInput4);
//			st.setString(5, userInput5);
//			st.setString(6, userInput6);
//			st.setString(7, userInput7);
//			st.setString(8, userInput8);
//			st.setString(9, userInput9);
//			st.executeUpdate();
//			//int rowsAdded = st.executeUpdate();
//			//System.out.println(rowsAdded + "rows added" + st);
//		}
//		catch(SQLException se)
//		{
//			System.out.println("ERROR");
//		}	
	}
		
}

