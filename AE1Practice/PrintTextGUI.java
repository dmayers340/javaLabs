/*
 * Demonstrates text fields and event handling
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrintTextGUI extends JFrame implements ActionListener
{
	//instance variables are all the components 
	private JPanel top, middle, bottom;
	private JTextField text;
	private JLabel label;
	private JButton printButton, clearButton;

	//The constructor adds all the components to the frame
	public PrintTextGUI()
	{
		//when the user clicks on the close button, the program exits
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A sample GUI with two buttons and a text field");
		setSize(400,150);
		setLocation(100,100);

		//set layout
		layoutComponents(); //calls method
	}

	private void layoutComponents() //helpermethod only called by constructor so can be private
	{
		//top panel is white and contains a button
		top = new JPanel();
		top.setBackground(Color.white);

		//create button with listener and add to the top panel
		printButton = new JButton("Print text");
		printButton.addActionListener(this);
		top.add(printButton);

		clearButton = new JButton("Clear text");
		clearButton.addActionListener(this);
		top.add(clearButton);

		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);

		//middle panel is green and contains a label and a text field
		middle = new JPanel();
		middle.setBackground(Color.white);

		//add a label and a text field to the middle panel
		JLabel enterLabel = new JLabel("Enter text here: ");
		middle.add(enterLabel);
		text = new JTextField(10);
		middle.add(text);
		add(middle, BorderLayout.CENTER);

		bottom = new JPanel();
		bottom.setBackground(Color.white);
		label = new JLabel("This is the bottom area where text will be placed from TextField");
		bottom.add(label);
		add(bottom, BorderLayout.SOUTH);
	}

	//handle button events

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==printButton)
			printText();
		else if (e.getSource()==clearButton)
			clearText();
	}

	//action if print button pressed
	//make new method to call above
	private void printText()
	{
		String s = text.getText();
		label.setText("You entered: \""+s+"\"");//we want to say "but whatever in textfield here", so need to use \ to get the "
		text.setText("");//clears whatever is in text field
	}

	//action if clear button pressed
	private void clearText()
	{
		label.setText("");
		text.setText("");
	}
}
