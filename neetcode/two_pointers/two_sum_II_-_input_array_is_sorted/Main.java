import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int target = scanner.nextInt();
		Solution solution = new Solution();
		int[] res = solution.twoSum(numbers, target);
		Arrays.stream(res).forEach(System.out::println);
	}
}

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		
		int left = 0;
		int right = numbers.length - 1;
		
		while (left <= right) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			} else if (numbers[left] + numbers[right] < target) {
				left++;
			} else {
				res[0] = left + 1;
				res[1] = right + 1;
				return res;
			}
		}

		return res;		
	}
}
