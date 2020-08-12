package SplayTree;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> rightNode;
	private Node<T> leftNode;
	private Node<T> parentNode; // becuase the splaying is implemented as a while loop taking only the
								// recentNode. This while loop stops at the root's parent ==null. So we need the
								// parent node of every node.

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}

	public Node<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node<T> parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
