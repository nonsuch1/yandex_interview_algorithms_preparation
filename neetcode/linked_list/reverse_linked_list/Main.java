import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		ListNode[] nodes = new ListNode[values.length];

		int i = 0;
		while (i < values.length) {
			nodes[i] = new ListNode(values[i]);	
			i++;
		}
		i = 0;
		while (i < nodes.length - 1) {
			nodes[i].next = nodes[i + 1];
			i++;
		}
		Solution solution = new Solution();

		ListNode result = solution.reverseList(nodes[1]);
		Files.write(Paths.get("output.txt"), (result + "").getBytes());
	}
}

class ListNode {
	int val;
	ListNode  next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			ListNode next = head.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;		
	}
}
