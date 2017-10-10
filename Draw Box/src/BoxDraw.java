import FormatIO.*;

public class BoxDraw 
{
	public static void main (String[] arg)
	{
		Console con = new Console("Draw Boxes");
		//String topLine = "";
		
		con.println("How many columns?");
		int colNumber = con.readInt();
		if(colNumber < 0)
		{
			colNumber = 1;
		}
		
		con.println("How many rows?");
		int rowNumber = con.readInt();
		if(rowNumber < 0)
		{
			rowNumber = 1;
		}
		
		
		drawTop(con, rowNumber);
		
		drawSide(con, colNumber);
	
	
		
	}
	
	private static void drawTop(Console con, int rowNumber)
	{
		for (int i = 0; i < rowNumber; i++)
		{
			con.print("+");
		}
	}

	
	private static void drawSide(Console con, int colNumber)
	{
		//for number of Rows, print + followed by -.
		for (int i=0; i < colNumber; i++)
		{
			con.println("-");
		}
		
		//con.println(topLine);
		//return topLine;
	}

}
