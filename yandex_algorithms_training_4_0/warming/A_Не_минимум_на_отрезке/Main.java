import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;


class Main { 
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = nm[0];
		int m = nm[1];
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] requests = new int[m][2];
		for (int i = 0; i < m; i++) {
			requests[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}		

		Solution solution = new Solution();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < m; i++) {
			if (i != 0) result.append("\n");
			result.append(solution.getNotMinInRange(nums, requests[i]));
		}
		System.out.println(result);
	}
}

class Solution {
	public String getNotMinInRange(int[] nums, int[] range) {
		int i = range[0] + 1;
		int notMin = nums[range[0]];
		int min = nums[range[0]];

		while (i <= range[1]) {
			if (nums[i] < min) {
				min = nums[i];
				break;
			} else if (nums[i] != min) {
				notMin = nums[i];
			}
			i++;
		}

		return min == notMin ? "NOT FOUND" : notMin + "";
	}
}
