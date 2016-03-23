package BackTracking;

public class Permutation {

	static void permutation(String str) {
		if (str.length() <= 0)
			return;
		int[] result = new int[str.length()];
		char[] arr = str.toCharArray();
		permutation(result, 0, arr);
	}

	static void permutation(int[] result, int current, char[] arr) {
		if (current == result.length) {
			printPermutation(result, arr);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (isValid(result, current, i)) {
				result[current] = i;
				permutation(result, current + 1, arr);
			}
		}
	}

	private static void printPermutation(int[] result, char[] arr) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(arr[result[i]] + " ");
		}
		System.out.println();

	}

	private static boolean isValid(int[] result, int current, int num) {
		for (int i = 0; i < current; i++) {
			if (result[i] == num)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Permutation per = new Permutation();
		per.permutation("ABC");

	}

}
