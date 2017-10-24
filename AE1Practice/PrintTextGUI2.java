/*
 * Demonstrates text fields and event handling
 **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class PrintTextGUI2 extends JFrame implements ActionListener
{
	//instance variables are all the components 
	private JPanel top, middle, right;
	private JTextField text;
	private JLabel myLabel;
	private BufferedImage image;
	
	//The constructor adds all the components to the frame
	public PrintTextGUI2()
	{
		//when the user clicks on the close button, the program exits
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("A GUI handling a JTextField event");
		setSize(400,150);
		//set layout
		layoutComponents();
	}

	private void layoutComponents()
	{
		//top panel is green and contains a label and a text field
		top = new JPanel();
		top.setBackground(Color.green);

		//add a label and a text field to the middle panel
		myLabel = new JLabel("Enter a number: ");
		top.add(myLabel);
		text = new JTextField(10);
		text.addActionListener(this);
		top.add(text);

		//add the top panel to the content pane
		add(top,BorderLayout.NORTH);

		//middle panel is white and contains a label
		middle = new JPanel();
		middle.setBackground(Color.white);

		//add a label and a text field to the middle panel
		myLabel = new JLabel("");
		middle.add(myLabel);

		//add the middle panel to the content pane
		add(middle,BorderLayout.CENTER);
		
		//Trying to add an image https://stackoverflow.com/questions/1242581/display-a-jpg-image-on-a-jpanel
		right = new JPanel();
		right.setBackground(Color.blue);
		ImageIcon myPicture = new ImageIcon("C:/Users/dmaye/Desktop/img/03southshields_gate.jpg");
		JLabel label = new JLabel("", myPicture, JLabel.CENTER);
		right.add(label, BorderLayout.EAST);
	}

	//handle return pressed in text field
	public void actionPerformed(ActionEvent e)
	{
		String s = text.getText().trim();
		try 
		{
			int n = Integer.parseInt(s); //object integer-finds int in string
			myLabel.setText("The square root of "+n+" is "+
					String.format("%.2f",Math.sqrt(n)));
		}
		catch (NumberFormatException x) //if fails the try-NumberFormatException already defined
		{
			myLabel.setText("You did not enter an integer!");
		}
		text.setText("");
	}
}
