package Sorting;

public class GetTotalOccurances {

	static int getTotalOccurances(int[] arr, int x){
		//Input: arr[] = {1,1,2,2,2,2,3} x=2
		//Output: 4
		return getTotalOccurances(arr, x, 0, arr.length-1);
	}
	static int getTotalOccurances(int[] arr, int x, int start, int end){
		if(end <start)
			return 0;
		if(arr[start] > x) // even smallest value is greater than x
			return 0;
		if(arr[end] < x) // even biggest value is smaller than x
			return 0;
		if(arr[start] == x && arr[end] == x) // all elements are x
			return end-start +1;
		
		int mid = (start + end) / 2;
		if(arr[mid] == x)
			return 1+getTotalOccurances(arr, x, start, mid-1)+getTotalOccurances(arr, x, mid+1, end);
		else if (arr[mid] < x) //search in the right side
			return getTotalOccurances(arr, x, mid+1, end);
		else
			return getTotalOccurances(arr, x, start, mid-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
