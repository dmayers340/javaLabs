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
	    String accountBalance = "";
	    //because it is not an int will loop through because do while cannot be completed
	    double initialAmount= Integer.MAX_VALUE;
	    
	    //JOptionPane 2
	    do
	    {
	    	accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");
		 	
		 	try  
		 	{
		 		initialAmount = Double.parseDouble(accountBalance);
		 		
		 	}
		 	catch (NumberFormatException exceptionNumber)
		 	{
		 		JOptionPane.showMessageDialog(null,  "No info provided. Please try again"); 
		 		System.out.println("No double");
		 	}
		 }
		
	 	while (initialAmount == Integer.MAX_VALUE);
	    
	    initialAmount = Double.parseDouble(accountBalance);
	    System.out.println("Double inital amount: " + initialAmount);
	    System.out.println("String acount balance " + accountBalance);
	 	
	 	//Main Interface
	 	LWMGUI myGUI = new LWMGUI(accountName, initialAmount, null, null);
	
	//CustomerAccount account = new CustomerAccount(accountName,initalAmount);
	 	
	}
}