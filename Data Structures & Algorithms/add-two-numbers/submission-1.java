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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result list handling
        ListNode ans = dummy; // Pointer to build the result list
        int carry = 0; // To store carry for addition

        // Traverse both lists while there's still a value to add
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + carry; // Compute sum including carry

            carry = sum / 10; // Extract carry for next addition
            int val = sum % 10; // Extract digit to store

            ans.next = new ListNode(val); // Create new node for the sum digit
            ans = ans.next; // Move to the next node

            // Move l1 and l2 forward if they are not null
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next; // Return the result linked list starting from dummy.next
    }
}
