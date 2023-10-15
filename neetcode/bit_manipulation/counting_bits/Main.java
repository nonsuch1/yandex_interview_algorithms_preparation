class Solution {
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		int i = 0;
		while (i <= n) {
			ans[i] = numberOf1Bits(i);
			i++;
		}
		return ans;
	}	

	private int numberOf1Bits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) != 0) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}
}

0 0		0
1 1		1
2 10		1
3 11		2
4 100		1
5 101		2
6 110		2
7 111		3
8 1000		1
9 1001		2
10 1010		2
11 1011		3
12 1100		2
13 1101		3
14 1110		3
15 1111		4
16 10000	1
17 10001	2
18 10010	2
19 10011	3
20 10100	2
21 10101	3
22 10110	3
