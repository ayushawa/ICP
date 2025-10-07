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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode node = new ListNode(head.val);
        ListNode curr = node;
        ListNode temp = head.next;
        while(temp!=null){
            if(curr.val != temp.val){
                curr.next = new ListNode(temp.val);
                curr = curr.next;
            }
            temp = temp.next;
        }
        return node;
        
    }
}