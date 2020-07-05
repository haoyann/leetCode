package jianzhioffer.step22;

/**
 * 双指针
 * 一快一慢、相差k个节点当快指针指向尾末时，慢指针就是倒数第k个节点
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode slow = null;
        ListNode quick = head;
        int count = 0;
        while (quick != null) {
            if (count == k) {
                slow = head;
            }
            quick = quick.next;
            if (slow != null) {
                slow = slow.next;
            }
            count++;
        }

        return slow == null ? head : slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
