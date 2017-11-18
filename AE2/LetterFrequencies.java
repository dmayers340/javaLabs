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
			alphabet[i] = (char)('Z' - i);
		}
	}
		
	/**
	 * Increases frequency details for given character
	 * @param ch the character just read
	 */
	public void addChar(char ch)
	{
	    // your code
	}
	
	/**
	 * Gets the maximum frequency
	 * @return the maximum frequency
	 */
	private double getMaxPC()
        {
	    return 0.0;  // replace with your code
	}
	
	/**
	 * Returns a String consisting of the full frequency report
	 * @return the report
	 */
	public String getReport()
	{
	    return "";  // replace with your code
	}
}