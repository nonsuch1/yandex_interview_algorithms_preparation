import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int n = Integer.parseInt(scanner.nextLine());
		int[] a = new int[n];
		if (n > 0) {
			a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} else {
			scanner.nextLine();
		}
		int m = Integer.parseInt(scanner.nextLine());
		int[] b = new int[m];
		if (m > 0) {
			b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Solution solution = new Solution();
		int[] res = solution.merge(a, b);
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < res.length) {
			if (i != 0) sb.append(" ");
			sb.append(res[i++]);
		}
		System.out.println(sb);
	}
}

class Solution {
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
