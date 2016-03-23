package Sorting;

public class CountSort {

	private static int range = 10; //the whole range has been given
	private static void CountSort(int[] arr){
		int[] count = new int[range];
		//store count of each value
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		//go through entire range
		int index =0;
		for(int i=0; i<range; i++){
			//if range value has occurred more than once
			while(count[i]>0){
				arr[index]=i; //add value in the index
				index++;      //increment index
				count[i]--;   //decrement # of times the value occurred in count array
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
