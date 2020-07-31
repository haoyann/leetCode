package jianzhioffer.step59;


public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k+1];

        int max = -1;
        for(int i = 0; i <= nums.length - k ; i++){

            if(i > max){
                max =findMax(i,nums,k+i);
            }
            if(nums[i+k-1] >= nums[max]){
                max = i+k-1;
            }
            res[i] = nums[max];
        }

        return res;
    }

    private int findMax(int start,int[] nums, int k){
        int max = start;
        for(int i = start; i < k; i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        return max;
    }
}
