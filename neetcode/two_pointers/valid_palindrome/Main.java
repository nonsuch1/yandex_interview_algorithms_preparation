import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			String s = scanner.nextLine();
			boolean result = new Solution().isPalindrome(s);

			Files.write(Paths.get("output.txt"), (result + "").getBytes());
		} catch (IOException e) {
			System.out.println("Some error has occured");
		}
	}
}

class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
		int i = 0;
		int length = s.length();
		while (i < length - 1 - i)) {
			if (s.charAt(i) != s.charAt(length - 1 - i)) return false;
			i++;
		}
		return true;
	}
}
