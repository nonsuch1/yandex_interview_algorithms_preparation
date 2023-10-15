import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));	
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Solution solution = new Solution();
		int result = solution.singleNumber(nums);
		Files.write(Paths.get("output.txt"), (result + "").getBytes());
	}
}

class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num: nums) {
			res ^= num;
		}
		return res;
	}
}
