package DynamicProgramming;

public class LongestIncreasingSubSequence {
	
	int longestIncreasingSubSequence(int[] arr){
		int[] lis = new int[arr.length];
		for(int i = 0; i < lis.length; i++)
			lis[i] = 1; // give initial value
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1){ // ?
					lis[i] = lis[j] + 1;
					if(max < lis[i])
						max = lis[i];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestIncreasingSubSequence  liss = new LongestIncreasingSubSequence();
		int[] arr = {3,4,-1,0,6,2,3};
		System.out.println(liss.longestIncreasingSubSequence(arr));

	}

}
