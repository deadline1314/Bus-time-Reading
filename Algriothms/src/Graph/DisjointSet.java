package Graph;

import java.util.HashMap;

public class DisjointSet {
	
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	
	public void makeSet(int data){
		Node node = new Node();
		node.parent = node;
		node.rank = 0;
		node.data = data;
		map.put(data, node);
	}
	
	public int findSet(int data){
		return findSet(map.get(data).data);
	}
	
	private Node findSet(Node node){
		Node parent = node.parent;
		if(parent == node)
			return parent;
		node.parent = findSet(node.parent);
		return node.parent;
	}
	
	public boolean union(int data1, int data2){
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		if(parent1 == parent2)
			return false;
		if(parent1.rank >= parent2.rank){
			if(parent1.rank == parent2.rank)
				parent1.rank +=1;
			parent2.parent = parent1;
		}else{
			parent1.parent = parent2;
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node{
		public int data;
		public Node parent;
		public int rank;
		
	}

}
