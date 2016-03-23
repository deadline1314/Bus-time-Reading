package BackTracking;

public class GenerateSubsetsSumEqualK {
	static void generateSubsetsSumEqualK(int[] arr, int k) {
		if (arr.length == 0)
			return;
		int[] result = new int[arr.length];
		generateSubsetsSumEqualK(result, 0, arr, k);
	}

	private static void generateSubsetsSumEqualK(int[] result, int current, int[] arr, int k) {
		if (current == result.length) {
			printSubsetsSumEqualK(result, arr, k);
			return;
		}

		for (int i = 0; i < 2; i++) {
			result[current] = i;
			generateSubsetsSumEqualK(result, current + 1, arr, k);
		}
	}

	private static void printSubsetsSumEqualK(int[] result, int[] arr, int k) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 1) {
				sb.append(arr[i] + " ");
				sum += arr[i];
			}
		}
		sb.append("}");

		if (sum == k)
			System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		GenerateSubsetsSumEqualK gssek = new GenerateSubsetsSumEqualK();
		int[] arr = { 0, 1, 2, 3, 4, 6, 5 };
		int k = 5;
		gssek.generateSubsetsSumEqualK(arr, k);

	}

}
