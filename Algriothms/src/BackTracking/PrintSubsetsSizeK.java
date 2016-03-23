package BackTracking;

public class PrintSubsetsSizeK {

	static void printSubsetsSizeK(String str, int k) {
		if (str.length() <= 0 || k <= 0)
			return;
		char[] arr = str.toCharArray();
		char[] result = new char[k];
		printSubsetsSizeK(arr, k, result, 0, 0);
	}

	private static void printSubsetsSizeK(char[] arr, int k, char[] result, int current, int indexInArray) {
		if (current == k) {
			String s = new String(result);
			System.out.println(s);
			return;
		}

		if (indexInArray >= arr.length)
			return;
		result[current] = arr[indexInArray];
		printSubsetsSizeK(arr, k, result, current + 1, indexInArray + 1);
		printSubsetsSizeK(arr, k, result, current, indexInArray + 1);

	}

	public static void main(String[] args) {
		PrintSubsetsSizeK pssk = new PrintSubsetsSizeK();
		pssk.printSubsetsSizeK("ABCDE", 3);
	}

}
