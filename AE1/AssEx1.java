/*
 * Main method. 1.) Gets customer name and starting balance from JOptionPane
 * Create two obj: Model Obj: Wine and Cust Account--View Control Obj too
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
		//1. JOptionPane return String w/ customerName
	   String accountName = JOptionPane.showInputDialog("Please Enter The Account Name");

	    // if they enter a name, return to user and return name
	    if (accountName.isEmpty())
	    {
	       System.exit(0);
	    }
	     // error message if no error
	     else 
	     {
	    	System.out.println();
	    	
	     }
	  
	    //JOptionPane 2-return double for currentBalance
	    String accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");
		double initialAmount = Double.parseDouble(accountBalance);
		
		//loop until enter a balance
	 	while (accountBalance == null)
	 	{
	 		JOptionPane.showMessageDialog(null,  "No info provided");
	 	}
	 	System.out.println(initialAmount);
	 	
	 	
	 	//Main Interface
	 	LWMGUI myGUI = new LWMGUI();
	
	//CustomerAccount account = new CustomerAccount(accountName,initalAmount);
	 	
	}
}
