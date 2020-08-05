package jianzhioffer.step62;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、模拟删除
 * 2、数学
 */
public class Solution {

    public int lastRemaining(int n, int m) {
        int res = 0;
        for(int i = 2; i <=n; i++){
            res = (res+m)%i;
        }

        return res;
    }

//    public int lastRemaining(int n, int m) {
//        List<Integer> res = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            res.add(i);
//        }
//        int index = 0;
//        while (n > 1){
//            index = (index+m-1)%n;
//            res.remove(index);
//            n--;
//        }
//        return res.get(0);
//    }
}
