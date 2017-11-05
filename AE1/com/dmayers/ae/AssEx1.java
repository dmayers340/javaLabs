package com.dmayers.ae;
/*
 * Main method. 1.) Gets customer name and starting balance from JOptionPane
 * Create two Model Objects: Wine and Customer Account. 
 * 2.) Creates Customer Account Object w/ details
 * 3.) Displays GUI object passing CustomerAccount as parameter
 */
import javax.swing.JOptionPane;


public class AssEx1 
{	
	Wine wineObject;
	static CustomerAccount customerAccount;
	
	
	public static void main(String [] args)
	{	
		//JOptionPane1 get User Name
	   String accountName = JOptionPane.showInputDialog("Please Enter The Account Name");

	    //If nothing is answered, quit the system
	    if (accountName.isEmpty())
	    {
	       System.exit(0);
	    }
	     // error message if no error
	     else 
	     {
	    	System.out.println(accountName);
	    	
	     }
	    
	    //Get Account Balance, if text field is empty or don't enter an int will loop through because the do while cannot be completed
	    double initialAmount= Integer.MAX_VALUE;
	    
	    do
	    {		    	
	    	String accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");
	    	try 
	    	{
	    		initialAmount = Double.parseDouble(accountBalance);
	    		
	    		//Create Customer account and GUI Objs
	    		CustomerAccount customerAccount = new CustomerAccount(accountName, initialAmount);
	    		LWMGUI myGUI = new LWMGUI(customerAccount); 
	    		
	    		if (initialAmount < 0)
	    		{
	    			//IF neg: print out balance with a CR behind it
	    			System.out.println("Account Balance is a CR");
	    		}
	    		else
	    		{
	    			System.out.println("Balance is normal");
	    		}
	    	}
	    	catch(Exception exception1)
	    	{
	    		JOptionPane.showMessageDialog(null,  "Incorrect information provided. Please try again"); 
	    		System.out.println("No double");
	    	}
	    }
	    while (initialAmount == Integer.MAX_VALUE);		
	}
}