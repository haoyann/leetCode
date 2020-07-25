package jianzhioffer.step45;

/**
 * 将数组按照规则升序排序
 *  if "a" +"b" > "b"+"a"   a > b
 *
 */
public class Solution {
    public String minNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);

        String res = "";
        for(int i =0; i < nums.length; i++){
            res+=String.valueOf(nums[i]);
        }
        return res;
    }

    private  void quickSort(int[] arr,int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int target = arr[left];

        while(i < j){
            while(i<j && compareTo(arr[j],target)>=0) j--;
            while(i<j && compareTo(arr[i],target)<=0) i++;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[i];
        arr[i] = target;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }

    private int compareTo(int a,int b){
        String s1 = String.valueOf(a)+String.valueOf(b);
        String s2 = String.valueOf(b)+String.valueOf(a);
        return s1.compareTo(s2);
    }
}
