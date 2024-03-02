/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode head){
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        while(lenA > lenB){
            lenA--;
            headA = headA.next;
        }
        while(lenB > lenA){
            lenB--;
            headB = headB.next;
        }
        while(headA  != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}