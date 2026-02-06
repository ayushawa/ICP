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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) return head;
        ListNode temp = head;
        int len  =0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
       
        if(len<k) return head;
         temp = head;
         ListNode prev = head;
        int count = 0;
        Stack<Integer> st = new Stack<>();
        while(len-- >0){
            count++;
            st.push(temp.val);
            if(count == k){
                while(!st.isEmpty()){
                    prev.val = st.pop();
                    prev = prev.next;
                }
                count = 0;
            }
            temp = temp.next;
        

        }
        return head;

    }
}