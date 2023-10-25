import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Solution solution = new Solution();
		int[] result = solution.productExceptSelf(nums);

		Arrays.stream(result).forEach(System.out::println);
	}
}

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		
		int i = 1;
		while (i < nums.length) {
			res[i] = nums[i - 1] * res[i - 1];
			i++;
		}

		i = nums.length - 1;
		int postFix = 1;
		while (i >= 0) {
			res[i] = postFix * res[i];
			postFix *= nums[i];
			i--;
		}
		return res;
	}
}
