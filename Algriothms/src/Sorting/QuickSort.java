package Sorting;

public class QuickSort {

	static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
		
//		for (int m = 0; m < arr.length; m++) // these two lines are for testing output
//			System.out.print(arr[m] + " ");
	}
	static void quickSort(int[] arr, int left, int right){
		int i =left;
		int j = right;
		int temp;
		int pivot = arr[(left+right)/2];
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j){
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		if(left<j)
			quickSort(arr,left,j);
		if(right>i)
			quickSort(arr,i,right);
	}
	
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] nums = { 3, 4, 5, 7, 1 };
		sort.quickSort(nums);

	}

}
