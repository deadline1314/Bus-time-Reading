package Sorting;

public class DutchFlag {

	static void dutchFlag(int[] arr, int pivot) { //pivot = 1
		// 0,1,0,1,2,0,0,1
		int small = 0;
		int equal = 0;
		int large = arr.length - 1;

		int temp;
		while (equal <= large) {
			if (arr[equal] < pivot) {
				temp = arr[equal];
				arr[equal] = arr[small];
				arr[small] = temp;
				small++;
				equal++;
			} else if (arr[equal] == pivot) {
				equal++;
			} else {
				temp = arr[equal];
				arr[equal] = arr[large];
				arr[large] = temp;
				large--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
