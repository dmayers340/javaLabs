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
		frameArea = new JTextArea();
		frameArea.setFont(new Font("Courier", Font.PLAIN, 14));
		add(frameArea, BorderLayout.CENTER);
		
	}
	
	//build report for display on JTextArea
	public void buildReport()
	{
		
	}
        // your code here
}
