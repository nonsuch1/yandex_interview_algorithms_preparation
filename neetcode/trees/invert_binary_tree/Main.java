class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode result = solution.invertTree(root);
	}
}

class Solution {
	public TreeNode invertTree(TreeNode root) {
		TreeNode res = root;
		if (root == null) return res;
		TreeNode temp = null;
		while (root.left != null || root.right != null) {
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return res;
	}
}
