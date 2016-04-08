package DynamicProgramming;

public class Bitonic {

	int bitonic(int[] arr) {
		int[] lis = new int[arr.length];
		int[] lds = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[i] > arr[j])
					lds[i] = lds[i] > lds[j] + 1 ? lds[i] : lds[j] + 1;
			}
		}

		int max = 0;
		for (int i = 1; i < arr.length; i++)
			max = max < lis[i] + lds[i] - 1 ? lis[i] + lds[i] - 1 : max;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
