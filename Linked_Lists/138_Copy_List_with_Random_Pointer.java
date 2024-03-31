/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node og = head;
        while(og != null){
            Node clone = new Node(og.val);
            clone.next = og.next;
            og.next = clone;
            og = og.next.next;
        }
        og = head;
        while(og != null){
            if(og.random != null){
                og.next.random = og.random.next;
            }
            og = og.next.next;
        }
        og = head;
        Node copy = head.next;
        Node temp = copy;
        while(og != null){
            og.next = og.next.next;
            if(temp.next != null) temp.next = temp.next.next;
            og = og.next;
            temp = temp.next;
        }
        return copy;

    }
}