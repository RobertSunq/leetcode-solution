
```
// @Title: 跳跃游戏 II (Jump Game II)
// @Author: robert.sunq
// @Date: 2020-05-13 00:35:31
// @Runtime: 8 ms
// @Memory: 7.7 MB

class Solution {
public:
    int jump(vector<int>& nums) {
        int ans = 0;
        int star = 0;
        int end = 1;
        while(end<nums.size()){
            int temp = 0;
            for(int i = star ; i<end;i++){
                temp = max(i+nums[i],temp);
            }
            star = end;
            end = temp+1;
            ans++;
        }
        return ans;
    }
};
