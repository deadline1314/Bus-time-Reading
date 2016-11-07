package DynamicProgramming;

public class GetMinCoins {

	int getMinCoins(int[] coins, int total) {
		int[][] matrix = new int[coins.length][total + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (coins[i] > j) {
<<<<<<< HEAD
					if (i > 0)
						matrix[i][j] = matrix[i - 1][j];
=======
					matrix[i][j] = matrix[i - 1][j];
>>>>>>> origin/master
				} else {
					matrix[i][j] = Math.min(matrix[i-1][j] , matrix[i][j - coins[i]] + 1);
				}
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
	}

	public static void main(String[] args) {
		GetMinCoins gmc = new GetMinCoins();
		int[] coins = {5, 1, 6, 8 };
		System.out.println(gmc.getMinCoins(coins, 11));

	}

}
