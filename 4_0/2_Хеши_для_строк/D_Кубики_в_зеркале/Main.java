import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int ballsN= input[0];
		int colorsN = input[1];
		int[] balls = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Solution solution = new Solution();
		List<Integer> res = solution.solve(balls);
		StringBuilder sb = new StringBuilder();
		for (int i = res.size() - 1; i >= 0; i--) {
			if (i != res.size() - 1) sb.append(" ");
			sb.append(res.get(i));
		}
		System.out.println(sb);
	}
}

class Solution {
	private int p = (int) (Math.pow(10, 9) + 7);
	private long xx = 257;
        private long[] h;
	private long[] z;
        private long[] x;

	public List<Integer> solve(int[] balls) {
		List<Integer> res = new ArrayList<>();
		res.add(balls.length);

		hashInit(balls);
		for (int i = 0; i < balls.length / 2; i++) {		
			if (equals(i + 1, i + 1, balls.length - i - 1)) {
				res.add(balls.length - i - 1);
			}
		}		
		return res;
	}

	 private void hashInit(int[] s) {
                h = new long[s.length + 1];
		z = new long[s.length + 1];
                x = new long[s.length + 1];
                h[0] = 0;
                x[0] = 1;
		z[0] = 0;
                for (int i = 0; i < s.length; i++) {
                        h[i + 1] = (h[i] * xx + s[i]) % p;
                        x[i + 1] = (x[i] * xx) % p;
			z[i + 1] = (z[i] * xx + s[s.length - i - 1]) % p;	
                }
        }

	public boolean equals(int len, int frH, int frZ) {
		return (h[frH + len] + z[frZ] * x[len]) % p ==
			(z[frZ + len] + h[frH] * x[len]) % p;
	}
}
