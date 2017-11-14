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
	 * Will take keyword as the first letters and then make the rest of the alpabet after
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
			alphabet[i] = (char)('A' + i);
		
		System.out.println("monoc " + keyword);
		char keywordArray[] = new char[(keyword.length())];
		for (int keywordLength =0; keywordLength<keyword.length();keywordLength++)
		{
			for (int alphabetLength = 0; alphabetLength<SIZE; alphabetLength++)
			{
				if (alphabet[alphabetLength]==keyword.charAt(keywordLength))
				{
					keywordArray[keywordLength]=cipher[alphabetLength];
				}
			}
		}
		//[ , , ]?? WITH KEYWORD ABC
		System.out.println(Arrays.toString(keywordArray));
		System.out.println(Arrays.toString(alphabet));
		// create first part of cipher from keyword
		// create remainder of cipher from the remaining characters of the alphabet
		// print cipher array for testing and tutors
	}
	
	/**
	 * Encode a character
	 * @param ch the character to be encoded
	 * @return the encoded character
	 */
	public char encode(char ch)
	{
	    return ' ';  // replace with your code
	}

	/**
	 * Decode a character
	 * @param ch the character to be encoded
	 * @return the decoded character
	 */
	public char decode(char ch)
	{
	    return ' ';  // replace with your code
	}
}
