
class Solution {
    public int dfs(TreeNode root,int moves[]){
        if(root == null) return 0;
        int left = dfs(root.left,moves);
        int right  = dfs(root.right,moves);
        moves[0] += Math.abs(left + right + root.val -1);
        return left  + right + root.val -1;
    }
    public int distributeCoins(TreeNode root) {
        int moves[] = {0};
         dfs(root,moves);
         return moves[0];
    }
}