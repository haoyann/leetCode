package jianzhioffer.step68;

public class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = p.val > q.val ? q : p;
        TreeNode right = p.val > q.val ? p : q;

        while(root != null){
            if(root.val == right.val || root.val == left.val){
                break;
            }
            if(root.val > right.val){
                root = root.left;
            }
            if(root.val < left.val){
                root = root.right;
            }
            if(root.val > left.val && root.val < right.val){
                break;
            }
        }

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
