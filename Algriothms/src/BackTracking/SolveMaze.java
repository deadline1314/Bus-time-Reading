package BackTracking;

public class SolveMaze {

	static boolean solveMaze(int[][] arr) {
		if (arr == null || arr.length == 0 || arr[0].length == 0)
			return false;
		char[] result = new char[arr.length + arr[0].length];
		return solveMaze(arr, 0, 0, result, 0, -1, -1);
	}

	static boolean solveMaze(int[][] arr, int i, int j, char[] result, int current, int iPrev, int jPrev) {
		if (i > arr.length - 1 || j > arr[0].length - 1)
			return false;

		if (i == arr.length - 1 && j == arr[0].length - 1 && arr[i][j] == 1) {
			if (j > jPrev && jPrev != -1)
				result[current] = 'D';
			if (i > iPrev && iPrev != -1)
				result[current] = 'R';
			String s = new String(result);
			System.out.println(s);
			return true;
		}
		if (arr[i][j] != 1)
			return false;
		if (j > jPrev && jPrev != -1)
			result[current] = 'D';
		if (i > iPrev && iPrev != -1)
			result[current] = 'R';

		if (solveMaze(arr, i, j + 1, result, current + 1, i, j) == true)
			return true;
		if (solveMaze(arr, i + 1, j, result, current + 1, i, j) == true)
			return true;

		return false;
	}

	public static void main(String[] args) {
		SolveMaze sm = new SolveMaze();
		int[][] arr = { { 1, 1, 0, 1 },  //纵向赋值，可以保证符合直角坐标系
						{ 0, 1, 1, 1 },  //i=arr.length       j=arr[0].length
						{ 0, 0, 0, 1 }, 
						{ 0, 1, 0, 1 } };
		
//		int[][] arr = { { 1, 0, 0, 0 },  //按原来顺序赋值，其矩阵中坐标与直角坐标系(x,y)颠倒
//						{ 1, 1, 0, 1 },  //i=arr[0].length     j=arr.length
//						{ 0, 1, 0, 0 },
//						{ 1, 1, 1, 1 } };
		sm.solveMaze(arr);

	}

}
