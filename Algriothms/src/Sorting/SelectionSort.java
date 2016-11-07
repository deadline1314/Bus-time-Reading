package Sorting;

public class SelectionSort {
	static void selectionSort(int[] arr) {
		if (arr.length == 0)
			return;
		int temp;
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		for (int m = 0; m < arr.length; m++) // these two lines are for testing
												// output
			System.out.print(arr[m] + " ");
	}

	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		int[] nums = { 3, 4, 5, 7, 6 };
		sort.selectionSort(nums);

	}

}
