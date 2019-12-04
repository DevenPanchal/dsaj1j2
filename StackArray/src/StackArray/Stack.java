package StackArray;

public class Stack<T> {

	private T[] stackArray;
	private int countOfItemsInStack;

	public Stack() {

		// WE CANNOT DO this.stack = NEW T[1] ; BECAUSE JAVA DOES NOT SUPPORT GENERIC
		// ARRAYS.

		this.stackArray = (T[]) new Object[1];
		this.countOfItemsInStack=0;
	}

	public void push(T item) {

		if (countOfItemsInStack == this.stackArray.length) {
			resize(2 * this.stackArray.length);
		}

		this.stackArray[countOfItemsInStack] = item;
		countOfItemsInStack++;
	}

	public T pop() {

		
		T poppedItem = this.stackArray[countOfItemsInStack-1];
		// the items popped off the stackArray will not be garbage collected if not set to
		// null. Hence set the popped items to null
		this.stackArray[countOfItemsInStack] = null;
		countOfItemsInStack--;


		if (countOfItemsInStack > 0 && countOfItemsInStack == this.stackArray.length / 4) {
			resize(this.stackArray.length / 2);
		}
		return poppedItem;
	}

	public T peek() {
		T peekedItem = this.stackArray[countOfItemsInStack-1];
		return peekedItem;
	}

	public boolean isEmpty() {
		return this.countOfItemsInStack == 0;
	}

	public int size() {
		return this.countOfItemsInStack;
	}

	// O(n)
	private void resize(int capacity) {

		T[] stackCopy = (T[]) new Object[capacity];

		for (int i = 0; i < countOfItemsInStack; i++) {
			stackCopy[i] = this.stackArray[i];
		}

		this.stackArray = stackCopy;
	}
}
