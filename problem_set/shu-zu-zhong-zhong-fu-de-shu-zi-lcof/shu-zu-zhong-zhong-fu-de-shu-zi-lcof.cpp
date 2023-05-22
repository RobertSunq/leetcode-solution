
```
// @Title: 数组中重复的数字 (数组中重复的数字 LCOF)
// @Author: robert.sunq
// @Date: 2020-03-21 14:46:52
// @Runtime: 88 ms
// @Memory: 29.5 MB

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int len = nums.size();
        map<int ,int> mp;
        for(int i=0;i<len;i++){
            mp[nums[i]]++;
            if(mp[nums[i]] > 1) return nums[i];
        }
        return -1;
        

    }
};
