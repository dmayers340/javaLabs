import java.util.Arrays;

/** Defines an object representing a single fitness class
 * define fitness class obj
 */
public class FitnessClass implements Comparable<FitnessClass> 
{
	final private int CLASSWEEKS = 5;
	private String id = ""; 
	private String className = "";
	private String tutorName = "";
	private int timeStart; 
	private int[] attendance; 
	
	//Default Constructor
	public FitnessClass()
	{
		this.id = "";
		this.className = "";
		this.tutorName = "";
		this.timeStart = -1;
		this.attendance = new int[CLASSWEEKS];
	}
	
	public FitnessClass(String id, String name, String tutorName, int time)
	{
		this.id = id;
		this.className = name;
		this.tutorName = tutorName;
		this.timeStart = time;
		this.attendance = new int[CLASSWEEKS];
	}
	//Non-default constructor to set instance vars from a string containing id, name, tutor name, start time)--need to break apart all info
	public FitnessClass(String classInfo) 
	{
		String[] individualPieces = classInfo.split(" ");
		
		id = individualPieces[0];
		className = individualPieces[1];
		tutorName = individualPieces[2];
		timeStart = Integer.parseInt(individualPieces[3]);	
		
		this.attendance = new int[CLASSWEEKS];

	}

	//get the average attendance for each class
	public double averageAttendance()
	{ 
		int total = 0;
		double average = 0;
		
		for(int i =0; i<attendance.length; i++) 
		{
			total = total + i;
		}
		average = (double) total/CLASSWEEKS;			
		return average;
	}
	//TODO compareAvgs to sort in FProg
	//compare average attendances of each class 
	public int compareTo(FitnessClass other) 
    {
		double average = this.averageAttendance();
		double otherAverage = other.averageAttendance();
		
		if(average < otherAverage)
		{
			return 1;
		}
		else if (average == otherAverage)
		{
			return 0;
		}
		else
			return -1;
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
	
	public void setAttendance(int[] attendanceArray)
	{ //has attendnace
		this.attendance = attendanceArray;
		System.out.println("This is the attendnace array from setAttendnace() in FClass Att " + Arrays.toString(attendance));
	}

	//Accessors for instance variables 
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
	
	public int[] getAtt()
	{
		return attendance;
	}
	//TODO get AttendnaceString working
	public String getAttendnaceString()
	{ 	//in this method the var attendance is 0,0,0,0 	
		System.out.println("Get attendnace String fclass " + Arrays.toString(attendance));
		StringBuilder attendanceString = new StringBuilder();
		for (int i : attendance) //; i<attendance.length; i++) //returning 0,1,2,3,4
		{
			attendanceString.append(i + " ");
		}
		
		String attendnaceStringFinal = attendanceString.toString();
		return attendnaceStringFinal;
	}
	
	//To format the report as a string as requested, however I do not use this
	public String toString()
	{				
		String formattedReport = String.format("%10s %\t\t10s %\t\t10s %\t\t10s %\t\t10s \n", getID(), getClassName(), getTutorName(), getAttendnaceString(), averageAttendance());
		return formattedReport;
	}
}