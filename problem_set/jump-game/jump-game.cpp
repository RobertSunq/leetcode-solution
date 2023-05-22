
```
// @Title: 跳跃游戏 (Jump Game)
// @Author: robert.sunq
// @Date: 2020-05-13 00:26:46
// @Runtime: 20 ms
// @Memory: 12.7 MB

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int k=0;
        for (int i=0;i<nums.size();i++){
            if (i>k) return false;
            k = max(k,i+nums[i]);
        }
        return true;

    }
};
