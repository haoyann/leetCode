package jianzhioffer.step11;

/**
 * 1、遍历数组 O(N)
 * 2、二分查找 log(N)
 */
public class Solution {
    // [3,4,5,1,2]
    public int minArray(int[] numbers) {

        if (numbers.length == 0) {
            return 0;
        }

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
