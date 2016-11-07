package DynamicProgramming;

public class LongestPalindromicSubsequence {
	
	public int longestPalindromicSubsequence(char[] str) {
		int[][] matrix = new int[str.length][str.length];
		for(int i = 0; i < str.length; i++)
			matrix[i][i] = 1;
		for(int l = 1; l < str.length; l++) {
			for(int i = 0; i < str.length - l; i++) {
				int j = i + l;
				if(l == 1 && str[i] == str[j])
					matrix[i][j] = 2;
				else
					matrix[i][j] = 1;
				if(str[i] == str[j])
					matrix[i][j] = matrix[i+1][j-1] + 2;
				else
					matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j-1]);
			}
		}
		return matrix[0][str.length - 1];
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		char[] str = {'a','g','k','d','k','a'};
		System.out.println(lps.longestPalindromicSubsequence(str));

	}

}
