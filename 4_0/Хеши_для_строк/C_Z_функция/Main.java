import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();
	
		Solution solution = new Solution();
		int[] z = solution.getZFunction(s);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < z.length; i++) {
			if (i != 0) sb.append(" ");
			sb.append(z[i]);
		}
		System.out.println(sb);
	}
}

class Solution {

	public int[] getZFunction(String s) {
		int[] z = new int[s.length()];
		z[0] = 0;
		int l = 0;
		int r = 0;
		
		for (int i = 1; i < s.length(); i++) {
			if (i < r) {
				z[i] = Integer.min(r - i, z[i - l]);
			}
			while ((i + z[i] < s.length()) && s.charAt(i + z[i]) == s.charAt(z[i])) {
				z[i]++;
			}
			if (z[i] > 0) {
				l = i;
				r = i + z[i];
			}	
		}
		return z;
	}
}
