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
	private FitnessClass[] fclassArray = new FitnessClass[MAXIMUM];
	
	String className;
	int currentNumberOfClasses;
	

	public FitnessProgram() //default constructor to initalize array
	{			
		fclassArray = new FitnessClass[MAXIMUM];
	}

	//get the Fitness Class Object Array
	public FitnessClass[] getObjArray()
	{
		return fclassArray;
	}
	public void getObjTime(FitnessClass[] obj)
	{
		for(int i=0; i<obj.length; i++)
		{
			if(fclassArray[i] == null)
			{
				fclassArray[i] = new FitnessClass();
			}
			else
			{
				fclassArray[fclassArray[i].getTimeStart()-9] = fclassArray[i];
			}
		}
	}
	
	public String getClassLists(int timeStart)
	{
			for (int i=0; i<MAXIMUM; i++)
			{
				FitnessClass fclass = this.getObjArray()[i];
				if( fclass == null)
				{
					className = "Open";
				}
				
				else if (timeStart + 9 == (fclass.getTimeStart())) 
				{
					className = fclass.getClassName();
					return className;
				}
			}
			return className;
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
	public void setAttendances(String attendaceID, int[] attendances)
	{
		for (int i = 0; i<MAXIMUM; i++)
		{
			//loop through array to see if it matches attendance id
			//
		}
	}
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
