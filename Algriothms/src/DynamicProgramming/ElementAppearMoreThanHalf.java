package DynamicProgramming;

public class ElementAppearMoreThanHalf {
	//O(n) time -> # of element > 50%
	public int majorityOfElement(int[] nums) {
		int count = 1;
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1])
				count++;
			else
				count--;
			if(count == 0)
				res = nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		ElementAppearMoreThanHalf eamth = new ElementAppearMoreThanHalf();
		int[] nums = {3,3,4,2,4,4,2,4,4};
		System.out.println(eamth.majorityOfElement(nums));

	}

}
