package jianzhioffer.step55II;


public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左、右子树长度
        int leftDepth = rootDepth(root.left);
        int rightDepth = rootDepth(root.right);
        int abs = Math.abs(leftDepth - rightDepth);
        if (abs > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int rootDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return Math.max(rootDepth(node.left), rootDepth(node.right)) + 1;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
