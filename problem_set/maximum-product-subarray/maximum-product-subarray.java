
```
// @Title: 乘积最大子数组 (Maximum Product Subarray)
// @Author: robert.sunq
// @Date: 2021-06-12 01:22:32
// @Runtime: 2 ms
// @Memory: 38.2 MB

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len <= 0) return 0;
        int cur = nums[0];
        // 由于有正负，所以保存最大值，最小值。
        int tempMax = 1;
        int tempMin = 1;
        for(int i=0;i<len;i++){
            // 由于负数，会导致最大变最小，最小变最大，所以当前值为负数的时候，交换最大最小
            if (nums[i] < 0){
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }
            // 当前位置最大值，两种状态， 乘以前面的最大值时正收益，否则到这里的最大连续时本身
            tempMax = Math.max(tempMax*nums[i],nums[i]);
            // 最小值同理
            tempMin = Math.min(tempMin*nums[i],nums[i]);
            cur = Math.max(tempMax,cur);
        }

        return cur;

    }
}
