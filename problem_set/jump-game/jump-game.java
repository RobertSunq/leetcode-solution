
```
// @Title: 跳跃游戏 (Jump Game)
// @Author: robert.sunq
// @Date: 2021-06-04 22:40:47
// @Runtime: 3 ms
// @Memory: 39.8 MB

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int res = 0;
        for(int i= 0;i<len;i++){
            // 当前位置可以到达的最大位置， 为I+ nums[i] 或者别的模块的最大值
            res= Math.max(res,i+nums[i]);
            // res <= i 则表示最远只能到达I 如果此时I到最后位置，则表示到达不返回false  
            if(res <= i && i<len-1){
                return false;
            }
        }
        // 可以走出循环则代表可以走到最后
        return true;
    }
}
