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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i != 0) sb.append("$");
			sb.append(s.charAt(i));
		}
		hashInit(sb);
		for (int i = 0; i < sb.length(); i++) {
			int maxLenPalindrome = findMaxLengthPalindrome(sb, i);
			if (sb.charAt(i) == '$' && maxLenPalindrome > 1) {
				count += (maxLenPalindrome + 1) / 4;
			} else if (sb.charAt(i) != '$') {
				count += (maxLenPalindrome + 3) / 4;
			}
		}
		return count;
	}

	private int findMaxLengthPalindrome(StringBuilder s, int center) {
		int result = 0;
		int sLength = s.length();
		int radius = Integer.min(center, sLength - 1 - center);
		int l = center - radius;
		int r = center;
		int prevL = center - radius;
		while (l <= r) {
			int frH = l;
			int frZ = center + (center - l);
			if (equals(sLength, center - l + 1, frH, frZ)) {
				int curLen =  2 * (center - l) + 1;
				result = Integer.max(result, curLen);
				r = l - 1;
				int tmp = l;
				l = prevL + 1;
				prevL = tmp;
			} else {
				prevL = l;
				l = (r + l) / 2 + 1;
			}
		}
		if (s.charAt(center + result / 2) == '$') result -= 2;
		return result;
	}

	private void hashInit(StringBuilder s) {
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

        public boolean equals(int sLen, int len, int frH, int frZ) {
		frZ = sLen - 1 - frZ;
                return (h[frH + len] + z[frZ] * x[len]) % p ==
                        (z[frZ + len] + h[frH] * x[len]) % p;
        }
}
