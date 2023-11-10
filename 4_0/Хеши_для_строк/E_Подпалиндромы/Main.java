import java.io.File;
import java.util.Scanner;
import java.io.IOException;


class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();
		Solution solution = new Solution();
		int res = solution.solve(s);
		System.out.println(res);
	}
}

class Solution {
	private int p = (int) (Math.pow(10, 9) + 7);
        private long xx = 257;
        private long[] h;
        private long[] z;
        private long[] x;

	public int solve(String s) {
		int count = 0;
		hashInit(s);
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				int len = j - i;
				if (equals(len, i, s.length() - j - 1)) {
					count++;		
				}
			}
		}
		return count;
	}

	private void hashInit(String s) {
        	h = new long[s.length() + 1];
                z = new long[s.length() + 1];
                x = new long[s.length() + 1];
                h[0] = 0;
                x[0] = 1;
                z[0] = 0;
                for (int i = 0; i < s.length(); i++) {
                        h[i + 1] = (h[i] * xx + s.charAt(i)) % p;
                        x[i + 1] = (x[i] * xx) % p;
                        z[i + 1] = (z[i] * xx + s.charAt(s.length() - i - 1)) % p;
                }
        }

        public boolean equals(int len, int frH, int frZ) {
                return (h[frH + len] + z[frZ] * x[len]) % p ==
                        (z[frZ + len] + h[frH] * x[len]) % p;
        }
}
