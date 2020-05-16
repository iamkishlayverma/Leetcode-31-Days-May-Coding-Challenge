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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode currOdd = head;
        ListNode currEven = head.next;
        ListNode currEvenHead = head.next;
        ListNode curr = currEven.next;
        while (curr != null) {            
            currOdd.next = curr;
            currEven.next = curr.next;
            curr.next = currEvenHead;
            currOdd = currOdd.next;
            if (currEven.next == null)
                break;
            currEven = currEven.next;
            curr = currEven.next;
        }
        return head;
    }
}
