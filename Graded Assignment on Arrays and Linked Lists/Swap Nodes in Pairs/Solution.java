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
        if(head == null || head.next == null)   
        return head;
 
    ListNode head1 = new ListNode(0);
    head1.next = head;
    ListNode prev = head1;
 
    while(prev.next != null && prev.next.next != null){
        //use t1 to track first node
        ListNode track1 = prev;
        prev = prev.next;
        track1.next = prev.next;
 
        //use t2 to track next node of the pair
        ListNode track2 = prev.next.next;
        prev.next.next = prev;
        prev.next = track2;
    }
 
    return head1.next;
    }
}
