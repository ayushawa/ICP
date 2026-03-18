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
    public int helper(TreeNode root,int res[],HashMap<TreeNode,Integer> map){
      if(root == null) return 0;
      if(map.containsKey(root)) return map.get(root);
      int leftNotTake = helper(root.left,res,map);
      int rightNotTake = helper(root.right,res,map);
      int leftMax =0;
      if(root.left != null) leftMax+=  helper(root.left.left,res,map)+helper(root.left.right,res,map);
      int rightMax = 0;
      if(root.right != null) rightMax = helper(root.right.left,res,map)+helper(root.right.right,res,map);
      res[0]  = Math.max(res[0],Math.max(leftNotTake+rightNotTake,root.val + leftMax + rightMax));
      map.put(root,Math.max(leftNotTake+rightNotTake,root.val + leftMax+rightMax));
      return Math.max(leftNotTake+rightNotTake,root.val + leftMax+rightMax) ;
    }
    public int rob(TreeNode root) {
        int res[] = {root.val};
         HashMap<TreeNode,Integer> map = new HashMap<>();
        helper(root,res,map);
       
        return res[0];
    }
}