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
    class Pair{
        TreeNode node;
        long i;
        Pair(TreeNode node,long i){
            this.node  = node;
            this.i = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq = new ArrayDeque<>();
        int maxWidth = 0;
        dq.addFirst(new Pair(root,(long)0));
        while(!dq.isEmpty()){
            long startIdx = dq.peekFirst().i;
            long lastIdx = dq.peekLast().i;
            maxWidth = Math.max(maxWidth,(int)(lastIdx-startIdx+1));
            int size = dq.size();
            for(int j=0;j<size;j++){
                Pair p = dq.pollFirst();
                long i = p.i;
                TreeNode node = p.node;
                if(node.left!= null) dq.addLast(new Pair(node.left,((long)2*i+1)));
                if(node.right!=null) dq.addLast(new Pair(node.right,((long)2*i+2)));
            }
        }
        return maxWidth;
    }
}