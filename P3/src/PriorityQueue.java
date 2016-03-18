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
		boolean found = false;
		for(int i = 1; i < currentSize && !found; i++){
			if(array[i].getPriority() == item.getPriority()){
				found = true;
				Queue<E> queue = item.getList();
				while(queue.size() > 0){
					array[i].add(queue.dequeue());
				}
			}				
		}
		if(!found){
			currentSize++;
			if(currentSize+1 == array.length){
				doubleArray(); 
			}			
			array[currentSize] = item;
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
		array[1] = array[currentSize--];
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
		this.array = (PriorityQueueItem<E>[]) Array.newInstance(PriorityQueueItem.class, DEFAULT_CAPACITY);
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
		PriorityQueueItem<E> left = array[hole*2];
		PriorityQueueItem<E> right = array[(hole*2)+1];
		PriorityQueueItem<E> parent = array[hole];

		if(parent.compareTo(right) == -1){
			PriorityQueueItem<E> temp = parent;
			array[hole] = array[(hole*2)+1];
			array[(hole*2)+1] = temp;
			percolateDown((hole*2)+1);
		}
		else if(parent.compareTo(left) == -1){
			PriorityQueueItem<E> temp = parent;
			array[hole] = array[(hole*2)];
			array[(hole*2)] = temp;
			percolateDown((hole*2));
		}
	}

	private void perculateUp(int child) {
		// TODO Auto-generated method stub
		PriorityQueueItem<E> childItem = array[child];
		PriorityQueueItem<E> parent = array[child/2];

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
		PriorityQueueItem<E>[] newArray;

		newArray = (PriorityQueueItem<E>[]) Array.newInstance(PriorityQueueItem.class, array.length * 2);

		for (int i = 0;i < array.length;i++)
			newArray[i] = array[i];
		array = newArray;
	}

	@Override
	public boolean isEmpty()
	{
		if(currentSize == 0)
			return true;
		return false;
	}
}
