/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void getSmallest(TreeNode root, int[] k, int[] min) {
        if (root == null) return;
        getSmallest(root.left, k, min);
        if (--k[0] == 0) {
            min[0] = root.val;
            return;
        }
        getSmallest(root.right, k, min);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] min = new int[1];
        getSmallest(root, new int[]{k}, min);
        return min[0];
    }
}