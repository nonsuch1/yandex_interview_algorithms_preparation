class Main {
	public static void main(String[] args) {
		
	}
}

class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (set.add(n) == true || n != 1) {
			int sum = 0;
			while (n >= 10) {
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			sum += n * n;
			n = sum;
			
		}
		return n == 1;
	}
}
