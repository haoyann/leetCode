package jianzhioffer.step21;

/**
 * 用两个指针分别代表奇偶
 * 从数组左右两边同时扫描
 * 发现不同交换位置
 */
public class Solution {

    public int[] exchange(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }

        int odd = 0;
        int even = nums.length-1;

        while(odd<even){
            while(nums[odd]%2 == 1 && odd<even){
                odd ++;
            }
            while(nums[even]%2 == 0 && odd<even){
                even --;
            }
            //交换
            int temp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = temp;
            odd++;
            even--;
        }
        return nums;

    }
}
