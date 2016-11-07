package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;


public class BinarySearchTree {

	public static class Node { // define structure of node
		public int data;
		public Node left;
		public Node right;
		public int horiDis; //to store the horizon distance

		private Node() {
		}

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BST {
		Node root;

		public BST() {
			root = null;
		}

		public void insert(int data) { // insert
			Node node = new Node(data);
			if (root == null) {
				root = node;
				return;
			}
			Node parent = null;
			Node current = root;
			while (current != null) {
				parent = current;
				if (current.data > data)
					current = current.left;
				else
					current = current.right;
			}
			if (parent.data > data)
				parent.left = node;
			else
				parent.right = node;
		}

		private Node findMin(Node node) { // find min way 1 using recursion
			if (node == null)
				return null;
			if (node.left == null)
				return node;
			return findMin(node.left);
		}

		private Node findMinIter(Node node) { // find min way 2 using iteration
			if (node == null)
				return null;
			Node curr = root;
			while (curr.left != null)
				curr = curr.left;
			return curr;
		}

		private Node findMax(Node node) { // find max
			if (node == null)
				return null;
			if (node.right == null)
				return node;
			return findMax(node.right);
		}

		public void remove(int data) { // remove
			remove(root, null, data);
		}

		public void remove(Node node, Node parent, int data) {
			if (node == null)
				return;
			if (node.data > data) // target in left side
				remove(node.left, node, data);
			else if (node.data < data) // target in the right side
				remove(node.right, node, data);
			else {
				if (node.left == null && node.right == null) { // no children
					if (parent.left == node)
						parent.left = null;
					else
						parent.right = null;
					node = null;
					return;
				} else if (node.left == null || node.right == null) { // only one child
					if (node.left != null) {
						if (parent.left == node)
							parent.left = node.left;
					} else {
						if (parent.right == node)
							parent.right = node.right;
					}
				} else { // two children
					node.data = findMin(node.right).data;
					remove(node.right, node, node.data);
				}
			}
		}

		public void preOrder() { // preOrder
			preOrder(root);
			System.out.println();
		}

		private void preOrder(Node node) {
			if (node != null) {
				System.out.print(node.data + " ");
				preOrder(node.left);
				preOrder(node.right);
			}
		}

		public void inOrder() { // inOrder
			inOrder(root);
			System.out.println();
		}

		private void inOrder(Node node) {
			if (node != null) {
				inOrder(node.left);
				System.out.print(node.data + " ");
				inOrder(node.right);
			}
		}

		public void postOrder() { // postOrder
			postOrder(root);
			System.out.println();
		}

		private void postOrder(Node node) {
			if (node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.print(node.data + " ");
			}
		}

		public int getHeight() { // get the height of the tree
			return getHeight(root);
		}

		private int getHeight(Node node) {
			if (node == null)
				return 0;
			int lHeight = getHeight(node.left);
			int rHeight = getHeight(node.right);

			return 1 + Math.max(lHeight, rHeight);
		}

		public int getSize() { // get the size of the tree
			return getSize(root);
		}

		private int getSize(Node node) {
			if (node == null)
				return 0;
			return 1 + getSize(node.left) + getSize(node.right);
		}

		public boolean isBST() { // is or isn't BST
			return isBST(root, findMin(root).data, findMax(root).data);
		}

		private boolean isBST(Node node, int min, int max) {

			if (node == null)
				return true;
			if (node.data < min || node.data > max)
				return false;
			return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
		}

		public void printLevelOrder() { // print according to the levels
			printLevelOrder(root);
		}

		private void printLevelOrder(Node node) {
			if (node == null)
				return;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);

			while (queue.size() > 0) {
				Node curr = queue.poll();
				if (curr != null) {
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);
					System.out.print(curr.data + "  ");
				} else {
					if (queue.size() == 0)
						break;
					queue.add(null);
					System.out.println();
				}
			}
		}

		public void printZigZag() { // print level in a ZigZag way
			printZigZag(root);
		}

