package jianzhioffer.step19;

/**
 * . 任意字符
 * * 任意个数 0-n
 * <p>
 * 1、字符相等 匹配
 * 2、字符不相等
 * a、 为 . 匹配
 * b、 为*   s不动p移动两位   s移动两位 p不动
 * c、 不相等 不匹配
 */
public class Solution {


    public boolean isMatch(String s, String p) {

        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //为空
                if (j == 0){
                    dp[i][j] = i == 0;
                    continue;
                }
                //相等
                if (i > 0 && s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //不相等
                    if (i>0 && p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (p.charAt(j-1) == '*') {
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || s.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

}
