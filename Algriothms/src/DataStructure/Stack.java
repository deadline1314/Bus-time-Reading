package DataStructure;

import DataStructure.Node1;

public class Stack<T> {
	public Node1<T> head;
	public Node1<T> tail;
	
	public Stack(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		if(tail == null)
			return true;
		return false;
	}
	
	public void push(T data){
		Node1<T> node = new Node1<T>(data);
		if(head == null){
			head = node;
			tail = node;
			return;
		}
		node.next = tail;
		node.next.previous = node;
		tail = node;
	}
	
	public T pop(){
		if(head == null){
			return null;
		}
		T val = tail.data;
		if(tail.next == null){
			head = null;
		}
		tail = tail.next;
		tail.previous = null;
		return val;
	}
	
	public T peek(){
		if(head == null)
			return null;
		return tail.data;
	}

	public static void main(String[] args) {

		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());

	}

}
