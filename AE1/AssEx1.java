/*
 * Main method. 1.) Gets customer name and starting balance from JOptionPane
 * 2.) Creates Customer Account Object w/ details
 * 3.) Displays GUI obj passing CustomerAccount as parameter
 */
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

public class AssEx1 
{
	public static void main(String [] args)
	{	
		LWMGUI myGUI = new LWMGUI(); 
		//1. JOptionPane (return String w/ customerName
		//Enter Account Name (press OK or CANCEL)-showOptionDialog or showInputDialog
		//Ask User to input Account Name
	    String accountName = JOptionPane.showInputDialog(null, "Please Enter The Account Name");
	    // if they enter a name, return to user and return name
	    if (accountName != null)
	    {
	      
	       System.out.println(accountName);
	      // return accountName;
	    }
	     // error message if no error
	     else if (accountName == null)
	    	System.exit(0);
	    
	    //JOptionPane 2-return double for currentBalance
	    //Enter account balance and store as balance
	 	String accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");
		double initialAmount = Double.parseDouble(accountBalance);
	 	if (accountBalance != null)
	 	{
			 JOptionPane.showMessageDialog(null, "You entered \"" + accountBalance + "\"", 
		    		   "Result summary", JOptionPane.INFORMATION_MESSAGE);
			 System.out.println(initialAmount);
	 	}	
		else JOptionPane.showMessageDialog(null, "No information provided", "Result summary", JOptionPane.ERROR_MESSAGE);
		}
	
	
}
