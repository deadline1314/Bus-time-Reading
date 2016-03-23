package BackTracking;

public class Combinations {
	
	static void combinations(String str){
		if(str.length() == 0)
			return;
		int[] result = new int[str.length()];
		char[] arr = str.toCharArray();
		combinations(result, 0, arr);
	}

	static void combinations(int[] result, int current, char[] arr) {
		if (current == result.length) {
			printCombinations(result, arr);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			result[current] = i;
			combinations(result, current + 1, arr);
		}
	}

	private static void printCombinations(int[] result, char[] arr) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(arr[result[i]] + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		Combinations com = new Combinations();
		com.combinations("ABC");

	}

}
