/* Model class to define Customer account. 
 * Stores customer name, current balance, and performs operations to balance 
 * Also holds Class constant for serviceCharge.
 */
public class CustomerAccount 
{
	//instance vars
	private String customerName;
	private double currentBalance;
	
	//other vars
	public int saleBottles;
	public double totalCost;
	public int serviceCharge;
	public double credit;
	
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
		double costBottle = wine.getWinePrice();
		
		//Num Bottles
		int numBottles = wine.getBottleNumber();
		
		//TotalCost
		totalCost = numBottles * costBottle;
		
		//updates account balance. Adding because we owe LWM current balance plus total cost.
		currentBalance = currentBalance + totalCost;
		
		//returns total cost as double
		return totalCost;
	}
	
	//Process Return
	public double Return(Wine wine)
	{	
		//Wine Price
		double costBottle = wine.getWinePrice();
				
		//Num Bottles
		int numBottles = wine.getBottleNumber();
		
		//Total Cost
		totalCost = numBottles * costBottle * 0.8;
		
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