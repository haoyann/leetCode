package jianzhioffer.step42;


public class Solution {

    public int maxSubArray(int[] nums) {
        // dp[i] = max(i,dp[i-1]+i);
        int max = nums[0];

        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            pre = Math.max(nums[i],pre+nums[i]);
            if(max < pre){
                max = pre;
            }
        }

        return max;

    }
}
