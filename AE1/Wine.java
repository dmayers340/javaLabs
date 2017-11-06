/* Model Class
 * Represents info about type of wine involved in transaction
 * Instance var: wineName, double price of bottle, int quantity 
 * Contains:
 * 1.) Constructor to initialize instance vars
 * 2.) Methods to return instance var values
 */

public class Wine 
{
	//instance vars
	private String wineName;
	private double winePrice;
	private int wineAmount;
		
	//constructor to initalize instance variables
	public Wine(String nameOfWine, double priceOfWine, int bottleNumber)
	{
		wineName = nameOfWine; 
		winePrice = priceOfWine;
		wineAmount = bottleNumber;
		
	}
	
	//methods to return values of instance vars
	public String getWineName()
	{
		return wineName;
	}
	
	public double getWinePrice()
	{
		return winePrice;
	}
	
	public int getBottleNumber()
	{
		return wineAmount;
	}
}