package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	public class DijkstraData {
		private int value;
		private Node from;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getFrom() {
			return from;
		}

		public void setFrom(Node from) {
			this.from = from;
		}

	}

	private String startNode;
	private HashMap<String, Node> nodes;

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public Graph() {
		nodes = new HashMap<String, Node>();
	}

	public void setStart(String nodeName) {
		if (nodes.containsKey(nodeName))
			startNode = nodeName;
	}

	public void resetVisited() {
		for (Entry<String, Node> node : nodes.entrySet()) {
			node.getValue().setVisited(false);
		}
	}
	
	private ArrayList<Node> getNeighbours(Node node){
		ArrayList<Node> neighbours = new ArrayList<Node>();
		ArrayList<String> list = node.getNeighbours();
		for(String str: list){
			neighbours.add(nodes.get(str));
		}
		return neighbours;
	}
	
	public void BFS(String startNode){
		resetVisited();
		setStart(startNode);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(nodes.get(startNode));
		nodes.get(startNode).setVisited(true);
		
		while(queue.size() > 0){
			Node node = queue.poll();
			if(!node.isVisited()){
				System.out.println("Visiting node "+node.getName());
				node.setVisited(true);
			}
			ArrayList<String> neighbours = node.getNeighbours();
			for(int i = 0; i < neighbours.size(); i++){
				if(nodes.get(neighbours.get(i)).isVisited() == false){
					System.out.println("Visiting node "+node.getName());
					nodes.get(neighbours.get(i)).setVisited(true);
					queue.add(nodes.get(neighbours.get(i)));
				}
			}
		}
	}
	
	
	/*
	 * judge cycle existing or not in a given graph 
	 */
	public boolean containCycle(){
		HashSet<Node> unvisited = new HashSet<Node>();
		HashSet<Node> visiting = new HashSet<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		for(Entry<String, Node> node : nodes.entrySet()){
			unvisited.add(node.getValue());
		}
		while(unvisited.size() > 0){
			Node current = unvisited.iterator().next();
			if(DFSCycle(current, unvisited, visiting, visited)){
				return true;
			}
		}
		return false;
	}
	public boolean DFSCycle(Node current, HashSet<Node> unvisited, HashSet<Node> visiting, HashSet<Node> visited){
		//move the current to visiting and then explore it
		moveNode(current, unvisited, visiting);
		ArrayList<Node> neighbours = getNeighbours(current);
		for(Node neigh : neighbours){
			if(visited.contains(neigh))
				continue;
			if(visiting.contains(neigh))
				return true;
			if(DFSCycle(neigh, unvisited, visiting, visited))
				return true;
		}
		moveNode(current, visiting, visited);
		return false;
	}
	private void moveNode(Node node, HashSet<Node> source, HashSet<Node> dest){
		source.remove(node);
		dest.add(node);
	}
	
	
	/*
	 * topologicalSort a graph
	 */
	public void topologicalSort(){
		Stack<String> stack = new Stack<String>();
		HashSet<String> visited = new HashSet<String>();
		for(int i = 0; i < nodes.size(); i++){
			if(!visited.contains(nodes.get(i).getName())){
				topologicalSortUtil(nodes.get(i).getName(), visited, stack);
			}
		}
	}
	private void topologicalSortUtil(String nodeName, HashSet<String> visited, Stack<String> stack){
		visited.add(nodeName);
		ArrayList<Edge> edges = nodes.get(nodeName).getEdges();
		for(int i = 0; i < edges.size(); i++){
			if(!visited.contains(edges.get(i).getEndNode())){
				topologicalSortUtil(edges.get(i).getEndNode(), visited, stack);
			}
		}
		stack.push(nodeName);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


// edge
class Edge {
	private String startNode;
	private String endNode;
	private int weight;

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public String getEndNode() {
		return endNode;
	}

	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Edge(String startNode, String endNode, int weight) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
	}
}

// vertical
class Node {
	private String name;
	public ArrayList<Edge> listEdges;
	private boolean visited;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node(String name, boolean visited) {
		this.name = name;
		this.visited = visited;
		listEdges = new ArrayList<Edge>();
	}

	public void addEdge(String endNode, int weight) {
		for (Edge e : listEdges) {
			if (e.getEndNode().equals(endNode))
				return;
		}
		Edge edge = new Edge(this.name, endNode, weight);
		listEdges.add(edge);
	}

	public void deleteEdge(String endNode) {
		for (int i = 0; i < listEdges.size(); i++) {
			if (listEdges.get(i).getEndNode().equals(endNode)) {
				listEdges.remove(i);
				return;
			}
		}
	}

	public ArrayList<String> getNeighbours() {
		ArrayList<String> neighbours = new ArrayList<String>();
		for (Edge edge : listEdges) {
			neighbours.add(edge.getEndNode());
		}
		return neighbours;
	}

	public ArrayList<Edge> getEdges() {
		return listEdges;
	}
}
