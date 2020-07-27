package jianzhioffer.step53II;


public class Solution {

    public int missingNumber(int[] nums) {
        int index = binarySearch(nums);
        return index+1;
    }

    private int binarySearch(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == mid){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return right;

    }
}
