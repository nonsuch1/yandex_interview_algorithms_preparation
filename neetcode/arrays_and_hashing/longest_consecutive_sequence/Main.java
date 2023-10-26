import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Solution solution = new Solution();
		int res = solution.longestConsecutive(nums);
		System.out.println(res);
	}
}

class Solution {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int longest = 0;

		for (int num: nums) {
			set.add(num);
		}
		
		int i = 0;
		while (i < nums.length) {
			if (!set.contains(nums[i] - 1)) {	
				int current = 0;
				int curNum = nums[i];
				while (set.contains(curNum)) {
					current++;
					curNum++;
				}
				longest = Integer.max(current, longest);
			}
			i++;
		}
		return longest;
	}
}
