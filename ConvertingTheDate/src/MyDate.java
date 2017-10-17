import FormatIO.*;

public class MyDate 
{
	//MyDate Constroctor
	public int MyDate(int day, int month, int year) 
	{
		String ddmmyy = "" + day + month + year;
		//if two digit
		if (year < 20 && year > 00)
		{
			year += 2000;
			return year;
			
		}
		else
		{
			year += 1900;
			return year;
			
		}
	}
	
	
}

 