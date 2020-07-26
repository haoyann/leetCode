package jianzhioffer.step53;

import sun.misc.LRUCache;

/**
 * 使用二分查找分别找左边界、右边界
 */
public class Solution {
    public int search(int[] nums, int target) {
        int right = findRight(nums,target);
        if (right > 0 && nums[right-1] != target){
            return 0;
        }
        int left = findLeft(nums,target);
        return right - left - 1;
    }

    private int findRight(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] <= target){
                left = mid +1;
            }else  if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return left;
    }


    private int findLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] >= target){
                right = mid -1;
            }else  if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return right;
    }
}
