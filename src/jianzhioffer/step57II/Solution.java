package jianzhioffer.step57II;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> window = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < target; i++) {
            sum += i;
            window.add(i);
            //需要将窗口中的数字依次弹出
            while (sum > target && window.size() > 0) {
                Integer first = window.remove(0);
                sum -= first;
            }

            //窗口中数据与目标相等
            if (sum == target) {
                res.add(new ArrayList<>(window));
            }

        }

        int[][] resArray = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] arr = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                arr[j] = res.get(i).get(j);
            }
            resArray[i] = arr;
        }

        return resArray;
    }
}
