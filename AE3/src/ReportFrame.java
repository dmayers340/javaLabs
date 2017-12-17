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
	private JTextArea frameArea;
	FitnessProgram fprogram = new FitnessProgram();
	FitnessClass fclass = new FitnessClass();
	String attendanceLine;
	
	public ReportFrame(FitnessProgram initFProgram) 
	{
		fprogram = initFProgram;
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setTitle("Attendance Display");
		setSize(1500, 425);	

		frameArea = new JTextArea();
		frameArea.setFont(new Font("Courier", Font.PLAIN, 14));
		add(frameArea, BorderLayout.CENTER);
		
	}
	
	//build report for display on JTextArea
	public void buildReport()
	{
		String[] columnNames = {"ID", "\t\tClass Name","\t\tTutor Name", "\t\tAttendance Totals", "\t\tAverage Class Attendance"};
				
		for(int i=0; i<columnNames.length; i++)
		{
			frameArea.append(String.format("%10s ", columnNames[i]));
		}
		frameArea.append("\n");


		for(int i = 0; i<7; i++)
		{
			frameArea.append("\n");
			frameArea.append(String.format("%10s", fprogram.getID(i)));
			frameArea.append(String.format("\t\t%10s", fprogram.getClassLists(i)));
			frameArea.append(String.format("\t\t%10s", fprogram.getTutor(i)));
			frameArea.append(String.format("\t\t%10s", fprogram.getAttendnaces(i)));			
			frameArea.append(String.format("\t\t%10s", fprogram.getAverage(i)));	//returns 12 for all.I assume bc last class is all 12? 		
			frameArea.append("\n");
		}			
		frameArea.append("\n");
		frameArea.append(String.format("\n\t\t\t\t\t\t\t\t\t\t%10s %10s", "Overall Attendnace: ", Double.toString(fprogram.finalAvAttendance())));
	}
	
}