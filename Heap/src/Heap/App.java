package Heap;

public class App {
	public static void main(String[] args) {


		Heap heap2 = new Heap(10);

		heap2.insert(10);
		heap2.insert(100);
		heap2.insert(-10);
		heap2.insert(15);
		heap2.insert(7);
		heap2.insert(99);
		heap2.insert(20);
		heap2.insert(63);
		heap2.insert(-35);

		// doing a heapsort once will remove all the items because of the way we have
		// implemented it.
		// it is as good as doing deleteRoot or poll() 8 times.
		heap2.heapsort();

		System.out.println();

		

	}
}
