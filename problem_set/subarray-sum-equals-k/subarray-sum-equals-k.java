
```
// @Title: 和为 K 的子数组 (Subarray Sum Equals K)
// @Author: robert.sunq
// @Date: 2021-06-22 00:23:36
// @Runtime: 28 ms
// @Memory: 41.7 MB

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        // Map 用来保存，从0 到当前某一位，期间和 sum 的出现次数
        Map<Integer,Integer> mp = new HashMap<>();
        // mp初始化，即开始循环之前
        mp.put(0,1);
        for(int i =  0 ;i<nums.length;i++){
            // 从零到当前元素的和
            sum  = sum + nums[i];
            // 即之前有 sum - k 这个和的存在n次，则由那n个数字的下标起，到当前数值的和为 k     sum - （sum - k） = k
            res = res + mp.getOrDefault(sum - k , 0);
            // 将当前序列的和保存到Map中
            mp.put(sum,mp.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
