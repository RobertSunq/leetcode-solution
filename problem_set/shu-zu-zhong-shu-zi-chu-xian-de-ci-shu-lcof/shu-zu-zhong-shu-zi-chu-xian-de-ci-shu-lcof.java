
```
// @Title: 数组中数字出现的次数 (数组中数字出现的次数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 18:34:46
// @Runtime: 2 ms
// @Memory: 40.2 MB

class Solution {
    public int[] singleNumbers(int[] nums) {
        int k=0;
        for (int i =0 ;i<nums.length;i++){
            k = k^nums[i];
        }
        int d = 1;
        // 找到两个数第一位不相等的数位
        while(( k&d ) == 0) d = d<<1;
        // 第一类，
        int a = 0;
        // 第二类
        int b = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & d) == 0){
                a = a^nums[i];
            }else{
                b = b^nums[i];
            }
        }
        return new int[]{a,b};
    }
}
