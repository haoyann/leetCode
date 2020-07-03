package jianzhioffer.step17;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *1、循环遍历  长度会不够
 * 2、 用字符串保存大数，全排列所有结果
 */
public class Solution {

    public int[] printNumbers(int n) {
        List<String> res = new ArrayList<>();
        char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        dfs(n, nums, "", res, 0);
        //字符串转int,去除0
        return convertIntArray(res);
    }

    private void dfs(int n, char[] nums, String s, List<String> res, int countZero) {
        if (s.length() == n) {
            //保存结果 不为0才添加
            if (countZero != n) {
                res.add(s);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = countZero;
            if (nums[i] == '0') {
                temp++;
            }
            dfs(n, nums, s + nums[i], res, temp);
        }

    }

    private int[] convertIntArray(List<String> res) {
        int[] array = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            String s = res.get(i);
            int num = 0;
            for (int j = 0; j < s.length(); j++) {
                int n = s.charAt(j) - '0';
                n = n*(int) Math.pow(10, j);
                num += n;
            }
            array[i] = num;
        }
        Arrays.sort(array);
        return array;
    }
}
