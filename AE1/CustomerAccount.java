/* Model class to define Customer account. Stores cust name
 * current balance, and performs operations to balance to update
 * instance var: int current balance, string customerName
 */
public class CustomerAccount 
{
	private String customerName;
	private int currentBalance;
	
	public int numBottles;
	public double costBottle;
	public int saleBottles;
	public double totalCost;
	public int serviceCharge;
	
	//constructor initializing instance variables
	CustomerAccount(String name, int currentBalance)
	{
		customerName = name;
		this.currentBalance = currentBalance;
	}
	
	//Process sale of numBottles of wine w/ costBottle
	public double Sale()
	{
		costBottle = costBottle * 100;
		totalCost = numBottles * costBottle;
		totalCost = totalCost / 100;
		//updates account balance
		currentBalance = (int) (currentBalance + totalCost);
		
		//returns total cost as double
		return totalCost;
	}
	
	public double Return()
	{	
		totalCost = numBottles * costBottle * 0.8;
		
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
	public int getCurrentBalance()
	{
		return currentBalance;
	}

}
