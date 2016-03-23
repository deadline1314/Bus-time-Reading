package Sorting;

public class BubbleSort {
	// BubbleSort
	static void bubbleSort(int[] arr) {
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int m = 0; m < arr.length; m++) // these two lines are for testing output
			System.out.print(arr[m] + " ");
	}

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] nums = { 3, 4, 5, 7, 6 };
		sort.bubbleSort(nums);
	}

}
