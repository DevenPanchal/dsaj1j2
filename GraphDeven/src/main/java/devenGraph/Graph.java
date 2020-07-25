package devenGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	// Add node for directed graphs
	void addNode(int uniqueId, int[] edges) {

		Node newNode = new Node(uniqueId);
		LinkedList<Node> adj = new LinkedList<Node>();

		if (edges != null) {
			for (int edge : edges) {
				// add edge to the adjacent data structure of the Node
				Node edgeNode = null;
				if ((nodeLookup.get(edge)) == null) {
					edgeNode = new Node(edge);
				}
				adj.add(nodeLookup.get(edge));
			}

			newNode.setAdjacent(adj);
		}

		nodeLookup.put(uniqueId, newNode);

	}

	void addEdge(int uniqueId1, int uniqueId2) {

		// check if uniqueId1, uniqueId2 2 exists
		if ((getNode(uniqueId1) == null) || (getNode(uniqueId2) == null)) {
			System.out.println("Either the source node or Destination node does not exit!");
			return;
		}

		// if both exist then add an edge from uniqueId1 to uniqueId2 // MEANING- WE ARE
		// CONSTRUCTING A DIRECTED GRAPH
		Node uniqueId1Node = getNode(uniqueId1);
		Node uniqueId2Node = getNode(uniqueId2);

		// Before this you would ideally check if the edge already exists. But we do not
		// check for brevity and to save time.

		uniqueId1Node.getAdjacent().add(uniqueId2Node); // adj linkedlist of uniqueId1Node changes in-place. See what
														// add() method returns

	}

	// given id, return the Node structure that has the id
	Node getNode(int uniqueId) {
		Node matchedNode = nodeLookup.get(uniqueId);
		return matchedNode;

	}

	// implemented using recursive DFS, same logic as
	// distanceBetweenSourceAndDestination function below, fibonacci, getHeight,
	// Board Paths problem
	boolean hasPath(int uniqueId1, int uniqueId2) {

		// check if uniqueId1, uniqueId2 2 exists
		if ((getNode(uniqueId1) == null) || (getNode(uniqueId2) == null)) {
			System.out.println("Either the source node or Destination node does not exit!");
			return false;
		}

		else {
			// call sophisticated hasPath which sends around a visited Hashset for every
			// recursive call to clearly see and edit who has been visited and who has not
			// been
			HashSet<Integer> visited = new HashSet<Integer>();
			boolean pathExists = hasPath(uniqueId1, uniqueId2, visited);

			visited.clear();// clear the local variable visited after before you return the answer.
			return pathExists;
		}

	}

	private boolean hasPath(int uniqueId1, int uniqueId2, HashSet<Integer> visited) {

		boolean hadPath = false;
		// it node/ int is not visited, then visit it
		if (!(visited.contains(uniqueId1))) {

			// Print node here
			System.out.print(uniqueId1 + " --> ");

			// mark it visited first
			visited.add(uniqueId1);

			// if it is not the id we are looking for then, call hasPath i.e DFS
			// recursively
			if (uniqueId1 != uniqueId2) {

				// check its neighbours
				Node node = nodeLookup.get(uniqueId1);

				for (Node neighbour : node.getAdjacent()) {
					// call deeper

					if (neighbour != null) {
						hadPath = hasPath(neighbour.getId(), uniqueId2, visited);
					} // return if you get true from below
					if (hadPath) {
						return true;
					}

					// if the lower call did not have 'true' then continue iterating over the other
					// neighbours
				}

				// no neighbours remaining in the adjacent list

				return false;
			}

			else {
				return true;
			}

		}
		return false; // the program will never come here. See the pic titled
						// "Reason-For-Last-Return-In-Has-Path.jpg" in the project folder.

	}

	// Has Path using DFS. This DFS uses Iterative Approach. So we will have to //
	// Stack
	boolean hasPathIterativeDFS(int uniqueId1, int uniqueId2) { //
		// check if uniqueId1,uniqueId2 2 exists
		if ((getNode(uniqueId1) == null) || (getNode(uniqueId2) == null)) {
			System.out.println("Either the source node or Destination node does not exit!");
			return false;
		}

		else { // call sophisticated hasPath which sends around a visited Hashset for
				// every recursive call to clearly see and edit who has been visited and who
				// has not been

			HashSet<Integer> visited = new HashSet<Integer>();

			// Create neighbour stack

			Stack<Integer> s = new Stack<Integer>();

			boolean pathExists = hasPathIterativeDFS(uniqueId1, uniqueId2, visited, s);
			visited.clear();// clear the local variable visited after before you return the answer.
			return pathExists;

		}
	}

	private boolean hasPathIterativeDFS(int uniqueId1, int uniqueId2, HashSet<Integer> visited, Stack s) {

		while (true) {

			// if not visited then visit and perform actions

			if (!(visited.contains(uniqueId1))) {

				// Print node here
				System.out.print(uniqueId1 + " --> ");

				// mark it visited first
				visited.add(uniqueId1);

				if (uniqueId1 == uniqueId2) {
					// I am the destination!
					return true; // this is the only place that will return TRUE
				}

				else {

					// Spread Frock
					for (Node neighbour : getNode(uniqueId1).getAdjacent()) {
						// Add all not visited neighbours to stack

						if ((neighbour != null) && (!(visited.contains(neighbour.getId())))) {
							s.push(neighbour.getId());
						}

					}

					// pop one topmost neighbour now or if no neighbours were added, then pop
					// whatever is next.
					if (!(s.empty())) {
						uniqueId1 = (Integer) s.pop();
						continue;
					}

					else
						return false; // because may be no new neighbour was added to stack and nothing remaining
										// too from elsewehere
				}
			} // if !visited ends

			// if visited node, then continue with next popped element
			if (!(s.isEmpty())) {
				uniqueId1 = (Integer) s.pop();
				continue;
			}

		} // while ends

	}

	// Has Path using BFS. This BFS uses Iterative Approach. So we will have to use
	// Queue
	boolean hasPathIterativeBFS(int uniqueId1, int uniqueId2) {
		// check if uniqueId1, uniqueId2 2 exists
		if ((getNode(uniqueId1) == null) || (getNode(uniqueId2) == null)) {
			System.out.println("Either the source node or Destination node does not exit!");
			return false;
		}

		else {
			// call sophisticated hasPath which sends around a visited Hashset for every
			// recursive call to clearly see and edit who has been visited and who has not
			// been
			HashSet<Integer> visited = new HashSet<Integer>();

			// Create neighbour queue
			Queue<Integer> q = new LinkedList<Integer>();

			boolean pathExists = hasPathIterativeBFS(uniqueId1, uniqueId2, visited, q);
			visited.clear();// clear the local variable visited after before you return the answer.
			return pathExists;

		}
	}

	private boolean hasPathIterativeBFS(int uniqueId1, int uniqueId2, HashSet<Integer> visited, Queue q) {

		while (true) {

			// if not visited then visit and perform actions

			if (!(visited.contains(uniqueId1))) {

				// Print node here
				System.out.print(uniqueId1 + " --> ");

				// mark it visited first
				visited.add(uniqueId1);

				if (uniqueId1 == uniqueId2) {
					// I am the destination!
					return true; // this is the only place that will return TRUE
				}

				else {

					// Spread Frock
					for (Node neighbour : getNode(uniqueId1).getAdjacent()) {
						// Add all not visited neighbours to queue

						if ((neighbour != null) && (!(visited.contains(neighbour.getId())))) {
							q.add(neighbour.getId());
						}
					}

					// dequeue the earliest item from queue
					if (!(q.isEmpty())) {
						uniqueId1 = (Integer) q.remove();
						continue;
					}

					else
						return false; // because may be no new neighbour was added to queue and nothing remaining
										// too from elsewehere
				}
			} // if !visited ends

			// if visited node, then continue with next enqueued element
			if (!(q.isEmpty())) {
				uniqueId1 = (Integer) q.remove();
				continue;
			}
		} // while ends

	}

	/*
	 * // implemented using recursive DFS, same logic as hasPath function above , //
	 * fibonacci, getHeight, Board Paths problem
	 * 
	 * // returns -1 if no path found int distanceBetweenSourceAndDestination(int
	 * uniqueId1, int uniqueId2) {
	 * 
	 * // check if uniqueId1, uniqueId2 2 exists if ((getNode(uniqueId1) == null) ||
	 * (getNode(uniqueId2) == null)) { System.out.
	 * println("Either the source node or Destination node does not exit!"); return
	 * -1; }
	 * 
	 * else { // call sophisticated hasPath which sends around a visited Hashset for
	 * every // recursive call to clearly see and edit who has been visited and who
	 * has not // been HashSet<Integer> visited = new HashSet<Integer>(); int
	 * distance = distanceBetweenSourceAndDestination(uniqueId1, uniqueId2, visited,
	 * -1); // initialize with -1 // i.e not a // meaningful // distance
	 * visited.clear(); return distance;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // returns -1 if no path found private int
	 * distanceBetweenSourceAndDestination(int uniqueId1, int uniqueId2,
	 * HashSet<Integer> visited, int distance) {
	 * 
	 * // it node/ int is not visited, then visit it if
	 * (!(visited.contains(uniqueId1))) {
	 * 
	 * // Print node here System.out.print(uniqueId1 + " --> ");
	 * 
	 * // mark it visited first visited.add(uniqueId1);
	 * 
	 * // if it is not the id we are looking for then, call hasPath i.e DFS //
	 * recursively if (uniqueId1 != uniqueId2) {
	 * 
	 * // check its neighbours i.e Spread frock Node node =
	 * nodeLookup.get(uniqueId1);
	 * 
	 * for (Node neighbour : node.getAdjacent()) { // call deeper
	 * 
	 * if (neighbour != null) { distance =
	 * distanceBetweenSourceAndDestination(neighbour.getId(), uniqueId2, visited,
	 * distance);
	 * 
	 * }
	 * 
	 * // return distance; return distance++;
	 * 
	 * // if the lower call did not have 'true' then continue iterating over the
	 * other // neighbours }
	 * 
	 * // no neighbours remaining in the adjacent list return -1; // no distance
	 * found. }
	 * 
	 * else { // since distance from 'me' to 'me' is 0. return 0; }
	 * 
	 * } return -1; // the program will never come here. See the pic titled //
	 * "Reason-For-Last-Return-In-Has-Path.jpg" in the project folder.
	 * 
	 * }
	 */

}
