package SplayTree;

public class App {

	public static void main(String[] args) {

		SplayTree<Integer> splayTree = new SplayTree<>();

		/*
		 * splayTree.recursiveInsert(10); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * System.out.println("The root is - "); splayTree.printRoot();
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal();
		 * 
		 * splayTree.recursiveInsert(0); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * System.out.println("The root is - "); splayTree.printRoot();
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveInsert(234); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveInsert(-3); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveInsert(23); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveInsert(-56); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * System.out.println("The root is - "); splayTree.printRoot();
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveInsert(78); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * System.out.println("The root is - "); splayTree.printRoot();
		 * 
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal(); System.out.println();
		 * 
		 * splayTree.recursiveFind(23); splayTree.setParentNode(null); // reset the
		 * parentNode variable of the class to null
		 * 
		 * System.out.println("The root is - "); splayTree.printRoot();
		 * System.out.println("The inOrder (LNR) Traversal is - ");
		 * splayTree.inOrderTraversal(); System.out.println();
		 * 
		 * System.out.println("The preOrder (NLR) Traversal is - ");
		 * splayTree.preOrderTraversal();
		 * 
		 * System.out.println();
		 */
		
		splayTree.iterativeInsert(10);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();

		splayTree.iterativeInsert(0);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.iterativeInsert(234);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.iterativeInsert(-3);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.iterativeInsert(23);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.iterativeInsert(-56);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.iterativeInsert(78);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveFind(23);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();

		System.out.println();
		
		
		
		

	}
}
