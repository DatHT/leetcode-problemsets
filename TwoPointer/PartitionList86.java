package TwoPointer;
// https://leetcode.com/problems/partition-list/

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode smallerNode = new ListNode(0);
        ListNode smaller = smallerNode;
        ListNode greaterNode = new ListNode(0);
        ListNode greater = greaterNode;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        smaller.next = greaterNode.next;
        greater.next = null;
        return smallerNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}