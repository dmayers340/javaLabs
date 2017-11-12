import java.util.*;
import java.io.*;
/**
 * Programming AE2
 * Creates and shows the cipher GUI
 */
public class AssEx2
{
	/**
	 * The main method
	 * @param args the arguments
	 */
	public static void main(String [] args)
	{
		try
		{
			String fileInput = "messageP.txt";
			FileReader reader = new FileReader(fileInput);

			Scanner in = new Scanner(reader);
			
			int nextChar = reader.read();
			char character = (char) nextChar;

			while (in.hasNext());
			{
				String fileIn = in.next();
			int	lengthFileIn = fileIn.length();
				
				fileIn.toCharArray();
			}
		}
		catch (IOException noFile)
		{
			System.err.println("File Not Found");
		}
		CipherGUI CipherGUI = new CipherGUI();
		CipherGUI.setVisible(true);
	}
}
