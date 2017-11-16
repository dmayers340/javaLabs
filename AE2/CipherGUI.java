import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/** 
 * Programming AE2
 * Class to display cipher GUI and listen for events
 * 
 * Open input/output files read and write to them
 * give letters to cipher objs, get ecrypted or decrypted chars back
 * 
 * Step 1: Read a file
 */
public class CipherGUI extends JFrame implements ActionListener
{
	
	//instance variables which are the components
	private JPanel top, bottom, middle;
	private JButton monoButton, vigenereButton;
	private JTextField keyField, messageField;
	private JLabel keyLabel, messageLabel;

	//application instance variables
	//including the 'core' part of the textfile filename
	//some way of indicating whether encoding or decoding is to be done
	private MonoCipher mcipher;
	private VCipher vcipher;
	private LetterFrequencies frequentLetters;
	
	private String userKeyword;
	
	boolean vigenere;
	
	/**
	 * The constructor adds all the components to the frame
	 */
	public CipherGUI()
	{
		this.setSize(400,150);
		this.setLocation(100,100);
		this.setTitle("Cipher GUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.layoutComponents();
		
	}
	
	/**
	 * Helper method to add components to the frame
	 */
	public void layoutComponents()
	{
		//top panel is yellow and contains a text field of 10 characters
		top = new JPanel();
		top.setBackground(Color.white);
		keyLabel = new JLabel("Keyword : ");
		top.add(keyLabel);
		keyField = new JTextField(10);
		top.add(keyField);
		this.add(top,BorderLayout.NORTH);
		
		//middle panel is yellow and contains a text field of 10 characters
		middle = new JPanel();
		middle.setBackground(Color.white);
		messageLabel = new JLabel("Message file : ");
		middle.add(messageLabel);
		messageField = new JTextField(10);
		middle.add(messageField);
		this.add(middle,BorderLayout.CENTER);
		
		//bottom panel is green and contains 2 buttons
		bottom = new JPanel();
		bottom.setBackground(Color.white);
		//create mono button and add it to the top panel
		monoButton = new JButton("Process Mono Cipher");
		monoButton.addActionListener(this);
		bottom.add(monoButton);
		//create vigenere button and add it to the top panel
		vigenereButton = new JButton("Process Vigenere Cipher");
		vigenereButton.addActionListener(this);
		bottom.add(vigenereButton);
		//add the top panel
		this.add(bottom,BorderLayout.SOUTH);
	}
	
	/**
	 * Listen for and react to button press events
	 * (use helper methods below)
	 * @param e the event
	 */
	public void actionPerformed(ActionEvent e)
	{
		this.getKeyword();
		this.processFileName();
		
		if (e.getSource()==monoButton)
		{
			//create a monocipher obj named mcipher, give it the userKeyword
			mcipher = new MonoCipher(userKeyword);
			vigenere = false;
			this.processFile(vigenere);
		}
		else if (e.getSource()==vigenereButton)
		{
			vcipher = new VCipher(userKeyword);
			vigenere = true;
			this.processFile(vigenere);
		}
	}
	

	/** 
	 * Obtains cipher keyword
	 * If the keyword is invalid, a message is produced
	 * @return whether a valid keyword was entered
	 */
	private boolean getKeyword()
	{		
		//get keyword from textfield
		userKeyword = keyField.getText().toUpperCase();
		
		//check if keyword is valid 1.) Not null. 2.) no duplicate letters
		if (userKeyword.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Keyword Cannot be empty");
			keyField.setText(""); //reset keyField 
		}
		
//		//check for duplicates
//		for (int i =0; i<userKeyword.length(); i++)
//		{
//			inKeyword = false;
//			
//			//check again, like alphabet
//			for (int j = 0; j<userKeyword.length(); j++)
//			{
//				if (userKeyword.charAt(i) == userKeyword.charAt(j))
//				{
//					inKeyword = true;
//					count++;
//				}
//			}
//			if(inKeyword)
//			{
//				JOptionPane.showMessageDialog(null, "Cannot have duplicate letters");
//				keyField.setText("");
//			}
//		}
		return true;
	}
	
	/** 
	 * Obtains filename from GUI
	 * The details of the filename and the type of coding are extracted
	 * If the filename is invalid, a message is produced 
	 * The details obtained from the filename must be remembered
	 * @return whether a valid filename was entered
	 */
	private String userFileName;
	
	private boolean processFileName()
	{
		userFileName = messageField.getText();
		
		if (userFileName.equals(""))
		{
			JOptionPane.showMessageDialog(null,  "Cannot Be Empty");
		}
		return true;
	}
	
	/** 
	 * Reads the input text file character by character
	 * Each character is encoded or decoded as appropriate
	 * and written to the output text file
	 * @param vigenere whether the encoding is Vigenere (true) or Mono (false)
	 * @return whether the I/O operations were successful
	 */
	

	private boolean processFile(boolean vigenere)
	{	
		char fileChar = 0;
		FileReader userFileReader = null;

		try
		{
			try
			{
				userFileReader = new FileReader(userFileName + ".txt");
				boolean finishedReading = false;
				
				while (!finishedReading)
				{
					//keep reading characters until -1 
					int nextChar = userFileReader.read();
					
					// -1 indicates EOF
					if (nextChar == -1)
					{
						//if EOF then it is finished
						finishedReading = true;
					}
					else
					{
						//make nextChar into chars
						fileChar = (char) nextChar;
						System.out.print(fileChar);
						char characterMEncoded = mcipher.encode(fileChar);
						System.out.println(characterMEncoded);
						
					}
				}
			}
			finally 
			{
				//even if exception is raised
				System.out.println("\nEOF");
				//close the file
				if (userFileReader != null)
				{
					userFileReader.close();
				}
			}
		}
		catch (IOException noFileFound)
		{
			System.err.println("Could not find file: " + noFileFound);
		}		


		return true;
	}
}
