
```
// @Title: 接雨水 (Trapping Rain Water)
// @Author: robert.sunq
// @Date: 2021-07-01 22:00:29
// @Runtime: 1 ms
// @Memory: 38.2 MB

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        // 记录到当前位置的左侧最大值
        for(int i =0 ;i<len;i++){
            if(i == 0){
                left[i] = height[i];
            }else{
                left[i] = Math.max(left[i-1],height[i]);
            }
        }
        int res = 0;
        int temp = 0;
        int h = 0;
        for(int i = len-1;i>0;i--){
            if(i == len-1){
                temp = height[i];
            }else{
                // 记录到当前位置的右侧最大值
                temp = Math.max(temp,height[i]);
                // 可以接水的最大高度为左右侧的最小值
                h = Math.min(left[i],temp);
                if(h>height[i]){
                    res = res + (h - height[i]);
                }
            }
        }

        return res;
    }
}
