class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] height = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		
		Solution solution = new Solution();
		int res = solution.maxArea(height);
		System.out.println(res);
	}
}

class Solution {
	public int maxArea(int[] height) {
		
	}
}
