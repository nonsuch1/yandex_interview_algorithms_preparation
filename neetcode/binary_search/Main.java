import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Integer target = scanner.nextInt();

		Solution solution = new Solution();

		int res = solution.search(nums, target);
		Files.write(Paths.get("output.txt"), (res + "").getBytes());
	}
}

class Solution {
	public int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (nums[(end + start) / 2] < target) {
				start = (end + start) / 2 + 1;
			} else if (nums[(end + start) / 2] > target) {
				end = (end + start) / 2 - 1;
			} else {
				return (end + start) / 2;
			}
		}
		return -1;
	}
}
/*
-1 0 3 5 9 12
9

len = 6, len / 2 = 3
ar[len / 2] > 2 a[3] = 5 > 2 => 

start = 0
end = 5
nums[2] = 3 < 9
start = 3
end = 5
nums[]

ar[(end - start) / 2] > x => start = ((end - start) / 2) + 1
*/
