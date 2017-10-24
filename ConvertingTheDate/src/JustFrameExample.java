import java.awt.*; //Needed for BorderLayout
import java.awt.event.*; //Needed for Action Listeners etc
import javax.swing.*; //Needed for JFrame and JButton

public class JustFrameExample extends JFrame implements ActionListener
{
	private JButton button;
	private JButton button2;
	private JButton button3;
	private JTextField textField;
	private JLabel label;
	
	
	public JustFrameExample()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);//do not need
		setLocation(100,100); //do not need
		setTitle("MyDate");
		
		
		button = new JButton("Ok");
		button2 = new JButton("Quit");
		button3 = new JButton("Third");
		textField = new JTextField("Please Delete This Default Text");
				
		this.add(button,BorderLayout.NORTH); //add to frame
		this.add(button2, BorderLayout.WEST); //add to frame
		this.add(button3, BorderLayout.EAST);
		this.add(textField, BorderLayout.SOUTH);
		button.addActionListener(this);//when event happens need to tell Java that this will handle button press
		button2.addActionListener(this);//this must have method called action performed
		button3.addActionListener(this);
		textField.addActionListener(this);
		
		label = new JLabel(new ImageIcon("C:\Users\dmaye\Desktop\October15.png"));
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent myevent)
	{
		if(myevent.getSource()==button)
		{
			System.out.println("Got Stuff from OK");
		}
		else if (myevent.getSource()==button2)
		{
			System.out.println("Got Stuff from Quit");
		}
		
		else if (myevent.getSource()==button3)
		{
			System.out.println("Got Stuff From Third");
		}
		else if (myevent.getSource()==textField)
		{
			System.out.println("TextField");
		}
	}
	
	public static void main(String[] Args)
	{
		new JustFrameExample();
	}
}


 
