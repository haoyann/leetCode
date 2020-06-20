package jianzhioffer.step7;


import java.util.HashMap;
import java.util.Map;

/**
 * 1、前序遍历特点-->  根节点在第一位
 * 2、中序遍历特点--> 根节点在左子树与右子树中间
 * 3、先在前序遍历找到根节点，然后在中序遍历中将树分为左子树与右子树
 * 4、将第3步拆分的左子树与右子树继续重复第3步一直到左右节点都为空
 * <p>
 * 方法：递归  处理重复子问题（拆分二叉树）
 */
public class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length ; i++) {
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int preRoot,int inLeft,int inRight){
        if (inLeft > inRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = map.get(preorder[preRoot]);
        //左子树前序根节点= preRoot+1, 中序左边界= inLeft 中序右边界=inRoot-1;
        root.left = buildTree(preorder,preRoot+1,inLeft,inRoot-1);

        //右子树前序根节点= preRoot+左子树长度 + 1 = preRoot +(inRoot-inLeft)+1
        //  中序左边界= inRoot+1 中序右边界=inRight;
        root.right = buildTree(preorder,preRoot+inRoot-inLeft+1,inRoot+1,inRight);

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
