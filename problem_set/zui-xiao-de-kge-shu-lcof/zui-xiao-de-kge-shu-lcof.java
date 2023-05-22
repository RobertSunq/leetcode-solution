
```
// @Title: 最小的k个数 (最小的k个数  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-28 23:20:13
// @Runtime: 814 ms
// @Memory: 39.9 MB

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 冒泡排序法，将最小值放到后面，排序K次即可
        int len = arr.length;
        // 冒泡排序K次
        for (int i = 1;i<=k;i++){
            // 注意，这里采用 j 与 j+1 比较 故I从1开始
            for(int j=0;j<len-i;j++){
                if(arr[j] < arr[j+1]){
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 取后K位即可
        int[] res = new int[k];
        while(k > 0){
            res[k-1] = arr[len-k];
            k--;
        }
        return res;
    }
}
