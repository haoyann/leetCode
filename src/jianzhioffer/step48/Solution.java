package jianzhioffer.step48;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、滑动窗口
 * 2、dp
 *  a、num[i] 不存在左边
 *  dp[i] = dp[i-1] +1
 *  b、num[i] 存在左边 i从右往左出现的第一个重复字符距离为j
 *   j > dp[i-1]   dp[i] = dp[i-1]+1
 *   j <= dp[i - 1]  dp[i] = j;
 *
 */
public class Solution {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //存放字符最新出现的位置
        Map<Character, Integer> dir = new HashMap<>();

        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = dp[0];
        dir.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = dir.get(c);
            if (index == null) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = i - index > dp[i - 1] ? dp[i - 1] + 1 : i - index;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
            //更新出现的位置
            dir.put(c, i);
        }
        return max;
    }

    //滑动窗口
//    public int lengthOfLongestSubstring(String s) {
//        String window = "";
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            //字符串在窗口中的位置
//            int index = index(window,c);
//            window += c;
//            //在窗口中
//            if (index >= 0){
//                window = window.substring(index+1);
//            }
//            if (max < window.length()){
//                max = window.length();
//            }
//        }
//        return max;
//    }
//
//    private int index(String s,char c){
//        for (int i = 0; i < s.length(); i++) {
//            if (c == s.charAt(i)){
//                return i;
//            }
//        }
//        return -1;
//    }


}
