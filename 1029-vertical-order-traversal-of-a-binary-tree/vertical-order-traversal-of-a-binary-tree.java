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
    public void helper(TreeNode root,int x,int y,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map){
        if(root == null) return;
        if(!map.containsKey(x)){
            TreeMap<Integer,List<Integer>> mp = new TreeMap<>();
            map.put(x,mp);
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y,new ArrayList<>());
        }
        map.get(x).get(y).add(root.val);
        helper(root.left,x-1,y+1,map);
        helper(root.right,x+1,y+1,map);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map =new TreeMap<>();
        helper(root,0,0,map);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet()){
            List<Integer> temp = new ArrayList<>();
            for(int y: map.get(key).keySet()){
                List<Integer> l = map.get(key).get(y);
                Collections.sort(l);
                temp.addAll(l);
            }
            ans.add(temp);
        }
        return ans;

    }
}