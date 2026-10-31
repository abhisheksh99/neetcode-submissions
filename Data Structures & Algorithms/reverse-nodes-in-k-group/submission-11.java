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

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        // Check if there are at least k nodes available to reverse
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head; // less than k nodes, no reversal
        }

        // Reverse k nodes
        curr = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // head is now the last node in this group,
        // connect it with reversed result of next group
        head.next = reverseKGroup(curr, k);

        return prev; // prev is the new head of the reversed group
    }
}

