import java.util.Scanner; 
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String[] strs = scanner.nextLine().split(" ");
		Solution solution = new Solution();
		List<List<String>> result = solution.groupAnagrams(strs);
		for (List<String> list: result) {
			list.stream().forEach(System.out::println);
			System.out.println();
		}
/*
		int i = 0; 
		while (i < result.size()) {
			 System.out.println((char) ('a' + i) + ":" + result.get(i));
			 i++;
		}
*/
	 }
}

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<List<Integer>, List<String>> map = new HashMap<>();
		for (String str: strs) {
			List<Integer> count = getCountMap(str);	
			if (map.get(count) == null) {
				List<String> words = new ArrayList<>();
				words.add(str);
				map.put(count, words);
			} else {
				map.get(count).add(str);
			}
		}
		return new ArrayList(map.values());
	}

	private  List<Integer> getCountMap(String s) {
		List<Integer> count = new ArrayList<>();
		int i = 0;
		while (i < 26) {
			count.add(0);
			i++;
		}
		i = 0;
		while (i < s.length()) {
			count.set(s.charAt(i) - 'a', count.get(s.charAt(i) - 'a') + 1);
			i++;
 		} 
		return count;
	}
}
