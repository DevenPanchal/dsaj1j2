package devenSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DevenSearch {
	

	
	public void recursiveDFS(Vertex v) {

		// On encountering a node, Define what the function does, i.e just reads and
		// prints the data and sets visited as true saying "read" or "visited"

		System.out.println("The vertex is " + v.getName() + " with data " + v.getData() + " ");
		v.setVisited(true);

		// since it is depth first, immediately go depthwise and try to push child nodes
		// towards the function recursiveDFS if it has not been handled.

		for (Vertex cv : v.getChildvertices()) {
			// the below if condition is needed only for a closed graph. ie when children
			// are neighbours and there is a possibility of having encountering a vertex
			// more than once.
			if (cv.isVisited() != true) {
				recursiveDFS(cv);
			}

		}

	}
	
	
public void iterativeQueueBFS(Vertex v) {
	
	Queue<Vertex> q = new LinkedList<Vertex>();
	q.add(v);
	
	while (!q.isEmpty()) {

		Vertex actualNode = q.remove();
		actualNode.setVisited(true);
		System.out.println("The vertex is " + actualNode.getName() + " with data " + actualNode.getData() + " ");

		for (Vertex cv : actualNode.getChildvertices()) {
			// the below if condition is needed only for a closed graph. ie when children
			// are neighbours and there is a possibility of having encountering a vertex
			// more than once.

			if (cv.isVisited() != true) {
				q.add(cv);

			}
		}
	}
	
	}

	public void iterativeStackDFS(Vertex v) {

		// On encountering a node, push it to the stack. We will use the stack from
		// java.util here
		Stack<Vertex> s = new Stack<Vertex>();
		s.push(v);

		// Now keep processing the stack until it is empty. The strategy here is -
		// since it is iterative, deepest children will require deep nested for loops.
		// But our strategy of pushing the children onto the stack i.e modifying the
		// stack in the for loop, and popping and reading data outside it works like an
		// endless loop consuming all vertices.

		while (!s.empty()) {

			Vertex actualNode = s.pop();
			actualNode.setVisited(true);
			System.out.println("The vertex is " + actualNode.getName() + " with data " + actualNode.getData() + " ");

			for (Vertex cv : actualNode.getChildvertices()) {
				// the below if condition is needed only for a closed graph. ie when children
				// are neighbours and there is a possibility of having encountering a vertex
				// more than once.

				if (cv.isVisited() != true) {
					s.push(cv);

				}
			}
		}

	}

	public int rFactorial(int num) {

		if (num == 0) {
			return 1;
		}
		return num * rFactorial(num - 1);
	}

	public int iFactorial(int num) {

		Stack<Integer> s2 = new Stack<Integer>();

		s2.push(num);
		int fact = 1;

		while (!s2.isEmpty()) {

			int actualNum = s2.pop();
			fact = fact * actualNum;
			actualNum--;

			// No for loop required here since 1 node is connected to only 1 node i.e the
			// number lesser than 1
			if (actualNum >= 1) {
				s2.push(actualNum);
			}
		}

		return fact;

	}
}
