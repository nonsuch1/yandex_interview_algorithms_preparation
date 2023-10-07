class Solution {
	public boolean sameTree(TreeNode p, TreeNode q) {
		if (p == null ^ q == null) return false;
		return (p == null && q == null) || sameTree(p.left, q.left) && sameTree(p.right, q.right);
	}
}
