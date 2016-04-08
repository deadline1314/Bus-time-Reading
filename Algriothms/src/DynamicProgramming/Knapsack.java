package DynamicProgramming;

public class Knapsack {

	int knapsack(int totalWeight, int[] weight, int[] val) {
		int[][] matrix = new int[weight.length + 1][totalWeight + 1];

		for (int i = 0; i < weight.length + 1; i++) {
			for (int j = 0; j < totalWeight + 1; j++) {
				if (i == 0 || j == 0)
					matrix[i][j] = 0;
				else if (weight[i - 1] <= j) {
					matrix[i][j] = Math.max(val[i - 1] + matrix[i - 1][j - weight[i - 1]], matrix[i - 1][j]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[weight.length][totalWeight];
	}

	public static void main(String[] args) {
		Knapsack kn = new Knapsack();
		int[] weight = { 1, 3, 4, 5 };
		int[] val = { 1, 4, 5, 7 };
		System.out.println(kn.knapsack(7, weight, val));

	}

}
