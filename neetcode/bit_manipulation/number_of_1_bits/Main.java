class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new File("input.txt"));
		scanner.nextLine().toInt();
	}
}

class Solution {
	public int hammingWeight(int n) {
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

/*

0 0
1 1
2 10
3 11
4 100
5 101
6 110
7 111
8 1000
9 1001
10 1010
11 1011
12 1100
13 1101
14 1110
15 1111
16 10000

101 
010
001
0
*/
