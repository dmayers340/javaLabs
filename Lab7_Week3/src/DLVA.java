
public class DLVA 
{
	private String areaCode; //two letters (region, registration office)
	private int ageIdentifier; //if Mar-Aug: last two digits of yr-else: Setp-feb +50 to year 
	private String letterSequence; //three letter no meaning
	private String regMark = areaCode + ageIdentifier + letterSequence;
	String getLocalOffice;
	
	char a = areaCode.charAt(0);
	if (a.equals('S') || a.equals('T')) 
	{
		System.out.println("Registered in Scotland");
	}
	else
	{
		System.out.println("Registered elsewhere in GB");
	}
	
	char secondLetter = areaCode.charAt(1);
	switch (secondLetter) 
	{
		case a:
		case B:
		case C:
		case D:
		case E:
		case F:
		case G:
		case H:
		case J:
			System.out.println("Glasgow");
	
	
		case K:
		case L:
		case M: 
		case N:
		case O:
			System.out.println("Edinburgh");

		case P:
		case R:
		case S:
		case T:
			System.out.println("Dundee");

		case U:
		case V:
		case W:
			System.out.println("Aberdeen");

		case X:
		case Y:
			System.out.println("Inverness");

	}
}


public DLVA(String areaCode, int ageIdentifier, String letterSequence)
{
	tempAreaCode = areaCode;
	tempAgeIdentifier = ageIdentifier;
	tempLetterSequence = letterSequence; 
}

