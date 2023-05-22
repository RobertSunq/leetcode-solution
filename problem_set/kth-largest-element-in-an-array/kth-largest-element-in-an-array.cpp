
```
// @Title: 数组中的第K个最大元素 (Kth Largest Element in an Array)
// @Author: robert.sunq
// @Date: 2020-05-13 19:03:00
// @Runtime: 36 ms
// @Memory: 9.6 MB

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {

        sort(nums.begin(),nums.end());
        int res = -1;
        int n = nums.size();
        if(k<=0 || k>n) return res;
        return nums[n-k];
        

    }
};
