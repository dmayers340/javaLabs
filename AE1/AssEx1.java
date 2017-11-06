/*
 * Main method. 1.) Gets customer name and starting balance from JOptionPane
 * Create two Model Objects: Wine and Customer Account. 
 * 2.) Creates Customer Account Object w/ details
 * 3.) Displays GUI object passing CustomerAccount as parameter
 */
import javax.swing.JOptionPane;


public class AssEx1 
{	
	public static void main(String [] args)
	{	
		//JOptionPane1 get User Name
	   String accountName = JOptionPane.showInputDialog("Please Enter The Account Name");

	    //If no input, quit the system
	    if (accountName.isEmpty())
	    {
	       System.exit(0);
	    }
	    
	    //Get Account Balance, if text field is empty or user doesn't enter an int the program will loop through because the do while cannot be completed w/ MAX_VALUE
	    double initialAmount= Integer.MAX_VALUE;
	    
	    do
	    {		    	
	    	String accountBalance = JOptionPane.showInputDialog(null, "Please enter your initial balance");

	    	//if users presses cancel or red x at top, exit program
	    	if (accountBalance == null)
	    	{
	    		System.exit(0);
	    	}
	    	
	    	//exception if cannot parse the amount
	    	try 
	    	{
	    		initialAmount = Double.parseDouble(accountBalance);
	    		
	    		//Create Customer account and GUI OBJs
	    		CustomerAccount customerAccount = new CustomerAccount(accountName, initialAmount);
	    		LWMGUI myGUI = new LWMGUI(customerAccount); 
	    	}
	    	catch(Exception badInfo)
	    	{
	    		JOptionPane.showMessageDialog(null,  "Incorrect information provided. Please try again"); 
	    	}
	    }
	    while (initialAmount == Integer.MAX_VALUE);		
	}
}