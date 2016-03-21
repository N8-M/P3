///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  StudentCenter.java
// File:             PriorityQueueIterator.java
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
// File:             PriorityQueueIterator.java
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
 * Creates an iterator to traverse throught the Priority Queue
 *
 * @author "the" Luke Van Hulle and "the" Neight Mindham
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueueIterator<T> implements Iterator<PriorityQueueItem<T>>
	{

	private PriorityQueue<T> priorityQueue;

	/**
	 * Constructs a PriorityQueueIterator by utilizing a copy of the
	 * PriorityQueue. Hint : The local priorityQueue object need not be
	 * preserved, and hence you can use the dequeue() operation.
	 * 
	 * @param pq
	 */
	public PriorityQueueIterator(PriorityQueue<T> pq)
		{
		// TODO
		// This copies the contents of the passed parameter to the local object.
		// Hint : see copy constructor in PriorityQueue
		priorityQueue = new PriorityQueue<T>(pq);		}

	/**
	 * Returns true if the iteration has more elements.
	 * 
	 * @return true/false
	 */
	@Override
	public boolean hasNext()
		{
		// TODO
		// returns truth value of if priorityQueue is not empty
		return !priorityQueue.isEmpty();
		}

	/**
	 * Returns the next element in the iteration. The iterator should return the
	 * PriorityQueueItems in order of decreasing priority.
	 * 
	 * @return the next element in the iteration
	 * @throws NoSuchElementException
	 *             if the iteration has no more elements
	 */
	@Override
	public PriorityQueueItem<T> next()
		{
		// TODO
		// Throws exception if iteration has no more elements
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		// returns the top element in the queue
		return priorityQueue.dequeue();
		}

	/**
	 * Unsupported in this iterator for this assignment
	 */
	@Override
	public void remove()
		{
		// Do not implement
		throw new UnsupportedOperationException();
		}

	}
