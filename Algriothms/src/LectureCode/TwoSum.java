package LectureCode;

import java.util.HashMap;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int[] res = new int[2];
	        
	        for(int i = 0; i < nums.length; i++){
	            if(map.containsKey(target - nums[i])){
	                res[0] = map.get(target-nums[i]);
	                res[1] = i;
	            }
	            map.put(nums[i], i);
	        }
	        return res;
	    }

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		TwoSum ts = new TwoSum();
		int[] result = new int[2];
		result = ts.twoSum(nums, 3);
		System.out.println(result[0] +" " + result[1]);

	}

}
