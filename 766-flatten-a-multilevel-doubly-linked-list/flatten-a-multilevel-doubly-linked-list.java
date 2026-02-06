
class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        Stack<Node> st = new Stack<>();
        while(temp!=null){
            if(temp.child != null){
                if(temp.next != null) st.push(temp.next);
                temp.next = temp.child;
                temp.next.prev = temp;
            
                temp.child = null;  
                 
            }
            if(temp.next == null && !st.isEmpty()){
                temp.next = st.pop();
                temp.next.prev = temp;
            }
            temp = temp.next;
        }
        return head;

    }
}