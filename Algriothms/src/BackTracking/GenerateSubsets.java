package BackTracking;

public class GenerateSubsets {

	static void generateSubsets(String str) {
		if (str.length() == 0)
			return;
		int[] result = new int[str.length()];
		char[] arr = str.toCharArray();
		generateSubsets(result, 0, arr);
	}

	static void generateSubsets(int[] result, int current, char[] arr) {
		if (current == result.length) {
			printSubsets(result, arr);
			return;
		}

		for (int i = 0; i < 2; i++) {
			result[current] = i;
			generateSubsets(result, current + 1, arr);
		}
	}

	private static void printSubsets(int[] result, char[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 1)
				sb.append(arr[i] + " ");
		}
		sb.append("}");
		System.out.println(sb.toString());

	}

	public static void main(String[] args) {
		GenerateSubsets gs = new GenerateSubsets();
		gs.generateSubsets("ABC");
	}

}
