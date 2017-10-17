import FormatIO.Console;

public class DateMainMethod 
{
	private static int day;
	private static int month;
	private static int year;
	private static String firstName;
	private static String lastName;
	private static String name;
	
	public static void main(String[] arg)
	{
		Console con = new Console();
		//get the person's name
		new Person();
		con.println("Please enter your first name");
		firstName = con.readLine();
		
		con.println("Please enter your last name");
		lastName = con.readLine();
		
		
		con.println("Please enter the day in a two digit format (ex. 02)");
		day = con.readInt();
		con.println("Please enter the month in a two digit format (ex. Decmeber = 12)");
		month = con.readInt();
		con.println("Please enter the year in a two digit format (ex. 1999=99)");
		year = con.readInt();

		con.println("" + day + "/" + month + "/" + year);
		
		con.println("Thank you for your time");
		
	}
}
