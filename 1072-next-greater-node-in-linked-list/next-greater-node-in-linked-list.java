/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp  = head;
        while(temp!= null){
            st.push(temp.val);
            temp = temp.next;
        }
        int ans[] = new int[st.size()];
        Stack<Integer> st2 = new Stack<>();
        int i = ans.length-1;
        while(!st.isEmpty()){
            int val = st.pop();
            while(!st2.isEmpty() && st2.peek()<=val){
                st2.pop();
            }
            if(st2.isEmpty()) ans[i--] = 0;
            else ans[i--] = st2.peek();
            st2.push(val);
        }
        return ans;
    }
}