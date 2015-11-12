public class Queue<T> implements QueueInterface<T> {
	
	Node<T> head = null;
	Node<T> tail = null;
	
	int size = 0;
	int maxSize;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
	}
	
	/**
	 * Adds one element to the rear of this queue.
	 * @param element  the element to be added to the rear of the queue
	 */
	public void enqueue(T element) throws QueueFullException {
		if (size == maxSize) {
			throw new QueueFullException();
		}
		
		Node<T> newNode = new Node<T>(element, null);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
			
			size++;
			
			return;
		}
		
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}
	
	/**
	 * Removes and returns the element at the front of this queue.
	 * @return the element at the front of the queue
	 */
	public T dequeue() throws QueueEmptyException {
		if (head == null) {
			throw new QueueEmptyException();
		}
		
		T ret = head.getValue();
		
		head = head.getNext();
		
		size--;
		
		return ret;
	}
	
	/**
	 * Returns without removing the element at the front of this queue.
	 * @return the first element in the queue
	 */
	public T peek() throws QueueEmptyException {
		if (head == null) {
			throw new QueueEmptyException();
		}
		
		return head.getValue();
	}
	
	/**
	 * Returns true if this queue contains no elements.
	 * @return true if this queue is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns true if this queue contains the maximum number of elements.
	 * @return true if this queue is full
	 */
	public boolean isFull() {
		return size == maxSize;
	}
	
	/**
	 * Returns the number of elements in this queue.
	 * @return the integer representation of the size of the queue
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns a string representation of this queue.
	 * @return the string representation of the queue
	 */
	public String toString() {
		String ret = "[";
		String flag = "";
		Node<T> cur = head;
		
		while (cur != null) {
			ret += flag + cur.getValue();
			flag = ", ";
			cur = cur.getNext();
		}
		
		return ret + "]";
	}
	
}