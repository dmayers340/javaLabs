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

public class JDBCGUI extends JFrame implements ActionListener
{
	MainJDBC main = new MainJDBC();
	JTabbedPane tabbedPane = new JTabbedPane();
	JTable courseTable, memberTable; 
	String[] columnNames = {"Course Name", "Max Places", "Instructor ID", "Instructor First Name", "Instructor Last Name", "Num Members on Course"};
	DefaultTableModel model = new DefaultTableModel();
	JTextField bookingNumber, membershipNumber, coursedate, courseID, courseName, coursecost,  instuctorID, maxPlaces, coursetime;   
	JButton noButton, okayButton;
	GridLayout panel3layout = new GridLayout(10, 2);
	String userInputOne;
	String userInputTwo;
	String userInputThree;
	String userInputFour;
	String userInputFive;
	String userInputSix;
	String userInputSeven;
	String userInputEight;
	String userInputNine;
	
	
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
		
		memberTable = new JTable();
		
		JLabel label1 = new JLabel();
		label1.setText("Courses");
		panel1.add(label1);
		
		
		
		JLabel label2 = new JLabel();
		label2.setText("Member");
		
		panel2.add(label2);
		panel2.add(memberTable);
		
		int max = 100;
		int min = 1;
		Random randomBookingNum = new Random();
		int bookingNum = min + randomBookingNum.nextInt(max);
		String rand = Integer.toString(bookingNum);
		
		//book member on course: book num, memNum, courseID from Booking table
		//From course table: courseID, courseName, instructor id, maxplaces, coursetime, coursedate, coursecost
		JLabel bookNum = new JLabel();
		bookNum.setText("Booking Number");
		bookingNumber = new JTextField();
		bookingNumber.setText(rand);
				
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
		okayButton.addActionListener(this);

		noButton = new JButton("Quit");
		noButton.addActionListener(this);
		

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
	
	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == okayButton)
		{
			userInputOne = bookingNumber.getText();
			userInputTwo = membershipNumber.getText();
			userInputThree = courseID.getText();
			userInputFour = courseName.getText();
			userInputFive = instuctorID.getText();
			userInputSix = maxPlaces.getText();
			userInputSeven = coursetime.getText();
			userInputEight = coursedate.getText();
			userInputNine = coursecost.getText();
			
			System.out.println(userInputOne);
			System.out.println(userInputTwo);
			System.out.println(userInputThree);
			System.out.println(userInputFour);
			System.out.println(userInputFive);
			System.out.println(userInputSix);
			System.out.println(userInputSeven);
			System.out.println(userInputEight);
			System.out.println(userInputNine);

				//push all to database

		}
		
		else if(e.getSource() == noButton)
		{
			System.exit(0);
		}
	}
	
	public String getUserInput1() 
	{
		return userInputOne;
	}
	public String getUserInput2()
	{
		return userInputTwo;
	}
	public String getUserInput3()
	{
		return userInputThree;
	}
	public String getUserInput4()
	{
		return userInputFour;
	}
	public String getUserInput5()
	{
		return userInputFive;
	}
	public String getUserInput6()
	{
		return userInputSix;
	}
	public String getUserInput7()
	{
		return userInputSeven;
	}
	public String getUserInput8()
	{
		return userInputEight;
	}
	public String getUserInput9()
	{
		return userInputNine;
	}
	
}