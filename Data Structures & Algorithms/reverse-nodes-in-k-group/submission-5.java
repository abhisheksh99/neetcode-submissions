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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode currentNode = head;

        // Count total number of nodes
        int totalNodes = 0;
        while (currentNode != null) {
            totalNodes++;
            currentNode = currentNode.next;
        }

        // Reverse nodes in groups of k
        while (totalNodes >= k) {
            currentNode = prevGroupEnd.next;
            ListNode nextNode = currentNode.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                currentNode.next = nextNode.next;
                nextNode.next = prevGroupEnd.next;
                prevGroupEnd.next = nextNode;
                nextNode = currentNode.next;
            }

            prevGroupEnd = currentNode;
            totalNodes -= k;
        }

        return dummy.next;
    }
}
