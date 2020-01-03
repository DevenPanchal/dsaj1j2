package SplayTree;

public class App {

	public static void main(String[] args) {

		Tree<Integer> splayTree = new SplayTree<>();

		splayTree.insert(10);
		splayTree.insert(0);
		((SplayTree<Integer>) splayTree).printRoot();
		splayTree.insert(234);
		splayTree.insert(-3);
		splayTree.insert(23);
		splayTree.insert(-56);
		((SplayTree<Integer>) splayTree).printRoot();
		splayTree.insert(78);

		splayTree.inOrderTraversal();

		splayTree.find(23);
		System.out.println();
		((SplayTree<Integer>) splayTree).printRoot();
	}
}
