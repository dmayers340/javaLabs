import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

//View course Booking info and add course bookings

//view courses and instructors, cpacity of course, number members booked on course
//view members on course-member name and id for each course
//book given member on course

//Course times: M-F 8a-4p for 1 hr
//MAX 10 courses in DB
//Max enrollment = 40
//Course names unique

//GUI: SHow courses running
//Max cap of courses
//Current number of members on course
//User can book member from db to course
//View members booked on course

//Members
//Student mem, name, ID
//Staff mem, name, ID
//Instrutor: Alice Pensive, ID 56

//Courses
//Mon. Pilates 1400, max cap 5, ID 90 taught anyone
//Tuesday Spinning 1000, max cap 20, ID 17, taught alice pensive, 

//Course booking
//Ruby on course 90
//Book 4 other members not marks on 90


public class JDBCGUI extends JFrame implements ActionListener
{
	
	public void layoutComponents()
	{
		this.setSize(100,100);
		this.setTitle("JDBC DTA Assessed Exercise");
		
	}
	
	String[] courseNames = {"yoga", "pilates", "golf"}; //connector.getCourseNames() //get array from db connector
	JComboBox courseList = new JComboBox(courseNames);
	courseList.addActionListener(this);
	
	
	public void actionPerformed(ActionEvent e)
	{
		JComboBox cb = (JComboBox)e.getSource();
		String courseName = (String)cb.getSelectedItem();
		
	}
}