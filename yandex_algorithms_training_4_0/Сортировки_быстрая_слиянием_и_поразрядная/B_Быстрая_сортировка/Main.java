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
		if (k > 100) return;
		System.out.println("k = " + k);
		int x = (int) (l + Math.random() * (r - l));
		if (k % 2 != 0) x++;
		System.out.println("x = " + x);

		int p = partition(nums, l, r, nums[x]);
		if (p == -2) return;
		System.out.println("p = " + p);
		quicksort(nums, l, p);
		quicksort(nums, p + 1, r);
	} 

        public int partition(int[] nums, int left, int right, int x) {
		System.out.println("I'm here partition left =" + left + ", right =" + right);

		int e = -1;
		int g = -1;
		int n = left;

		int tmp = 0;
                while (n <= right) {
                        if (n <= right && nums[n] < x) {
                                if (e == - 1 && g == -1) {

				} else if (e != - 1 && g != -1) {
					swap(nums, e, n);
					swap(nums, g, n);
					e++;
					g++;
				} else if (e != -1) {
					swap(nums, e, n);
					e++;
				} else if (g != -1) {
					swap(nums, g, n);
					g++;
				}
                        } else if (n <= right && nums[n] == x) {
				if (e == - 1 && g == - 1) {
					e = n;
				} else if (e != -1 && g != - 1) {
					swap(nums, g, n);
					g++;
				} else if (e != - 1) {
				} else if (g != - 1) {
					swap(nums, g, n);
					e = g;
					g++;
				}
			} else if (n <= right && nums[n] > x) {
				if (e == - 1 && g == -1) {
					g = n;
				} else if (e != -1 && g != -1) {
				} else if (e != -1) {
					g = n;
				} else if (g != -1) {
				}
			}
			n++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) System.out.print(" ");
			System.out.print(nums[i]);
		}
		System.out.println();
		int res = 0;
		if (e == - 1 && g == -1) {
			res = -1;
		} else if (e != -1 && g != -1) {
			res = e - 1;
		} else if (e != -1) {
			if (e == left) {
				res = -2;
			} else {
				res = e - 1;
			}
		} else if (g != - 1) {
			res = g - 1;
		}
		return res;
	}

	private void swap(int[] nums, int p, int q) {
		int tmp = nums[p];
		nums[p] = nums[q];
		nums[q] = tmp;
	}
}
