package Sorting;

public class InsertionSort {
	static void insertionSort(int[] arr) {
		int key;
		for (int i = 1; i < arr.length; i++) {
			key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		for (int m = 0; m < arr.length; m++) // these two lines are for testing
												// output
			System.out.print(arr[m] + " ");
	}

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] nums = { 3, 4, 5, 7, 1 };
		sort.insertionSort(nums);

	}

}
