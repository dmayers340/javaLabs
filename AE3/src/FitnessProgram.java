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
	private FitnessClass[] fclassArray; 
	private FitnessClass[] sorted;
	private String className;
	private String tutorName;
	private String id;
	private String attendnace;
	private int currentNumberOfClasses;
	private FitnessClass fclass = new FitnessClass();

	public FitnessProgram() //default constructor to initalize array
	{			
		fclassArray = new FitnessClass[MAXIMUM];
	}

	//get the Fitness Class Object Array
	public FitnessClass[] getFitnessClasses()
	{
		return fclassArray;
	}
	
	//get the starting time
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
	
	//get the time classes start
		//entry x should contain class starting at time 9 + x or null if free
		public void classStartTime(FitnessClass fitnessClass)
		{
			
			
		}
		
		//returns the first open time for a class
		public int getOpenTime()
		{
			int x;
			for(x=0; x<MAXIMUM; x++)
			{
				//loop through fclass array, if the time is null, return
				if(fclassArray[x] == null)
				{
					x = x+9;
					return x;
				}
			}
			System.out.println("Open time " + x);
			return x;
		}
		
	//Gets the list of Class Name for display in GUI
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
	
	//Gets the list of Class ID for display in GUI
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
	
	//Gets the list of Class Tutor for display in GUI
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
	
	//get fitness class obj with ID number in array or null
	public FitnessClass getClassWithID(String idOfClass)
	{
		//if text box is equal to id number, return that class ID otherwise return nothing
		for(int i = 0; i< MAXIMUM; i++)
		{
			if(fclassArray[i].getID().equals(idOfClass))
			{
				return fclassArray[i];
			}
			else if(fclassArray[i] == null)
			{
				i++;
			}
		}
		return null;
	}
	
//	There should also be a method to populate the attendance lists for a given Fitness Class in the array, 
//	given a String representing a single line of AttendancesIn.txt as a parameter.
	public String attendnaces(String attendanceLine) 
	{
		String[] lineSplit = attendanceLine.split(" ");
		String attendanceid = lineSplit[0];
		int weekOne = Integer.parseInt(lineSplit[1]);
		int weekTwo = Integer.parseInt(lineSplit[2]);
		int weekThree = Integer.parseInt(lineSplit[3]);
		int weekFour = Integer.parseInt(lineSplit[4]);
		int weekFive = Integer.parseInt(lineSplit[5]);
		int[] attendanceArray = {weekOne, weekTwo, weekThree, weekFour, weekFive};
				
		fclass.setAttendance(attendanceArray);
		String array = Arrays.toString(attendanceArray);
		System.out.println("FProgram " + array); 
		System.out.println("\nFrom prog: " + attendanceLine);
		return array;		
	}
	
	public String getAttendnaces(int number)
	{
		for (int i = 0; i<MAXIMUM; i++)
		{
			FitnessClass fclass = this.getFitnessClasses()[i];
			if(fclass == null)
			{
				attendnace = "\"OPEN\"";
			}
			else if(number + 9 == (fclass.getTimeStart()))
			{
				attendnace = Arrays.toString(fclass.getAttendance());
				return attendnace;
			}
		}
		return attendnace;
	}
	
	//method to return list sorted in non-increasing order on av attendance using arrays.sort
	public String sortArray()
	{
		int classes = 0;
		if(classes == MAXIMUM)
		{
			sorted = (FitnessClass[]) fclassArray.clone();
		}
		else
		{
			sorted = new FitnessClass[classes];
			
			for (int i = 0; i< MAXIMUM; i++)
			{
				FitnessClass fclass = fclassArray[i];
				
				if( fclass != null)
				{
					sorted[i] = fclass;
				}
			}
		}
		Arrays.sort(sorted);
		System.out.println("fclassarray program" + Arrays.asList(sorted));
		return Arrays.toString(sorted);
	}
	
	//loop through each fclass attendnace array, get avg attendnace
	//return average
	public String getAverage(int num)
	{
		String avgString = "";
		//THIS BIT RETURNS 12
//		double avg = fclass.averageAttendance();
//		System.out.println("average from fprog " + avg);
//		String avgString = Double.toString(avg);
//		return avgString;
		
		//THIS BIT RETURNS 0 AND 'OPEN'			
			for (int i = 0; i<MAXIMUM; i++)
			{
				FitnessClass fclass = this.getFitnessClasses()[i];
				if(fclass == null)
				{
					avgString = "\"OPEN\"";
				}
				else if(num + 9 == (fclass.getTimeStart()))
				{
					avgString = fclass.getAverageAttendnace();
					//double avg = fclass.averageAttendance();
					System.out.println("average from fprog " + avgString);
				//	avgString = Double.toString(avg);
					return avgString;
				}
			}
			return avgString;		
	}

	//get attendnace averages from fitnessclass, IS 0 because not getting averages
	public double finalAvAttendance()
	{
		double total = 0;
		double average = 0;
		double finalAverage = 0;
	
		//for each Fitness Class attendnace
		for(int i = 0; i<7; i++) 
		{
			//get the average of single class
			average = fclass.averageAttendance();
			//add to the total
			total = total + average;
		}
		
		//get overall average
		finalAverage = total/7; 
		
		System.out.println("Total Average " + finalAverage);
		System.out.println("Total " + total);
		return finalAverage;
	}
	
	public void addClass(FitnessClass newFClass)
	{
		
	}
	
	public void deleteClass(FitnessClass deleteFClass)
	{
		
	}
}