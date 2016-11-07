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
		// these two lines are for testing output
		for (int m = 0; m < arr.length; m++)
			System.out.print(arr[m] + " ");
	}

	static void insertionSort2(int[] arr) {
		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} else {
					break;
				}
			}
		}
		// these two lines are for testing output
		for (int m = 0; m < arr.length; m++)
			System.out.print(arr[m] + " ");
	}

	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		int[] nums = { 3, 4, 5, 7, 1 };
		sort.insertionSort2(nums);

	}

}
