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
	private int timeStart; 
	private String attendaceID;
	private int[] attendance; 
	
	//optional default constructor
	public FitnessClass(String id, String name, String tutorName)
	{
		this.id = id;
		this.className = name;
		this.tutorName = tutorName;
		attendance = new int[CLASSWEEKS];
	}
	
	public FitnessClass()
	{
		
	}
	//Non-default constructor to set instance vars from a string containing id, name, tutor name, start time)--need to break apart all info
	//this splits both Class info and Attendance info
	public FitnessClass(String classInfo) 
	{
		String[] individualPieces = classInfo.split(" ");
		
		id = individualPieces[0];
		className = individualPieces[1];
		tutorName = individualPieces[2];
		timeStart = Integer.parseInt(individualPieces[3]);	
		attendance = new int[CLASSWEEKS];
	}
	//get the average attendance for each class
	public double averageAttendance()
	{ 
		//returns 12-last class
		int total = 0;
		double average = 0;
		
		System.out.println("Attendnace array from avgAttendnace " + Arrays.toString(attendance)); //only returns last class
	
		//for each # in attendance array
		for(int i: attendance) 
		{
			total = total + i;
		}
		
		average = total/attendance.length;
		System.out.println("Total Average " + average);
		System.out.println("Total " + total);
		return average;
	}
	
	//TODO compareAvgs to sort in FProg
	//compare average attendances of each class 
	public int compareTo(FitnessClass other) 
    {
		double average = averageAttendance();
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
	{
		this.attendance = attendanceArray;
	}
	public void setAttendanceID(String attendaceID)
	{
		this.attendaceID = attendaceID;
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
	public String getAttendnaceString()
	{
		StringBuilder attendanceString = new StringBuilder();
		for (int i: attendance)
		{
			attendanceString.append(i + "");
		}
		String attendnaceStringFinal = attendanceString.toString();
		return attendnaceStringFinal;
	}
//	public int[] getAttendance() //this is empty
//	{
//		System.out.println("Attendnace from get Attendnace " + Arrays.toString(attendance));
//		return this.attendance;
//	}
	public String getAttendanceID()
	{
		return attendaceID;
	}

	
	public String formatReport()
	{
		//put in attendnace array as String
		StringBuilder attendnacesString = new StringBuilder();
		for (int i=0; i<CLASSWEEKS; i++)
		{
			int attendnaceNum = this.attendance[i];
			attendnacesString.append(String.format("%10d", attendnaceNum));
		}
		double formatAverage = averageAttendance();
		
		String formattedReport = String.format("%10s %10s %10s %10s %10.2f %\n", getID(), getClassName(), getTutorName(), getAttendnaceString(), averageAttendance());
		return formattedReport;
	}
}