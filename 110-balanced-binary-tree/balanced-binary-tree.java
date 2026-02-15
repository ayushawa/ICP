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
    public int height(TreeNode root,int diff[]){
        if(root == null) return 0;
        int leftheight = 1 + height(root.left,diff);
        int rightheight = 1 + height(root.right,diff);
        diff[0] = Math.max(diff[0],Math.abs(leftheight-rightheight));
        return Math.max(leftheight,rightheight);
    }
    public boolean isBalanced(TreeNode root) {
        int diff[] = {0};
        height(root,diff);
        if(diff[0]>1) return false;
        return true;
    }
}