package jianzhioffer.step46;

/**
 * dfs
 * dp dp[i] = dp[i-1]+dp[i-2](大于9小于26)
 */
public class Solution {

    public int translateNum(int num) {

        String n = String.valueOf(num);
        int a = 1;
        int b = 1;
        for (int i = 1; i < n.length(); i++) {
            int twoNum = 0;
            int temp = Integer.valueOf(n.substring(i - 1, i + 1));
            if (temp > 9 && temp < 26 ) {
                twoNum = a;
            }
            a = b;
            b = a + twoNum;

        }
        return b;

    }

    // dfs
//    private int res = 0;
//    public int translateNum(int num) {
//        if(num == 0){
//            return 1;
//        }
//
//        dfs(String.valueOf(num),0);
//        return res;
//    }
//
//    private void dfs(String num,int path){
//        int len = num.length();
//
//        if(len == path){
//            res = res+1;
//            return;
//        }
//
//        if(len - path < 2){
//            dfs(num,path+1);
//        }else{
//            //取一位
//            dfs(num,path+1);
//            //取两位 数字小于等于25大于9
//            int twoNum = Integer.valueOf(num.substring(path,path+2));
//            if(twoNum <= 25 && twoNum > 9){
//                dfs(num,path+2);
//            }
//        }
//
//    }
}
