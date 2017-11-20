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
	int count;
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
			alphabet[i] = (char)('A' + i);
		}
		
		count = keyword.length();
		
		//create cipher from keyword
		vCipher = new char [keyword.length()][SIZE];
		
		//find letters in keyword for cipher
		for (int i = 0; i<keyword.length(); i++)
		{		
			vCipher[i][holder] = keyword.charAt(i);
			for (char currentLetter:alphabet)
			{
				for(int j = 1; j<keyword.length(); j++)
				{
					if (currentLetter == keyword.charAt(j))
					{
						vCipher[i][j] = 'A';
					}
					
					
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
		int encod = ch-'A';
		int checkLen = 0;
		if(checkLen == count)
		{
			checkLen = 0;
		}
		if(encod > 0 && encod < SIZE)
		{
			ch = vCipher[checkLen][encod];
		}
		return ch;

//		boolean foundVLetter = false;
//		
//		for(int i = 0; i<SIZE && !foundVLetter; i++)
//		{
//			if(ch ==alphabet[i])
//			{
//				encodedVLetter = vCipher[holder][i];
//				holder ++;
//				foundVLetter = true;
//			}
//		}
//	    return encodedVLetter;  
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
