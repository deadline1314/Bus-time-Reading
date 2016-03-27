package DataStructure;

import java.util.ArrayList;
import java.util.List;

class Node2 {
	public char ch;
	public boolean isTerminalChar;
	public List<Node2> children;


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
			String sub = str.substring(str.length() - 1 - i, str.length());
			insert(sub);
			// System.out.println(sub);
		}

	}

	public int occurNumOfSubstring(String substr) {
		if (substr.length() == 0)
			return Integer.MAX_VALUE;
		char[] arr = substr.toCharArray();

		Node2 curr = root;
		for (int i = 0; i < arr.length; i++) {
			Node2 child = findChild(curr, arr[i]);
			if (child != null) {
				curr = child;
			} else {
				return 0;
			}
		}
		if (curr.ch == arr[arr.length - 1]) {
			count = DFSCount(curr, '$');
		}
		return count;

	}

	int count = 0;
	
	int DFSCount(Node2 curr, char c) {
		for (Node2 cur : curr.children) {
			if (cur.ch == '$') {
				count++;
			}
			DFSCount(cur, c);
		}
		return count;
	}

	public String longestRepeatedSubstr(String str) {
		StringBuilder sb = new StringBuilder();
		String result = "";
		DFS(result, sb, root);
		return result;
	}

	void DFS(String result, StringBuilder sb, Node2 current) {
		System.out.println(sb.toString());
		System.out.println(count);
		if (occurNumOfSubstring(sb.toString()) < 2) {
			System.out.println("1111");
			result = result.length() > sb.toString().length() ? result : sb.toString();
			// System.out.println(result);
			return;
		}
		// System.out.println(sb.toString() + "]]");
		for (Node2 cur : current.children) {
			// System.out.println(sb.toString() + "||");
			sb.append(cur.ch);
			// System.out.println(sb.toString());
			DFS(result, sb, cur);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		String str = "banana";
		Trie tr = new Trie();
		tr.createSuffixTrie(str);
		// System.out.println(tr.doesExist("an"));
		 System.out.println(tr.occurNumOfSubstring("an"));
//		System.out.println(tr.longestRepeatedSubstr("banana"));
	}

}
