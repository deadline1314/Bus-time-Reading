package FinalQuestion;

public class OneTrascationMaxProfit {

	void oneTrascationMaxProfit(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					max = max > arr[i] - arr[j] ? max : arr[i] - arr[j];
			}
		}
		if (max == Integer.MIN_VALUE) {
			System.out.println("There is no profit.");
		} else {
			System.out.println("Max profit is: " + max);
		}
	}

	public static void main(String[] args) {
		OneTrascationMaxProfit otmp = new OneTrascationMaxProfit();
		int[] arr = { 5, 2, 1, 8, 12, 0, 5 };
		int[] arr2 = { 10, 9, 8, 7, 6, 5 };
		otmp.oneTrascationMaxProfit(arr);
		otmp.oneTrascationMaxProfit(arr2);

	}

}
