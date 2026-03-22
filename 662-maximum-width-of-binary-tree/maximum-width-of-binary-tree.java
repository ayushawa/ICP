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
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        map.put(root,0);
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 1;
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<TreeNode> l = new ArrayList<>();
            int size = q.size();
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                last = 0;
                TreeNode node = q.poll();
                if(i == 0) first = map.get(node);
                if(i == size-1) last = map.get(node);
                int val = map.get(node);
                if(node.left != null){
                    q.add(node.left);
                    map.put(node.left,2 * val +1);
                }
                if(node.right != null){
                    q.add(node.right);
                    map.put(node.right,2 * val + 2);
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
        
    }
}