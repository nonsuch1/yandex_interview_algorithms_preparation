import java.util.Arrays;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));

		ListNode[] list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(ListNode[]::new);
		
		int i = 0;
		while (i < list1.length - 1) {
			list1[i].next = list1[i + 1];
			i++;
		}
		ListNode[] list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(ListNode[]::new);
		i = 0;
		while (i < list2.length - 1) {
			list2[i].next = list2[i + 1];
			i++;
		}
		Solution solution = new Solution();
		ListNode result = solution.mergeTwoLists(list1[0], list2[0]);

//		Files.write(Paths.get("output.txt"), (result + "").getBytes());
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode();
		ListNode tail = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}
		if (list1 != null) {
			tail.next = list1;
		}
		if (list2 != null) {
			tail.next = list2;
		}
		return dummy.next;
	}
}
