package Heap;

public class Heap {

	// we implement the heap data structure with an array. It is a class level
	// variable so that the swap function can also see and alter the same heap.
	private int[] heap;

	// we want to track the size of the heap.
	private int heapSize;

	// this will store the max possible size of heap
	private int maxSize;

	public Heap(int maxSize) {
		this.heap = new int[maxSize];
		this.maxSize = maxSize;

	}

	// insertion takes O(1) time BUT we have to make sure the heap properties are
	// not violated (it takes O(logN) because of the fixUp() method)
	public void insert(int item) {
		if (isHeapFull())
			throw new RuntimeException("Heap is Full...");

		this.heap[heapSize] = item;
		heapSize++;

		// heap properties may be violated, so call fix up method.
		fixUp(heapSize - 1);

	}

	// starting from the last inserted item go up, and swap node and its parents if
	// violation is found.
	// Since this is a MAX heap, a violation means parent < node. So swap if this is
	// the case.
	// Takes O(logN) time
	private void fixUp(int index) {
		int parentIndex = (index - 1) / 2;
		if (index > 0 && heap[index] > heap[parentIndex]) {
			swap(index, parentIndex);
			// fix the next up node
			fixUp(parentIndex);

		}

	}

	private void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;

	}

	

	// Poll or delete root
	// Takes O(1) + (O(logN) time because of the fixDown method) = O(logN) time.
	public int poll() {
		int max = this.heap[0];
		// swap root element and the last element
		swap(0, heapSize - 1);
		this.heapSize--;

		fixDown(0);
		return max;
	}

	// Takes O(logN) time
	private void fixDown(int index) {

		// calculate the indexes of the children
		int indexLeft = 2 * index + 1;
		int indexRight = 2 * index + 2;

		// initiate indexLargest with the parent's index
		int indexLargest = index;

		// logic to find the larger of the 2 children and swap the parent with that
		// child.
		if (indexLeft < heapSize && heap[indexLeft] > heap[index]) {
			indexLargest = indexLeft;
		}

		if (indexRight < heapSize && heap[indexRight] > heap[indexLargest]) {
			indexLargest = indexRight;
		}

		// IMPORTANT: only swap if one of the children was greater than the parent. not
		// otherwise
		if (index != indexLargest) {
			swap(index, indexLargest);
			fixDown(indexLargest);
		}

	}

	private boolean isHeapFull() {
		if (heapSize == maxSize) {
			return true;
		} else
			return false;
	}

	// The Heap Sort which has been implemented as -
	// - HEAPIFY(fix Down) -> this will not be needed for a valid heap uptil that
	// point.
	// - SWAP LAST ITEM WITH ROOT
	// - NEGLECT THE LAST ITEM i.e that is the item bubbling out. This neglecting
	// leads to sorting
	// - REPEAT

	public void heapsort() {
		int size = this.heapSize;
		for (int i = 0; i < size; i++) {

			int max = poll();
			System.out.print(max + " ");
		}
	}

}
