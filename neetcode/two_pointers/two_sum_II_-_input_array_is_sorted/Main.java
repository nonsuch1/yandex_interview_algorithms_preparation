class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		int target = scanner.nextInt();

		Solution solution = new Solution();
		int[] result = solution.twoSum(nums, target);
		for (int i: result) {
			System.out.print(i + " ");
		}
	}
}

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num: numbers) {
			set.add(num);
		}
		int i = 0;
		while (i < numbers.length) {
			
			i++;
		}
		return null;
	}
}
