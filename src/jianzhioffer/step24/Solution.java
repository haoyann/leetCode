package jianzhioffer.step24;

/**
 * 前后双指针
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;

        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = newHead;
            newHead = currentNode;
            currentNode = next;
        }
        return newHead;
    }


    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
