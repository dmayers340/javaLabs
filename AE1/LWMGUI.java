/*
 * User Interface, handle events=View/Controller Class
 * -Veiw in constructor-controller: actionPerformed
 * 1. Layout components
 * 2. Listen for events
 * Process Sales and Returns
 */
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

//need constructor


//Need to pass events to Wine() which will figure out what happens when things are entered into textField
public class LWMGUI extends JFrame implements ActionListener
{
	//instance vars
	private JPanel top, middle, bottom;
	private JTextField  updateCurrentBalanceText, totalAmountText, nameText, amountText, priceText;
	private JLabel totalAmountLabel, label, nameLabel, priceLabel, amountLabel, fillerLabel, currentBalanceLabel;
	private JButton saleButton, returnButton;
	
	private CustomerAccount customerAccountObject;
	
	public LWMGUI(CustomerAccount customerAccount)
	{
		//wineObject = wine;
		customerAccountObject = customerAccount;
		
		//setting up the interface
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lilybank Wine Merchants:" + " " + customerAccountObject.getAccountName()); //set title to Account Name from JPanel
		setSize(450, 400);
		setLocation(100,100);
		setResizable(false);	
		layoutComponents();
		setVisible(true);	
	}
	
	//GUI Design
	private void layoutComponents()
	{ 
	//setting a font I can read
	Font readableFont = new Font("Arial", Font.BOLD, 14);
	
	//top area
	top = new JPanel();
	top.setBackground(Color.WHITE);
	
	//Opening Phrase
	label = new JLabel("Welcome to Lilybank Wine Merchants Transaction Center");
	label.setFont(readableFont);
	
	//add label and area to Layout
	top.add(label);
	add(top, BorderLayout.NORTH);
	
	//middle area 
	middle = new JPanel();
	middle.setBackground(Color.WHITE);
	
	//Product Name Label
	nameLabel = new JLabel("Please enter the product name");
	nameLabel.setFont(readableFont);
	middle.add(nameLabel);
	
	//Get Product Name from User Input
	nameText = new JTextField(10);
	nameText.addActionListener(this);
	System.out.println(nameText.getText()); //isn't doing this
	middle.add(nameText);

	//Product Amount Label
	amountLabel = new JLabel("Please enter the quantity (i.e. 3)");
	amountLabel.setFont(readableFont);
	middle.add(amountLabel);
	
	//Get Product Amount from User Input. Convert to
	amountText = new JTextField(10);
	System.out.println(amountText.getText());
	middle.add(amountText);
	
	//Product Cost
	priceLabel = new JLabel("Please enter the price of your item £");
	priceLabel.setFont(readableFont);
	middle.add(priceLabel);
	
	//Get Product Cost from User Input
	priceText = new JTextField(10);
	System.out.println(priceText.getText());
	middle.add(priceText);
	
	//Label to be switched to Transaction 
	fillerLabel = new JLabel("Please Press a Button Below to Create the Transaction");
	fillerLabel.setFont(readableFont);
	middle.add(fillerLabel);
	
	//Sale Button
	saleButton = new JButton("Sale");
	saleButton.setFont(readableFont);
	saleButton.addActionListener(this);
	middle.add(saleButton);
	
	//Return Button
	returnButton = new JButton("Return");
	returnButton.setFont(readableFont);
	returnButton.addActionListener(this);
	middle.add(returnButton);
	add(middle, BorderLayout.CENTER);
	
	//bottom area as a grid
	bottom = new JPanel();
	bottom.setLayout(new GridLayout(2,1));
	bottom.setBackground(Color.WHITE);
	
	
	//Get total amount of transaction.sws
	totalAmountLabel = new JLabel("Amount of Transaction:");
	totalAmountLabel.setFont(readableFont);
	bottom.add(totalAmountLabel);
	
	//Total Amount Text Field
	totalAmountText = new JTextField(" ");	
	totalAmountText.setText(customerAccountObject.getTotalCost()+""); 
	bottom.add(totalAmountText);
	System.out.println("From GUI " + totalAmountText);
	
	//Current Balance Label
	currentBalanceLabel = new JLabel("Current Balance:");
	currentBalanceLabel.setFont(readableFont);
	bottom.add(currentBalanceLabel);
	
	//Current Blanace Text Field
	updateCurrentBalanceText = new JTextField(" ");	
	updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); //the extra "" changes the double to a string
	
	bottom.add(updateCurrentBalanceText);
	
	add(bottom, BorderLayout.SOUTH);
	bottom.setVisible(true);
	}
	
	//Controller-ActionPerformed
	public void actionPerformed(ActionEvent decideWhichAction)
	{
		String tempText = amountText.getText().trim();
		String name = nameText.getText();
		Double price = Double.parseDouble(priceText.getText());
		int amount = Integer.parseInt(amountText.getText());
		Wine wine = new Wine(name,price,amount); //create new wine based on the users input
		
		//If amount is not an integer, throw error
		try
		{
			int amountNumber = Integer.parseInt(tempText);
			System.out.println(amountNumber);
		}
		catch(NumberFormatException x)
		{
			System.err.println("No Integer");
		}
		
		//Get the price text, parse into double
		String tempPrice = priceText.getText().trim();
		try 
		{
			double tempPriceDouble = Double.parseDouble(tempPrice);
			System.out.println(tempPriceDouble);
		}
		catch(NumberFormatException priceException)
		{
			System.err.println("Not a double");
		}
		
		//prints out the product name but not checking if not a string
		String tempProductName = nameText.getText().trim();
		System.out.println(tempProductName);
			
			
		if (decideWhichAction.getSource()==saleButton)
		{
			customerAccountObject.Sale(wine);
			printTransaction();
		}
		else if (decideWhichAction.getSource()==returnButton)
		{
			customerAccountObject.Return(wine);
			printReturn();
		}
	
	}
		
	private void printTransaction() 
	{
		//Wine transactionWine = new Wine();
		String name = nameText.getText();
		String amount = amountText.getText();
		String price = priceText.getText();
		//Confirmation Text
		fillerLabel.setText("You would like " + amount + " bottles of " + name + " costing £" + price + " per bottle");//we want to say "but whatever in textfield here", so need to use \ to get the "
		nameText.setText("");
		amountText.setText("");
		priceText.setText("");	
		
		totalAmountText.setText(customerAccountObject.getTotalCost()+""); //the extra "" changes the double to a string
		updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); //the extra "" changes the double to a string

		
	}	
	private void printReturn()
	{
		String name = nameText.getText();
		String amount = amountText.getText();
		String price = priceText.getText();
		//Confirmation Text
		fillerLabel.setText("You would like to return " + amount + " bottles of " + name + " at £" + price + " per bottle.");//we want to say "but whatever in textfield here", so need to use \ to get the "
		nameText.setText("");
		amountText.setText("");
		priceText.setText("");	
		
		totalAmountText.setText(customerAccountObject.getTotalCost()+""); //the extra "" changes the double to a string
		updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); //the extra "" changes the double to a string
	}
}
//when hit button-need to make calcuatlion and show information--then how to get it to keep doing moer--i