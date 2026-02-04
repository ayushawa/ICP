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
    public int getDecimalValue(ListNode head) {
        int len =0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        len--;
        temp = head;
        long ans = 0;
        while(temp!=null){
            if(temp.val == 1){
                ans = ans + (long)Math.pow(2,len);
                
                
            }
            len--;
            temp = temp.next;
        }
        return (int)ans;
    }
}