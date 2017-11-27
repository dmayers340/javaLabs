import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

//view courses and instructors, cpacity of course, number members booked on course
//view members on course-member name and id for each course
//book given member on course

public class JDBCGUI extends JFrame //implements ActionListener
{
	JTabbedPane tabbedPane = new JTabbedPane();
	JTable table = new JTable();
	
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
		
		JLabel label1 = new JLabel();
		label1.setText("Course");
		JLabel label2 = new JLabel();
		label2.setText("Member");
		JLabel label3 = new JLabel();
		label3.setText("Booking");
		
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		
		tabbedPane.addTab("Course", panel1);
		tabbedPane.addTab("Member", panel2);
		tabbedPane.addTab("Booking", panel3);
		
		ArrayList columnName = new ArrayList();
		ArrayList courseinfo = new ArrayList();
		ArrayList memberInfo = new ArrayList();
	
	}
	public JTable setTable()
	{
		return table;
	}
	
}
