/*A program that has 3 users. They enter in the quantity, name, and cost of each item. 
 * If item number is divisible by three, and cost is divisible by three than both cost 
 * and items will be equally distributed. If not, the first user must pay more and gets 
 * the extra items.
 * 
 * First ask for names of people using the program. Then ask how many items they have. For 
 * each item they have ask them for item name and price. 
 * Need an array that will Store names into a list, store prices into same list
 */
import FormatIO.*;

public class FinishedShoppingProgram 
{
	public static void main(String [] arg)
	{
	Console con = new Console("ShopperShare");
	int itemNumber = 0;
	String itemName = "";
	double itemCost = 0.00;
	double deliveryFee = 4.50;
	double costPerPerson = 0.00;
	double totalSum = 0.00; 
	double discount = 0.00;
	double discountTotal = 0.00;
	
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
	
	con.println(user1Name + " " + user2Name + " " + user3Name + " Let's start shopping.");
	
	
	//ask how many items they have
	con.println("Please enter the quantity of items you have selected. You may only select up to 10 items: ");
	itemNumber = con.readInt();
	System.out.println(itemNumber);
	int initItemNumber = itemNumber;
	con.println("Thank you. You would like " + itemNumber + " items");
	
	//Instruction for user
	con.println("Please enter the name and price of each item. Ex. Banana, 0.49");
	
	//Loop through this block to get name and price of each item
	while (itemNumber > 0)
	{
		//ask names of items
		con.println("Please enter the name of this item: ");
		itemName = con.readLine();
		System.out.print(itemName);

		//ask price of items
		con.println("Please enter the price of this item: ");
		itemCost = itemCost + con.readDouble();
		System.out.print(itemCost);
		
		itemNumber = itemNumber - 1;
		
	}
	
	//Message when done and calculate cost
	con.println("Great. Thank you. We will now calcualte your total cost.");
	con.println("Remember Delivery Fee is £4.50");
	
	//calculate the total 
	totalSum = deliveryFee + itemCost;
	String newtotalSum = String.format("%2.2f", totalSum);
	con.println("Your total cost is " + newtotalSum);
	
	if (itemNumber >= 40)
	{
		discount = totalSum * 0.10;
		discountTotal = totalSum - discount;
		con.println("Because you have ordered more than 40 items, your total price will be " + discountTotal);
	}

	//calculate total per person, format to nearest pence and assign to each person
	costPerPerson = totalSum / 3;
	String newcostPerPerson = String.format("%2.2f", costPerPerson);
	
	//divide number of items, and make the first person get the remainder
	int numberofItems = initItemNumber / 3;
	int remainder = initItemNumber % 3;
	
	//print out each person's total and the number of items they get
	con.println(user1Name + "You must pay " + newcostPerPerson + "and you will get " + (numberofItems + remainder) + " items");
	con.println(user2Name + "You must pay " + newcostPerPerson + "and you will get " + numberofItems + " items");
	con.println(user3Name + "You must pay " + newcostPerPerson + "and you will get " + numberofItems + " items");
	

	


	}
}