import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

class Main {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			String s = scanner.nextLine();
			String t = scanner.nextLine();
			
			Solution solution = new Solution();
			boolean result = solution.isAnagram(s, t);

			Path path = Paths.get("output.txt");
			Files.write(path, (result + "").getBytes());
		} catch (IOException e) {
			System.out.println("An error occured");
		}		
	}
}

class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false; 
		Map<Character, Integer> sMap = getCharOccurenceMap(s);
		Map<Character, Integer> tMap = getCharOccurenceMap(t);

		return sMap.equals(tMap); 
	}

	private Map<Character, Integer> getCharOccurenceMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			Character crnt = s.charAt(i);
			if (map.containsKey(crnt)) {
				map.put(crnt, map.get(crnt) + 1);
			} else {
				map.put(crnt, 1);
			}	
		}
		return map;
	}
}
