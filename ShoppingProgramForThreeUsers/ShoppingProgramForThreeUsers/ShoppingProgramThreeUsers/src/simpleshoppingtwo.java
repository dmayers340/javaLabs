import FormatIO.Console;

public class simpleshoppingtwo
{
	public static void main(String [] arg)
	{
		//defining variables
		Console con = new Console();
		String itemName = "";
		int itemNumber;
		double itemCost;
		int deliveryFee = 450;
		int costPerPerson;
		int costFirstPerson;
		int discount;
		int itemIntCost = 0;
		int discountTotalSum;
		int costForFortyItems = 0;
		int totalCostForItems;
		int discountForForty;
		int totalSumForFortyItems;
		
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
		
		con.println("Alright " + user1Name + ", " + user2Name + ", and " + user3Name + ". Let's start shopping.");
		
		//ask number of items they have
		con.println("Please enter how many items you have: ");
		itemNumber = con.readInt();
		System.out.print(itemNumber);
				
		//ask name of item
		con.println("If you would like batteries, type battery. \nIf you would like a torch, type torch. \nIf you would like a lightbulb, type light. \nOtherwise type other.");
		itemName = con.readLine();
		
		if (itemName.toLowerCase().equals("battery"))
		{
			
			int batteryPrice = 50;
			costForFortyItems = batteryPrice * 40 + deliveryFee;
			totalCostForItems = batteryPrice * itemNumber + deliveryFee;
			con.println("Great, you would like " + itemNumber + " batteries. This will cost £" + (totalCostForItems / 100.0));
		}
		else if (itemName.toLowerCase().equals("torch"))
		{
			int torchPrice = 399;
			costForFortyItems = torchPrice * 40 + deliveryFee;
			totalCostForItems = torchPrice * itemNumber + deliveryFee;
			con.println("\"Great, you would like " + itemNumber + " torches. This will cost £" + (totalCostForItems / 100.0));
		}
		else if (itemName.toLowerCase().equals("light"))
		{
			int lightPrice = 77;
			costForFortyItems = lightPrice * 40 + deliveryFee;
			totalCostForItems = lightPrice * itemNumber + deliveryFee;
			con.println("Great, you would like " + itemNumber + " lights. This will cost £" + (totalCostForItems/ 100.0));
		}
		else
		{
			con.println("Great, you would like " + itemName);
			//ask price of items
			con.println("Please enter the price of this item: ");
			itemCost = con.readDouble();
			itemIntCost = (int) (100.0 * itemCost);
			System.out.print(itemCost);
			//total cost including delivery fee
			totalCostForItems = (itemIntCost * itemNumber + deliveryFee);
			con.println("\nThe total cost for your items including delivery fee is £" + (totalCostForItems / 100.0));
			
			costForFortyItems = itemIntCost * 40 + deliveryFee;
			discountForForty = (int) (costForFortyItems * 0.10);
			totalSumForFortyItems = costForFortyItems - discountForForty;
		}
		discountForForty = (int) (costForFortyItems * 0.10);
		totalSumForFortyItems = costForFortyItems - discountForForty;
		
		System.out.println("\ncost for forty " + totalSumForFortyItems); 
		System.out.println("\ntotal Sum " + totalCostForItems); 
		
		//If total cost is less than the total for 40 items, make cart total 40 items 
		if	((itemNumber < 40) && (totalCostForItems > totalSumForFortyItems))
		{
			
			con.println("\nIt will be cheaper if you order 40 items. \nI have added items to your basket to bring the total to 40 items, and lower your cost.");
			int additionalItems = 40 - itemNumber;
			itemNumber = itemNumber + additionalItems;
			con.println("\nYou will recive " + additionalItems + " extra items, to make your total 40 items");
			System.out.println("Total Items " + itemNumber);
			con.println("You will now recieve a discount of £" + (discountForForty / 100.0));
			
			discountTotalSum = totalSumForFortyItems;
			con.println("\nYou will need to pay £" + (totalSumForFortyItems / 100.0) + " for your items, rather than £" + (totalCostForItems / 100.0));
			con.println("This will bring your total balance (including delivery fee) to £" + (discountTotalSum / 100.0));
		}

		else if (itemNumber >= 40)
		{
			discount = (int) (totalCostForItems * 0.10);
			con.println("You will recieve a discount of £" + (discount / 100.0));
			discountTotalSum = totalCostForItems - discount;
			con.println("You will need to pay £" + (discountTotalSum / 100.0) + " for your items");
			con.println("\nThis brings your total balance (including delivery fee) to £" + (discountTotalSum / 100.0));	
		}
		else
		{
			discountTotalSum = totalCostForItems;
			con.println("You will recieve " + itemNumber + " the total cost of this transaction will be £" + (discountTotalSum / 100.0));
		}
		
		//cost per person
		costPerPerson = discountTotalSum / 3;
		costFirstPerson = costPerPerson + discountTotalSum % 3;
		System.out.println("total discount" + discountTotalSum);
		System.out.println("CostPerPerson " + costPerPerson);
		System.out.print("CostRemainder" + costFirstPerson);
		String newcostPerPerson = String.format("%2.2f", costPerPerson / 100.0);
		String newcostFirstPerson = String.format("%2.2f", costFirstPerson / 100.0);
		con.println("\n" + user1Name + " needs to pay £" + newcostFirstPerson);
		con.println(user2Name + " and " + user3Name + " must pay £" + newcostPerPerson);
		
		System.out.println("\ntotal" + (costPerPerson + costPerPerson + costFirstPerson));
		
		//items per person
		int numberofItems = itemNumber / 3;
		int remainder = itemNumber % 3;
		con.println("\n" + user1Name + " will recieve " + (numberofItems + remainder) + " items.");
		con.println(user2Name + " and " + user3Name + " will recieve " + numberofItems + " item(s)."); 
		
	}

}