package LectureCode;

public class LongestPalindromicSubSequence {

	int longestPalindromicSubSequence(char[] ch) {
		int[][] matrix = new int[ch.length][ch.length];
		for (int i = 0; i < ch.length; i++)
			matrix[i][i] = 1;
		
		for (int l = 2; l <= ch.length; l++) {
			for (int i = 0; i <= ch.length - l; i++) {
				int j = i + l - 1;
				if (l == 2 && ch[i] == ch[j]) {
					matrix[i][j] = 2;
				} else if (ch[i] == ch[j]) {
					matrix[i][j] = matrix[i + 1][j - 1] + 2;
				} else {
					matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j - 1]);
				}
			}
		}
		return matrix[0][ch.length - 1];
	}

	int recursiveFind(char str[], int start, int len) {
		if (len == 1) {
			return 1;
		}
		if (len == 0) {
			return 0;
		}
		if (str[start] == str[start + len - 1]) {
			return 2 + recursiveFind(str, start + 1, len - 2);
		} else {
			return Math.max(recursiveFind(str, start + 1, len - 1), recursiveFind(str, start, len - 1));
		}
	}

	public static void main(String[] args) {
		LongestPalindromicSubSequence lpss = new LongestPalindromicSubSequence();
		String str = "agbdba";
		int r1 = lpss.longestPalindromicSubSequence(str.toCharArray());
//		int r2 = lpss.recursiveFind(str.toCharArray(), 0, str.length());
		System.out.println(r1);
//		System.out.println(r2);

	}

}
