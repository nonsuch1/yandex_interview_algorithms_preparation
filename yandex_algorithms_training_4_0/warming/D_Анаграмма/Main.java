import java.io.IOException;
import java.io.File;
import java.util.Scanner;


class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		Solution solution = new Solution();

		boolean res = solution.isAnagram(s1, s2);
		System.out.println(res ? "YES" : "NO");

	}
}

class Solution {
	public boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length()) return false;

		int[] arr = new int[26];
	
		int i = 0;
		while (i < s1.length()) {
			arr[s1.charAt(i) - 'a']++;
			arr[s2.charAt(i) - 'a']--;
			i++;
		}
		for (int j: arr) {
			if (j != 0) return false;
		}
		return true;
	}	
}
