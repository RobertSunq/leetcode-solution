
```
// @Title: 缺失的第一个正数 (First Missing Positive)
// @Author: robert.sunq
// @Date: 2021-07-11 21:25:09
// @Runtime: 3 ms
// @Memory: 94 MB

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i  = 0;
        // 使用元素自身作为hash表
        // 将元素 i位置放上数字 i + 1;
        // 
        while (i < nums.length){
            // 只处理可以映射到 nums上的正整数，因为大于nums.length的 其最小正整数肯定小于数组长度
            if(nums[i] < 1 || nums[i] > nums.length || nums[i] -1 == i || nums[nums[i] -1] == nums[i]){
                i++;
                continue;
            }
            // 将nums[i] 放到nums[ nums[i] - 1] 上
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp; 
        }
        i = 0;
        // 此时 再数据中，value和下标不对应的 就是第一个最小正整数
        while(i < nums.length){
            if(nums[i] -1 != i){
                return i+1;
            }
            i++;
        }
        return i+1;
    }
}
