package devenGraph;

public class Testing {

	public static void main(String[] args) {

		Graph g = new Graph();

		g.addNode(7, null);
		g.addNode(14, null);

		g.addNode(105, null);
		g.addNode(60, null);

		g.addNode(95, new int[] { 7, 14 });

		g.addNode(15, new int[] { 95, 60 });

		g.addNode(100, null);
		g.addNode(75, new int[] { 100 });

		g.addNode(55, new int[] { 75 });

		g.addNode(20, new int[] { 105, 55 });

		g.addNode(35, new int[] { 100 });

		g.addNode(5, new int[] { 15, 20 });

		g.addEdge(7, 15);
		g.addEdge(5, 35);
		g.addEdge(100, 20);

		System.out.println("Recursive DFS");
		System.out.println(g.hasPath(75, 105));

		System.out.println();
		System.out.println();
		System.out.println("Iterative DFS");
		System.out.println(g.hasPathIterativeDFS(75, 105));

		System.out.println();
		System.out.println();
		System.out.println("Iterative BFS.  Hey it prints nodes in the order of Levels of Tree/Graph");
		System.out.println(g.hasPathIterativeBFS(75, 105));

		System.out.println();
		System.out.println("***********************************************************");

		System.out.println();
		System.out.println();
		System.out.println("Recursive DFS");
		System.out.println(g.hasPath(5, 7));

		System.out.println();
		System.out.println();
		System.out.println("Iterative DFS");
		System.out.println(g.hasPathIterativeDFS(5, 7));

		System.out.println();
		System.out.println();
		System.out.println("Iterative BFS.  Hey it prints nodes in the order of Levels of Tree/Graph");
		System.out.println(g.hasPathIterativeBFS(5, 7));

	}

}
