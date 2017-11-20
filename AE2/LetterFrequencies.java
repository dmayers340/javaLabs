/**
 * Programming AE2
 * Processes report on letter frequencies
 * Set up in constructor
 * Given letters as encryption or decryption happens
 * -when this obj should calculate frequenceis and how report
 * totals and frequencies for each letter
 * and also most frequent letterf to GUI class
 */
public class LetterFrequencies
{
	/** Size of the alphabet */
	private final int SIZE = 26;
	
	/** Count for each letter */
	private int [] alphaCounts;
	
	/** The alphabet */
	private char [] alphabet; 
												 	
	/** Average frequency counts */
	private double [] avgCounts = {8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0,
							       0.2, 0.8, 4.0, 2.4, 6.7, 7.5, 1.9, 0.1, 6.0,  
								   6.3, 9.1, 2.8, 1.0, 2.4, 0.2, 2.0, 0.1};

	/** Character that occurs most frequently */
	private char maxCh;

	/** Total number of characters encrypted/decrypted */
	private int totChars;
	
	/**
	 * Instantiates a new letterFrequencies object.
	 */
	public LetterFrequencies()
	{
		//SET UP array-code from MonoCipher
		alphabet = new char[SIZE];
		alphaCounts = new int[SIZE];
		for (int i = 0; i < SIZE; i++)
		{
			alphabet[i] = (char)('A' + i);
			System.out.println("letterfrequencies " + alphabet[i]);
		}
	}
		
	/**
	 * Increases frequency details for given character
	 * @param ch the character just read
	 */
	public void addChar(char ch)
	{
		char characterFrequent = ch;
		boolean foundCharInText = false;
		
		for(int i = 0; i<SIZE && !foundCharInText; i++)
		{
			if(characterFrequent == alphabet[i])
			{
				foundCharInText = true;
				alphaCounts[i]++; //increase count of each individual letter
				totChars++; //increase total numbers
			}
		}
	}
	
	/**
	 * Gets the maximum frequency
	 * @return the maximum frequency
	 */
	private double getMaxPC()
    {
		maxCh = 0;
		
		for(int i =0; i<SIZE; i++)
		{
			maxCh = alphabet[i];

			if(maxCh < alphaCounts[i])
			{
				maxCh = (char) alphaCounts[i];
			}
		}
		
		double max = (double)maxCh/totChars;
		System.out.println("letterfre" + max);
		return max;
	}
	
	/**
	 * Returns a String consisting of the full frequency report
	 * @return the report
	 * 1. return letter...then freq...freq%, avgfreq%...diff between freq% and avfreq
	 */
	public String getReport()
	{
		//Structure report with header, then row definition
		String textReport = "";
		String header = "Letter Analysis";
		String headerTwo = String.format("\n%10s, %10s, %10s, %10s, %10s", "Letter", "Freq", 
				"Freq%", "AvgFreq%", "Diff"); //row definition
		
		String frequency = String.format("%5s %c %s %.1f", "The most frequent letter is ", maxCh, "at", getMaxPC(), "%."); //LAST line of file
		
		//Define Grid
		String colOne;
		String colTwo;
		String colThree;
		String colFour;
		String colFive;
		
		//get Freq%
		for(int i = 0; i<SIZE; i++)
		{
			double displayFreqPerc = (double)(alphaCounts[i])/totChars;
			double difference = displayFreqPerc-avgCounts[i];
			
			colOne = String.format("%5s", (char)('A' + i));
			colTwo = String.format("%5s", alphaCounts[i]);
			colThree = String.format("%5s", displayFreqPerc);
			colFour = String.format("%5s", avgCounts[i]);
			colFive = String.format("%5s\n", difference);
			
			textReport = colOne + colTwo +colThree + colFour + colFive; 	
		}
		
		String finalReport = header + headerTwo + textReport + frequency;
		return finalReport;
	}
}