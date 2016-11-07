package DynamicProgramming;

public class MaxSubsumNoAdjecent {
	
	public int maxSubsumNoAdjecent(int[] arr) {
		int exclude = 0;
		int include = arr[0];
		for(int i = 1; i < arr.length; i++) {
			int temp = include;
			include = Math.max(include, exclude+arr[i]);
			exclude = temp;
		}
		return include;
	}

	public static void main(String[] args) {
		MaxSubsumNoAdjecent msna = new MaxSubsumNoAdjecent();
		int[] arr = {4,1,1,4,2,1};
		System.out.println(msna.maxSubsumNoAdjecent(arr));
	}

}
