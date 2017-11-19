/**
 * Programming AE2
 * Class contains Vigenere cipher and methods to encode and decode a character
 */
public class VCipher
{
	private char [] alphabet;   //the letters of the alphabet
	private final int SIZE = 26;
	private char[][] vCipher;
	int holder = 0; 
	/** 
	 * The constructor generates the cipher
	 * @param keyword the cipher keyword
	 */
	public VCipher(String keyword)
	{
		//just change MCipher code a bit
		//create another alphabet array
		alphabet = new char [SIZE];
		
		for(int i = 0; i<SIZE; i++)
		{
			alphabet[i] = (char)('Z' - i);
		}
		int count = keyword.length();
		//create cipher from keyword
		vCipher = new char [keyword.length()][SIZE];
		//find letters in keyword for cipher
		for (int i = 0; i<keyword.length(); i++)
		{
			vCipher[i][holder] = keyword.charAt(i);
		}
		
		boolean inKeyword;
		for (char currentLetter:alphabet)
		{
			inKeyword = false;
			for(int j = 0; j<keyword.length(); j++)
			{
				if (currentLetter == keyword.charAt(j))
				{
					inKeyword = true;
				}
				if(!inKeyword)
				{
					vCipher[count][j] = currentLetter;
					count ++;
				}
			}
			
		}
	}
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */	
	public char encode(char ch)
	{
		char encodedVLetter = ch;
		boolean foundVLetter = false;
		
		for(int i = 0; i<SIZE && !foundVLetter; i++)
		{
			if(ch ==alphabet[i])
			{
				encodedVLetter = vCipher[holder][i];
				holder ++;
				foundVLetter = true;
			}
		}
	    return encodedVLetter;  
	}
	
	/**
	 * Decode a character
	 * @param ch the character to be decoded
	 * @return the decoded character
	 */  
	public char decode(char ch)
	{
	    char character = ch;
	    boolean foundChar = false;
	    
	    for(int i = 0; i<SIZE && !foundChar; i++)
	    {
	    	if (ch == alphabet[i])
	    	{
	    		character = vCipher[holder][i];
	    		holder ++;
	    		foundChar = true;
	    	}
	    }
	    return character;
	}
}
