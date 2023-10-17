class Solution {
	public int missingNumber(int[] nums) {
		int missingNumber = 0;
		int i = 0;
		while (i < nums.length) {
			missingNumber = missing ^ i ^ nums[i]; 
			i++;
		}
		return missingNumber;
	}
}
