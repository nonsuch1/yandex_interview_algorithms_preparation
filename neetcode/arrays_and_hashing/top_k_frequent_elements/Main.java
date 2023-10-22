import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int k = scanner.nextInt();

		Solution solution = new Solution();
		int[] result = solution.topKFrequent(nums, k);
		Map<Integer, Integer> map = solution.getFrequencyMap(nums);
		
	}
}

class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = getFrequencyMap(nums);
		return map.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.limit(k)
			.mapToInt(it -> it.getKey())
			.toArray();
	}

	private Map<Integer, Integer> getFrequencyMap(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num: nums) {
			if (map.get(num) == null) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		return map;
	}
}
