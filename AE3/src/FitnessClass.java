import java.util.Arrays;

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
	final private int CLASSWEEKS = 5;
	
	//Instance vars for id, class name, tutor name, start time, and attendance array
	private String id = ""; 
	private String className = "";
	private String tutorName = "";
	private int timeStart; //9-15:00
	private String attendaceID;
	private int[] attendance = new int[CLASSWEEKS]; //set of 5 int represent attendance COMING from GUI file
		
	private double averageAttendnace;
	//optional default constructor
	public FitnessClass()
	{
		
	}
	
	//Non-default constructor to set instance vars from a string containing id, name, tutor name, start time)--need to break apart all info
	//this splits both Class info and Attendance info
	public FitnessClass(String randomStuff) 
	{
		//gets two strings
		String[] individualPieces = randomStuff.split(" ");
		
		id = individualPieces[0];
		className = individualPieces[1];
		tutorName = individualPieces[2];
		timeStart = Integer.parseInt(individualPieces[3]);	
		
		
		//for each individual
		System.out.println("\nfrom fitnessclass method id: " + id);
		System.out.println("from fitnessclass method name: " + className);
		System.out.println("from fitnessclass method tutor: " + tutorName);
		System.out.println("from fitnessclass method time: " + timeStart);
		System.out.println("from fitnessclass method time: " + Arrays.toString(getAttendance()));

	}
	
	//compare average attendances of each class 
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
		//returns 12-last class
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
	public void setAttendance(int[] attendanceArray)
	{
		this.attendance = attendanceArray;
		System.out.println("Set attendnace " + Arrays.toString(attendance));
	}
	public void setAttendanceID(String attendaceID)
	{
		this.attendaceID = attendaceID;
	}
	
	public void setAverageAttendance(double avg)
	{
		this.averageAttendnace = avg;
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
	public int[] getAttendance() //this is empty
	{
		System.out.println("Attendnace from get Attendnace " + Arrays.toString(attendance));
		return this.attendance;
	}
	public String getAttendanceID()
	{
		return attendaceID;
	}
	public String getAverageAttendnace()
	{
		String averageString = Double.toString(averageAttendnace);
		return averageString;
	}
}