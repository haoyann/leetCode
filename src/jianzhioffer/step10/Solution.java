package jianzhioffer.step10;

/**
 * 斐波那契数列
 * 1、递归
 * 2、推导、记录状态  F(N) = F(N - 1) + F(N - 2)
 */
public class Solution {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f1 = 0;
        int f2 = 1;
        int f3 = f1 + f2;
        for (int i = 2; i < n ; i++) {
            f1 = f2;
            f2 = f3;
            f3 = (f1 + f2)% 1000000007;
        }
        return f3;

    }

//    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n-1) + fib(n-2);
//    }

}
