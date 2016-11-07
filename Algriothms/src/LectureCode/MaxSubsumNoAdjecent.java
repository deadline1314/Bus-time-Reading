package LectureCode;

public class MaxSubsumNoAdjecent {

	int maxSubsumNoAdjecent(int[] arr) {
		 if(arr.length == 0)
	            return 0;
		int include = 0;
		int exclude = arr[0]; // maximum so far
		for (int i = 1; i < arr.length; i++) {
			int temp = exclude;
			exclude = Math.max(exclude, include + arr[i]);
			include = temp;
		}
		return exclude;
	}

	public static void main(String[] args) {
		MaxSubsumNoAdjecent msna = new MaxSubsumNoAdjecent();
		int[] arr = { 4, 1, 1, 4, 2, 1 };
		System.out.println(msna.maxSubsumNoAdjecent(arr));

	}

}
