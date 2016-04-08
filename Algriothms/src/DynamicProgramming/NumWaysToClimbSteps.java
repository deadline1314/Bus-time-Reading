package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class NumWaysToClimbSteps {

	int numWaysToClimbSteps(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return numWaysToClimbSteps(n, map);
	}

	static int numWaysToClimbSteps(int n, Map<Integer, Integer> map){
		if(n<0)
			return 0;
		else if (n<1)
			return 1;
		else if(map.containsKey(n))
			return map.get(n);
		else{
			int k = numWaysToClimbSteps(n-1, map) + numWaysToClimbSteps(n-2, map)
			+ numWaysToClimbSteps(n-3, map);
			map.put(n, k);
			return k;
		}
		
	}

	public static void main(String[] args) {

		NumWaysToClimbSteps nwtcs = new NumWaysToClimbSteps();
		System.out.println(nwtcs.numWaysToClimbSteps(4));
	}

}
