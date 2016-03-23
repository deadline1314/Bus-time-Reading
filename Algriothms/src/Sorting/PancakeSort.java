package Sorting;

public class PancakeSort {

	static void pancakeSort(int[] arr){
		//start from the complete array and one by one reduce current size by one
		for(int curr_size = arr.length; curr_size >1; curr_size--){
			//find index of the maxium element in arr[0~curr_size-1]
			int mi = findMaxIndex(arr, curr_size);
			//move the maximum element to end of current array if it's not already at the end
			if(mi != curr_size -1){
				//to move at the end, first move maximum number to beginning
				flip(arr, mi);
				//now move the maximum number to end by reversing current array
				flip(arr, curr_size-1);
			}
		}
	}
	static void flip(int[] arr, int i){
		int temp, start = 0;
		while(start <i){
			temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			start++;
			i--;
		}
	}
	static int findMaxIndex(int[] arr, int end){
		int max_Index = 0;
		for(int i=0; i<end; i++){
			if(arr[i]>arr[max_Index])
				max_Index = i;
		}
		return max_Index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
