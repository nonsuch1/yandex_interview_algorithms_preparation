import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class MainAscii {
	public static void main (String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();
		String t = scanner.nextLine();

		Solution solution = new Solution();
		boolean result = solution.isValidAnagram(s, t);

		Path path = Paths.get("output.txt");
		Files.write(path, (result + "").getBytes());
	}
} 

class Solution {
	public boolean isValidAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] count = new int[26];

		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}	

		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a'] = count[t.charAt(i) - 'a'] - 1;
		}
		
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) return false;
		}
		return true;
	}
}
