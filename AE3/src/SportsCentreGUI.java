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
		setSize(600, 550);
		display = new JTextArea();
		display.setEditable(false);
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
		fprogram = new FitnessProgram();

		try
		{
			reader = new BufferedReader(new FileReader(classesInFile));
			while((line = reader.readLine()) != null)
			{
				// create new fitnessclass object based on line
				String[] newLine = line.split(" ");
				fclass = new FitnessClass(line);
				fprogram.getFitnessClasses()[fclass.getTimeStart()-9] = fclass;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot Read Classes In File");
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
				JOptionPane.showMessageDialog(null, "Cannot Close File");
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
				
				fprogram.attendnaces(attendanceLine); 

//				fclass.setAttendanceID(attendanceid);
			} 
		}
		catch (IOException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot Read Attendance File");
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
				JOptionPane.showMessageDialog(null, "Cannot Close Attendance File");
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
		String[] columnNames = {"Time", "\t\tCourse Name", "\t\tTutor Name"};
		
		String[] timeInfo = {"9-10 ", " 10-11 ", " 11-12 ", " 12-13 ", " 13-14 ", " 14-15 ", " 15-16 "};
		
		for(int i = 0; i<columnNames.length; i++)
		{
			display.append(String.format("%10s ", columnNames[i]));
		}
		display.append("\n\n");
		
		for(int i = 0; i<7; i++)
		{
			display.append("\n");
			display.append(String.format("%10s", timeInfo[i]));
			display.append(String.format("\t\t%10s", fprogram.getClassLists(i)));
			display.append(String.format("\t\t%10s", fprogram.getTutor(i)));
			display.append("\n");
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
	 * 
	 * Display warning message if list is full
	 * If class w/ ID exists display warning and cancle
	 * 	 */
	public void processAdding() 
	{	
		String gotID = idIn.getText();
		String gotName = classIn.getText();
		String gotTutor = tutorIn.getText();
		int firstTimeSlot = fprogram.getOpenTime();
		int[] initAttendnace = {0,0,0,0,0};
		
		fprogram.addClass(gotID, gotName, gotTutor);
		
//		
//		//if ID is already there display 
//		//JOptionPane.showMessageDialog(null, "Error. Class Already Exists");
//		if(gotID.isEmpty())
//		{
//			JOptionPane.showMessageDialog(null, "Cannot Process Request. Please Enter an ID.");
//		}
//		else if (gotName.isEmpty())
//		{
//			JOptionPane.showMessageDialog(null, "Cannot Process Request. Please Enter a Class Name");
//		}
//		else if (gotTutor.isEmpty())
//		{
//			JOptionPane.showMessageDialog(null, "Cannot Process Request. Please Enter a Tutor Name");
//		}
//		
//		else //Otherwise create fclass w/ ID, clas name and tutor and put it in earliest av time slot
//		{
//			fclass = fprogram.getClassWithID(gotID);
//			if(fclass == null)
//			{
//				FitnessClass addFClass = new FitnessClass();
//				addFClass.setID(gotID);
//				addFClass.setClassName(gotName);
//				addFClass.setTutorName(gotTutor);
//				addFClass.setTimeStart(firstTimeSlot);
//				addFClass.setAttendance(initAttendnace);
//				
//				//add to fitness program
//				fprogram.addClass(addFClass);
//				JOptionPane.showMessageDialog(null, "Added Class");
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(null, "Cannot Add Classes");
//			}
//			clear();
//			updateDisplay();
//		}
	}

	/**
	 * Processes deleting a class
	 * Delete based on ID number
	 */
	//TODO process Deletion
	public void processDeletion() 
	{
		String deleteID = idIn.getText();
		if(deleteID.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter ID");
		}
		this.fclass = fprogram.getClassWithID(deleteID);

		if(fclass == null)
		{
			JOptionPane.showMessageDialog(null, "Cannot Delete Class, No Class Found");
		}
		/*if there is a class to delete need to:
		 * 1.) delete class by:
		 * 	a.) Find Start Time
		 * 	b.) Give it an 'Open' name
		 * 	c.) Give it an 'Open' tutor
		 * 	d.) then add the new stuff into the class
		 */
		
		else 
		{
			fprogram.deleteClass(deleteID);
			updateDisplay();
//			int deltedStartTime = fclass.getTimeStart();
//			FitnessClass classAfterDeletion = new FitnessClass();
//			
//			classAfterDeletion.setTimeStart(deltedStartTime);
//			classAfterDeletion.setID("\"OPEN\"");
//			classAfterDeletion.setClassName("\"OPEN\"");
//			classAfterDeletion.setTutorName("\"OPEN\"");
//			fprogram.addClass(newClassID, newClassName, newClassTutor);
//			JOptionPane.showMessageDialog(null, "Delted Class " + deleteID);
//			clearTextFields();
		} 
		clear();
	}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() 
	{
		report = new ReportFrame(fprogram);
		report.buildReport();
		report.setVisible(true);
	}
	
	public void clear()
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
	