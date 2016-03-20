///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  StudentCenter.java
// File:             PriorityQueue.java
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
// File:             PriorityQueue.java
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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PriorityQueue implemented as a Binary Heap backed by an array. Implements
 * QueueADT. Each entry in the PriorityQueue is of type PriorityQueueNode<E>.
 * First element is array[1]
 * 
 * @author CS367
 *
 * @param <E>
 */
public class PriorityQueue<E> implements QueueADT<PriorityQueueItem<E>>
{
	private final int DEFAULT_CAPACITY = 100;

	// Number of elements in heap
	private int currentSize;

	/**
	 * The heap array. First element is array[1]
	 */
	private PriorityQueueItem<E>[] array;

	/**
	 * Construct an empty PriorityQueue.
	 */
	public PriorityQueue()
	{
		currentSize = 0;
		// the below code initializes the array.. similar code used for
		// expanding.
		array = (PriorityQueueItem<E>[]) Array.newInstance(PriorityQueueItem.class, DEFAULT_CAPACITY + 1);
	}

	/**
	 * Copy constructor
	 * 
	 * @param pq
	 *            PriorityQueue object to be copied
	 */
	public PriorityQueue(PriorityQueue<E> pq)
	{
		this.currentSize = pq.currentSize;
		this.array = Arrays.copyOf(pq.array, currentSize + 1);
	}

	/**
	 * Adds an item to this PriorityQueue. If array is full, double the array
	 * size.
	 * 
	 * @param item
	 *            object of type PriorityQueueItem<E>.
	 */
	@Override
	public void enqueue(PriorityQueueItem<E> item)
	{
		// TODO write appropriate code
		// Check if array is full - double if necessary



		// Check all nodes and find if one with equal priority exists.
		
		// boolean to find out if found equal priority
		boolean found = false;
		
		// for loop to check for item
		for(int i = 1; i < currentSize && !found; i++){
			
			// checks if equal priority
			if(array[i].getPriority() == item.getPriority()){
				
				// if found changes to true
				found = true;
				
				// queue to hold items list
				Queue<E> queue = item.getList();
				
				// adds the items in queue to array
				while(queue.size() > 0){
					array[i].add(queue.dequeue());
				}
			}				
		}
		
		// if not found create new node 
		if(!found){
			// increments current size
			currentSize++;
			
			// checks to see if we need to double size
			if(currentSize+1 == array.length){
				doubleArray(); 
			}			
			// adds to the last index
			array[currentSize] = item;
			
			//perculates the item into the right location in PQ
			perculateUp(currentSize);

		}
		// Add to the existing node's list if it does

		// Else create new node with value added to list and percolate it up
	}



	/**
	 * Returns the number of items in this PriorityQueue.
	 * 
	 * @return the number of items in this PriorityQueue.
	 */
	public int size()
	{
		// TODO write appropriate code
		// returns currentSize
		return currentSize;
	}

	/**
	 * Returns a PriorityQueueIterator. The iterator should return the
	 * PriorityQueueItems in order of decreasing priority.
	 * 
	 * @return iterator over the elements in this PriorityQueue
	 */
	public Iterator<PriorityQueueItem<E>> iterator()
	{
		// TODO write appropriate code - see PriortyQueueIterator constructor
		return new PriorityQueueIterator<E>(this);
	}

	/**
	 * Returns the largest item in the priority queue.
	 * 
	 * @return the largest priority item.
	 * @throws NoSuchElementException
	 *             if empty.
	 */
	@Override
	public PriorityQueueItem<E> peek()
	{
		// TODO fill in appropriate code, replace default return statement
		// looks at first item in queue
		return array[1];
	}

	/**
	 * Removes and returns the largest item in the priority queue. Switch last
	 * element with removed element, and percolate down.
	 * 
	 * @return the largest item.
	 * @throws NoSuchElementException
	 *             if empty.
	 */
	@Override
	public PriorityQueueItem<E> dequeue()
	{
		// TODO
		// Remove first element
		PriorityQueueItem<E> temp = array[1];
		
		// takes last item in moves it to the first item
		array[1] = array[currentSize--];
		
		// adjusts PQ
		percolateDown(1);

		// Replace with last element, percolate down
		return temp;
	}

	/**
	 * Heapify Establish heap order property from an arbitrary arrangement of
	 * items. ie, initial array that does not satisfy heap property. Runs in
	 * linear time.
	 */
	private void buildHeap()
	{
		for (int i = currentSize / 2;i > 0;i--)
			percolateDown(i);
	}

	/**
	 * Make this PriorityQueue empty.
	 */
	public void clear()
	{
		// TODO write appropriate code
		
		// creates a new PQ and points array to it
		this.array = (PriorityQueueItem<E>[]) Array.newInstance(PriorityQueueItem.class, DEFAULT_CAPACITY);
		
		// resets current size
		currentSize = 0; 
	}

	/**
	 * Internal method to percolate down in the heap. <a
	 * href="https://en.wikipedia.org/wiki/Binary_heap#Extract">Wiki</a>}
	 * 
	 * @param hole
	 *            the index at which the percolate begins.
	 */
	private void percolateDown(int hole)
	{
		// TODO
		
		// the left child
		PriorityQueueItem<E> left = array[hole*2];
		
		// right child
		PriorityQueueItem<E> right = array[(hole*2)+1];
		
		// parent
		PriorityQueueItem<E> parent = array[hole];
		
		// checks if parent is smaller than right child. if so, swaps them
		if(parent.compareTo(right) == -1){
			PriorityQueueItem<E> temp = parent;
			array[hole] = array[(hole*2)+1];
			array[(hole*2)+1] = temp;
			percolateDown((hole*2)+1);
		}
		// checks if parent is smaller than left child. if so, swaps them
		else if(parent.compareTo(left) == -1){
			PriorityQueueItem<E> temp = parent;
			array[hole] = array[(hole*2)];
			array[(hole*2)] = temp;
			percolateDown((hole*2));
		}
	}

	/**
	* Perculates up the child in the array
 	* 
 	*
 	* @param child: variable to be moved up if needed
 	*/
 	
	private void perculateUp(int child) {
		// TODO Auto-generated method stub
		// child
		PriorityQueueItem<E> childItem = array[child];
		
		// parent of child
		PriorityQueueItem<E> parent = array[child/2];
		
		// checks to see if child is greater than parent. if so, swap them
		if(childItem.compareTo(parent) == 1){
			PriorityQueueItem<E> temp = parent;
			array[child/2] = array[child];
			array[child] = temp;
			perculateUp(child/2);
		}

	}

	/**
	 * Internal method to expand array.
	 */
	private void doubleArray()
	{	
		// creates new array twice as big
		PriorityQueueItem<E>[] newArray;
		newArray = (PriorityQueueItem<E>[]) Array.newInstance(PriorityQueueItem.class, array.length * 2);
		
		// copies into new array
		for (int i = 0;i < array.length;i++)
			newArray[i] = array[i];
		
		// assigns to the new array	
		array = newArray;
	}

	@Override
	public boolean isEmpty()
	{
		// returns truth value of currentsize == 0
		return currentSize == 0;
	}
}
