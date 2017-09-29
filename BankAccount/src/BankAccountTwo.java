import FormatIO.*;

public class BankAccountTwo 
{
	public static void main(String [] arg)
	{
		Console con = new Console();
		
		//get account number
		con.println("Please enter your account number");
		String accountNumber = con.readLine();
		
		//get initial deposit
		con.println("Please enter how much you wish to deposit");
		double initialDeposit = con.readDouble();
		
		double currentBalance = initialDeposit;
		
		//create file with bank account number and initial deposit
		String bankFile = "account-" + accountNumber + ".txt";
		String accountLine = accountNumber + " " + initialDeposit;
		
		FileOut bankFileOut = new FileOut(bankFile);
		bankFileOut.println(accountLine);
		
		con.println("Your information has been recorded");
		bankFileOut.close();
		
		//read info from file
		con.print("Please enter your bank account number");
		accountNumber = con.readLine();
		
		bankFile = "account-" + accountNumber + ".txt";
		FileIn bankFileIn = new FileIn(bankFile);
		
		accountNumber = bankFileIn.readWord();
		currentBalance = bankFileIn.readDouble();
		
		bankFileIn.close();
		
		con.println(String.format("The balance of account %s is £%.2f", accountNumber, currentBalance));
		
		
		con.println("If you like to withdraw money type 'withdraw' or if you wish to deposit press 'deposit'.");
		String userAnswerTransaction = con.readLine();
	
		if (userAnswerTransaction.toLowerCase().equals("withdraw"))
		{
			con.println("How much would you like to withdraw?");
			double withdrawAmount = con.readDouble();
			System.out.print(currentBalance);
			con.println("Transaction: " + currentBalance + "-" + withdrawAmount);
			currentBalance = currentBalance - withdrawAmount;
			con.println("Your current balance is " + currentBalance);
		}
		
		else 
		{
			con.println("How much would you like to deposit?");
			double depositAmount = con.readDouble();
			System.out.println(currentBalance);
			con.println("Transaction: " + currentBalance + "+" + depositAmount);
			currentBalance = currentBalance + depositAmount;
			con.println("Your current balance is " + currentBalance);
		}
		
		bankFile = "account-" + accountNumber + ".txt";
		accountLine = accountNumber + " " + currentBalance;
		
		bankFileOut = new FileOut(bankFile);
		bankFileOut.println(accountLine);
		
		bankFileOut.close();
		
		//write statement
		con.println("Bank Statement");
		con.println("Please enter your account number");
		accountNumber = con.readLine();
		
		bankFile = "account-" + accountNumber + ".txt";
		bankFileIn = new FileIn(bankFile);
		
		accountNumber = bankFileIn.readWord();
		currentBalance = bankFileIn.readDouble();
		
		bankFileIn.close();
		
		
	}

}
