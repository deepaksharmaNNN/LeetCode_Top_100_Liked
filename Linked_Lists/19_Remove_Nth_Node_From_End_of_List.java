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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;
        while(n-- != 0){
            l2 = l2.next;
        }
        while(l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = l1.next.next;
        return dummy.next;
    }
}