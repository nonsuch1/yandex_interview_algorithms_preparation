import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(scanner.nextLine());
		int[] nums = new int[n];
		if (n > 0) {
			nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Solution solution = new Solution();
			int[] res = solution.sort(nums, 0, nums.length - 1);
		
			StringBuilder sb = new StringBuilder();
			int i = 0;
			while (i < res.length) {
				if (i != 0) sb.append(" ");
				sb.append(res[i++]);
			}
			System.out.println(sb);
		} else {
			System.out.println();
		}
	}
}

class Solution {
	public int[] sort(int[] nums, int l, int r) {
		if (l == r) return new int[]{ nums[l] };
		int half = (r + l) / 2;
		
		int[] left = sort(nums, l, half);
		int[] right = sort(nums, half + 1, r);
		return merge(left, right);
	}

	public int[] merge(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				res[k] = a[i];
				i++;
			} else {
				res[k] = b[j];
				j++;
			}
			k++;
		}
		while (i < a.length) {
			res[k++] = a[i];
			i++;
		}
		while (j < b.length) {
			res[k++] = b[j];
			j++;
		}
		
		return res;
	}
}
