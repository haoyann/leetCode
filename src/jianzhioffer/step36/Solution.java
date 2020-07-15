package jianzhioffer.step36;

/**
 * 1、二叉搜索树中序遍历  是一个有序集合
 * 2、 双向链表需要首位相连
 * 3、树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 */
public class Solution {

    private Node head = null;
    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        //首位相连
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        //处理当前层逻辑
        //头结点
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;
        dfs(cur.right);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
