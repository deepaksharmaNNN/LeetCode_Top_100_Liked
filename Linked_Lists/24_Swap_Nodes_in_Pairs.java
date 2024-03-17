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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode point = dummy;
        while(point.next != null && point.next.next != null){
            ListNode s1 = point.next;
            ListNode s2 = point.next.next;
            //Swap
            s1.next = s2.next;
            s2.next = s1;
            //prepare for next
            point.next = s2;
            point = s1;
        }
        return dummy.next;
    }
}