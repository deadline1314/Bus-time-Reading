package Sorting;

import Sorting.QuickSort;

public class SortArrayWaveForm {

	private static void sortArrayWaveForm(int[] arr){ // way 1
		//{3,6,5,10,7,20}
		QuickSort quicksort = new QuickSort();
		quicksort.quickSort(arr);
		int temp;
		for(int i=0; i< arr.length-1; i +=2){
			temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] =temp;
		}
		for (int m = 0; m < arr.length; m++) // these two lines are for testing output
			System.out.print(arr[m] + " ");
	}
	private static void sortArrayWaveFormLinear(int[] arr){ // way 2
		//the idea is based on the fact that if we make sure that all even positioned
		//(at index 0,2,4...)elements are greater than their adjacent odd elements, 
		//we don't need to worry about odd positioned element.
		//1) Traverse all even positioned elements of imput array, and do following:
		//-> a)If current element is smaller than previous odd element, swap previous and current.
		//-> b)If current element is smaller than next odd element, swap next and current
		int temp;
		//Traverse all even elements
		for(int i = 0; i < arr.length; i +=2){
			//If current even element is smaller than previous
			if(i>0 && arr[i-1]>arr[i]){
				temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
			}
			//If current even element is smaller than next
			if(i<arr.length-1 && arr[i]<arr[i+1]){
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}		
	}
	
	public static void main(String[] args) {
		SortArrayWaveForm sort = new SortArrayWaveForm();
		int[] nums = {3,6,5,10,7,20};
		sort.sortArrayWaveForm(nums);

	}

}
