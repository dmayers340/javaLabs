import FormatIO.*;
import java.util.*;
import java.lang.*;

public class RandomNumberGeneratorThree 
{
	public static void main(String[] arg)
	{
		Console con = new Console();
		Random rand = new Random();
		boolean playAgain = true;

		con.println("Welcome to Number Picker");
		con.println("You will need to pick a number between 0 and 9");

		while (playAgain)
		{
			userGuess(con, rand);
			
			con.println("If you would like to play again please type yes. Otherwise, type no.");
			String userPlayAgain = con.readLine();
			if (userPlayAgain.toLowerCase().equals("no"))
			{
				con.println("Thank you for playing Number Picker. Goodbye");
				playAgain = false;
			}

		}
	}
	
	private static void userGuess(Console con, Random rand)
	{
		int num = Math.abs(rand.nextInt()) % 10;
		System.out.println(num);
		
		int countTurns = 0;
		
		for (;;)
		{ 
			con.println("Please enter a number between 0 and 9");
			int userAnswerGuess = con.readInt();
			countTurns ++;

			if (userAnswerGuess > num && userAnswerGuess <= 9)
			{
				con.println("Too high! Try again");
			}
			else if (userAnswerGuess < num && userAnswerGuess <= 9)
			{
				con.println("Too low! Try again");
			}
		
			else if (userAnswerGuess == num)
			{
				con.println("Great Job You Won! It took you " + countTurns + " guesses");
				break;
			}
			else
			{
				con.println("You can only enter a number between 0 and 9. Try again");
			}
		}
	}
}