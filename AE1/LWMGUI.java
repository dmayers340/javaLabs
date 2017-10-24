import java.awt.*;

import java.awt.event.*;
import javax.swing.*;


//Wine() will figure out what happens when things are entered into textField
public class LWMGUI extends JFrame implements ActionListener
{
	private JPanel top, middle, bottom;
	private JTextField text, nameText, amountText, priceText;
	private JLabel label, nameLabel, priceLabel, amountLabel, fillerLabel, currentBalanceLabel;
	private JButton okButton, cancelButton;
	
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
	middle.add(amountText);
	
	priceLabel = new JLabel("Please enter the price of your item £");
	middle.add(priceLabel);
	priceText = new JTextField(10);
	middle.add(priceText);
	
	fillerLabel = new JLabel("Please create a transaction");
	middle.add(fillerLabel);
	
	//currentBalanceLabel = new JLabel("Current Balance" + currentBalance);
	
	
	add(middle, BorderLayout.CENTER);
	
	bottom = new JPanel();
	bottom.setBackground(Color.blue); 
	
	okButton = new JButton("Sale");
	okButton.addActionListener(this);
	bottom.add(okButton);
	
	cancelButton = new JButton("Return");
	cancelButton.addActionListener(this);
	bottom.add(cancelButton);
	
	add(bottom, BorderLayout.SOUTH);
	bottom.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent decideWhichAction)
	{
		if (decideWhichAction.getSource()==okButton)
		{
			printNameText();
			printAmountText();
			printPriceText();
		}
		else if (decideWhichAction.getSource()==cancelButton)
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
		fillerLabel.setText("You entered: \""+s+"\"");//we want to say "but whatever in textfield here", so need to use \ to get the "
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
