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
	FitnessClass[] fclassArray;
	
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
	
	//get the time classes start
	//entry x should contain class starting at time 9 + x or null if free
	public void classStartTime(FitnessClass fitnessClass)
	{
		
	}
	//method to return list sorted in non-increasing order on av attendance using arrays.sort
	public void sortArray()
	{
		Arrays.sort(fclassArray);
		System.out.println("fclassarray program" + Arrays.asList(fclassArray));
	}
	//populate attendance list for fitness class in array
	public void attendance(String attendances)//given String of single line of attendances from attendancesIn as parameter
	{
		//done at every 5th index of attendance arry from F.Class
	}
	
	//get fitness class obj with ID number in array or null
	public FitnessClass getClassWithID(int i)
	{
		return fclassArray[i];
	}
	
	//get fitness class from time 
	public FitnessClass getStartTime(int i)
	{
		return fclassArray[i];
	}
	
	public FitnessClass getFirstStartTime(int i)
	{
		return fclassArray[i];
		//get first time avaliable
	}
	
	//return fitness class obj at index x
	public FitnessClass retrunFitnessClassObj(int x)
	{
		return fclassArray[x];
	}
	
	//insert a class into array
	public void insert()
	{
		
	}
	
	//remove class from array
	public void delete()
	{
		
	}
	
	//method to return overall average attendance
	public double overallAverage()
	{
		double n = 0.0;
		return n;	
	}
}
