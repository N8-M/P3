///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Queue.java
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
// File:             Queue.java
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
 * An ordered collection of items, where items are added to the rear and removed
 * from the front.
 */
public class Queue<E> implements QueueADT<E>
{

	// TODO
	// You may use a naive expandable circular array or a chain of listnodes.
	// You may NOT use Java's predefined classes such as ArrayList or
	// LinkedList.
	// fields for linknodes
	private Listnode<E> head;
	private Listnode<E> tail;
	private int size;

	// constructors for the fields
	public Queue(){
		head = new Listnode<E>(null);
		tail = head;
		size = 0;
	}

	/**
	 * Adds an item to the rear of the queue.
	 * 
	 * @param item
	 *            the item to add to the queue.
	 * @throws IllegalArgumentException
	 *             if item is null.
	 */
	public void enqueue(E item)
	{
		// checks if item is null and throws exception if so
		if(item == null){
			throw new IllegalArgumentException();
		}
		
		// creates temp variable to hold item
		Listnode<E> temp = new Listnode<E>(item);
		
		// adds the temp variable and sets tail equal to it the increments size. 
		tail.setNext(temp);
		tail = temp;
		size++;
	}

	/**
	 * Removes an item from the front of the Queue and returns it.
	 * 
	 * @return the front item in the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E dequeue()
	{	
		// checks if size is zero. if so throw exception 
		if(size == 0){
			throw new EmptyQueueException();
		}
		// creates temp variable to heads next item
		Listnode<E> temp = head.getNext();
		
		// removes node and decrements size then returns the item removed
		head.setNext(temp.getNext());
		size--;
		return temp.getData();
	}

	/**
	 * Returns the item at front of the Queue without removing it.
	 * 
	 * @return the front item in the queue.
	 * @throws EmptyQueueException
	 *             if the queue is empty.
	 */
	public E peek()
	{
		// checks to see if size is zero. if so throws exception. 
		if(size == 0){
			throw new EmptyQueueException();
		}
		// returns the top item without removing it. 
		return head.getNext().getData();
	}

	/**
	 * Returns true iff the Queue is empty.
	 * 
	 * @return true if queue is empty; otherwise false.
	 */
	public boolean isEmpty()
	{
		// returns truth value of size == 0
		return size == 0;
	}

	/**
	 * Removes all items in the queue leaving an empty queue.
	 */
	public void clear()
	{
		// removes all items and creates a new one of size 0. 
		tail = new Listnode<E>(null);
		head.setNext(tail);
		size = 0; 
	}

	/**
	 * Returns the number of items in the Queue.
	 * 
	 * @return the size of the queue.
	 */
	public int size()
	{
		// returns the size 
		return size;
	}
	
	/**
	 * this method is not needed
	 * /
	 * 
	private void expandCapacity()
	{
		//expanding should be done using the naive copy-all-elements approach

	}

	/**
	 * The internal node structure of {@link PacketLinkedList}.
	 *
	 * @param <E> the generic type of the data content stored in the list
	 */
	public class Listnode<E> {
		private E data;                // data to be stored 
		private Listnode<E> next;   // connnection to next node

		/**
		 * Constructs a new list nodes with no links to neighboring nodes.
		 * @param data the data to be stored in this node
		 */
		Listnode(E data) {
			this(data, null);
		}

		/**
		 * Constructs a new list node with links to neighboring nodes.
		 * @param data the data to be stored in this node
		 * @param next the node after this one
		 */
		Listnode(E data, Listnode<E> next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Returns the current data.
		 * @return the current data
		 */
		E getData() {
			return data;
		}

		/**
		 * Returns the current next node.
		 * @return the current next node
		 */
		Listnode<E> getNext() {
			return next;
		}

		/**
		 * Sets the data to the given new value.
		 * @param data the new data
		 */
		void setData(E data) {
			this.data = data;
		}

		/**
		 * Sets the next node to the given new value.
		 * @param next the new next node
		 */
		void setNext(Listnode<E> next) {
			this.next = next;
		}
	}

}
