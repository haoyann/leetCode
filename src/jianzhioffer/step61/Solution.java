package jianzhioffer.step61;


import java.util.Arrays;

public class Solution {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0){
                zero++;
                continue;
            }
            if (nums[i] == nums[i+1]){
                return false;
            }
            if(nums[i] - nums[i+1] != -1){
                zero -= nums[i+1]-nums[i] -1;
            }
        }
        return zero >= 0;
    }
}
