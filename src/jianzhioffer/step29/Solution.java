package jianzhioffer.step29;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m -1;
        int[] res = new int[m*n];
        int resCount = 0;
        int times = m%2 == 0 ? m/2 : m/2+1;
        for(int i = 0; i < times; i++){
            //左到右
            if(left <= right &&resCount!=m*n){
                for(int j=left; j <= right; j++){
                    res[resCount] = matrix[up][j];
                    resCount++;
                }
                up++;
            }
            //上到下
            if(up<=down &&resCount!=m*n){
                for(int j=up; j <= down; j++){
                    res[resCount] = matrix[j][right];
                    resCount++;
                }
                right--;
            }
            //右到左
            if(left <= right &&resCount!=m*n){
                for(int j=right; j >= left; j--){
                    res[resCount] = matrix[down][j];
                    resCount++;
                }
                down--;
            }
            //下到上
            if(up<=down &&resCount!=m*n){
                for(int j=down; j >= up; j--){
                    res[resCount] = matrix[j][left];
                    resCount++;
                }
                left++;
            }
        }
        return res;
    }
}
