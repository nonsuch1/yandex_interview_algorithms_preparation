import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Solution solution = new Solution();
		int res = solution.maxProfit(prices);
		Files.write(Paths.get("output.txt"), (res + "").getBytes());
	}
}

class Solution {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buy = 0;
		int sell = 1;
		
		while (sell < prices.length) {
			if (prices[buy] < prices[sell]) {
				maxProfit = Integer.max(maxProfit, prices[sell] - prices[buy]);
			} else {
				buy = sell;
			}
			sell++;
		}
		return maxProfit;
	}
}
