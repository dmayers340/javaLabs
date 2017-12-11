import java.util.*;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 * 
 * entry x: fitness class start at 9+x
 *  * 
 * return instance vars plus method to return Fitness class obj at index x
 * 
 * method return fitness class at particul time
 * method return first start time avaliable
 * return fitness class obj w/ given ID num in array
 * Method to insert/delete fitness class to/from list
 * method to return list sorted in non-increasing order on av attendance each class using arrays.sort
 * method return overall avg attendance
 */
public class FitnessProgram 
{	
	int MAXIMUM = 7;
	private FitnessClass[] fclassArray; // = new FitnessClass[MAXIMUM];
	
	String className;
	String tutorName;
	ArrayList<Integer> attendnaceArray = new ArrayList<Integer>();
	//int[] attendanceArray = new int[5];
	String id;
	int currentNumberOfClasses;
	

	public FitnessProgram() //default constructor to initalize array
	{			
		fclassArray = new FitnessClass[MAXIMUM];
		
	}

	//get the Fitness Class Object Array
	public FitnessClass[] getFitnessClasses()
	{
		return fclassArray;
	}
	

	public void getTime(FitnessClass[] obj)
	{
		for(int i = 0; i<obj.length; i++)
		{
			fclassArray[obj[i].getTimeStart()-9] = obj[i];
		}
		
		for(int i=0; i<MAXIMUM; i++)
		{
			if(fclassArray[i]==null)
			{
				fclassArray[i] = new FitnessClass();
			}
		}		
	}
	
	public String getClassLists(int timeStart)
	{
			for (int i=0; i<MAXIMUM; i++)
			{
				FitnessClass fclass = this.getFitnessClasses()[i];
				if( fclass == null)
				{
					className = "\"OPEN\"";
				}
				
				else if (timeStart + 9 == (fclass.getTimeStart())) 
				{
					className = fclass.getClassName();
					return className;
				}
			}
			return className;
	}
	
	public String getID(int idNum)
	{
			for (int i=0; i<MAXIMUM; i++)
			{
				FitnessClass fclass = this.getFitnessClasses()[i];
				if( fclass == null)
				{
					id = "\"OPEN\"";
				}
				
				else if (idNum + 9 == (fclass.getTimeStart())) 
				{
					id = fclass.getID();
					return id;
				}
			}
			return id;
	}
	public String getTutor(int number)
	{
		for (int i = 0; i<MAXIMUM; i++)
		{
			FitnessClass fclass = this.getFitnessClasses()[i];
			if(fclass == null)
			{
				tutorName = "\"OPEN\"";
			}
			else if(number + 9 == (fclass.getTimeStart()))
			{
				tutorName = fclass.getTutorName();
				return tutorName;
			}
		}
		
		return tutorName;
	}
	
	
	//get the time classes start
	//entry x should contain class starting at time 9 + x or null if free
	public void classStartTime(FitnessClass fitnessClass)
	{
		
		
	}
	
	public int getOpenTime()
	{
		return 1;
	}
	
	//Easier as a String array w/ id? then can say 
	//for(int i=0; i<MAXIMUM; i++){
	//if(attendances[i].getAttednaceID.equals(attendances[0]
	//fclassArray[i].setAttendace(attendances)
	public ArrayList<Integer> setAttendances(String[] attendances)
	{
		for (int i=0; i<MAXIMUM; i++)
		{
			if(fclassArray[i].getAttendanceID().equals(attendances[0]))
			{	
				int weekOne = Integer.parseInt(attendances[1]);
				attendnaceArray.add(weekOne);
				int weekTwo = Integer.parseInt(attendances[2]);
				attendnaceArray.add(weekTwo);
				int weekThree = Integer.parseInt(attendances[3]);
				attendnaceArray.add(weekThree);
				int weekFour = Integer.parseInt(attendances[4]);
				attendnaceArray.add(weekFour);
				int weekFive = Integer.parseInt(attendances[5]);
				attendnaceArray.add(weekFive);

				return attendnaceArray;
			}
			else
			{
				i++;
			}
			//for each attendnace set, loop through check if id matches
		}
		return attendnaceArray;
	}
			//loop through array to see if it matches attendance id
			//
	//method to return list sorted in non-increasing order on av attendance using arrays.sort
	public void sortArray()
	{
		Arrays.sort(fclassArray);
		System.out.println("fclassarray program" + Arrays.asList(fclassArray));
	}
	
	//get fitness class obj with ID number in array or null
	public FitnessClass getClassWithID(String idOfClass)
	{
		//if text box is equal to id number, return that class ID otherwise return nothing
		for(int i = 0; i< MAXIMUM; i++)
		{
			if(fclassArray[i] == null)
			{
				i++;
			}
			else if(fclassArray[i].getID().equals(idOfClass))
			{
				return fclassArray[i];
			}
		}
		return null;
	}
}
