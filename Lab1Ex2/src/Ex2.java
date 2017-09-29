import FormatIO.*;


public class Ex2 
{
	public static void main(String[] arg)
	{
		Console con = new Console();
		FileIn fin = new FileIn("../Lab1Ex1/greeting.txt");
		String word = "";
		word = fin.readWord();
		con.println(word);
	}

}
