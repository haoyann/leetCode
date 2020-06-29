package jianzhioffer.step13;


/**
 * 往上、下、左、右 dfs遍历
 */
public class Solution {

    private int res = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        dfs(m, n, k, 0, 0, used);
        return res;
    }

    private void dfs(int m, int n, int k,  int i, int j, boolean[][] used) {
        //判断边界条件
        if (i < 0 || i == m || j < 0 || j == n || used[i][j]) {
            return ;
        }
        //判断是否越界
        if (moreK(i, j, k)) {
            return ;
        }
        used[i][j] = true;
        res = res+1;
        //上、下
        dfs(m, n, k,  i - 1, j, used);
        dfs(m, n, k,  i + 1, j, used);

        //左、右
        dfs(m, n, k,  i, j - 1, used);
        dfs(m, n, k,  i, j + 1, used);

        //reverse status
        //used[i][j] = false;
    }

    private boolean moreK(int i, int j, int k) {
        int num = 0;
        //i 个、十、百
        num += i % 10 + i / 10 + i / 100;
        //j 个、十、百
        num += j % 10 + j / 10 + j / 100;
        return num > k;
    }


}
