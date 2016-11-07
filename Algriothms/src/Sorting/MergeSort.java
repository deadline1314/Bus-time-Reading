package Sorting;

public class MergeSort {

	static void mergeSort(int[] arr) {
		mergeSortAux(arr, 0, arr.length - 1);

		// these two lines are for testing output
		for (int m = 0; m < arr.length; m++)
			System.out.print(arr[m] + " ");
	}

	// divide into two parts
	static void mergeSortAux(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSortAux(arr, low, mid);
		mergeSortAux(arr, mid + 1, high);
		merge(arr, low, high);
	}

	static void merge(int[] arr, int low, int high) { // merge and sort
		int mid = (low + high) / 2;
		int[] temp = new int[high - low + 1];

		int i = low;
		int j = mid + 1;
		int index = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[index] = arr[i];
				i++;
			} else {
				temp[index] = arr[j];
				j++;
			}
			index++;
		}
		// If there are left overs copy them in the temp array
		while (i <= mid) {
			temp[index++] = arr[i++];
		}
		while (j <= high) {
			temp[index++] = arr[j++];
		}
		i = low;
		for (int k = 0; k < temp.length; k++) {
			arr[i] = temp[k];
			i++;
		}
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int[] nums = { 3, 4, 5, 7, 6 };
		sort.mergeSort(nums);

	}

}
