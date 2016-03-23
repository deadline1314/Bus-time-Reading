package BackTracking;

public class GenerateMarySequence {

	static void generateMarySequence(int m, int digit) {
		if (digit <= 0)
			return;
		int[] result = new int[digit];
		generateMarySequence(result, 0, m);

	}

	static void generateMarySequence(int[] result, int current, int m) {
		if (current == result.length) {
			for (int i = 0; i < result.length; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < m; i++) {
			result[current] = i;
			generateMarySequence(result, current + 1, m);
		}
	}

	public static void main(String[] args) {
		GenerateMarySequence gms = new GenerateMarySequence();
		gms.generateMarySequence(4, 3);

	}

}
