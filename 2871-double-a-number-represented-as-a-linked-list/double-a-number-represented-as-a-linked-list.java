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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
    public ListNode doubleIt(ListNode head) {
        if(head == null) return null;
        head = reverse(head);
        int carry = 0;
        ListNode temp = head;
        while(temp != null){
            int val = temp.val * 2 + carry;
            temp.val = val%10;
            carry = val/10;
            if(temp.next == null && carry >0){
                temp.next = new ListNode(carry);
                break;
            }
            temp = temp.next;
        }
        return reverse(head);
    }
}