package StackLinkedList;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(10);
		stack.push(3);
		stack.push(15);
		stack.push(30);
		stack.push(99);
		stack.push(2);
		
		System.out.println("The stack size is "+stack.size());
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());

		System.out.println(stack.pop());

		System.out.println(stack.isEmpty());
		
		System.out.println("The stack size is "+stack.size());

	}

}
