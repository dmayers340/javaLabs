import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;


public class MainJDBC 
{
	static String course_name2;
	static String maxplace;
	static String instructorid;
	static String fname;
	static String bookedpeople;
	static String sname;
	static JTable table;
	
	JDBCGUI gui = new JDBCGUI();

	public static void main(String[] args)
	{
//		String course_name2;
//		String maxplace;
//		String instructorid;
//		String fname;
//		String bookedpeople;
//		String sname;
//		DefaultTableModel model = new DefaultTableModel(new String[] {"Course Name", "Max Places", "Instructor ID", "First Name", "Last Name", "Membership Number"}, 0);

		
		JDBCGUI gui = new JDBCGUI();
		gui.showGUI(); 
		gui.setVisible(true);
		
		
		String databaseName = "m_17_2067887m";
		String userName = "m_17_2067887m";
		String password = "2067887m";
		
		//make connection
		Connection connection = null;
		
		//attempt to connect to database
		try
		{
			connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/" + databaseName, userName, password);
		}
		catch(SQLException e)
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
		Statement stmt2 = null;
		String query2 = "SELECT gym.booking.membershipnumber, gym.course.coursename, gym.course.maxplaces, gym.course.instructorid, gym.instructor.fname, gym.instructor.sname FROM gym.course INNER JOIN gym.instructor ON gym.course.instructorid = gym.instructor.instructorid INNER JOIN gym.booking ON gym.course.courseid = gym.booking.courseid";
		try
		{
			stmt2 = connection.createStatement();
			ResultSet rs2 = stmt2.executeQuery(query2);
			while(rs2.next()) 
			{
				course_name2 = rs2.getString("coursename");
				maxplace = rs2.getString("maxplaces");
				instructorid = rs2.getString("instructorid");
				fname = rs2.getString("fname");
				sname = rs2.getString("sname");
				bookedpeople = rs2.getString("membershipnumber");
				
				System.out.println(course_name2);
				System.out.println(maxplace);
				System.out.println(instructorid);
				System.out.println(fname);
				System.out.println(sname);
				System.out.println(bookedpeople);
				
				//PASS FROM GUI
				gui.setTable() = new JTable(buildTableModel(rs2));

								
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.err.println("error executing query " + query2);
		}
		
		System.out.print(table); 
				
		
		Statement stmt = null;
		String query = "SELECT gym.gymmember.membershipnumber, gym.gymmember.fname, gym.gymmember.sname, gym.course.coursename, gym.booking.membershipnumber FROM gym.gymmember INNER JOIN gym.booking ON gym.gymmember.membershipnumber = gym.booking.membershipnumber INNER JOIN gym.course ON gym.course.courseid = gym.booking.courseid";
		try
		{
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) 
			{
				String membernumber = rs.getString("membershipnumber");
				String memberfname = rs.getString("fname");
				String membersname = rs.getString("sname");
				String coursename = rs.getString("coursename");
				
				//get other cols
				System.out.println(membernumber);
				System.out.println(memberfname);
				System.out.println(membersname);
				System.out.println(coursename);
				
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.err.println("error executing query " + query2);
		}
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

		
	}

}
