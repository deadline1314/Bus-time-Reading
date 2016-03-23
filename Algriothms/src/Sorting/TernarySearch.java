package Sorting;

public class TernarySearch {

	static int ternarySearch(int[] arr, int left, int right, int x){
		if(right >= left){
			int mid1 = left + (right - left) / 3;
			int mid2 = mid1 + (right - left) / 3;
			
			//if x is present at the mid1
			if(arr[mid1] == x)
				return mid1;
			//if x is present at the mid2
			if(arr[mid2] == x)
				return mid2;
			//if x is present in the left one-third
			if(arr[mid1] > x)
				return ternarySearch(arr, left, mid1-1, x);
			//if x is present in the right one-third
			if(arr[mid2] < x)
				return ternarySearch(arr, mid2+1, right, x);
			//if x is present in the middle one-third
			else
				return ternarySearch(arr, mid1+1, mid2-1, x);
		}
		//reach here when element is not present in array
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
