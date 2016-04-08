package DynamicProgramming;

public class CutRods {

	int cutRods(int[] price, int total) {
		int[][] matrix = new int[price.length + 1][total + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == 0 || i == 0) {
					matrix[i][j] = 0;
				} else if (i <= j) {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - i] + price[i - 1]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[price.length][total];
	}

	public static void main(String[] args) {
		CutRods cr = new CutRods();
		int[] price = { 2, 5, 7, 8 };
		System.out.println(cr.cutRods(price, 5));

	}

}
