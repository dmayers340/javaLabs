import FormatIO.*;


public class Ex2 
{
	public static void main(String[] arg)
	{
		
	Console con = new Console();
	con.println("Hello");
	String firstName = "";
	String lastName = "";
	String fullName = "";
	
	con.print("Please enter your first name: ");
	firstName = con.readLine();
	
	
	fullName = firstName + " " + lastName;
	
	String message2 = "Hello" + fullName + "Welcome to Glasgow.";
	
	}
}
