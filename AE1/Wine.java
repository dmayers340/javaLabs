//retruned by method in GUI
public class Wine 
{
	private String wineName;
	private double winePrice;
	private int numberOfBottles;
	
	public Wine(String nameOfWine, double priceOfWine, int bottleNumber)
	{
		wineName = nameOfWine; 
		winePrice = priceOfWine;
		numberOfBottles = bottleNumber;
		
	}
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
