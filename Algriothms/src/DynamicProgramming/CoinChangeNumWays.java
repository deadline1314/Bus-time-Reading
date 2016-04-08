package DynamicProgramming;

public class CoinChangeNumWays {
	
	int coinChangeNumWays(int[] coins, int total){
		int[][] matrix = new int[coins.length][total+1];
		for(int i=0; i< matrix.length; i++){
			for(int j=0; j<matrix[0].length;j++){
				if(coins[i]>j){
					if(j>0)
						matrix[i][j] = matrix[i-1][j];
					else
						matrix[i][j] = 1;
				}
				else{
					if(i>0)
						matrix[i][j] = matrix[i-1][j]+matrix[i][j-coins[i]];
					else
						matrix[i][j] = 1;
				}
			}
		}
		return matrix[coins.length-1][total];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
