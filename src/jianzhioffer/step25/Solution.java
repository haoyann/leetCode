package jianzhioffer.step25;


public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // newHead
        ListNode newHead = new ListNode(0);
        //初始化 newNode的第一个节点
        ListNode newNode = new ListNode(0);
        newHead.next = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }


        while (l1 != null) {
            newNode.next = l1;
            l1 = l1.next;
            newNode = newNode.next;
        }

        while (l2 != null) {
            newNode.next = l2;
            l2 = l2.next;
            newNode = newNode.next;
        }

        return newHead.next.next;

    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
