package BackTracking;

public class SolveSudoku {

	static boolean solveSudoku(int[][] arr) {
		int row = 0;
		int col = 0;
		if (!findLocation(arr, row, col)) {
			for (int i = 0; i <= 9; i++) {
				for (int j = 0; j <= 9; j++)
					System.out.print(arr[i][j]);
				System.out.println();
			}
			return true;
		}

		for (int i = 1; i <= 9; i++) {
			if (isValid(arr, row, col, i)) {
				arr[row][col] = i;
				if (solveSudoku(arr))
					return true;
				else
					arr[row][col] = 0;
			}
		}
		return false;
	}

	private static boolean isValid(int[][] arr, int row, int col, int num) {

		for (int i = 0; i < 9; i++) { // check row
			if (arr[i][col] == num)
				return false;
		}

		for (int j = 0; j < 9; j++) { // check col
			if (arr[row][j] == num)
				return false;
		}

		for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) // check block
			for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++)
				if (arr[i][j] == num)
					return false;

		return true;
	}

	private static boolean findLocation(int[][] arr, int row, int col) {
		for (row = 0; row < arr[0].length; row++){
			for (col = 0; col < arr.length; col++){
				if (arr[row][col] == 0)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = { {5,3,0,0,7,0,0,0,0},
						{6,0,0,1,9,5,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0} };
		SolveSudoku ss = new SolveSudoku();
		ss.solveSudoku(arr);
	}

}
