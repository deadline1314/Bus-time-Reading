package DynamicProgramming;

public class SubsetProblem {
	
	boolean subsetProblem(int[] input, int total){
		boolean[][] matrix = new boolean[input.length + 1][total + 1];
		for(int i = 0; i <= input.length; i++)
			matrix[i][0] = true;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i>0){
					//total > val, compare the both
					if(j - input[i-1] >= 0){
						matrix[i][j] = matrix[i-1][j] || matrix[i-1][j-input[i-1]];
					}else{
						//total < val, directly copy from the previous
						matrix[i][j] = matrix[i-1][j];
					}
				}else{
					matrix[i][j] = (j == input[i]);
				}
			}
		}
		return matrix[input.length][total];
	}

	public static void main(String[] args) {
		SubsetProblem sp = new SubsetProblem();
		int[] input = { 2,3,7,8,10};
		System.out.println(sp.subsetProblem(input, 11));

	}

}
