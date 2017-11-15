
public class SigmaTest 
{
	public static void main(String[] args)
	{
		
		int [] x = {1000, 10000, -1000, 100000,1000000004};
		//3, -6, 27, 101, 50, 0, -20, -21, 19, 6, 4, -10
		int possum = 0;
		int oddcount = 0;
		int negcount = 0;
		int n = x.length;
		
		for (int i=0; i<n; i++)
		{
			if (x[i] >= 0)
			{
				possum = possum + x[i];
			}
			if (x[i] >= 0 && !(x[i] % 2 == 0))
			{
				oddcount = oddcount + 1;
			}
			if (x[i] < 0)
			{
				negcount = negcount + 1;
			}
		}
		
		System.out.println(possum);
		System.out.println(negcount);
		System.out.println(oddcount);
	
		
	}

}
