package DynamicProgramming;

public class PatternMatching {

	boolean patternMatching(String str, String pattern) {
		boolean[][] matrix = new boolean[str.length() + 1][pattern.length() + 1];
		matrix[0][0] = true;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
					matrix[i][j] = matrix[i - 1][j - 1];
				if (pattern.charAt(j-1) == '*')
					matrix[i][j] = matrix[i - 1][j] || matrix[i][j - 1];
			}
		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	public static void main(String[] args) {
		PatternMatching pm = new PatternMatching();
		String str = "xaylmz";
		String pattern = "x?y*z";
		System.out.println(pm.patternMatching(str, pattern));

	}

}
