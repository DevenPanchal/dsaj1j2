package devenGraph;

import java.util.LinkedList;

public class Node {

	int id;
	LinkedList<Node> adjacent = new LinkedList<Node>();

	// boolean isVisited;}

	public Node(int uniqueId) {
		this.id = uniqueId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Node> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(LinkedList<Node> adjacent) {
		this.adjacent = adjacent;
	}
}
