package FinalQuestion;

public class PrintRightView {

	public static class Node { // define structure of node
		public int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BST { // buile BST
		Node root;
		Max_level max = new Max_level();

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

		// printRight function
		void printRightView() {
			printRightView(root);
		}

		void printRightView(Node node) {
			rightView(node, 1, max);
		}

		void rightView(Node node, int level, Max_level max_level) {
			if (node == null)
				return;
			if (max_level.max_level < level) {
				System.out.print(node.data + " ");
				max_level.max_level = level;
			}

			rightView(node.right, level + 1, max_level);
			rightView(node.left, level + 1, max_level);
		}

	}

	public static void main(String[] args) {
		BST bs = new BST();
		bs.insert(8); // root
		bs.insert(3);
		bs.insert(6);
		bs.insert(4);
		bs.insert(7);
		bs.insert(1);
		bs.insert(10);
		bs.insert(14);
		bs.insert(13);

		bs.printRightView();

	}

}

class Max_level {
	int max_level;
}
