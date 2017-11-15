import java.util.Arrays;

/**
 * Programming AE2
 * Contains monoalphabetic cipher and methods to encode and decode a character.
 */
public class MonoCipher
{
	/** The size of the alphabet. */
	private final int SIZE = 26;

	/** The alphabet. */
	private char [] alphabet;
	
	/** The cipher array.
	 * Will take keyword as the first letters and then make the rest of the alphabet after
	 */
	private char [] cipher;
	

	/**
	 * Instantiates a new mono cipher.
	 * @param keyword the cipher keyword
	 */
	public MonoCipher(String keyword)
	{
		//create alphabet
		alphabet = new char [SIZE];
		for (int i = 0; i < SIZE; i++)
			alphabet[i] = (char)('Z' - i);
				
		// create first part of cipher from keyword
		cipher = new char [SIZE];
		for (int i = 0; i < keyword.length(); i++) 
		{
			cipher[i] = keyword.charAt(i);	
		}
		
		//backwards alphabet should start at count which is the end of the keyword 
		int count = keyword.length();
		
		//if in the keyword add to cipher
		boolean inKeyword;

		for (char currentLetter: alphabet) 
		{
			inKeyword = false;
			for (int j = 0; j < keyword.length(); j++)
			{
				if (currentLetter == keyword.charAt(j)) 
				{
					//if letter is in keyword, add to cipher at beginning 
					inKeyword = true;
				}				
			}
			// create remainder of cipher from the remaining characters of the alphabet
			if(!inKeyword) 
			{
				cipher[count] = currentLetter; //letter not in cipher 
				count ++; //increase index
			}
		}
		
		//set alphabet array back to normal
		for (int k = 0; k < SIZE; k++)
			alphabet[k] = (char)('A' + k);
		// print cipher array for testing and tutors                                                                                                                                                                                                                                                                                       
		System.out.println(Arrays.toString(alphabet));
		System.out.println(Arrays.toString(cipher));
	}
	
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */
	public char encode(char ch)
	{	
		char character = ch;
		boolean findCharacter = false;
		
		for(int i=0; i<SIZE && !findCharacter; i++)
		{
			if(ch == alphabet[i])
			{
				character = cipher[i];
				findCharacter = true;
			}			
		}	
		return character;
	}

	/**
	 * Decode a character
	 * @param ch the character to be encoded
	 * @return the decoded character
	 */
	public char decode(char ch)
	{
		char decoded = ch;
		for (int i=0; i<SIZE; i++)
		{
			decoded = alphabet[i];
		}
	    return decoded;  // replace with your code
	}
}