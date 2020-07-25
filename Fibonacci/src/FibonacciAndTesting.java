
import java.util.*;

public class FibonacciAndTesting {

	Hashtable<Integer, Integer> dict = new Hashtable<Integer, Integer>();

	public static void main(String[] args) {

		FibonacciAndTesting t = new FibonacciAndTesting();

		// Enter the number 'n'. This will generate/ print the first 'n' terms of the
		// Fibonacci series
		t.fibonacci(25);

		t.printFibo();

	}

	public int fibonacci(int n) {
		int fib = 0;
		if (n <= 0) {
			dict.put(n, 0);
			return 0;
		}

		else if (n == 1) {
			dict.put(n, 1);
			return 1;
		}

		else if (n > 1) {

			fib = fibonacci(n - 2) + fibonacci(n - 1);

			dict.put(n, fib);

		}

		return fib;

	}

	public void printFibo() {

		Set<Integer> keys = dict.keySet();

		// Obtaining iterator over set entries
		Iterator<Integer> itr = keys.iterator();

		// Displaying Key and value pairs

		int intKey = 0;
		System.out.println("n  |  fib ");
		System.out.println("----------");
		while (itr.hasNext()) {
			// Getting Key
			intKey = itr.next();

			/*
			 * public V get(Object key): Returns the value to which the specified key is
			 * mapped, or null if this map contains no mapping for the key.
			 */
			System.out.println(intKey + "  |  " + dict.get(intKey));
		}
	}

}