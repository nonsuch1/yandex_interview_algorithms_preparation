import java.io.IOException;
import java.util.function.Predicate;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(sc.nextLine());

		if (n != 0) {
			int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int x = Integer.parseInt(sc.nextLine());
		
			Solution solution = new Solution();
			int res = solution.partition(i -> i < x, nums, 0, nums.length - 1);
			System.out.println("res = " + res);
			sb.append(res + 1).append("\n").append(nums.length - 1 - res);
		} else {
			sb.append("0\n0");
		}
		System.out.println(sb);
	}
}

class Solution {
	public int partition(Predicate<Integer> condition, int[] nums, int left, int right) {
		while (left <= right) {
			while (left <= right && condition.test(nums[left])) {
				left++;
			}
			if (left <= right && !condition.test(nums[left])) {
				while (left <= right && !condition.test(nums[right])) {
					right--;
				}
				if (left <= right && condition.test(nums[right])) {
					int tmp = nums[right];
					nums[right] = nums[left];
					nums[left] = tmp;
					left++;
					right--;
				}
			}
		}
		return left - 1;
	}
}
