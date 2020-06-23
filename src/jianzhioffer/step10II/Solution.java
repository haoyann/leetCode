package jianzhioffer.step10II;

/**
 * 1、递归  栈溢出
 * 2、 推导 f(n) = f(n-1) + f(n-2)
 */
public class Solution {

    public int numWays(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int f1 = 1;

        int f2 = 2;

        int f3 = f1 + f2;
        for (int i = 3; i < n; i++) {
            f1 = f2;
            f2 = f3;
            f3 = (f1 + f2) % 1000000007;
        }

        return f3;

    }
}
