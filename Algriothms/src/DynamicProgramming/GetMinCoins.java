package DynamicProgramming;

public class GetMinCoins {

	int getMinCoins(int[] coins, int total) {
		int[][] matrix = new int[coins.length][total + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (coins[i] > j) {
					if (i > 0)
						matrix[i][j] = matrix[i - 1][j];
					else
						matrix[i][j] = 0;
				} else {
					matrix[i][j] = matrix[i][j - coins[i]] + 1;
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			result = result > matrix[i][total] ? matrix[i][total] : result;
		}
		return result;
	}

	public static void main(String[] args) {
		GetMinCoins gmc = new GetMinCoins();
		int[] coins = { 1, 5, 6, 8 };
		System.out.println(gmc.getMinCoins(coins, 11));

	}

}
