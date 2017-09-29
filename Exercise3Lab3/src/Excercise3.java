//Getting user name, and birthday from console. Creating this into a file"

import FormatIO.*;

public class Excercise3
{
	public static void main(String[] arg)
	{ 
		//define console
		Console con = new Console();
		
		//getting first name
		con.println("Please enter your first name: ");
		String firstName = con.readWord();
		
		//getting last name
		con.println("Please enter your last name: ");
		String lastName = con.readWord();
		
		//making full name
		String fullName = firstName + " " + lastName;
		con.println("Thank you " + fullName);
		

		//getting birthdate
		con.println("Please enter the month you were born in (as a number. i.e. June = 06): ");
		int userBirthMonth = con.readInt();

		con.println("Please enter the day you were born as a number: ");
		int userBirthDay = con.readInt();

		con.println("Please enter the year you were born as a four digit number: ");
		int userBirthYear = con.readInt();
			
			
		//Make sure birthdate is correct. If it is, exit program. If not have them repeat the process. 	
		con.println("Thank you. If your birthdate is " + userBirthMonth + "/" + userBirthDay + "/" + userBirthYear + "please type 'Yes'. Otherwise type 'No'.");
		String userAnswered = con.readWord();
		System.out.println(userAnswered);
			
		//if no, loop through getting birthdate
		if (userAnswered.toLowerCase().equals("no"))
		{
			con.println("I'm sorry, let's try again");
		}
		//if yes, end program
		else 
		{
			con.println("Great. Thank you for your time. Goodbye.");
		}
		
		
		//Create an output file
		FileOut Lab3personnel = new FileOut("Lab3personnel.txt");
		String Lab3personnelString = String.format("%-2.12s %-2.12s was born on %d/%d/%d", firstName, lastName, userBirthMonth, userBirthDay, userBirthYear);
		Lab3personnel.println(Lab3personnelString);
		
	}
	
}

