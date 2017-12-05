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
	private int[] attendance = new int[5]; //set of 5 int represent attendance
	
	//set max classes here??????
	// int maxClasses = 7;

	//optional default constructor
	public FitnessClass()
	{
		id = "this is the id";
		className = "className";
		timeStart = 9;
	//	attendance = {9, 10, 11, 12, 13};
		
	}
	
	//one non-default constructor
	public FitnessClass(String idString, String nameClass, String nameTutor, int startTime, int[] attendanceArray)
	{
		setID();
		System.out.println(setID());
		setClassName();
		System.out.println(setClassName());
		setTutorName();
		setTimeStart();
		setAttendance();
	
		System.out.println("from fitness class " + idString + nameClass + nameTutor + startTime);
	}
	
	
   
	
	public int compareTo(FitnessClass other) 
    {
	  return 0; // replace with your code
    }
	
	//get the average attendance for each class
	public double averageAttendance()
	{
		double average = 0;
		double totalAverage = 0;
		//for each # in attendance array
		for(int i = 0; i<CLASSWEEKS; i++)
		{
			average = average + attendance[i];
		}
		totalAverage = average/CLASSWEEKS;
		System.out.println("Total Average" + totalAverage);
		return totalAverage;
		
	}
	
	//MUTATORS
	public String setID()
	{
		String id = this.id;
		return id;
	}
	public String setClassName()
	{
		String className = this.className;
		return className;
	}
	public String setTutorName()
	{
		String tutorName = this.tutorName;
		return tutorName;
	}
	public int setTimeStart()
	{
		int timeStart = this.timeStart;
		return timeStart;
	}
	public int[] setAttendance()
	{
		int[] attendance = this.attendance;
		return attendance;
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
