/** Defines an object representing a single fitness class
 * define fitness class obj
 * 
 * default constructor and optional default constructor, 
 * accessor and mutator calling instance vars
 * method return av attendance for class
 * mehtod return String for attendance report
 * compare two fitness class objs based on av attendance
 */
public class FitnessClass implements Comparable<FitnessClass> 
{
	
	private String id = ""; //UNIQUE
	private String className = "";
	private String tutorName = "";
	private int timeStart; //9-15:00
	final private int CLASSWEEKS = 5;
	private int[] attendance = {1, 2, 3, 4, 5}; //set of 5 int represent attendance

	//optional default constructor
	public FitnessClass()
	{
		
	}
	
	//one non-default constructor
	public FitnessClass(String randomStuff) //String contans id, name, tname, start time
	{
		String[] individualPieces = randomStuff.split(" ");
		id = individualPieces[0];
		className = individualPieces[1];
		tutorName = individualPieces[2];
		timeStart = Integer.parseInt(individualPieces[3]);		
	}
	
	//compare average from lecture 10--sorting in dec order
	public int compareTo(FitnessClass other) 
    {
		double average = averageAttendance();
		
		if(average < other.averageAttendance())
		{
			return -1;
		}
		else if (average == other.averageAttendance())
		{
			return 0;
		}
		else
			return 1;
    }
	
	//get the average attendance for each class
	public double averageAttendance()
	{
		int total = 0;
		double average = 0;
	
		//for each # in attendance array
		for(int i = 0; i<attendance.length; i++) 
		{
			total = total + attendance[i];
		}
		
		average = total/attendance.length;
		System.out.println("Total Average " + average);
		System.out.println("Total " + total);
		return average;
		
	}
	
	//MUTATORS
	public void setID(String id)
	{
		this.id = id;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public void setTutorName(String tutorName)
	{
		this.tutorName = tutorName;
	}
	public void setTimeStart(int timeStart)
	{
		this.timeStart = timeStart;
	}
	public void setAttendance(int[] attendance)
	{
		this.attendance = attendance;
	}
	
	//accessors
	public String getID()
	{
		return id;
	}
	public String getClassName()
	{
		return className;
	}
	public String getTutorName()
	{
		return tutorName;
	}
	public int getTimeStart()
	{
		return timeStart;
	}
	public int[] getAttendance()
	{
		return attendance;
	}
}
