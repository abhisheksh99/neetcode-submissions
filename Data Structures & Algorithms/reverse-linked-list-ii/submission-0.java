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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: move prev to node before m
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // Step 2: reverse sublist from m to n
        ListNode current = prev.next;
        ListNode next = null;
        ListNode tail = current; // tail of reversed sublist

        for (int i = 0; i <= n - m; i++) {
            ListNode temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }

        // Step 3: reconnect
        prev.next = next;
        tail.next = current;

        return dummy.next;
    }
}