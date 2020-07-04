package jianzhioffer.step18;


public class Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                break;
            }
            ListNode temp = current;
            current = pre.next;
            pre = temp;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
