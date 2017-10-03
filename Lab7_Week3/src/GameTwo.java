import java.util.*;
import java.lang.*;
import FormatIO.*;

public class GameTwo
{
	//main method
	public static void main(String[] arg)
	{
		Console con = new Console();
		Random rand = new Random();
	

		con.println("Welcome To Number Picker!");
		con.println("You will need to pick a number between 0 and 9.");

		userGuess(con, rand);
			
	}
	
	//helper method
	private static void userGuess(Console con, Random rand)
	{
		//Have system generate a random number
		int num = Math.abs(rand.nextInt()) % 10;
		System.out.println(num);
		
		//count number of turns to guess the random number
		int countTurns = 0;
		
		//loop through until user gets right guess
		for (;;)
		{
			con.println("When you're ready, please enter your number below.");
			int userNumberGuess = con.readInt();
			countTurns ++;
			
			//user guesses number
			/*if (userNumberGuess is not an integer)
			{
			con.println("Invalid response. Only integers less than 9 are accepted. Please try again.")
				
			}*/
			if (userNumberGuess > num && userNumberGuess <= 9)
			{
				con.println("Your guess was too high. Please try again.");
			}
			else if (userNumberGuess < num && userNumberGuess <= 9)
			{
				con.println("Your guess was too low. Please try again.");
			}
			else if (userNumberGuess == num)
			{
				con.println("Congratulations! You Win! It took you " + countTurns + " guesses.");
				break;
			}
			else 
			{
				con.println("Invalid Answer. Please try again.");
			}
		}
	}
}