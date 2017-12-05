/** Defines an object representing a single fitness class
 * define fitness class obj
 * class constant rep num of weeks which recorded: 5 weeks
 * class id
 * class name
 * tutor name
 * start time
 * set attendance records
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
	private int[] attendance = new int[5]; //set of 5 int represent attendance
	
	//default constructor
	public void FitnessClass()
	{
		setID();
		String className = this.className;
		String tutorName = this.tutorName;
		int timeStart = this.timeStart;
		int[] attendance = this.attendance;
		
	}
	
	//constructor to set instance var from string w/ Id nu, name, tutor name, start time
   
	
	public int compareTo(FitnessClass other) 
    {
	  return 0; // replace with your code
    }
	
	//setters
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
	
	//getters
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
