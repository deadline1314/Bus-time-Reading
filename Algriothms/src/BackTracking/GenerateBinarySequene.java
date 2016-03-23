package BackTracking;

public class GenerateBinarySequene {

	static void generateBinarySequence(int digit) {
		if (digit <= 0)
			return;
		int[] result = new int[digit];
		generateBinarySequence(result, 0);
	}

	static void generateBinarySequence(int[] result, int current) {
		if (current == result.length) {
			for (int i = 0; i < result.length; i++)
				System.out.print(result[i]+" ");
			System.out.println();
			return;
		}

		for (int i = 0; i < 2; i++) { // give value '0' and '1'
			result[current] = i;
			generateBinarySequence(result, current + 1);
		}
	}

	public static void main(String[] args) {
		GenerateBinarySequene gbs = new GenerateBinarySequene();
		gbs.generateBinarySequence(3);

	}

}
