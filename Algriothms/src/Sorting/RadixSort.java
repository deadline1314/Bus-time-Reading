package Sorting;

public class RadixSort {

	private static void radixSort(int[] arr){
		//find the maximum number to know number of digits
		int max = getMax(arr);
		//Do counting sort for every digit. Note that instead of passing digit number,
		//exp is passed. exp is 10^i where i is current digit number
		for(int exp =1; max/exp>0; exp *=10){
			countSort(arr,exp);
		}
	}
	private static int getMax(int[] arr){
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]> max)
				max = arr[i];
		}
		return max;
	}
	private static void countSort(int[] arr, int exp){
		int[] output = new int[arr.length]; // output array
		int[] count = new int[10]; //since there can be only 10 values: 0-9
		int i;
		//Store count of occurrences in count[]
		for ( i = 0; i < arr.length; i++) {
			count[(arr[i]/exp)%10]++;
		}
		//change count[i] so that count[i] now contains actual position of this digit in output[]
		for ( i=1; i<10; i++ ){
			count[i] += count[i-1];
		}
		//build the output array
		for( i=arr.length-1; i>=0; i--){
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		//copy the output array to arr[], 
		//so that arr[] now contains sorted numbers according to current digit
		for( i=0; i < arr.length; i++){
			arr[i] = output[i];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
