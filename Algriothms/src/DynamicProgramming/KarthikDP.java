package DynamicProgramming;

//1> data structure
//2> base case
//3> recursion
public class KarthikDP {

	public int countStepsBad(int n) {
		if (n == 0 || n == 1 || n == 2)
			return n;

		int n1 = countStepsBad(n - 1);
		int n2 = countStepsBad(n - 2);
		int n3 = countStepsBad(n - 3);

		return n1 + n2 + n3;
	}

	public int fibonacci(int n) {
		// 1+2^1+2^2+...2^n = 2^(n+1) O(2^n)
		if (n == 1 || n == 2)
			return 1;

		int n1 = fibonacci(n - 1);
		int n2 = fibonacci(n - 2);

		return n1 + n2;

	}

	public int fibDP(int n) {
		// O(n) time O(n) space
		int[] fib = new int[n];
		fib[0] = 1;
		fib[1] = 1;

		for (int i = 2; i < n; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		return fib[n - 1];
	}

	public int bestProfit(int[] prices) {
		if (prices.length == 0 || prices.length == 1)
			return 0;

		int buy = prices[0];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < prices.length; i++) {
			if (buy > prices[i])
				buy = prices[i];
			else
				maxProfit = prices[i] - buy > maxProfit ? prices[i] - buy : maxProfit;
		}
		return maxProfit;
	}

	public int pascalTriangle(int n, int k) {
		int[][] matrix = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			matrix[i][0] = 1;
			matrix[i][i] = 1;
		}
		for (int j = 1; j <= k; j++) {
			for (int i = 2; i < n + 1; i++)
				matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
		}
		return matrix[n][k];
	}

	public boolean isSentence(String sentence) {
		int size = sentence.length();
		boolean[] valid = new boolean[size + 1];

		valid[0] = true;
		for (int i = 0; i < size; i++) {
			for (int j = i; j >= 0; j--) {
				if (valid[j]) {
					String subString = sentence.substring(j, i + 1);
					if (isWord(subString)) {
						valid[i + 1] = true;
						break;
					}
				}
			}
		}
		return valid[size];
	}

	private boolean isWord(String b) {
		return false;

	}

	// input: yabaxabayabaxabask
	public int longestPalindrome(String str) {
		// O(n^3)
		int size = str.length();
		boolean[][] isPalindrome = new boolean[size][size];
		int maxLen = 1;

		for (int i = 0; i < size; i++)
			isPalindrome[i][i] = true;

		for (int i = 0; i < size - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				isPalindrome[i][i + 1] = true;
				maxLen = 2;
			}
		}
		
		for (int diff = 2; diff < size; diff++) {
			for (int i = 0; i < size - diff; i++) {
				if (str.charAt(i) == str.charAt(i + diff)) {
					isPalindrome[i][i + diff] = isPalindrome[i + 1][i + diff - 1];
					if (isPalindrome[i][i + diff])
						maxLen = diff + 1;
				}
				isPalindrome[i][i + diff] = false;
			}
		}
		return maxLen;
	}

}
