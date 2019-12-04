package StackArray;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();

		stack.push("Adam");
		stack.push("Joe");
		stack.push("Mary");
		stack.push("Jim");
		stack.push("Peter");

		System.out.println(stack.size());
		System.out.println(stack.pop());
		
		System.out.println(stack.size());

		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		stack.push("Nora");
		System.out.println(stack.size());

		System.out.println(stack.peek());
	}

}
