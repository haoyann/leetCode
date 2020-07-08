package jianzhioffer.step27;

/**
 * 递归交换每个节点的左右子树
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode right = mirrorTree(root.left);
        TreeNode left = mirrorTree(root.right);

        root.right = right;
        root.left = left;

        return root;

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
