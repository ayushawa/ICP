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
    public int helper(TreeNode root,int res[]){
        if(root == null) return 0;
        int leftsum = Math.max(0,helper(root.left,res));
        int rightsum  = Math.max(0,helper(root.right,res));
        res[0] = Math.max(res[0],root.val+leftsum+rightsum);
        return root.val + Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        int res[] = {root.val};
        helper(root,res);
        return res[0];
    }
}