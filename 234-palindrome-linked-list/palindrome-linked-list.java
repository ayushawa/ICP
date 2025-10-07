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
   
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode temp2 = new ListNode(head.val);
        ListNode temp = head.next;
        while(temp!=null){
            ListNode node = new ListNode(temp.val);
            node.next = temp2;
            temp2 = node;
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.val != temp2.val) return false;
            temp= temp.next;
            temp2 = temp2.next;
        }
        return true;
    }
}