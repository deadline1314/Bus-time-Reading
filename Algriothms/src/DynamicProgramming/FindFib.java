package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FindFib {
	
	int findFib(int n){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return findFib(n, map);
	}
	
	static int findFib( int n, Map<Integer, Integer> map){
		if(!map.containsKey(n)){
			if(n<=1)
				return n;
			map.put(n, findFib(n-1, map) + findFib(n-2, map));
		}
//		System.out.println(n +" " + map.get(n));
		return map.get(n);
	}

	public static void main(String[] args) {
		FindFib ff = new FindFib();
		System.out.println(ff.findFib(5));

	}

}