		private void printZigZag(Node node) {
			if (node == null)
				return;
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(null);
			boolean bPrint = true;
			Stack<Node> stack = new Stack<Node>();
			while (queue.size() > 0) {
				Node curr = queue.poll();
				if (curr != null) {
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);
					if (bPrint == true)
						System.out.print(curr.data + "  ");
					else
						stack.push(curr);
				} else {
					if (queue.size() == 0)
						break;
					queue.add(null);
					while (stack.size() > 0)
						System.out.print(stack.pop().data + "  ");
					bPrint = !bPrint;
					System.out.println();
				}
			}
			while (stack.size() > 0)
				System.out.print(stack.pop().data + "  ");
		}

		public void printPerimeter() { // way 1 print the data at the perimeter of the tree
			printPerimeter(root, 0, 0);
			System.out.println(root.data);
		}

		private void printPerimeter(Node node, int left, int right) {
			if (node != null) {
				
//				int l = left;   
//				int r = right;
				//œ¬√Ê–¥≥…
				//printPerimeter(node.left, ++l, right);
				//printPerimeter(node.right, left, ++r);
				if (right == 0 && left != 0)
					System.out.print(node.data + ",");
				else if (left == 0 && right != 0)
					System.out.print(node.data + ",");
				else if (node.left == null && node.right == null)
					System.out.print(node.data + ",");

				printPerimeter(node.left, left+1, right);
				printPerimeter(node.right, left, right+1);
			}
		}
		
		public void printPerimeter1() {  //way 2 using stack
			if (root == null)
				return;
			System.out.print(root.data + " ");
			Stack<Integer> stack = new Stack<Integer>();
			printPerimeter1(root, 0, 0, stack);
			while (stack.size() > 0) {
				System.out.print(stack.pop()+ " ");
			}
			System.out.println();
		}

		public void printPerimeter1(Node node, int left, int right, Stack<Integer> stack) {
			if (node == null)
				return;
			if (left > 0 && right == 0)
				System.out.print(node.data + " ");
			if (left == 0 && right > 0)
				stack.push(node.data);
			if (node.left == null && node.right == null && left > 0 && right > 0)
				System.out.print(node.data + " ");
			printPerimeter1(node.left, left+1, right, stack);
			printPerimeter1(node.right, left, right+1, stack);
		}
		
		public void bottomView() {  //view from the bottom
			bottomView(root);
		}

		public void bottomView(Node node) {
			if (root == null)
				return;
			//initialize the value for the root
			int horiDis = 0;
			
			//use map to store key value pair sorted on key value
			Map<Integer, Integer> map = new TreeMap<>();
			
			//use queue to store tree nodes in level order
			Queue<Node> queue = new LinkedList<Node>();

			root.horiDis = horiDis; //give value to the root
			queue.add(root); //add root into the queue
			
			//loop until the queue is empty
			while (queue.size() > 0) {
				Node curr = queue.remove();
				
				//pass every value of the dequeue node
				horiDis = curr.horiDis; 
				
				//put the dequeue node to map with key as horiDis, 
				//every time we find a node with the same horiDis value,
				//replace the old one
				map.put(horiDis, curr.data);
				
				if (curr != null) {
					if (curr.left != null) {
						curr.left.horiDis = horiDis - 1;
						queue.add(curr.left);
					}
					if (curr.right != null) {
						curr.right.horiDis = horiDis + 1;
						queue.add(curr.right);
					}
				}
			}
			
			//Extract the entries of map into a set to traverse
			Set<Entry<Integer, Integer>> set = map.entrySet();
			
			//make an iterator
			Iterator<Entry<Integer, Integer>> iterator = set.iterator();
			
			//traverse the map elements using the iterator
			while (iterator.hasNext()) {
				Map.Entry<Integer, Integer> me = iterator.next();
				System.out.print(me.getValue() + " ");
			}
		}
	
		public int getNodeLevel(int val){
			return getNodeLevel(root, 1, val);
		}
		
		public int getNodeLevel(Node node, int level, int val){
			if(node == null)
				return 0;
			
			if(node.data == val)
				return level;
			return getNodeLevel(node.left, level+1, val) | getNodeLevel(node.right, level+1, val);
		}
	
		public boolean areSiblings(Node root, Node x, Node y){
			if(root == null)
				return false;
			return((root.left == x && root.right == y) || 
					(root.left == y && root.right == x) ||
					areSiblings(root.left, x, y) ||
					areSiblings(root.right, x, y));
		}
		
		public boolean areCousins(Node root, Node x, Node y){
			int xLevel = getNodeLevel(x.data);
			int yLevel = getNodeLevel(y.data);
			return (xLevel == yLevel) && areSiblings(root, x, y); 
		}
		
		
	}

	public static void main(String[] args) {

		BST bs = new BST();
		bs.insert(8);  //root
		bs.insert(3);
		bs.insert(6);
		bs.insert(4);
		bs.insert(7);
		bs.insert(1);
		bs.insert(10);
		bs.insert(14);
		bs.insert(13);

		// System.out.println(bs.findMin(bs.root).data);
		// System.out.println(bs.findMax(bs.root).data);
		// bs.preOrder();
		// bs.inOrder();
		// bs.postOrder();
		// System.out.println(bs.getHeight());
		// System.out.println(bs.getSize());
		// System.out.println(bs.isBST());
		 bs.printLevelOrder();
		// bs.printZigZag();
//		bs.printPerimeter();
//		bs.printPerimeter1();
//		bs.bottomView();
//		System.out.println(bs.getNodeLevel(7));

	}
}
