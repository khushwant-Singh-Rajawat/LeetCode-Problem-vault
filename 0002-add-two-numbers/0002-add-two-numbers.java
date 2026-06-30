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
        // Create a dummy head to simplify building the new list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop while there are nodes to process in l1 OR l2 OR a remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get values if nodes exist, otherwise default to 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Calculate total sum for the current position
            int total = val1 + val2 + carry;

            // Update carry and the digit to store in the new node
            carry = total / 10;
            int digit = total % 10;

            // Append the new node and move the pointer forward
            current.next = new ListNode(digit);
            current = current.next;

            // Move to the next nodes in the input lists if they exist
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }
}