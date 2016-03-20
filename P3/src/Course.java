///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  StudentCenter.java
// File:             Course.java
// Semester:         CS 367 Spring 2016
//
// Author:           Neight Mindham
// CS Login:         Neight
// Lecturer's Name:  Deb Deppeler
// 
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Luke Van Hulle
// Email:            lvanHulle@wisc.edu
// CS Login:         van-hulle
// Lecturer's Name:  Deb Deppeler
//
////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  StudentCenter.java
// File:             Course.java
// Semester:         CS 367 Spring 2016
//
// Author:           Luke Van Hulle
// CS Login:         Van-hulle
// Lecturer's Name:  Deb Deppeler
// 
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
// Pair Partner:     Neight Mindham
// Email:            Nmindham@wisc.edu
// CS Login:         Neight
// Lecturer's Name:  Deb Deppeler
//
////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent every Course in our Course Registration environment
 * 
 * @author CS367
 *
 */

public class Course
{
	// states field variables
	private String courseCode;
	private String name;

	// Number of students allowed in the course
	private int maxCapacity;
	// Number of students enrolled in the course
	private int classCount;

	// The PriorityQueue structure
	private PriorityQueue<Student> registrationQueue;

	// List of students who are finally enrolled in the course
	private List<Student> courseRoster;
	
	/**
	 * Initializes the fields with the parameters sent in. 
 	* 
 	* 
 	*
	* @param classCode: string that tells the class's code 
 	* @param name: Name of the student
 	* @param maxCapacity: max Capacity for the class
 	* 
 	*/
	public Course(String classCode, String name, int maxCapacity)
	{
		// TODO initialize all parameters
		
		// initializes parameters
		courseCode = classCode;
		this.name = name; 
		this.maxCapacity = maxCapacity; 
		classCount = 0; 
		registrationQueue = new PriorityQueue<Student>(); 
		courseRoster = new ArrayList<Student>(); 

	}

	/**
	 * Creates a new PriorityqueueItem - with appropriate priority(coins) and
	 * this student in the item's queue. Add this item to the registrationQueue.
	 * 
	 * @param student
	 *            the student
	 * @param coins
	 *            the number of coins the student has
	 */
	public void addStudent(Student student, int coins)
	{
		// This method is called from Studentcenter.java

		// Enqueue a newly created PQItem.
		// Checking if a PriorityQueueItem with the same priority already exists
		// is done in the enqueue method.

		// TODO : see function header
		
		// variable to hold the new student with priority coins
		PriorityQueueItem<Student> temp = new PriorityQueueItem<Student>(coins);
		
		// adds student 
		temp.add(student);
		
		// adds the student to the priority queue
		registrationQueue.enqueue(temp);

	}

	/**
	 * Populates the courseRoster from the registration list.
	 * Use the PriorityQueueIterator for this task.
	 */
	public void processRegistrationList()
	{
		// TODO : populate courseRoster from registrationQueue
		// Use the PriorityQueueIterator for this task.
		
		// creates a new iterator over registration queue
		PriorityQueueIterator<Student> itr = new PriorityQueueIterator<Student>(registrationQueue); 
		
		// while loop to 
		while(courseRoster.size() < maxCapacity && itr.hasNext()){

		}
	}
	
	/**
 	* Gets the course name
 	* 
	* @return courseName: name of the course
	*/
	public String getCourseName()
	{
		// TODO
		
		// returns the coursename
		return courseName;
	}

	/**
 	* Gets the courseCode
 	* 
	* @return courseCode: code for the course
	*/
	public String getCourseCode()
	{
		// TODO
		
		// returns the coursecode
		return null;
	}

	/**
 	* Gets the courseRegister
 	* 
	* @return courseRegister: list of students in the courseRegister
	*/
	public List<Student> getCourseRegister()
	{
		// TODO
		
		// returns the list of sturdents for course register
		return null;
	}
}
