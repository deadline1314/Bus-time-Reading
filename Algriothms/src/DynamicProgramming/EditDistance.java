package DynamicProgramming;

public class EditDistance {
	
	int editDistance(String str1, String str2){
		int[][] matrix = new int[str1.length()+1][str2.length()+1];
		for(int i = 0; i < matrix.length; i++){
			matrix[i][0] = i;
		}
		for(int i = 0; i < matrix[0].length; i++){
			matrix[0][i] = i;
		}
		
		for(int i = 1; i <= str1.length(); i++){
			for(int j = 1; j <= str2.length(); j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					matrix[i][j] = matrix[i-1][j-1];
				}else{
					matrix[i][j] = 1 + Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j], matrix[i][j-1]));
				}
			}
		}
		return matrix[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		String str1 = "azced";
		String str2 = "abcdef";
		System.out.println(ed.editDistance(str1, str2));

	}

}
