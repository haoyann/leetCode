package jianzhioffer.step16;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、循环n次，乘自身 O(N)
 * 2、 分治 3^6  = 3^3*3^3  O(logN)
 */
public class Solution {


    public double myPow(double x, int n) {

        Map<Integer,Double> mem = new HashMap<>();
        mem.put(0,1.0);
        mem.put(1,x);
        double res = dfs(x,n > 0 ? n : - n ,mem);
        return n > 0 ? res: 1/res;
    }

    private double dfs(double x, int n,Map<Integer,Double> mem){
        if (mem.containsKey(n)){
            return mem.get(n);
        }

        double res;
        if (n % 2 == 0) {
            res =  dfs(x, n / 2,mem) * dfs(x, n / 2,mem);
        }else {
            res = dfs(x, n / 2,mem) * dfs(x, n / 2,mem) * x;
        }
        mem.put(n,res);
        return res;
    }



}
