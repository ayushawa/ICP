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
    public long  setSubtreeSum(TreeNode root,HashMap<TreeNode,Long> map){
        if(root == null) return 0;
        long leftsum = setSubtreeSum(root.left,map);
        long rightsum = setSubtreeSum(root.right,map);
        long sum = leftsum+rightsum+root.val;
        map.put(root,sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        HashMap<TreeNode,Long> subtreeSum = new HashMap<>();
       long totalsum = setSubtreeSum(root,subtreeSum);
        long mod = (long)1000000007;
        long maxi = (long)0;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null) continue;
                else if(node.left != null){
                    long left = subtreeSum.get(node.left);
                    long p = left * (totalsum -left );
                    maxi = Math.max(maxi,p);
                    q.add(node.left);

                    
                }
                if(node.right != null){
                    long right = subtreeSum.get(node.right);
                    long p = right * (totalsum -right);
                    maxi = Math.max(maxi,p);
                    q.add(node.right);

                    
                }

            }

        }
        return (int)(maxi%mod);
    }
}