/*
 * User Interface, handle events=View/Controller Class
 * 1. Layout components
 * 2. Listen for events
 * Process Sales and Returns
 */
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;


//Wine() will figure out what happens when things are entered into textField
public class LWMGUI extends JFrame implements ActionListener
{
	private JPanel top, middle, bottom;
	private JTextField text, nameText, amountText, priceText;
	private JLabel label, nameLabel, priceLabel, amountLabel, fillerLabel, currentBalanceLabel;
	private JButton saleButton, returnButton;
	
	public LWMGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lilybank Wine Merchants");
		setSize(400, 400);
		setLocation(100,100);
		setResizable(false);	
		layoutComponents();
		setVisible(true);
		
	}
	
	
	private void layoutComponents()
	{
	top = new JPanel();
	top.setBackground(Color.gray);
	//set font to White and Bold and background color to burgundy/maroon (color of red wine)
	
	label = new JLabel("Hello. Welcome to Lilybank Wine Merchants Transaction Center");
	top.add(label);
	
	add(top, BorderLayout.NORTH);
	
	middle = new JPanel();
	middle.setBackground(Color.WHITE);
	
	nameLabel = new JLabel("Please enter the product name");
	middle.add(nameLabel);
	nameText = new JTextField(10);
	middle.add(nameText);
	
	amountLabel = new JLabel("Please enter the quantity (i.e. 3)");
	middle.add(amountLabel);
	amountText = new JTextField(10);
	//int amountNumber = Integer.parseInt(amountText);
	middle.add(amountText);
	
	priceLabel = new JLabel("Please enter the price of your item £");
	middle.add(priceLabel);
	priceText = new JTextField(10);
	middle.add(priceText);
	
	fillerLabel = new JLabel("Please Press a Button Below to Create the Transaction");
	middle.add(fillerLabel);
	
	//currentBalanceLabel = new JLabel("Current Balance" + currentBalance);
	
	
	add(middle, BorderLayout.CENTER);
	
	bottom = new JPanel();
	bottom.setBackground(Color.blue); 
	
	saleButton = new JButton("Sale");
	saleButton.addActionListener(this);
	bottom.add(saleButton);
	
	returnButton = new JButton("Return");
	returnButton.addActionListener(this);
	bottom.add(returnButton);
	
	add(bottom, BorderLayout.SOUTH);
	bottom.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent decideWhichAction)
	{
		if (decideWhichAction.getSource()==saleButton)
		{
			printNameText();
			//printAmountText();
			//printPriceText();
		}
		else if (decideWhichAction.getSource()==returnButton)
			//exitProgram()
			//printText();
			System.out.println("aswerio");
		else if (decideWhichAction.getSource()==nameText)
			System.out.println("name");
		else if (decideWhichAction.getSource()==priceText)
			System.out.println("pirce");
		else if (decideWhichAction.getSource()==amountText)
			System.out.println("amount");
	}
	private void printNameText() 
	{
		String s = nameText.getText();
		fillerLabel.setText("You would like " + s);//we want to say "but whatever in textfield here", so need to use \ to get the "
		nameText.setText("");//clears whatever is in text field
		
	}
	private void printAmountText()
	{
		String amount = amountText.getText();
		fillerLabel.setText("You entered: \""+amount+"\"");
		amountText.setText("");
	}
	private void printPriceText()
	{
		String s = priceText.getText();
		fillerLabel.setText("You entered: \""+s+"\"");
		priceText.setText("");
	}
}
