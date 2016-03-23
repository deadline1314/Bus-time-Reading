package Logic;

public class BuyAndSellStocks {
	void getMaxProfit(int[] stockPrices) {
		if (stockPrices.length <= 1)
			return;
		int buy = 0;
		int sell = 0;
		for (int i = 0; i < stockPrices.length - 1; i++) {
			if (stockPrices[i + 1] < stockPrices[i]) {
				if (buy != sell) {
					System.out.println(stockPrices[buy] + "," + stockPrices[sell]);
					buy = sell = i;
				}
				buy++;
				sell = buy;
				continue;
			}
			if (stockPrices[i + 1] > stockPrices[i]) {
				sell++;
				continue;
			}
		}
		if (buy != sell)
			System.out.println(stockPrices[buy] + "," + stockPrices[sell]);

	}

	public static void main(String[] args) {
		BuyAndSellStocks bass = new BuyAndSellStocks();
		int[] nums = { 39, 20, 45, 51, 36, 23, 54, 69 };
		bass.getMaxProfit(nums);
	}

}
