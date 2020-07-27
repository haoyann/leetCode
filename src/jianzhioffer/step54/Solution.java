package jianzhioffer.step54;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if (k > res.size()) {
            return -1;
        }
        return res.get(res.size() - k);
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
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
