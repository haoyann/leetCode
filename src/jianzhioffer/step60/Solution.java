package jianzhioffer.step60;

/**
 * 1、递归超时
 * 2、动态规划
 * n->骰子个数，点数j出现点数的次数
 * dp[n][j] += dp[n-1][j-i]  (i = 1-6)
 */
public class Solution {

    public  double[] twoSum(int n) {
        int[][] dp = new int[n+1][67];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            //当前骰子可以出现的点数
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if(j-k <= 0){
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double all = Math.pow(6,n);
        double[] res = new double[6*n+1-n];
        int j = 0;
        for (int i = n; i <= 6*n; i++) {
            res[j] = dp[n][i]/all;
            j++;
        }
        return res;
    }


}
