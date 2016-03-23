package Sorting;

public class GetFirstOccurance {

	static int getFirstOccurance(int[] arr, int x){
		return getFirstOccurance(arr, x, 0, arr.length-1);
	}
	static int getFirstOccurance(int[] arr, int x, int start, int end){
		if(start > end)
			return -1;
		if(arr[start] > x) //smallest value is greater than x
			return -1;
		if(arr[end] < x) // even greatest value is smaller than x
			return -1;
		if(arr[start] == x)
			return start;
		
		int mid = (start + end)/2;
		if(arr[mid] == x)
			return getFirstOccurance(arr, x, start, mid-1);
		else if(arr[mid] < x)
			return getFirstOccurance(arr, x, mid+1, end);
		else
			return getFirstOccurance(arr, x, start, mid-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
