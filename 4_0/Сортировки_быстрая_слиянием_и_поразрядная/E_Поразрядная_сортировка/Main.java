import java.io.File;
import java.util.Scanner;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(scanner.nextLine());
		String[] nums = new String[n];
		int i = 0;
		while (i < n) {
			nums[i] = scanner.nextLine();
			i++;
		}
		Solution solution = new Solution();
		String res = solution.getRes(nums);
		System.out.println(res);
	}
}

class Solution {
	public String getRes(String[] nums) {
		StringBuilder sb = new StringBuilder();
		String[] buffer = new String[nums.length];
		int[] count = new int[10];
		int[] pos = new int[10];
		
		sb.append("Initial array:\n");
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) sb.append(", ");
			sb.append(nums[i]);	
		}
		
		for (int chIndex = nums[0].length() - 1; chIndex >= 0; chIndex--) {

			for (int i = 0; i < count.length; i++) {
				count[i] = 0;
			}

			for (int i = 0; i < nums.length; i++) {
				count[nums[i].charAt(chIndex) - '0']++;
			}

			for (int i = 0; i < pos.length; i++) {
				if (i == 0) {
					pos[i] = 0;
				} else {
					pos[i] = count[i - 1] + pos[i - 1];
				} 
			}
		
			for (int i = 0; i < nums.length; i++) {
				buffer[pos[nums[i].charAt(chIndex) - '0']++] = nums[i];
			} 
			sb.append("\n**********\nPhase " + (nums[0].length() - chIndex));
			int j = 0;
			int k = 0;
			while (j < count.length) {
				sb.append("\nBucket " + j + ": ");
				if (count[j] > 0) {
					int l = 0;
					while (count[j]-- > 0) {
						if (l != 0) sb.append(", ");
						sb.append(buffer[k++]);
						l++;
					}
				} else {
					sb.append("empty");
				}
				j++;	
			}
			for (int i = 0; i < nums.length; i++) {
				nums[i] = buffer[i];
			}
		}
		sb.append("\n**********\nSorted array:\n");
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) sb.append(", ");
			sb.append(nums[i]);
		}
		return sb.toString();
	}
		
}
