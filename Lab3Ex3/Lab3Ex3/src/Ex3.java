//Getting user name, and birthday from console. Creating this into a file"

import FormatIO.*;

public class Ex3 
{
	//static method can be invoked without creating objects
	//void don't expect any return  
	
	public static void main(String[] arg)
	{ 
		//define console
		Console con = new Console();
		
		int userBirthMonth;
		int userBirthDay;
		int userBirthYear;
		
		//getting user name
		con.println("Please enter your first name: ");
		String firstName = con.readWord();
		
		con.println("Please enter your last name: ");
		String lastName = con.readWord();
		
		String fullName = firstName + " " + lastName;
		con.println("Thank you " + fullName);
		
		String userAnswer = "";
		int attempts =  0;
		
		do
		{
			//getting Month
		con.println("Please enter the month you were born in (as a number. i.e. June = 06): ");
		userBirthMonth = con.readInt();

		//getting Day
		con.println("Please enter the day you were born as a number: ");
		userBirthDay = con.readInt();

		//getting Year
		con.println("Please enter the year you were born as a four digit number: ");
		userBirthYear = con.readInt();

		// Make sure birthdate is correct. If it is, exit program. If not have them repeat the process.
		con.println("Thank you. If your birthdate is " + userBirthMonth + "/" + userBirthDay + "/" + userBirthYear + " please type 'Yes'. Otherwise type 'No'.");
		userAnswer = con.readWord();
		System.out.println(userAnswer);
		attempts ++;
		
			if (attempts >= 2)
			{
				con.println("I'm sorry you have exceeded the maximum number of attempts.");
			}
		}
		while(userAnswer.toLowerCase().equals ("no") && attempts < 2);
		
		con.println("Thank you for your time.");
		
		//Create an output file
		FileOut Lab3personnel = new FileOut("Lab3personnel.txt");
		String Lab3personnelString = String.format("%-2.12s %-2.12s was born on %d/%d/%d", firstName, lastName, userBirthMonth, userBirthDay, userBirthYear);
		Lab3personnel.println(Lab3personnelString);
	
	}
}
			
		
		


