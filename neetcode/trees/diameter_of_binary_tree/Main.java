class Solution {
   Diameter maxDiameter = new Diameter(0);

        public int diameterOfBinaryTree(TreeNode root) {
                dfs(root);
                return maxDiameter.value;
        }

        private int dfs(TreeNode root) {
                if (root == null) return -1;

                int left = dfs(root.left);
                int right = dfs(root.right);
                maxDiameter.value = Integer.max(maxDiameter.value, left + right + 2);
                return Integer.max(left, right) + 1;
        }
}

class Diameter {
        int value;

        public Diameter(int value) { this.value = value; }
}
