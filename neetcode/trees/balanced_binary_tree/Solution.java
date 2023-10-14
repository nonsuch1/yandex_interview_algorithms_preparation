class Solution {
         boolean isBalanced = true;


        public boolean isBalanced(TreeNode root) {
                if (root == null) return true;
                dfs(root);
                return isBalanced;
        }

        private int dfs(TreeNode root) {
                if (root == null) return -1;
                int left = dfs(root.left);
                int right = dfs(root.right);
                if (Math.abs(left - right) > 1) {
                        isBalanced = false;
                }

                return Integer.max(left + 1, right + 1);
        }

}
