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
	
	//Fitness Program Obj
	FitnessProgram fprogram = new FitnessProgram();
	
	private String line;
	private String attendanceline;
	
	FitnessClass fclass = new FitnessClass(line, attendanceline);

	
	/**
	 * Constructor for AssEx3GUI class
	 * Set up GUI and File INputs
	 */
	public SportsCentreGUI() 
	{
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Boyd-Orr Sports Centre");
		setSize(700, 300);
		display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER);
		layoutTop();
		layoutBottom();
		
		initLadiesDay();
		initAttendances();
//		fClass = new FitnessClass();
//		fClass.averageAttendance();	
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 */
	public void initLadiesDay() 
	{
		BufferedReader reader = null;
		//String line;

		try
		{
			reader = new BufferedReader(new FileReader(classesInFile));
			while((line = reader.readLine()) != null)
			{
				String[] newLine = line.split(" ");
				//FitnessClass fclass = new FitnessClass(line, attendanceline);
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
		String attendanceLine;

		try
		{
			reader = new BufferedReader(new FileReader(attendancesFile));
			while((attendanceLine = reader.readLine()) != null)
			{
				String[] lineSplit = attendanceLine.split(" ");
			//	FitnessClass attend = new FitnessClass(attendanceLine);
				System.out.println("From GUI" + attendanceLine);
				
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
	    // your code here
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
	    // your code here
	}

	/**
	 * Processes deleting a class
	 */
	public void processDeletion() 
	{
	    // your code here
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() 
	{
	    // your code here
	}

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() 
	{
	    // your code here
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
			
		}
		else if (ae.getSource() == deleteButton)
		{
			processDeletion();
			
		}		
	}

}