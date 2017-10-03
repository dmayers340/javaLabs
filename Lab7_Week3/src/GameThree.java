import java.util.*;
import java.lang.*;
import FormatIO.*;

public class GameThree
{
	//main method
	public static void main(String[] arg)
	{
		Console con = new Console();
		Random rand = new Random();
		boolean playAgain = true;
		
		int totalScore = 0;
		int numberGames =0;
		
	
		con.println("Welcome To Number Picker!");
		con.println("You will need to pick a number between 0 and 9.");

		while (playAgain)
		{
			totalScore += userGuess(con, rand);
			numberGames ++;
			//guessNumber = countTurns;

			con.println("If you would like to play again please type yes. Otherwise, type 'no'.");
			String userPlayAgain = con.readLine();
			if(userPlayAgain.toLowerCase().equals("no")) 
			{
				con.println("Thank you for playing. Goodbye.");

				playAgain = false;
			}
			double average = (double) totalScore / numberGames;
			con.println("Your average score was " + average);
				
		}
		
	}
			
	
	//helper method
	private static int userGuess(Console con, Random rand)
	{
		//Have system generate a random number
		int num = Math.abs(rand.nextInt()) % 10;
		System.out.println(num);
		
		//count number of turns to guess the random number
		int countTurns = 0;
		
		//loop through until user gets right guess
		for (;;)
		{
			con.println("When you're ready, enter your number below.");
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
			else if (userNumberGuess > 9)
			{
				con.println("Invalid Answer. Please try again.");
			}
			else if (userNumberGuess == num)
			{
				con.println("Congratulations! You Win! It took you " + countTurns + " guesses.");
				System.out.print(countTurns);
				return countTurns;
			
			}
		}
	}
}