class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;

        // Move front pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            front = front.next;
        }

        // Move both pointers until front reaches the end
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        // Remove the nth node from the end
        back.next = back.next.next;

        return dummy.next;
    }
}
