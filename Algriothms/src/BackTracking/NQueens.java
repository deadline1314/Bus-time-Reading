package BackTracking;

public class NQueens {
	
	void nQueens(int n){
		if(n <= 0)
			return;
		int[] result = new int[n];
		nQueens(n, result, 0);
	}
	
	static void nQueens(int n, int[] result, int curr){
		if(curr == n){
			printNQueens(result);
		}
		
		for(int i = 0; i < n; i++){
			if(isValidPosition(result, curr, i)){
				result[curr] = i;
				nQueens(n, result, curr+1);
			}
		}
	}
	
	static boolean isValidPosition(int[] result, int curr, int num){
		for(int i = 0; i < curr; i++){
			if(result[i] == num || Math.abs(curr - i) == Math.abs(result[i] - num))
				return false;
		}
		return true;
	}
	
	static void printNQueens(int[] result){
		for(int i = 0; i < result.length; i++)
			System.out.print(i+","+result[i]+" ");
		System.out.println();
		System.out.println("Next Value.");
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		nq.nQueens(4);

	}

}
