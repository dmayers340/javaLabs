import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

//view courses and instructors, cpacity of course, number members booked on course
//view members on course-member name and id for each course
//book given member on course

public class JDBCGUI extends JFrame //implements ActionListener
{
	JTabbedPane tabbedPane = new JTabbedPane();
	JTable courseTable, memberTable; 
	JTextField bookingNumber, membershipNumber, coursedate, courseID, courseName, coursecost,  instuctorID, maxPlaces, coursetime;   
	JButton noButton, okayButton;
	GridLayout panel3layout = new GridLayout(10, 2);
	public void showGUI() 
	{
		
		JFrame frame = new JFrame ("JDBC DTA Assessed Exercise");
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//set tabbed panel
		frame.add(tabbedPane);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(panel3layout);
		JTable courseTable = new JTable();
		JTable memberTable = new JTable();
		
		JLabel label1 = new JLabel();
		label1.setText("Course");
		JLabel label2 = new JLabel();
		label2.setText("Member");
		JLabel label3 = new JLabel();
		label3.setText("Booking");
		
		panel1.add(label1);
		panel1.add(courseTable);
		
		panel2.add(label2);
		panel2.add(memberTable);
		
		panel3.add(label3);
		int max = 100;
		int min = 1;
		Random randomBookingNum = new Random();
		int bookingNum = min + randomBookingNum.nextInt(max);
		
		//book member on course: book num, memNum, courseID from Booking table
		//From course table: courseID, courseName, instructor id, maxplaces, coursetime, coursedate, coursecost
		JLabel bookNum = new JLabel();
		bookNum.setText("Booking Number");
		bookingNumber = new JTextField();
		
		JLabel memNum = new JLabel();
		memNum.setText("Membership Number");
		membershipNumber = new JTextField();
		
		JLabel courseNum = new JLabel();
		courseNum.setText("Course ID");
		courseID = new JTextField();
		
		JLabel courseNa = new JLabel();
		courseNa.setText("Course Name");
		courseName = new JTextField();
		
		JLabel idInst = new JLabel();
		idInst.setText("Instructor ID");
		instuctorID = new JTextField();
		
		JLabel maxPlace = new JLabel();
		maxPlace.setText("Maximum Places");
		maxPlaces = new JTextField();
		
		JLabel time = new JLabel();
		time.setText("Time");
		coursetime = new JTextField();

		JLabel date = new JLabel();
		date.setText("Date");
		coursedate = new JTextField();

		JLabel cost = new JLabel();
		cost.setText("Cost");
		coursecost = new JTextField();
		
		okayButton = new JButton("Okay");

		JButton noButton = new JButton("Quit");
		

		tabbedPane.addTab("Course", panel1);
		tabbedPane.addTab("Member", panel2);
		tabbedPane.addTab("Booking", panel3);
		
		panel3.add(bookNum);
		panel3.add(bookingNumber);
		
		panel3.add(memNum);
		panel3.add(membershipNumber);
		
		panel3.add(courseNum);
		panel3.add(courseID);
		
		panel3.add(courseNa);
		panel3.add(courseName);

		panel3.add(idInst);
		panel3.add(instuctorID);
		
		panel3.add(maxPlace);
		panel3.add(maxPlaces);

		panel3.add(time);
		panel3.add(coursetime);

		panel3.add(date);
		panel3.add(coursedate);
		
		panel3.add(cost);
		panel3.add(coursecost);

		panel3.add(okayButton);

		panel3.add(noButton);

	
		
		
	}
}