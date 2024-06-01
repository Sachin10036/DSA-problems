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

    public ListNode reverseLinkedList(ListNode head){
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }

    public ListNode getKthNode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            
            reverseLinkedList(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}