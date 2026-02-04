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
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode res = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return res;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode head2 = new ListNode(-1);
        ListNode temp = head;
        ListNode temp2  = head2;
        int carry = 0;
        while(temp != null){
            int value = temp.val * 2 + carry ;
            temp2.next = new ListNode(value%10);
            temp2 = temp2.next;
            carry = value/10;
            temp = temp.next;
        }
        if(carry >0) {
            temp2.next = new ListNode(carry);
            
        }
        return reverse(head2.next);
    }
}