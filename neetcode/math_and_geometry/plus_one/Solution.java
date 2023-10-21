class Solution {
	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		int buffer = 1;
		while (buffer > 0 && i >= 0) {
			if (digits[i] < 9) {
				digits[i] += 1;
				buffer = 0;
			} else {
				digits[i] = 0;
				i--;
			} 
		}
		if (buffer > 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			i = 0;
			while (i < digits.length) {
				result[i + 1] = digits[i];
				i++;
			}
			return result;
		}
		return digits;
	}	
}
