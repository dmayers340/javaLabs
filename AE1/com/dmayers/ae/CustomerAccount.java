package com.dmayers.ae;
/* Model class to define Customer account. Stores customer name
 * current balance, and performs operations to balance to update
 * instance var: int current balance, string customerName
 */
public class CustomerAccount 
{
	//instance vars
	private String customerName;
	private double currentBalance;
	private double credit;
	
	//other vars
	public double costBottle;
	public int numBottles;
	public int saleBottles;
	public double totalCost;
	public int serviceCharge;
	
	
	//Constructor to initalize instance vars
	CustomerAccount(String name, double currentBalance)
	{
		customerName = name;
		this.currentBalance = currentBalance;
		if (currentBalance < 0)
		{
			credit = currentBalance;
		}
	}
	
	//Method to process Sale
	public double Sale(Wine wine)
	{
		//Wine price per bottle
		costBottle = wine.getWinePrice();
		costBottle = costBottle * 100;
		
		//Num Bottles
		numBottles = wine.getBottleNumber();
		
		//TotalCost
		totalCost = numBottles * costBottle;
		totalCost = totalCost / 100;
		
		//updates account balance. Adding because we owe LWM current balance plus total cost.
		currentBalance = currentBalance + totalCost;
		
		//returns total cost as double
		return totalCost;
	}
	
	//Process Return
	public double Return(Wine wine)
	{	
		//Wine Price
		costBottle = wine.getWinePrice();
		costBottle = costBottle * 100;
				
		//Num Bottles
		numBottles = wine.getBottleNumber();
		
		//Total Cost
		totalCost = numBottles * costBottle * 0.8;
		totalCost = totalCost / 100;
		
		//updates account balance, subtracting because LWM owed us money, but now we buy wine
		currentBalance = currentBalance - totalCost;
		
		//return total cost as double
		return totalCost;
	}
	
	//methods to return values of instance vars
	public String getAccountName()
	{
		return customerName;
	}
	public double getTotalCost()
	{
		return totalCost;
	}
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	public double getCreditCurrentBalance()
	{
		return credit;
	}

}