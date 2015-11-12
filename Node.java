public class Node<T> {
	T data;
	Node<T> next;
	
	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public T getValue() {
		return data;
	}
}