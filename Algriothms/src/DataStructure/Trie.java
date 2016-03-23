package DataStructure;

import java.util.ArrayList;
import java.util.List;

class Node2 {
	public char ch;
	public boolean isTerminalChar;
	public List<Node2> children;

	private Node2() {
	}

	public Node2(char ch) {
		this.ch = ch;
		this.isTerminalChar = false;
		children = new ArrayList<Node2>();

	}
}

public class Trie {

	Node2 root;

	public Trie() {
		root = new Node2('\0');
	}

	private void insert(String str) {
		char[] arr = str.toCharArray();

		Node2 curr = root;
		for (int i = 0; i < arr.length; i++) {
			Node2 child = findChild(curr, arr[i]);
			if (child == null) {
				child = new Node2(arr[i]);
				curr.children.add(child);
			}

			curr = child;
			if (i == arr.length - 1)
				curr.isTerminalChar = true;
		}
	}

	private Node2 findChild(Node2 node, char ch) {
		for (int i = 0; i < node.children.size(); i++) {
			if (ch == node.children.get(i).ch)
				return node.children.get(i);
		}

		return null;
	}

	public boolean doesExist(String str) {
		char[] arr = str.toCharArray();

		Node2 curr = root;
		for (int i = 0; i < arr.length; i++) {
			Node2 child = findChild(curr, arr[i]);
			if (child == null)
				return false;
			curr = child;
		}
		return true;
	}

	public void createSuffixTrie(String str) {
		str += "$";
		for (int i = 0; i < str.length(); i++) {
			String sub = str.substring(str.length() - 1 - i, i + 1);
			insert(sub);
		}

	}

	public static void main(String[] args) {

	}

}
