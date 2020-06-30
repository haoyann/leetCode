package jianzhioffer.step14;

/**
 * 每次剪绳子存在n-1种可能,
 * dp[i] = max(dp[i],max(j*(i-j),j*dp[i-j]))
 *             dp[i] 当前位置不剪
 *             j*(i-j) 从j处开始剪,不再往下
 *             j*dp[i-j]  从j处开始剪,继续往下减
 */
public class Solution {

    public int cuttingRope(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }


}
