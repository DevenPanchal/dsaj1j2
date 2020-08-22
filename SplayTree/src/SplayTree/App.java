package SplayTree;

public class App {

	public static void main(String[] args) {

		SplayTree<Integer> splayTree = new SplayTree<>();

		splayTree.recursiveInsert(10);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();

		splayTree.recursiveInsert(0);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveInsert(234);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveInsert(-3);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveInsert(23);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveInsert(-56);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();
		System.out.println();

		splayTree.recursiveInsert(78);
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

		splayTree.recursiveFind(999);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree.preOrderTraversal();

		System.out.println();

		System.out.println("*******************************************************************************");

		SplayTree<Integer> splayTree2 = new SplayTree<>();

		splayTree2.iterativeInsert(10);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree2.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();

		splayTree2.iterativeInsert(0);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree2.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeInsert(234);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeInsert(-3);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeInsert(23);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeInsert(-56);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree2.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeInsert(78);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree2.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();
		System.out.println();

		splayTree2.iterativeFind(23);
		splayTree.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree2.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();

		System.out.println();

		splayTree2.iterativeFind(999);
		splayTree2.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree2.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree2.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree2.preOrderTraversal();

		System.out.println();

		System.out.println("*******************************************************************************");

		SplayTree<Integer> splayTree3 = new SplayTree<>();

		splayTree3.recursiveInsert(10);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree3.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();

		splayTree3.recursiveInsert(0);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree3.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveInsert(234);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveInsert(-3);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveInsert(23);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveInsert(-56);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree3.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveInsert(78);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null
		System.out.println("The root is - ");
		splayTree3.printRoot();

		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();
		System.out.println();

		splayTree3.recursiveFind(23);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree3.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();

		System.out.println();

		splayTree3.recursiveFind(999);
		splayTree3.setParentNode(null); // reset the parentNode variable of the class to null

		System.out.println("The root is - ");
		splayTree3.printRoot();
		System.out.println("The inOrder (LNR) Traversal is - ");
		splayTree3.inOrderTraversal();
		System.out.println();

		System.out.println("The preOrder (NLR) Traversal is - ");
		splayTree3.preOrderTraversal();

		System.out.println();

	}
}
