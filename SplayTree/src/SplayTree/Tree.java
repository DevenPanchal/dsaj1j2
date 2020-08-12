package SplayTree;

public interface Tree<T extends Comparable<T>> {
	public void iterativeInsert(T data);
	public Node<T> iterativeFind(T data);
	public T getMin();
	public T getMax();
	public void inOrderTraversal();
	void preOrderTraversal();
}
