package com.dmayers.ae;
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

public class LWMGUI extends JFrame implements ActionListener
{
	private JPanel top, middle, bottom;
	private JTextField  updateCurrentBalanceText, totalAmountText, nameText, amountText, priceText;
	private JLabel totalAmountLabel, label, nameLabel, priceLabel, amountLabel, fillerLabel, currentBalanceLabel;
	private JButton saleButton, returnButton;
	
	//create the CustomerAccount object
	private CustomerAccount customerAccountObject;
	
	//Set up the GUI
	public LWMGUI(CustomerAccount customerAccount)
	{
		customerAccountObject = customerAccount;
		
		//setting up the interface
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lilybank Wine Merchants:" + " " + customerAccountObject.getAccountName()); //set title to Account Name from JPanel
		setSize(450, 400);
		setLocation(100,100);
		setResizable(false);//assuming that wine name is not long
		layoutComponents();
		setVisible(true);	
	}
	
	//Setting up the components of the GUI Design
	private void layoutComponents()
	{ 
	//Setting a font I can read
	Font readableFont = new Font("Arial", Font.BOLD, 14);
	
	//Top area
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
	System.out.println(nameText.getText());
	middle.add(nameText);

	//Product Amount Label
	amountLabel = new JLabel("Please enter the quantity (i.e. 3)");
	amountLabel.setFont(readableFont);
	middle.add(amountLabel);
	
	//Get Product Amount from User Input
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
	
	//Label to be switched to transaction information
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
	
	//Total Amount of Transaction Label
	totalAmountLabel = new JLabel("Amount of Transaction:");
	totalAmountLabel.setFont(readableFont);
	bottom.add(totalAmountLabel);
	
	//Total Amount Text Field, provided by Customer Account
	totalAmountText = new JTextField(" ");	
	totalAmountText.setText(customerAccountObject.getTotalCost()+""); 
	bottom.add(totalAmountText);
	
	//Current Balance Label
	currentBalanceLabel = new JLabel("Current Balance:");
	currentBalanceLabel.setFont(readableFont);
	bottom.add(currentBalanceLabel);
	
	//Current Balance Text Field provided by Customer Account
	updateCurrentBalanceText = new JTextField(" ");
	double tempCurrentBalance = customerAccountObject.getCreditCurrentBalance();
	if (tempCurrentBalance < 0)
	{
		double absCurrentBalance = Math.abs(tempCurrentBalance);
		tempCurrentBalance = absCurrentBalance;
		updateCurrentBalanceText.setText(tempCurrentBalance +" CR"); 
	}
	else
	{
		updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); 
	}
	
	bottom.add(updateCurrentBalanceText);
	
	//add the bottom to layout
	add(bottom, BorderLayout.SOUTH);
	bottom.setVisible(true);
	}
	
	//Controller-ActionPerformed
	public void actionPerformed(ActionEvent decideWhichAction)
	{
		
		String amountTextString = amountText.getText().trim();
		String name = nameText.getText();
		String tempPrice = priceText.getText().trim();	//because you were trying to parse here it was throwing the exception 
														//and stopping your code before it even got to your try catch blocks
		
		int amount = 0;
		double price = 0.0;
		
		//If amount is not an integer, throw error--should work now
		try
		{
			amount = Integer.parseInt(amountTextString);
			price = Double.parseDouble(tempPrice);

		}
		catch(NumberFormatException wrongFormat)
		{
			JOptionPane.showMessageDialog(null, "Incorrect information provided."); // now we try to parse and if we can't we do something
																					//if we can then all is good and we can create wine 
																					//(though not sure why you're creating wine...)
		}

		Wine wine = new Wine(name,price,amount); 

		//Process Sale
		if (decideWhichAction.getSource()==saleButton)
		{
			customerAccountObject.Sale(wine);
			printTransaction();
		}
		//Process Return
		else if (decideWhichAction.getSource()==returnButton)
		{
			customerAccountObject.Return(wine);
			printReturn();
		}
	
	}
		
	private void printTransaction() 
	{
		String name = nameText.getText();
		String amount = amountText.getText();
		String price = priceText.getText();
		
		//Transaction Information
		fillerLabel.setText("You would like " + amount + " bottles of " + name + " costing £" + price + " per bottle");
		
		//Set Text fields back to empty
		nameText.setText("");
		amountText.setText("");
		priceText.setText("");	
		
		//update the total amount and current balance boxes
		totalAmountText.setText(customerAccountObject.getTotalCost()+""); 
		
		//updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); if only have this line the result will be in a negative
		
		//this if-else works for everything but sale when initial balance is negative
		double tempCurrentBalance = customerAccountObject.getCreditCurrentBalance();
		if (tempCurrentBalance < 0)
		{
			double absCurrentBalance = Math.abs(tempCurrentBalance);
			tempCurrentBalance = absCurrentBalance;
			updateCurrentBalanceText.setText(tempCurrentBalance +" CR"); 
		}
		else
		{
			updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); 
		}
		
		
	}	
	private void printReturn()
	{
		String name = nameText.getText();
		String amount = amountText.getText();
		String price = priceText.getText();
		
		//Transaction information
		fillerLabel.setText("You would like to return " + amount + " bottles of " + name + " at £" + price + " per bottle.");
		
		//reset text fields
		nameText.setText("");
		amountText.setText("");
		priceText.setText("");	
		
		//update the total amount and current balance boxes
		totalAmountText.setText(customerAccountObject.getTotalCost()+""); 
		updateCurrentBalanceText.setText(customerAccountObject.getCurrentBalance()+""); 
	}
}