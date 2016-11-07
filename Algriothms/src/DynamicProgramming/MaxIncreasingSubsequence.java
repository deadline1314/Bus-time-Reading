package DynamicProgramming;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class MaxIncreasingSubsequence {
	
	public List<Integer> maxIncreasingSubsequence(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		int[] value = new int[len];
		int[] source = new int[len];
		value[0] = nums[0];
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					if(value[i] < value[j] + nums[i]) {
						value[i] = value[j] + nums[i];
						source[i] = j;
					}
				}else{
					if(value[i] < nums[i]){
						value[i] = nums[i];
						source[i] = i;
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i = 0; i < len; i++) {
			if(max < value[i]){
				max = value[i];
				index = i;
			}
		}
		while(index != source[index]){
			res.add(nums[index]);
			index = source[index];
		}
		res.add(nums[index]);
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		MaxIncreasingSubsequence mis = new MaxIncreasingSubsequence();
		int[] nums = {4,6,1,3,8,4,6};
		List<Integer> res = mis.maxIncreasingSubsequence(nums);
		for(int num : res)
			System.out.print(num + " ");
	}
}
