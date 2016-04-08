package DynamicProgramming;

public class LongestCommonSubstring {
	
	int longestCommonSubstring(char[] arr1, char[] arr2){
		int[][] matrix = new int[arr1.length+1][arr2.length+1];
		int max = 0;
		
		for (int i = 1; i < matrix[0].length; i++) {
			for (int j = 1; j < matrix.length; j++) {
				if(arr1[i-1] == arr2[j-1]){
					matrix[i][j] = matrix[i-1][j-1] + 1;
					max= max<matrix[i][j]? matrix[i][j]:max;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		char[] arr1 = {'a','b','c','d','e','f'};
		char[] arr2 = {'z','c','d','e','g','e'};
		System.out.println(lcs.longestCommonSubstring(arr1, arr2));
		

	}

}
