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
    public int helper(TreeNode root,HashMap<TreeNode,Integer> map){
         if(root == null) return 0;
         if(map.containsKey(root)) return map.get(root);

         int takeLeft = 0;
         if(root.left != null) takeLeft = helper(root.left.left,map)+helper(root.left.right,map);
         int takeright = 0;
         if(root.right !=null) takeright = helper(root.right.left,map) + helper(root.right.right,map);
         map.put(root,Math.max(root.val+ takeLeft+takeright, helper(root.left,map)+helper(root.right,map)));
         return Math.max(root.val  + takeLeft+takeright, helper(root.left,map)+helper(root.right,map));

    }
    public int rob(TreeNode root) {
       
         HashMap<TreeNode,Integer> map = new HashMap<>();
       return  helper(root,map);
       
        
    }
}