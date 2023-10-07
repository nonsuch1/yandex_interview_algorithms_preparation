class Main {
	public static void main(String[] args) {
		ListNode head = new ListNode();
		Solution solution = new Solution();
		boolean result = solution.hasCycle(head);
	}
}

class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
                if (head == null || head.next == null) return false;
                ListNode fast = head.next;
                while (fast != null && fast.next != null) {
                        if (fast != slow) {
                                fast = fast.next.next;
                                slow = slow.next;
                        } else {
                                return true;
                        }
                }
                return false;
	}	
}
