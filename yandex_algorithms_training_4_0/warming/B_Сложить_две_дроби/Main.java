import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int a = input[0];
		int b = input[1];
		int c = input[2];
		int d = input[3];
		Solution solution = new Solution();
		String res = solution.sum(a, b, c, d);
		System.out.println(res);
	}
}

class Solution {
	public String sum(int a, int b, int c, int d) {
		int up = a * d + b * c;
		int down = b * d;
		
		int i = 2;
		while (i <= Integer.max(up, down) && (up != 1 || down != 1)) {
			while (up % i == 0 && down % i == 0) {
				up /= i;
				down /= i;
			}
			i++;
		}
		return up + " " + down;
	}
}

