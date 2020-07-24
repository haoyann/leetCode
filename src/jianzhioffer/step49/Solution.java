package jianzhioffer.step49;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1、最小堆
 * 2、dp  三指针
 *    dp[i] = min(2*dp[a],3*dp[b],5*dp[c])
 */
public class Solution {


    public  int nthUglyNumber(int n) {
        int[] dp = new int[1690];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;

        for(int i = 1; i < n; i++) {
            int n2 = 2*dp[a] ,n3 = 3*dp[b], n5 = 5*dp[c];
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n-1];
    }

// 最小堆
//public static int nthUglyNumber(int n) {
//
//    PriorityQueue<Long> queue = new PriorityQueue<>();
//    long[] nums = new long[1690];
//    Set<Long> set = new HashSet<>();
//    queue.offer(1L);
//    set.add(1L);
//    nums[0] = 1L;
//    for (int i = 0; i < n; i++) {
//        long num = queue.poll();
//        if (!set.contains(num*2)){
//            queue.offer(num * 2);
//            set.add(num*2);
//        }
//        if (!set.contains(num*3)){
//            queue.offer(num * 3);
//            set.add(num*3);
//        }
//        if (!set.contains(num*5)){
//            queue.offer(num * 5);
//            set.add(num*5);
//        }
//        nums[i] = num;
//    }
//    return (int)nums[n-1];
//
//}



}
