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
    public void reorderList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            l.add(temp.val);
            temp = temp.next;
        }

        int s = 0;
        int e = l.size()-1;
        temp = head;
        while(temp!=null){
            temp.val = l.get(s);
            temp = temp.next;
            s++;

            if(temp!=null){
                temp.val = l.get(e);
                temp = temp.next;
                e--;
            }
        }
        
    }
}