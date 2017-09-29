//Program to make a console, read text input from user, print with System.err and then start a expression with a number

import FormatIO.*;

public class Ex2 
{
	public static void main(String[] arg)
	{
		//Declare Console
		Console con = new Console("Get User Input");
		
		//have user input on console and make a string
		con.println("Please enter a color and a number: ");
		String userInput = con.readLine();
		System.out.println(userInput);
		
		//take that string and make it a StringIn object
		StringIn userLine = new StringIn(userInput);
		
		//Read word from StringIn store as var and print
		String firstWord = userLine.readWord();
		
		//Read number and store as variable 
		double firstNumber = userLine.readDouble();
		
		System.out.println(userInput);
		System.err.println(firstWord);
		System.err.println(""+ firstNumber);
	}

}
