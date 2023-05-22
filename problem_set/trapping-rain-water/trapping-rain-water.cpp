
```
// @Title: 接雨水 (Trapping Rain Water)
// @Author: robert.sunq
// @Date: 2020-05-13 14:54:01
// @Runtime: 8 ms
// @Memory: 6.8 MB

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        if (n<3) return 0; 
        vector<int> left(n,0),right(n,0);
        for(int i=1;i<n-1;i++){
            left[i] = max(left[i-1],height[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = max(right[i+1],height[i+1]);
        }
        int sum = 0;
        for(int i=1;i<n-1;i++){
            int temp = min(right[i],left[i]);
            if(temp > height[i])
                sum = sum+temp-height[i];
        }
        return sum;
    }
};
