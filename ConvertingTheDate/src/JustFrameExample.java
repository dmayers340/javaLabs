import java.awt.*; //Needed for BorderLayout
import java.awt.event.*; //Needed for Action Listeners etc
import javax.swing.*; //Needed for JFrame and JButton

public class JustFrameExample extends JFrame implements ActionListener
{
	private JButton button;
	private JButton button2;
	
	
	public JustFrameExample()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);
		setLocation(100,100);
		setTitle("MyDate");
		
		
		button = new JButton("Ok");
		button2 = new JButton("Quit");
		this.add(button,BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		button.addActionListener(this);
		button2.addActionListener(this);
		
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
	}
	
	public static void main(String[] Args)
	{
		new JustFrameExample();
	}
}


 
