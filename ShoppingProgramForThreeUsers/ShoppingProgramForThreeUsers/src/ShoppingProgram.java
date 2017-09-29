/*A program that has 3 users. They enter in the quantity, name, and cost of each item. 
 * If item number is divisible by three, and cost is divisible by three than both cost 
 * and items will be equally distributed. If not, the first user must pay more and gets 
 * the extra items.
 */
import FormatIO.*;

public class ShoppingProgram 
{
	public static void main(String [] arg)
	{
	Console con = new Console("ShopperShare");
	//start program
	con.println("Welcome to ShopperShare. A unique way to shop online");
	con.println("Please start by entering the name of each person using the program:");
	
	//get first person name
	String user1Name = con.readLine();
	con.println("Thank you " + user1Name);
	
	//get second person name
	con.println("Please enter the next name: ");
	String user2Name = con.readLine();
	con.println("Thank you " + user2Name);
	
	//get third person name
	con.println("Please enter the next name: ");
	String user3Name = con.readLine();
	con.println("Thank you " + user3Name);
	
	//ask how many items they have
	con.println("Please enter the quantity of items you have selected: ");
	int itemCount = con.readInt();
	con.println("Thank you. You would like " + itemCount + " items");
	
	con.println("Please enter the name and price of each item. Ex. Banana, 0.49");
	
	//ask for names and price of each item
	for (int i = 0; i <= itemCount; i++)
	{
		if (i < itemCount)
		{
			con.println("Please enter the name of this item");
			con.readLine
			con.println("Please enter the price of this item");
		}
	}
		/*
		else
		{
			con.println("Thank you");
		}}
	}
	
	//tell delivery fee
	//double deliveryFee = 4.50;
	//con.println("Your delivery fee will be £4.50");
	
	//tell price
	 */
	 
	
	}
}
