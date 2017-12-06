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

	private String id = ""; 
	private String attendanceID = "";
	private String className = "";
	private String tutorName = "";
	private int timeStart; //9-15:00
	private int[] attendance = {1, 2, 3, 4, 5}; //set of 5 int represent attendance COMING from GUI file

	//optional default constructor--WHAT IS THE PURPOSE OF THIS?
	public FitnessClass()
	{
		
	}
	
	//Non-default constructor to set instance vars from a string containing id, name, tutor name, start time)--need to break apart all info
	//this splits both Class info and Attendance info
	public FitnessClass(String randomStuff, String attendances) 
	{
		String[] individualPieces = randomStuff.split(" ");
		id = individualPieces[0];
		className = individualPieces[1];
		tutorName = individualPieces[2];
		timeStart = Integer.parseInt(individualPieces[3]);	
		
		String[] attendanceFile = attendances.split(" ");
		attendanceID = attendanceFile[0];
		int weekOne = Integer.parseInt(attendanceFile[1]);
		int weekTwo = Integer.parseInt(attendanceFile[2]);
		int weekThree = Integer.parseInt(attendanceFile[3]);
		int weekFour = Integer.parseInt(attendanceFile[4]);
		int weekFive = Integer.parseInt(attendanceFile[5]);
		
		System.out.println("from fitnessclass method id: " + id);
		System.out.println("from fitnessclass method name: " + className);
		System.out.println("from fitnessclass method tutor: " + tutorName);
		System.out.println("from fitnessclass method time: " + timeStart);
		
		System.out.println("from fitnessclass method attendanceid: " + attendanceID);
		System.out.println("from fitnessclass method weekOne: " + weekOne);
		System.out.println("from fitnessclass method 2: " + weekTwo);
		System.out.println("from fitnessclass method 3: " + weekThree);
		System.out.println("from fitnessclass method 4: " + weekFour);
		System.out.println("from fitnessclass method 5: " + weekFive);

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
	
	public String formatReport()
	{
		String asd = "ASD";
		return asd;
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
	
	//Accessors
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