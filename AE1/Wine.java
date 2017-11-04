/*
 * Model Class
 * represented info about type of wine involved in transaction
 * Instance var: wineName, double price of bottle, int quantity needed
 * 
 */
//returned by method in GUI
public class Wine 
{
	//instance vars
	private String wineName;
	private double winePrice;
	private int numberOfBottles;
		
	//constructor to initalize instance variables
	public Wine(String nameOfWine, double priceOfWine, int bottleNumber)
	{
		wineName = nameOfWine; 
		winePrice = priceOfWine;
		numberOfBottles = bottleNumber;
		
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
		return numberOfBottles;
	}
}