
public class Date 
{
	public static main(String[] arg)
	{
		
		
		
		//constructor-like method declration-name of class
		public Date(int day, int month, int year)
		{
			//day;
			//month;
			//year;
			
			//if two digit
			if (year < 20 && year > 00)
			{
				year += 2000;
			}
			else
			{
				year += 1900;
			}
		}
	}
}
 