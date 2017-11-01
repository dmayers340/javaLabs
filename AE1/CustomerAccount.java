/* Model class to define Customer account. Stores cust name
 * current balance, and performs operations to balance to update
 * instance var: int current balance, string customerName
 */
public class CustomerAccount 
{
	//instance vars
	private String customerName;
	private double currentBalance;
	
	//other vars
	public double winePrice;
	public int numBottles;
	public int saleBottles;
	public double totalCost;
	public int serviceCharge;
	
	//reference to the Wine Script
	//Wine wine;
	
	//constructor initializing instance variables--this is what is referenced when creating new obj
	//this is int and the ass ex is double
	CustomerAccount(String name, double currentBalance)
	{
		customerName = name;
		this.currentBalance = currentBalance;
	}
	
	//Process sale of numBottles of wine w/ costBottle
	public double Sale(Wine wine)
	{
		winePrice = wine.getWinePrice();
		
		//sets to a whole number
		winePrice = winePrice * 100;
		
		//get the number of bottles from Wine Class
		numBottles = wine.getBottleNumber();
		
		//calculate the total cost by multiplying quantity * price
		totalCost = numBottles * winePrice;
		
		//divide by 100 to put back into a float
		totalCost = totalCost / 100;
		
		//updates account balance
		currentBalance = (int) (currentBalance + totalCost);
		
		//returns total cost as double
		return totalCost;
	}
	
	public double Return(Wine wine)
	{	
		totalCost = numBottles * winePrice * 0.8;
		
		//updates account balance
		//currentBalance = currentBalance + totalCost;
		
		//return total cost as double
		return totalCost;
	}
	//accessor to get instance var
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

}