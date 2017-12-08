import java.awt.*;
import javax.swing.*;

/**
 * Class to define window in which attendance report is displayed.
 * Fitness program
 * JText Area objs as instance vars
 * 
 * constructor w/ fitness program parameter to initalize fitnessprogram instance var
 * add JTextArea componenet
 * 
 * Build report for display on TextArea
 * 
 */
public class ReportFrame extends JFrame 
{
	FitnessProgram fprogramFrame = new FitnessProgram();
	private JTextArea frameArea;
	
	
	
	public ReportFrame() //needs fitness program parameter
	{
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Attendance Display");
		setSize(700, 300);	
		
		frameArea = new JTextArea();
		frameArea.setFont(new Font("Courier", Font.PLAIN, 14));
		add(frameArea, BorderLayout.CENTER);
	}
	
	//build report for display on JTextArea
	public void buildReport(FitnessProgram fprogram)
	{
		String id = "ID";
		String className = "Class Name";
		String tutorName = "Tutor Name";
		String attendanceTotals = "Attendance Totals";
		String averageAttendace = "Average Class Attendance";
		String overallAttendance = "Overall Attendnace: ";
		
		frameArea.setText("");
		
		frameArea.append(String.format("%10s, %10s, %10s, %10s, %10s", id, className, tutorName, attendanceTotals, averageAttendace));
		//get the order of the array and place here based on attendance
		
	}
	
        // your code here
}
