package Sorting;

public class FindKthLargest {

	static int findKthLargest(int[] arr, int k){
		return findKthLargest(arr, k, 0, arr.length-1);
	}
	static int findKthLargest(int[] arr, int k, int left, int right){
		int i =left;
		int j =right;
		int temp;
		int pivot =arr[(left+right)/2];
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j){
				temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		if(j==k)
			return arr[j];
		else if(left<j)
			return findKthLargest(arr,k,left,j);
		else //if(right>i)
			return findKthLargest(arr,k,i,right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
