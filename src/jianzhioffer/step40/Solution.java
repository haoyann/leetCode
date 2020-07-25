package jianzhioffer.step40;

/**
 * 1、排序
 * 2、小顶堆
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0 || arr.length==0){
            return new int[0];
        }
        quickSort(arr);

        int[] res = new int[k];
        for(int i =0; i < k; k++){
            res[i] = arr[i];
        }
        return res;
    }

    private  void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private  void quickSort(int[] arr,int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int target = arr[left];

        while(i < j){
            while(i<j && arr[j] >= target) j--;
            while(i<j && arr[i] <= target) i++;
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
}
