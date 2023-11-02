import java.io.IOException;
import java.util.function.Predicate;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class Main {
        public static void main(String[] args) throws IOException {
                StringBuilder sb = new StringBuilder();
                Scanner sc = new Scanner(new File("input.txt"));
                int n = Integer.parseInt(sc.nextLine());

                if (n != 0) {
                        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                        Solution solution = new Solution();
			solution.quicksort(nums, 0, nums.length - 1);
			for (int i = 0; i < nums.length; i++) {
				if (i != 0) sb.append(" ");
				sb.append(nums[i]);
			}
                } else {
                        sb.append("");
                }
                System.out.println(sb);
        }
}

class Solution {
	public int k = 0;
	
	public void quicksort(int[] nums, int l, int r) {
		if (l >= r) return;		
		System.out.print("current array to sort (l =" + l + ", r =" + r +"): ");
		for (int i = l; i <= r; i ++) {
			System.out.print(" " + nums[i]);
		}
		System.out.println();
		k++;
		System.out.println("k = " + k);
		if (k > 300) return;
//		int x = 0;
//		if (k % 2 == 0) {
//			x = (r - l) / 2;
//		} else {
//			x = (r - l) / 2 + 1;
//		}
		int x = (int) (l + Math.random() * (r - l));
		if (k % 2 != 0) x++;
		System.out.println("x = " + x);
		int newx = x;
		int p = partition(i -> i < nums[newx], nums, l, r);
		System.out.println("p = " + p);
		quicksort(nums, l, p);
		quicksort(nums, p + 1, r);
	} 

        public int partition(Predicate<Integer> condition, int[] nums, int left, int right) {
		System.out.println("I'm here partition left =" + left + ", right =" + right);
                while (left <= right) {
                        while (left <= right && condition.test(nums[left])) {
                                left++;
                        }
                        if (left <= right && !condition.test(nums[left])) {
                                while (left <= right && !condition.test(nums[right])) {
                                        right--;
                                }
                                if (left <= right && condition.test(nums[right])) {
                                        int tmp = nums[right];
                                        nums[right] = nums[left];
                                        nums[left] = tmp;
                                        left++;
                                        right--;
                                }
                        }
                }
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) System.out.print(" ");
			System.out.print(nums[i]);
		}
		System.out.println();
		return left - 1;
	}
}
