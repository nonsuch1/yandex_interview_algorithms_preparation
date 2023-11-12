import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();
		int q = Integer.parseInt(scanner.nextLine());
		int[][] requests = new int[q][3];		

		for (int i = 0; i < q; i++) {
			requests[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Solution solution = new Solution();
		String res = solution.equals(s, requests);
		System.out.println(res);
	}
}

class Solution {
	public String equals(String s, int[][] requests) {
		StringBuilder sb = new StringBuilder();
		s = " " + s;
		int xx = 257;
		int p = (int)(Math.pow(10, 9) + 7);
		int[] a = new int[s.length()];
		long[] h = new long[s.length()];
		long[] x = new long[s.length()];
		h[0] = 0;
		x[0] = 1;
		for (int i = 1; i < s.length(); i++) {
			a[i] = s.charAt(i);
			h[i] = (h[i - 1] * xx + a[i]) % p;
			x[i] = (x[i - 1] * xx) % p;
		}
		for (int i = 0; i < requests.length; i++) {	
			int len = requests[i][0];
			int from1 = requests[i][1] + 1;
			int from2 = requests[i][2] + 1;

			sb.append((h[from1 + len - 1] + h[from2 - 1] * x[len]) % p == 
				(h[from2 + len - 1] + h[from1 - 1] * x[len]) % p ? "yes" : "no");
			sb.append("\n");
		}
		return sb.toString();
	}
}
