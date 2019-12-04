package ArraysArrayLists;

public class App {

	public static void main(String[] args) {

		int[] nums = new int[5];

		int[] nums2 = new int[10];

		for (int i = 1; i < nums.length; ++i)
			nums[i] = i;

		// O(1) Random Search
		int num = nums[2];
		System.out.println(num);

		// O(N) "Linear search" --> O(logN) binary trees --> O(1) hashtables

		for (int i = 0; i < nums.length; ++i)
			if (nums[i] == 4)
				System.out.println("Index found," + i);

		// Below will throw an eception
		nums[5] = 10;
	}
}