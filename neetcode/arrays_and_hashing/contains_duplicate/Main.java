import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Solution {
	public static boolean containsDuplicate(int[] nums) {
		Set set = new HashSet<Integer>();
		for (int num: nums) {
			if (set.add(num) == false)
				return true;
		}
		return false;
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int length = scanner.nextInt();
		int[] nums = new int[length];
		int i = 0;
		while (i < length) {
			nums[i++] = scanner.nextInt();
		}
		System.out.println(Solution.containsDuplicate(nums));
	}
}
