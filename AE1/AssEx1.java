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
	Wine wineObject;
	CustomerAccount customerAccount;
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
	    	System.out.println(accountName);
	    	
	     }
	    String accountBalance;
	    double initialAmount;
	    //JOptionPane 2-return double for currentBalance--NEEDS TO LOOP IF NOT DOUBLE
	    do
	    {
	    	accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");
		 	JOptionPane.showMessageDialog(null,  "No info provided. Please try again"); //occurs even if correct
		 	try  
		 	{
		 		initialAmount = Double.parseDouble(accountBalance);
		 		
		 	}
		 	catch (NumberFormatException exceptionNumber)
		 	{
		 		System.out.println("No double");
		 	}
		 }
		
	 	while (accountBalance.isEmpty());
	    
	    initialAmount = Double.parseDouble(accountBalance);
	    System.out.println("Double inital amount: " + initialAmount);
	    System.out.println("String acount balance " + accountBalance);
	 	
	 	//Main Interface
	 	LWMGUI myGUI = new LWMGUI(accountName, initialAmount, null, null);
	
	//CustomerAccount account = new CustomerAccount(accountName,initalAmount);
	 	
	}
}
