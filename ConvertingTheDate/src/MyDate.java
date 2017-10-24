import FormatIO.*;
//stores date as day, mo, year. Have two constructors. 
public class MyDate 
{
	private int day, month, year; //private bc only instance of Date obj can access it--Instance var
	private int ddmmyy;
	
	//MyDate Constroctor-not used to return -set in constructor in class-get using accessors 
	public MyDate(int day, int month, int year) //names do not matter only inside constructor
	{
		this.day = day;
		this.month = month;
		this.year = year;
		//this is those from private---others are the right side
		
		//if two digit presented convert to 4 digits bc--ALWAYS STORE YEAR AS 4 DIGITS
		if (this.year < 20 && this.year > 00)
		{
			this.year += 2000;
			System.out.println(year);
			System.out.println(day);
			System.out.println(month);
			
		}
		else
		{
			this.year += 1900;
			System.out.println(year);
			System.out.println(day);
			System.out.println(month);
		}
		
		
	}
	//constructor 2
	public MyDate(int ddmmyy)
	{
		this.day = ddmmyy / 10000;
		ddmmyy = ddmmyy % 10000;
		
		this.month = ddmmyy / 1000;
		ddmmyy = ddmmyy % 1000;
		
		this.year = ddmmyy / 100;
		ddmmyy = ddmmyy % 100;
		//this.year = (this.year <= 20) ? 2000 + this.year;
		ddmmyy = day + month + year;
		
	}
	//accessor methods
	public int getDay()
	{
		return day;
	}
	public int getMonth()
	{
		return month;
	}
	public int getYear()
	{
		return year;
	}
	
	public String getDDMMYY()
	{
		String ds= "";
		ds += String.format("%02d", day);
		ds += String.format("%02d",  month);
		if(year >= 2000 ) {
			ds += String.format("%02d", (year - 2000));
		}
		else {
			ds += (String.format("%02d", year- 1900));
		}
		
		return ds;
	}
	
	public static void main(String[] args)
	{
		MyDate d1 = new MyDate(10, 14, 2043);
		System.out.println(d1.getDDMMYY());
		
		Console con = new Console();
		d1.printC(con);
	}
	
	public void printC(Console c) //ref c only on this method
	{
	String s = String.format("%02d/%02d/%04d", day, month, year);
	c.println(s);
	}
	
}
