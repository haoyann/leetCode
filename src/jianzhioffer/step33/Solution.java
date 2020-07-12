package jianzhioffer.step33;

/**
 * 二叉搜索树 根节点 大于左子树  小于右子树
 * 后序遍历根节点在最后位置
 */
public class Solution {


    public boolean verifyPostorder(int[] postorder) {

        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int left, int right) {
        //只有一个节点、满足条件
        if (left >= right) {
            return true;
        }
        //根节点的值
        int rootValue = postorder[right];

        //从左往右找出第一个大于rootValue的坐标，表示右子树开始的位置
        int rightIndex = findRightIndex(postorder, rootValue, left, right);

        //检查右子树是否合法
        boolean checkRightTree = checkRightTree(postorder, rightIndex, right - 1, rootValue);
        if (!checkRightTree) {
            return false;
        }

        // 左 、 右
        return dfs(postorder, left, rightIndex - 1) && dfs(postorder, rightIndex, right - 1);
    }

    private int findRightIndex(int[] postorder, int rootValue, int left, int right) {
        for (int i = left; i < right; i++) {
            if (postorder[i] > rootValue) {
                return i;
            }
        }

        return right;
    }

    private boolean checkRightTree(int[] postorder, int left, int right, int rootValue) {
        for (int i = left; i <= right; i++) {
            if ( postorder[i] < rootValue) {
                return false;
            }
        }
        return true;
    }

}
