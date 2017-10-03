import java.util.*;
import java.lang.*;
import FormatIO.*;

public class GameOne
{
	public static void main(String[] arg)
	{
		Console con = new Console();
		Random rand = new Random();

		con.println("Welcome To Number Picker!");
		con.println("You will need to pick a number between 0 and 9.");
		
		userGuess(con, rand);	
	}
	
	//need (to contain what info is being shared)
	private static void userGuess(Console con, Random rand)
	{
		//Have system generate a random number
		int num = Math.abs(rand.nextInt()) % 10;
		System.out.println(num);
		
		con.println("When you're ready, enter your number below.");
		int userNumberGuess = con.readInt();
		
		//user guesses number
		if (userNumberGuess == num)
		{
			con.println("Congratulations! You Win!");
		}
		if (userNumberGuess > 9)
		{
			con.println("Invalid Answer");
		}
		else if (userNumberGuess > num)
		{
			con.println("Your guess was too high.");
		}
		else if (userNumberGuess < num)
		{
			con.println("Your guess was too low.");
		}
	}
}