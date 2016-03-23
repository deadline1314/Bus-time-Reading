package DataStructure;

class Node1<T> {
	public T data;
	public Node1<T> next;
	public Node1<T> previous;

	public Node1(T data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

}

public class Queue<T> {
	public Node1<T> head;
	public Node1<T> tail;
	
	public Queue(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		if(head == null)
			return true;
		return false;
	}
	
	public void enqueue(T data){
		Node1<T> node = new Node1<T>(data);
		if(head == null){
			head = node;
			tail = node;
			return;
		}
		
		node.next = tail;
		node.next.previous = node; //define the function of "previous"
		tail = node;
	}
	
	public T dequeue(){
		if(head == null){
			return null;
		}
		
		T val = head.data;
		if(head.previous == null){
			tail = null;
		}
		head = head.previous;
		head.next = null;
		return val;
	}
	
	public T peek(){
		if(head == null)
			return null;
		return head.data;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.peek());
		queue.dequeue();
		System.out.println(queue.peek());

	}

}
