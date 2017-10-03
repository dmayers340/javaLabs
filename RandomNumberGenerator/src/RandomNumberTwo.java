import FormatIO.*;
import java.util.*;
import java.lang.*;

public class RandomNumberTwo 
{
	Console con = new Console();
	Random rand = new Random();
	int num = Math.abs(rand.nextInt()) % 10;
	
	con.println("Welcome to Number Picker");
	con.println("You will need to pick a number between 0 and 9");
	
	int userAnswerGuess = 0;
	
	while (userAnswerGuess = !num)
	{ 
		con.println("Please enter a number between 0 and 9");
		userAnswerGuess = con.readInt();
		
		if (userAnswerGuess > num);
		{
			con.println("Too high! Try again");
		}
		else if (userAnswerGuess < num);
		{
			con.println("Too low! Try again");
		}
	}
	con.println("Great Job You Won!");
}
