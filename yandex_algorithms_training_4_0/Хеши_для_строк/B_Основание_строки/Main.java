import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("input.txt"));
		String s = scanner.nextLine();
	
		Solution solution = new Solution();
		int res = 0;
		if (!s.isEmpty()) {
			res = solution.getMinRepeatableFragment(s);
		}
		System.out.println(res);
	}
}

class Solution {
	private long xx = 257;
	private int p = (int)(Math.pow(10, 9) + 7);
	private long[] h;
	private long[] x;

	public int getMinRepeatableFragment(String s) {
		StringBuilder sb = new StringBuilder();
		s = " " + s;
		hashInit(s);
		int fr1 = 2;
		while (fr1 < s.length() && !equals(s, s.length() - fr1, fr1, 1)) {
			fr1++;
		}
		return fr1 - 1;
	}

	private void hashInit(String s) {
		int[] a = new int[s.length()];
                h = new long[s.length()];
                x = new long[s.length()];
                h[0] = 0;
                x[0] = 1;
                for (int i = 1; i < s.length(); i++) {
                        a[i] = s.charAt(i);
                        h[i] = (h[i - 1] * xx + a[i]) % p;
                        x[i] = (x[i - 1] * xx) % p;
                }
	}	

	public boolean equals(String s, int len, int fr1, int fr2) {
		s = " " + s;
		return (h[fr1 + len - 1] + h[fr2 - 1] * x[len]) % p ==
			(h[fr2 + len - 1] + h[fr1 - 1] * x[len]) % p;
	}
}
