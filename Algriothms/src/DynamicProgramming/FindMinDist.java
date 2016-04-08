package DynamicProgramming;

public class FindMinDist {
	
	int findMinDist(int[][] arr){
		int row = arr[0].length;
		int col = arr.length;
		int[][] matrix = new int[row][col];
		
		matrix[0][0] = arr[0][0];
		for(int i=1; i<row; i++)
			matrix[i][0] = matrix[i-1][0] + arr[i][0];
		for(int j=1; j<col; j++)
			matrix[0][j] = matrix[0][j-1] + arr[0][j];
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++)
				matrix[i][j] = matrix[i-1][j]<matrix[i][j-1]+arr[i][j]?
						matrix[i-1][j]:matrix[i][j-1]+arr[i][j];
		}
		return matrix[row-1][col-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
