class Solution {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null ^ subRoot == null) return false;
		if (root == null && subRoot == null) return true;
		return (root.val == subRoot.val && sameTree(root, subRoot)) ||
			isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean sameTree(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) return false;
		return (p == null && q == null) || (p.val == q.val) && sameTree(p.left, q.left) && sameTree(p.right, q.right);
	}
}
