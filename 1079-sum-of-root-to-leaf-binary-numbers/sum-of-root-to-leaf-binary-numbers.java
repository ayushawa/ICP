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
    public int helper(TreeNode root,int sum){
        if(root == null ) return 0;
        else if(root.left == null && root.right == null) {
            return sum * 2 + root.val;
        }

        int ans = 0;
        if(root.left != null) ans+= helper(root.left ,sum * 2 + root.val );
        if(root.right != null) ans += helper(root.right,sum * 2 + root.val);
        return ans;
    }
    public int sumRootToLeaf(TreeNode root) {
        return helper(root,0);
    }
}