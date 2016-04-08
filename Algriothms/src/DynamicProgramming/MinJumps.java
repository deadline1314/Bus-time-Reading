package DynamicProgramming;

public class MinJumps {
	
	int minJumps(int[] arr){
		
		int[] jumps = new int[arr.length];
//		int[] result = new int[arr.length];
		jumps[0] = 0;
		
		for(int i = 1; i < arr.length; i++){
			jumps[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <arr.length; i++){
			for(int j = 0; j < i; j++){
				//check if we can actually jump
				if(arr[j] + j >= i){
					if(jumps[i] > jumps[j] + 1){
						jumps[i] = jumps[j] + 1;
//						result[i] = j;
					}
				}
			}
		}
		return jumps[jumps.length - 1];
	}

	public static void main(String[] args) {
		MinJumps mj = new MinJumps();
		int[] arr = {2,3,1,1,2,4,2,0,1,1};
		System.out.println(mj.minJumps(arr));

	}
}
