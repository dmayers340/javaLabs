
import FormatIO.*;

public class SimpleShopping 
{
	public static void main(String [] arg)
	{
		//defining variables
		double itemCost = 0.00;
		String itemName = "";
		int itemNumber = 0;
		double deliveryFee = 4.50;
		double costPerPerson = 0.00;
		double costFirstPerson = 0.00;
		double totalSum = 0.00;
		double discount = 0.00;
		double discountTotalSum = 0.00;
		double costForFortyItems = 0.00;
		double totalCostForItems = 0.00;
		double discountForForty = 0.00;
		double totalSumForFortyItems = 0.00;
		
		Console con = new Console();
		
		//ask name of item
		con.println("Please enter the name of this item: ");
		itemName = con.readLine();
		System.out.print(itemName);
				
		//ask number of items they have
		con.println("Please enter how many items you have: ");
		itemNumber = con.readInt();
		System.out.print(itemNumber);

		//ask price of items
		con.println("Please enter the price of this item: ");
		itemCost = itemCost + con.readDouble();
		System.out.print(itemCost);

		//total cost
		totalCostForItems = itemCost * itemNumber;
		totalSum = deliveryFee + totalCostForItems;
		String newtotalSum = String.format("%2.2f", totalSum);
		con.println("Your total cost is " + newtotalSum);
		
		//calculate for exactly 40 items
		costForFortyItems = itemCost * 40;
		discountForForty = costForFortyItems * 0.10;
		totalSumForFortyItems = costForFortyItems + deliveryFee - discountForForty;
		System.out.println("cost for forty " + totalSumForFortyItems); 
		System.out.println("total Sum " + totalSum); 
		
		//If total cost is less than the total for 40 items, make cart total 40 items 
		if	((itemNumber < 40) && (totalSum > totalSumForFortyItems))
		{
			
			con.println("It will be cheaper if you order 40 items. \nI have added items to your basket to bring the total to 40 items, and your cost down.");
			int additionalItems = 40 - itemNumber;
			itemNumber = itemNumber + additionalItems;
			con.println("You will recive " + additionalItems + " extra items, to make your total 40 items");
			System.out.println("Total Items " + itemNumber);
			con.println("You will now recieve a discount of " + discountForForty);
			discountTotalSum = totalSum - discount;
			con.println("You will need to pay " + discountTotalSum);
			
			
		}

		else if (itemNumber >= 40)
		{
			discount = totalSum * .10;
			con.println("You will recieve a discount of " + discount);
			discountTotalSum = totalSum - discount;
			con.println("You will need to pay " + discountTotalSum);
			
		}
		//cost per person
		costPerPerson = totalSum / 3;
		costFirstPerson = costPerPerson + (totalSum % 3);
		String newcostPerPerson = String.format("%2.2f", costPerPerson);
		String newcostFirstPerson = String.format("%2.2f", costFirstPerson);
		con.println("The subscriber to this program needs to pay " + newcostFirstPerson);
		con.println("The other two must pay " + newcostPerPerson);
		
	
		//items per person
		int numberofItems = itemNumber / 3;
		int remainder = itemNumber % 3;
		con.println("The subscriber to this program will get " + (numberofItems + remainder) + " items");
		con.println("The other two will get " + numberofItems);
		
	}

}
