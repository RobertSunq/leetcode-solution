
```
// @Title: 下一个排列 (Next Permutation)
// @Author: robert.sunq
// @Date: 2021-06-02 23:42:18
// @Runtime: 1 ms
// @Memory: 38.7 MB

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        int j = nums.length-1;
        int k = nums.length-1;
        // 从后往前找到第一队 相对增序 即 nums[i]<nums[j]
        while( i >=0 && nums[i] >= nums[j] ){
            i--;
            j--;
        }
        if(i < 0) {
            recur(nums,0,nums.length-1);
            return;
        }else{
            // 从后往前找到第一个大于nums[i]的数， 及刚刚找到的相对最小的数。
            while(k>=j && nums[i] >= nums[k]){
                k--;
            }
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp; 
            recur(nums,j,nums.length-1);
            return;
        }
    }

    // 反转序列
    void recur(int[] nums,int i,int j ){
        if(i>= j ) return;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }
}
