package BackTracking;

import java.util.HashSet;
import java.util.Set;

public class SolveSudokuUsingSet {
	public void solveSudoku(int[][] board) {
		solve(board);
	}

	public boolean solve(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != 0) {
					continue;
				}
				for (int k = 1; k <= 9; k++) {
					board[i][j] = k;
					if (isValid(board, i, j) && solve(board)) {
						return true;
					}
					board[i][j] = 0;
				}
				return false;
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		return true;
	}

	public boolean isValid(int[][] board, int a, int b) {
		Set<Integer> contained = new HashSet<Integer>();
		for (int j = 0; j < 9; j++) {
			if (contained.contains(board[a][j]))
				return false;
			if (board[a][j] > 0 && board[a][j] <= 9)
				contained.add(board[a][j]);
		}

		contained = new HashSet<Integer>();
		for (int j = 0; j < 9; j++) {
			if (contained.contains(board[j][b])) {
				return false;
			}
			if (board[j][b] > 0 && board[j][b] <= 9) {
				contained.add(board[j][b]);
			}
		}

		contained = new HashSet<Integer>();
		for (int m = 0; m < 3; m++) {
			for (int n = 0; n < 3; n++) {
				int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
				if (contained.contains(board[x][y])) {
					return false;
				}
				if (board[x][y] > 0 && board[x][y] <= 9) {
					contained.add(board[x][y]);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] arr = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
						{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		SolveSudokuUsingSet ssus = new SolveSudokuUsingSet();
		ssus.solveSudoku(arr);

	}
}
