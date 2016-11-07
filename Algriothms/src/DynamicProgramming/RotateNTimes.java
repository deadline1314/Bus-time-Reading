package DynamicProgramming;

public class RotateNTimes {
	
	public int[] rotateNTimes(int[] nums, int n) {
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, n - 1);
		reverse(nums, n, nums.length - 1);
		return nums;
	}
	private void reverse(int[] nums, int start, int end) {
		while(start <= end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

	public static void main(String[] args) {
		RotateNTimes rnt = new RotateNTimes();
		int[] nums = {1,2,3,4,5};
		int[] res = rnt.rotateNTimes(nums, 3);
		for(int num : res)
			System.out.print(num + " ");
	}
}
