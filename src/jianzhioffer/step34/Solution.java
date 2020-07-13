package jianzhioffer.step34;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanhao
 * @date 2020/7/13
 * @description:
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        dfs(root,sum,0,new ArrayList<>(),res);
        return res;
    }

    private void dfs(TreeNode node,int sum,int currentSum,List<Integer> path,List<List<Integer>> res){
        if(node == null){
            return;
        }

        int temp = currentSum+node.val;

        if(sum == temp && node.left == null && node.right == null){
            path.add(node.val);
            res.add(path);
            return;
        }
        path.add(node.val);
        //左子树
        dfs(node.left,sum,temp,new ArrayList<>(path),res);

        //右子树
        dfs(node.right,sum,temp,new ArrayList<>(path),res);

        //reset status
        path.remove(path.size()-1);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
