package jianzhioffer.step39;


import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}
