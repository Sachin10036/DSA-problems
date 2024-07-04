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
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode start = head;
        while (start != null) {
            ListNode end = start;   
            int sum = 0;
            while (end.val != 0) {
                sum += end.val;
                end = end.next;
            }
            start.val = sum;   
            start.next = end.next;   
            start = start.next;
        }
        return head;
    }
}