import java.util.*;

import javax.swing.JOptionPane;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 */
public class FitnessProgram 
{	
	final int MAXIMUM = 7;
	private int currentNumberOfClasses;
	private FitnessClass[] fclassArray; 
	private FitnessClass[] sorted;
	private String array;
	
	FitnessClass fclass;

	//Default constructor to initalize array 
	public FitnessProgram() 
	{			
		fclassArray = new FitnessClass[MAXIMUM];
		currentNumberOfClasses = 0;
	}

	//get the Fitness Class Object Array
	public FitnessClass[] getFitnessClasses()
	{
		return fclassArray;
	}
	
	//gets class at index
	public FitnessClass getClassAtIndex(int i)
	{
		return fclassArray[i];
	}
	
	//get the time of a class
	public FitnessClass getTimeOfClass(int i)
	{
		//return fclassArray[i+9];
		return fclassArray[i-9];
	}

	//returns the first open time for a class
	public int getOpenTime()
	{
		int open;
		for(open=0; open<MAXIMUM; open++)
		{
			//loop through fclass array, if the time is null, return
			if(fclassArray[open] == null)
			{
				open = open+9;
				return open;
			}
		}
		return 1;
	}
		
	//Gets the list of Class Name for display in GUI
	public String getClassLists(int timeStart)
	{
		String className = "";
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
		String id = "";
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
		String tutorName = "";

		for (int i = 0; i<MAXIMUM; i++)
		{
			fclass = this.getFitnessClasses()[i];
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
		for(int i=0; i<MAXIMUM; i++)
		{
			if (fclassArray[i]== null)
			{
				i++;
			}
			else
			{
				String thisID = fclassArray[i].getID();
				if (thisID.equals(idOfClass))
				{
					return fclassArray[i];
				}
			}
		}
		return null;
	}
	
	//Method to populate attendnace lists, given String representing single line of AtendancesIn.txt as a parameter 
	public String attendnaces(String attendanceLine) 
	{
		String[] lineSplit = attendanceLine.split(" ");
		FitnessClass fclass = new FitnessClass();
		String id = lineSplit[0];
		getClassWithID(id);
		
		int weekOne = Integer.parseInt(lineSplit[1]);
		int weekTwo = Integer.parseInt(lineSplit[2]);
		int weekThree = Integer.parseInt(lineSplit[3]);
		int weekFour = Integer.parseInt(lineSplit[4]);
		int weekFive = Integer.parseInt(lineSplit[5]);
		int[] attendanceArray = {weekOne, weekTwo, weekThree, weekFour, weekFive};
				
		fclass.setAttendance(attendanceArray);
		array = Arrays.toString(attendanceArray);
		System.out.println("this attendnace arry " + Arrays.toString(attendanceArray));
		System.out.println("string attendnace in fprog " + array);

		return array; //is returning attendnaces
	}
	public String getAtt(int num)	
	{
		return array;
	}
	//get attendnace averages from fitnessclass, IS 0 because not getting averages
	public String finalAvAttendance()
	{
		double total = 0; 
		double average = 0;
		
		for(int i=0; i<MAXIMUM; i++)
		{
			if(fclassArray[i] != null)
			{
				total = total + fclassArray[i].averageAttendance();
			}
		}
		average = (double) total/fclassArray.length;
		return String.format("%.2f", average);
	}
	
	public void addClass(String newClassID, String newClassName, String newClassTutor)
	{
		int[] attendnaceInital = {0,0,0,0,0};
		
		for(int i=0; i<MAXIMUM; i++)
		{
			try
			{
				fclassArray[i].getID();
			}
			catch(Exception cannotAdd)
			{
				int newTime = getOpenTime();
				FitnessClass fclass = new FitnessClass(newClassID, newClassName, newClassTutor, newTime);
				fclass.setAttendance(attendnaceInital);
				fclassArray[i] = fclass;
				currentNumberOfClasses ++;
				return;
			}
		}
	}
	
	public void deleteClass(FitnessClass classToDelete)
	{
		for(int i=0; i < MAXIMUM; i++)
		{
			if(fclassArray[i] != null)
			{
				if(fclassArray[i].getID().equals(classToDelete.getID()))
				{
					fclassArray[i] = null;

					currentNumberOfClasses--;
					return;	
				}
			}
		}
	}

	//Gets the current number of classes
	public int getCurrentNumberOfClasses()
	{
		if(fclass == null)
		{
			currentNumberOfClasses = currentNumberOfClasses - 1;
		}
		else if(getOpenTime()==1)
		{
			return 1;
		}
		else
		{
			this.currentNumberOfClasses = fclassArray.length;
		}
		return currentNumberOfClasses;
	}
	
	//TODO sort array based on attendnace
	//method to return list sorted in non-increasing order on av attendance using arrays.sort
	public String sortArray()
	{
		int array = 0;
		
		for(int i=0; i<MAXIMUM; i++)
		{
			if(fclassArray[i] != null)
			{
				array ++;
			}
		}
		
		sorted = new FitnessClass[array];
		
		int count = 0;
		
		for (int i = 0; i<MAXIMUM; i++)
		{
			if(fclassArray[i] != null)
			{
				sorted[count++] = fclassArray[i];
			}
		}
		
		Arrays.sort(sorted);
		String sortedString = Arrays.toString(sorted);
		return sortedString;
	}
}