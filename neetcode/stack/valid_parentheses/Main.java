import java.util.Stack;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();	
		Solution solution = new Solution();
		boolean result = solution.isValid(s);
		
		Files.write(Paths.get("output.txt"), (result + "").getBytes());
	}
}

class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> parentheses = new HashMap<>();
		parentheses.put('(', ')');
		parentheses.put('{', '}');
		parentheses.put('[', ']');
		int i = 0;
		while (i < s.length()) {
			if (parentheses.get(s.charAt(i)) != null) {
				stack.push(parentheses.get(s.charAt(i)));
			} else if (stack.size() == 0 || stack.pop() != s.charAt(i)) {
				return false;
			}
			i++;
		}
		
		return stack.size() == 0;
	}
}

/*

input: {()}

stack: })

*/
