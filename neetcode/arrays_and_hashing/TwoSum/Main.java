import java.util.stream.Stream;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			Integer[] nums = Stream.of(scanner.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
			int target = scanner.nextInt();
			Solution solution = new Solution();
			int[] result = solution.twoSum(nums, target);

			Path path = Paths.get("output.txt");
// int array to byte array?			Files.write(path, )
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {
		
	}
}
