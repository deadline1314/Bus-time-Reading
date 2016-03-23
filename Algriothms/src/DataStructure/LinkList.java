package DataStructure;

	class Node<T> {
	public T data;
	public Node<T> next;

	private Node() {
	}

	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkList<T> {

	private Node<T> head;
	private Node<T> tail;

	public LinkList() {
		head = null;
		tail = null;
	}

	public void addHead(T data) {
		Node<T> add = new Node<T>(data);
		add.next = head;
		if (head == null) {
			tail = add;
		}
		head = add;
	}

	public void addTail(T data) {
		Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		tail = node;
	}

	// if add static, then can't use <T>
	public LinkList<T> combineTogether(LinkList<T> ll1, LinkList<T> ll2) { // way 1
		LinkList<T> add = new LinkList<T>();
		Node<T> temp = ll1.head;
		while (temp != null) {
			add.addTail(temp.data);
			temp = temp.next;
		}
		temp = ll2.head;
		while (temp != null) {
			add.addTail(temp.data);
			temp = temp.next;
		}
		return add;
	}

	public static Node connectTwoLinkList(LinkList list1, LinkList list2) { // way 2
		Node original = list1.head;
		Node previous = null;
		Node current = list1.head;
		while (current != null) {
			previous = current;
			current = current.next;
		}
		previous.next = list2.head;
		return original;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
