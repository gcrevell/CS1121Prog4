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
		String ret = "";
		String flag = "";
		Node<T> cur = head;
		
		while (cur != null) {
			ret = cur.getValue() + flag + ret;
			flag = ", ";
			cur = cur.getNext();
		}
		
		return ret + "]";
	}
	
	public static void main(String args[]) throws Exception {
		Queue<Integer> q = new Queue<Integer>(10);
		
		System.out.println("Size (Should be 0) = " + q.size());
		System.out.println("Q is empty (should be true) " + q.isEmpty());
		
		q.enqueue(5);
		
		System.out.println("Size (Should be 1) = " + q.size());
		System.out.println("Q is empty (should be false) " + q.isEmpty());
		System.out.println("Q is full (should be false) " + q.isFull());
		
		System.out.println("Polling top value (Should be 5) " + q.peek());
		System.out.println("Removing top value (Should be 5) " + q.dequeue());
		
		System.out.println("Size (Should be 0) = " + q.size());
		System.out.println("Q is empty (should be true) " + q.isEmpty());
		System.out.println("Q is full (should be false) " + q.isFull());
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		System.out.println("Size (Should be 3) = " + q.size());
		
		System.out.println("Polling top value (Should be 1) " + q.peek());
		System.out.println("Removing top value (Should be 1) " + q.dequeue());
		System.out.println("Polling top value (Should be 2) " + q.peek());
		System.out.println("Removing top value (Should be 2) " + q.dequeue());
		
		System.out.println("Size (Should be 1) = " + q.size());
		
		
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		
		System.out.println("Size (Should be 10) = " + q.size());
		System.out.println("Q is full (should be true) " + q.isFull());
		System.out.println(q);
	}
	
}