class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
	}
}

class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];
		dp[0] = cost[0];
		dp[1] = cost[1];
		int i = 2;
		while (i < cost.length) {
			dp[i] = Integer.min(dp[i - 1], dp[i - 2]) + cost[i];
			i++;
		}
		return Integer.min(dp[i], dp[i - 1]);
	}
}
