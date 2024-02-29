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
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode fast = temp.next;
            temp.next = prev;
            prev = temp;
            temp = fast;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){//for odd case
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
        if(slow.val != fast.val) return false;
        slow = slow.next;
        fast = fast.next;
    }
    return true;
    }
}