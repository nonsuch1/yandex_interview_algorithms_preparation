import java.util.PriorityQueue;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] stones = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Solution solution = new Solution();
		int result = solution.lastStoneWeight(stones);
		Files.write(Paths.get("output.txt"), (result + "").getBytes());
	}
}

class Solution {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for (int stone: stones) {
			heap.add(stone);
		}
		while (heap.size() > 1) {
			heap.add(heap.poll() - heap.poll());
		}
		return heap.size() == 1 ? heap.poll() : 0;
	}
}
