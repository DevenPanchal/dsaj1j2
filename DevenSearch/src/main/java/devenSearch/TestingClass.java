package devenSearch;



public class TestingClass {

	// arguments are passed using the text field below this editor
	public static void main(String[] args) {
		Vertex v8 = new Vertex("v8", 45, false);
		Vertex v7 = new Vertex("v7", 5, false);
		Vertex v6 = new Vertex("v6", 7, false);
		Vertex v5 = new Vertex("v5", 39, false);
		Vertex v4 = new Vertex("v4", 99, false);
		Vertex v3 = new Vertex("v3", 10, false);
		Vertex v2 = new Vertex("v2", 34, false);
		Vertex v1 = new Vertex("v1", 57, false);

		// @formatter:off
		    /*
		    
		    v1-v2-v3
		      -v5-v6-v4
		      -v7   \
		             v8
		    */
			
		// @formatter:on	

		Vertex[] v8vertices = new Vertex[] {};
		Vertex[] v7vertices = new Vertex[] {};
		Vertex[] v6vertices = new Vertex[] { v4, v8 };
		Vertex[] v5vertices = new Vertex[] { v6 };
		Vertex[] v4vertices = new Vertex[] {};
		Vertex[] v3vertices = new Vertex[] {};
		Vertex[] v2vertices = new Vertex[] { v3 };
		Vertex[] v1vertices = new Vertex[] { v2, v5, v7 };

		v1.setChildvertices(v1vertices);
		v2.setChildvertices(v2vertices);
		v3.setChildvertices(v3vertices);
		v4.setChildvertices(v4vertices);
		v5.setChildvertices(v5vertices);
		v6.setChildvertices(v6vertices);
		v7.setChildvertices(v7vertices);
		v8.setChildvertices(v8vertices);

		// Passing the root vertex to recursiveDFS to test
		System.out.println("Calling Recursive Depth First Search");
		DevenSearch rDFS = new DevenSearch();
		rDFS.recursiveDFS(v1);

		System.out.println("Clearing visited flags from the vertices");
		v1.setVisited(false);
		v2.setVisited(false);
		v3.setVisited(false);
		v4.setVisited(false);
		v5.setVisited(false);
		v6.setVisited(false);
		v7.setVisited(false);
		v8.setVisited(false);

		System.out.println("*************************************************");

		// Passing the root vertex to iterativeStackDFS to test
		System.out.println("Calling Iterative Depth First Search");
		DevenSearch iDFS = new DevenSearch();
		iDFS.iterativeStackDFS(v1);

		System.out.println("Clearing visited flags from the vertices");
		v1.setVisited(false);
		v2.setVisited(false);
		v3.setVisited(false);
		v4.setVisited(false);
		v5.setVisited(false);
		v6.setVisited(false);
		v7.setVisited(false);
		v8.setVisited(false);

		System.out.println("*************************************************");

		// Passing the root vertex to iterativeStackDFS to test
		System.out.println("Calling Iterative Breadth First Search");
		DevenSearch iBFS = new DevenSearch();
		iBFS.iterativeQueueBFS(v1);
		
		System.out.println("Clearing visited flags from the vertices");
		v1.setVisited(false);
		v2.setVisited(false);
		v3.setVisited(false);
		v4.setVisited(false);
		v5.setVisited(false);
		v6.setVisited(false);
		v7.setVisited(false);
		v8.setVisited(false);

		System.out.println("*************************************************");
		System.out.println("Calling Recursive Factorial");

		DevenSearch d1 = new DevenSearch();
		System.out.println(d1.rFactorial(7));

		System.out.println("*************************************************");
		System.out.println("Calling Iterative Factorial");

		System.out.println(d1.iFactorial(7));

	}
}
