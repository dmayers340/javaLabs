import java.util.*;
import java.lang.*;

public class WithoutFormatIO 
{
	public static void main(String[] arg)
	{
		Random rand = new Random();
		
		
		System.out.print("Welcome To Number Picker!");
		System.out.print("\nYou will need to pick a number between 0 and 9");
		Scanner sc = new Scanner(System.in);

		
		userGuess(sc,rand);
		sc.close();	
	}
	
	//helper method
	private static void userGuess(Scanner sc, Random rand)
	{
		//Have system generate a random number
		int num = Math.abs(rand.nextInt()) % 10;
		//System.out.println(num);
		
		//count number of turns to guess the random number
		int countTurns = 0;
		int userNumberGuess = 0;
		
		
		//loop through until user gets right guess
		for (;;)
		{
			System.out.print("When you're ready, please enter your number below.");
			userNumberGuess = sc.nextInt();
			countTurns ++;
			
			//user guesses number
			/*if (userNumberGuess is not an integer)
			{
			con.println("Invalid response. Only integers less than 9 are accepted. Please try again.")
				
			}*/
			if (userNumberGuess > num && userNumberGuess <= 9)
			{
				System.out.print("Your guess was too high. Please try again.");
			}
			else if (userNumberGuess < num && userNumberGuess <= 9)
			{
				System.out.print("Your guess was too low. Please try again.");
			}
			else if (userNumberGuess == num)
			{
				System.out.print("Congratulations! You Win! It took you " + countTurns + " guesses.");
				break;
			}
			else 
			{
				System.out.print("Invalid Answer. Please try again.");
			}
		}
	}
}
