import java.util.*;
import java.lang.*;
import FormatIO.*;

public class RandomNumberGenerator 
{
	Console con = new Console();
	Random rand = new Random();
	int num = Math.abs(rand.nextInt()) % 10;
	 	
	int userNumberGuess = con.readInt();
	
	con.println("Welcome To Number Picker.");
	con.println("You will need to pick a number between 0 and 9. /nWhen you're ready, enter your number below.");
	
	if (userNumberGuess > 9)
	{
		con.println("Invalid Answer");
	}
	else if (userNumberGuess == num)
	{
		con.println("Congratulations! You win!!");
	}
	else if (userNumberGuess > num)
	{
		con.println("Your guess was too high.");
	}
	else if (userNumberGuess < num)
	{
		con.println("Your guess was too low.");
	}
	else
	{
		con.println("Invalid Response");
	}
}
