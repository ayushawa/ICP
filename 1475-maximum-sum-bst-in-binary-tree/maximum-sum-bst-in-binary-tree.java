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
    int maxsum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxsum;
    }
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int leftArray[] = helper(root.left);
        int rightArray[] = helper(root.right);
        if(root.val > leftArray[1] && root.val<rightArray[0]){
            int currmin = Math.min(root.val,leftArray[0]);
            int currmax =  Math.max(root.val,rightArray[1]);
            int currsum= leftArray[2] + root.val  + rightArray[2];
            maxsum = Math.max(maxsum,currsum);
            return new int[]{currmin,currmax,currsum};
        }
        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0};
    }
}