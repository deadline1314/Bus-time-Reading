package Sorting;

public class BinarySearch {

	static boolean binarySearch(int[] arr, int x) {   //way 1
		if (arr.length == 0)
			return false;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2; // int mid = low/2+high/2;
			if (arr[mid] == x)
				return true;
			else if (arr[mid] < x) {
				low = mid + 1; // search in right half
			} else {
				high = mid - 1; // search in the left half
			}
		}
		return false;
	}
	
	
	static boolean binarySearchRecursive(int[] arr, int x){  //way 2
		return binarySearchRecursive(arr, x, 0, arr.length-1);
	}
	static boolean binarySearchRecursive(int[] arr, int x, int low, int high){
		if(low > high)
			return false;
		int mid=(low+high)/2;
		if(arr[mid] == x)
			return true;
		else if (arr[mid] < x)
			return binarySearchRecursive(arr, x, mid+1, high);
		else
			return binarySearchRecursive(arr, x, low, mid-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
