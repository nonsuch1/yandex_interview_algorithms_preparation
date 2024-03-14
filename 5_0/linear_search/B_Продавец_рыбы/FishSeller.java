import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FishSeller {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int days = scanner.nextInt();
		int sellDelta = scanner.nextInt();
		int[] prices = new int[days];
		for (int i = 0; i < days; i++) {
			prices[i] = scanner.nextInt();
		}
		System.out.println(days + " " + sellDelta);
		for (int i = 0; i < prices.length; i++) {
			System.out.print(prices[i] + " ");
		}
		System.out.println();

		int buyDay = 0;
		int buy = prices[buyDay];
		int sellDay = 1;
		int sell = prices[sellDay];
		int maxProfit = sell - buy > 0 ? sell - buy : 0;
		while (sellDay < prices.length) {
			int delta = 0;
			while ((buyDay + delta < prices.length) && delta <= sellDelta) {
				if (prices[buyDay + delta] >= sell) {
					sell = prices[buyDay + delta];
					sellDay = buyDay + delta;
					maxProfit = Integer.max(maxProfit, sell - buy);
				}
				delta++;
			}
			buyDay++;
			buy = prices[buyDay];
			sellDay = buyDay + 1;
			if (sellDay < prices.length)
				sell = prices[sellDay];
			else break;
		}
		System.out.println(maxProfit);
	}
}
