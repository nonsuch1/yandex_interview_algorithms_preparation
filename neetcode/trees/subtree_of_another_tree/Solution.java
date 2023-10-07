class Solution {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root.val == subRoot.val) {
			return 
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean sameTree(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) return false;
		retun (p == null && q == null) || (p.val == q.val) && sameTree(p.left, q.left) && sameTree(p.right, q.right);
	}
}
