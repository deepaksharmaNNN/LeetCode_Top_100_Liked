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
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightView = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		if (root != null) { // Add a null check for the root node
    	que.add(root);
		}
		while(que.size()>0){
		int size = que.size();
		int rightMost = 0;
		while(size-->0){
			TreeNode rnode = que.remove();
			rightMost = rnode.val;
			if(rnode.left!=null) que.add(rnode.left);
			if(rnode.right!=null) que.add(rnode.right);
		}
		rightView.add(rightMost);
		}
		return rightView;
    }
}