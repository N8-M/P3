///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  PriorityQueueItem.java
// File:             Course.java
// Semester:         CS 367 Spring 2016
//
// Author:           Neight Mindham
// Email:            Nmindham@wisc.edu
// CS Login:         Neight
// Lecturer's Name:  Deb Deppeler
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////

// Pair Partner:     Luke Van Hulle
// Email:            lvanhulle@wisc.edu
// CS Login:         van-hulle
// Lecturer's Name:  Deb Deppeler	
////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  StudentCenter.java
// File:             PriorityQueueItem.java
// Semester:         CS 367 Spring 2016
//
// Author:           Luke Van Hulle
// Email:            lvanhulle@wisc.edu
// CS Login:         van-hulle
// Lecturer's Name:  Deb Deppeler
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
 
// Pair Partner:     Neight Mindham
// Email:            nmindham@wisc.edu
// CS Login:         Neight
// Lecturer's Name:  Deb Deppeler	
////////////////////////////////////////////////////////////////////////////////


/**
 * 
 * Class to represent object stored at every entry in the PriorityQueue. ie, The
 * internal node structure of {@link PriorityQueue}
 * 
 * @author CS367
 *
 * @param <E>
 *            the generic type of the data content stored in the list
 */
public class PriorityQueueItem<E> implements Comparable<PriorityQueueItem<E>>
{
	
	// field variables
	private int priority;
	private Queue<E> queue;
	
	// initiates fields
	public PriorityQueueItem(int priority)
	{
		this.priority = priority;
		queue = new Queue<E>();
	}

	/**
 	* Gets the Priority and returns it
 	* @return priority
 	*/
	public int getPriority()
	{
		// TODO
		return priority;
	}

	/**
 	* Gets the Queue list
 	*
 	* @return queue
 	*/
	public Queue<E> getList()
	{
		// TODO
		return queue;
	}

	/**
	 * Add an item to the queue of this PriorityQueueItem object
	 * 
	 * @param item
	 *            item to add to the queue
	 */
	public void add(E item)
	{
		queue.enqueue(item);
	}

	/**
	 * Compares this Node to another node on basis of priority
	 * 
	 * @param o
	 *            other node to compare to
	 * @return -1 if this node's priority is lesser, +1 if this nodes priority
	 *         is higher after, else 0 if priorities are the same.
	 */
	@Override
	public int compareTo(PriorityQueueItem<E> o)
	{
		// TODO
		// checks to see if priority is greater than o's priority.
		// if so returns positive
		if(priority > o.getPriority()){
			return 1;
		}
		// checks to see if priority is less than o's priority.
		// if so returns negative
		if(priority < o.getPriority()){
			return -1; 
		}
		// returns zero if equal
		return 0; 
	}
}
