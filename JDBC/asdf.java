
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


public class asdf extends JFrame implements ActionListener
{
	private JButton btnOkay, btnCancel, btnBooking;
	private JTable table;

	
	
	public asdf() 
	{
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane rightScroll = new JScrollPane();
		getContentPane().add(rightScroll);
		
		JScrollPane bottomScroll = new JScrollPane();
		getContentPane().add(bottomScroll);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Please Make a Selection:", "Course", "Member", "Instructor", "Booking"}));
		getContentPane().add(comboBox);
	}
	
	public void layoutComponents()
	{
		this.setSize(100,100);
		this.setTitle("JDBC DTA Assessed Exercise");
		
	}
	
	String[] courseNames = {"yoga", "pilates", "golf"}; //connector.getCourseNames() //get array from db connector
	
	
	public void actionPerformed(ActionEvent e)
	{
		JComboBox cb = (JComboBox)e.getSource();
		String courseName = (String)cb.getSelectedItem();

		if (e.equals("Course"))
		{
			getCourseBox();
			//go into next frame
		}
		else if(e.equals("Member"))
		{
			getMemberBox();
		}
		else if(e.equals("Instructor"))
		{
			getInstructorBox();
			
		}
		else if(e.equals("Booking"))
		{
			getBookingBox();
		}
	}
	
	public void getCourseBox()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourse.gridx = 0;
		gbc_lblCourse.gridy = 0;
		getContentPane().add(lblCourse, gbc_lblCourse);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		getContentPane().add(table, gbc_table);
		
	}
	
	public void getMemberBox()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCourse = new JLabel("Member");
		lblCourse.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourse.gridx = 0;
		gbc_lblCourse.gridy = 0;
		getContentPane().add(lblCourse, gbc_lblCourse);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		getContentPane().add(table, gbc_table);
		
	}
	
	public void getInstructorBox()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCourse = new JLabel("Instructor");
		lblCourse.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourse.gridx = 0;
		gbc_lblCourse.gridy = 0;
		getContentPane().add(lblCourse, gbc_lblCourse);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		getContentPane().add(table, gbc_table);
		
	}
	
	public void getBookingBox()
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCourse = new JLabel("Booking");
		lblCourse.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblCourse = new GridBagConstraints();
		gbc_lblCourse.insets = new Insets(0, 0, 5, 0);
		gbc_lblCourse.gridx = 0;
		gbc_lblCourse.gridy = 0;
		getContentPane().add(lblCourse, gbc_lblCourse);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 4;
		getContentPane().add(table, gbc_table);
	}
}