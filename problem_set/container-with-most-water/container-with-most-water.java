
```
// @Title: 盛最多水的容器 (Container With Most Water)
// @Author: robert.sunq
// @Date: 2021-06-02 00:11:44
// @Runtime: 5 ms
// @Memory: 51.8 MB

class Solution {
    public int maxArea(int[] height) {
        // 双指针， 由两边向内收缩
        int i = 0 , j = height.length -1;
        int res = 0;
        while(i < j){
            // 容量由，两个板子中最低的决定
            res = Math.max(res,Math.min(height[i],height[j])*(j-i));
            // 移动长板子，段板子不动的话，不管移动到哪个位置，整体的高度只能比短板子小，或者相等
            // 因此 移动短板子，使得容量变为可能增大
            // 相等时，移动哪一个都一样
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
