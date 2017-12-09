import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * Defines a GUI that displays details of a FitnessProgram object
 * and contains buttons enabling access to the required functionality.
 */
public class SportsCentreGUI extends JFrame implements ActionListener 
{
	
	/** GUI JButtons */
	private JButton closeButton, attendanceButton;
	private JButton addButton, deleteButton;

	/** GUI JTextFields */
	private JTextField idIn, classIn, tutorIn;

	/** Display of class timetable */
	private JTextArea display;
	

	/** Display of attendance information */
	private ReportFrame report;

	/** Names of input text files */
	private final String classesInFile = "ClassesIn.txt";
	private final String classesOutFile = "ClassesOut.txt";
	private final String attendancesFile = "AttendancesIn.txt";
	
	
	private String line;
	private String attendanceLine;
	
	FitnessClass fclass;
	FitnessProgram fprogram;

	
	/**
	 * Constructor for AssEx3GUI class
	 * Set up GUI and File INputs
	 */
	public SportsCentreGUI() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Boyd-Orr Sports Centre");
		setSize(700, 475);
		display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER);
		layoutTop();
		layoutBottom();
		
		initLadiesDay();
		initAttendances();
		updateDisplay();
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() 
	{
		BufferedReader reader = null;
		
		// store new fitnessclass object in array
		fprogram = new FitnessProgram();

		try
		{
			reader = new BufferedReader(new FileReader(classesInFile));
			
			while((line = reader.readLine()) != null)
			{
				// create new fitnessclass object based on line
				String[] newLine = line.split(" ");
				fclass = new FitnessClass(line);//GIVE LINE INFORMATION--SHOULD ONLY BE ONE STRING
//				fprogram.getObjTime();
				fprogram.getObjArray()[fclass.getTimeStart()-9] = fclass;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.err.println("Cannot read file");
		}	
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException cannotClose)
			{
				cannotClose.printStackTrace();
				System.err.println("Cannot Close File");
			}
		}
	}

	/**
	 * Initialises the attendances using data
	 * from the file AttendancesIn.txt
	 */
	public void initAttendances() 
	{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new FileReader(attendancesFile));
			while((attendanceLine = reader.readLine()) != null)
			{
				String[] lineSplit = attendanceLine.split(" ");
				String attendanceid = lineSplit[0];
				
				int weekOne = Integer.parseInt(lineSplit[1]);
				int weekTwo = Integer.parseInt(lineSplit[2]);
				int weekThree = Integer.parseInt(lineSplit[3]);
				int weekFour = Integer.parseInt(lineSplit[4]);
				int weekFive = Integer.parseInt(lineSplit[5]);
				int[] attendanceArray = {weekOne, weekTwo, weekThree, weekFour, weekFive};
				System.out.println("\nFrom GUI: " + attendanceLine);
				fclass.setAttendance(attendanceArray);
				
				fprogram.setAttendances(attendanceid, attendanceArray);
			} 
		}

		catch (IOException e)
		{
			e.printStackTrace();
			System.err.println("Cannot read file");
		}	
		finally
		{
			try
			{
				reader.close();
			}
			catch(IOException cannotClose)
			{
				cannotClose.printStackTrace();
				System.err.println("Cannot Close File");
			}
		}
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 */
	public void updateDisplay() 
	{
		display.setText("");
		String[] columnNames = {"Time      		", "Course Name    		", "  Tutor Name    "};
		
		String[] timeInfo = {"9:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00"};
		
		for(int i = 0; i<columnNames.length; i++)
		{
			display.append(String.format("%10s ", columnNames[i]));
		}
		
		display.append("\n");
		
		for(int i = 0; i<7; i++)
		{
			display.append(String.format("\n%10s \n ", timeInfo[i]));
		}
		
		display.append("\n");
	
		
	}

	/**
	 * adds buttons to top of GUI
	 */
	public void layoutTop() 
	{
		JPanel top = new JPanel();
		closeButton = new JButton("Save and Exit");
		closeButton.addActionListener(this);
		top.add(closeButton);
		attendanceButton = new JButton("View Attendances");
		attendanceButton.addActionListener(this);
		top.add(attendanceButton);
		add(top, BorderLayout.NORTH);
	}

	/**
	 * adds labels, text fields and buttons to bottom of GUI
	 */
	public void layoutBottom() 
	{
		// instantiate panel for bottom of display
		JPanel bottom = new JPanel(new GridLayout(3, 3));

		// add upper label, text field and button
		JLabel idLabel = new JLabel("Enter Class Id");
		bottom.add(idLabel);
		idIn = new JTextField();
		bottom.add(idIn);
		
		JPanel panel1 = new JPanel();
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		panel1.add(addButton);
		bottom.add(panel1);

		// add middle label, text field and button
		JLabel nmeLabel = new JLabel("Enter Class Name");
		bottom.add(nmeLabel);
		classIn = new JTextField();
		bottom.add(classIn);
		
		JPanel panel2 = new JPanel();
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel2.add(deleteButton);
		bottom.add(panel2);

		// add lower label text field and button
		JLabel tutLabel = new JLabel("Enter Tutor Name");
		bottom.add(tutLabel);
		tutorIn = new JTextField();
		bottom.add(tutorIn);

		add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Processes adding a class
	 */
	public void processAdding() 
	{
		String gotID = idIn.getText();
		String gotName = classIn.getText();
		String gotTutor = tutorIn.getText();
		
		int firstTimeSlot = fprogram.getOpenTime();
		
		if(firstTimeSlot == -1)
		{
			JOptionPane.showMessageDialog(null, "Cannot Add Classes");
			
			clearTextFields();
		}
//		else if (program exists)
//		{
//			JOptionPane.showMessageDialog(null, "Class Exists");
//		}
		else 
		{
			//add class to FProgram
		//	fprogram add Class(gotID, gotName, gotTutor);
			
			JOptionPane.showMessageDialog(null, "Added Class");
		}
		clearTextFields();
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() 
	{
	    String gotID = idIn.getText();
		if(gotID.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter ID");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Delted Class " + gotID);
			
			clearTextFields();
			updateDisplay();
		} 
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() 
	{
		report = new ReportFrame();
		JTextArea reportTextArea;
		//reportTextArea = report.buildReport();
		
		//reportTextArea.setText(); set text to fitness program
		report.setVisible(true);
	}
	
	public void clearTextFields()
	{
		idIn.setText("");
		classIn.setText("");
		tutorIn.setText("");
		
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() 
	{
		PrintWriter classOut = null;
		try 
		{
			classOut = new PrintWriter(classesOutFile);
			classOut.println(display.getText());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		classOut.close();
		System.exit(0);
	}

	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) 
	{
		if (ae.getSource() == closeButton)
		{
			processSaveAndClose();
			
		}
		else if (ae.getSource() == attendanceButton)
		{
			displayReport();
			
		}
		else if (ae.getSource() == addButton)
		{
			
			processAdding();
			updateDisplay();
			
		}
		else if (ae.getSource() == deleteButton)
		{
			
			processDeletion();
			updateDisplay();
			
		}		
	}

}
	