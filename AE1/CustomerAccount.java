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
	
	CustomerAccount(String name, double currentBalance)
	{
		customerName = name;
		this.currentBalance = currentBalance;
	}
	
	//Process Sale
	public double Sale(Wine wine)
	{
		//Wine Price
		winePrice = wine.getWinePrice();
		System.out.println("Wine price from CA:" + winePrice);//is getting this
		winePrice = winePrice * 100;
		
		//Num Bottles
		numBottles = wine.getBottleNumber();
		
		//TotalCost
		totalCost = numBottles * winePrice;
		totalCost = totalCost / 100;
		
		//updates account balance
		currentBalance = (int) (currentBalance - totalCost);
		
		//returns total cost as double
		return totalCost;
	}
	
	//Process Return
	public double Return(Wine wine)
	{	
		//Wine Price
		winePrice = wine.getWinePrice();
		winePrice = winePrice * 100;
				
		//Num Bottles
		numBottles = wine.getBottleNumber();
		
		//Total Cost
		totalCost = numBottles * winePrice * 0.8;
		totalCost = totalCost / 100;
		
		//updates account balance
		currentBalance = currentBalance + totalCost;
		
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
		System.out.println("Total Cost from CA: " + totalCost);
		return totalCost;
	}
	public double getCurrentBalance()
	{
		System.out.println("CurrentBalance from CA " + currentBalance);
		return currentBalance;
	}

}