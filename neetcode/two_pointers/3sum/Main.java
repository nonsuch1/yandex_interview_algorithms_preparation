import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		
		Solution solution = new Solution();
		List<List<Integer>> res = solution.threeSum(nums);
		for (List<Integer> triplet: res) {
			for (int num: triplet) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		Arrays.sort(nums);
		int a = 0;
		int b = 0;
		int c = 0;
		
		while ((a < nums.length - 2) && (nums[a] <= 0)) {
			b = a + 1;
			c = nums.length - 1;
			
			while (b < c) {
				if (nums[a] + nums[b] + nums[c] > 0) {
					c--;
				} else if (nums[a] + nums[b] + nums[c] < 0) {
					b++;
				} else {
					res.add(new ArrayList<>(List.of(nums[a], nums[b], nums[c])));
					b++;
					while (b < nums.length - 1 && nums[b] == nums[b - 1]) {
						b++;
					}
					c = nums.length - 1;
				}
			}	
			a++;
			while (a < nums.length - 2 && nums[a] == nums[a - 1]) {
				a++;
			}
		}
		
		return res;
	}
}
