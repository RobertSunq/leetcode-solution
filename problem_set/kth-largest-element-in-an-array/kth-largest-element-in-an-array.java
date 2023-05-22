
```
// @Title: 数组中的第K个最大元素 (Kth Largest Element in an Array)
// @Author: robert.sunq
// @Date: 2021-06-30 22:26:59
// @Runtime: 10 ms
// @Memory: 39.1 MB

class Solution {
    int K;
    // 冒泡排序
    public int findKthLargest(int[] nums, int k) {
        K = k;
        recur(nums,0,nums.length-1);
        return nums[k-1];
    }
    // 采用快速排序每次确定一个元素位置 来  剪枝
    void recur(int[] nums,int start,int end){
        if ( end <= start) return;
        // 哨兵
        int temp = nums[start];
        int i = start;
        int j = end;
        while(i<j){
            while(j>i && nums[j] <= temp) j--;
            if(j>i) nums[i] = nums[j];
            while(j>i && nums[i] > temp) i++;
            if(j>i) nums[j] = nums[i];
        }
        nums[i] = temp;
        // 此时 哨兵就是 第k个元素
        if(i == K-1) return ;
        else if(i < K-1){
            // 则第K个大 肯定在后半段中
            recur(nums,i+1,end);
        } else{
            // 否则 在前半段中
            recur(nums,start,i-1);
        }
        
    }
}
