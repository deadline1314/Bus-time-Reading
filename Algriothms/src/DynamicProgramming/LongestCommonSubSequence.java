package DynamicProgramming;

public class LongestCommonSubSequence {
	
	int longestCommonSubSequence(char[] arr1, char[] arr2){
		
		int[][] matrix = new int[arr1.length+1][arr2.length+1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(i==0 || j==0){
					matrix[i][j] = 0;
				}
				else if(arr1[i-1] == arr2[j-1]){
					matrix[i][j] = matrix[i-1][j-1]+1;
				}
				else{
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
			
		}
		return matrix[arr1.length][arr2.length];
	}

	public static void main(String[] args) {
		LongestCommonSubSequence lcss = new LongestCommonSubSequence();
		char[] arr1 = {'a','b','c','d','a','f'};
		char[] arr2 = {'a','c','b','c','f'};
		System.out.println(lcss.longestCommonSubSequence(arr1, arr2));

	}

}
