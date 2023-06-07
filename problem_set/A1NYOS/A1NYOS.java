
```
// @Title: 0 和 1 个数相同的子数组 (0 和 1 个数相同的子数组)
// @Author: robert.sunq
// @Date: 2023-06-08 00:45:20
// @Runtime: 44 ms
// @Memory: 52.8 MB

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // 记录前 i 位和 -> i
        Map<Integer, Integer> pre = new HashMap<>();

        int preSum = 0;
        int ans = 0;
        // 这样初始化的原因在于，  初始时，前 i 位 和为 0 时的 i 的索引为 -1; 这样遇到后续第一次出现和为0时的j位时， j - (-1) 就是这个序列的长度
        pre.put(0, -1);
        for (int i = 0; i < n; i++) {
            int tmp = nums[i] > 0 ? 1 : -1;
            // 依据解析 https://leetcode.cn/problems/QTMn0o/solution/he-wei-k-de-zi-shu-zu-by-leetcode-soluti-1169/
            // 设 pre[i] 为 前 i 位和， [j, i] 的序列和为 k
            // 则 pre[j - 1] + k = pre[i]  ---> pre[i] - k = pre[j - 1] 
            // 使用 map 来保存这前序和到最初的 j - 1 的索引， 这样 使用 [j, i] 的长度就可以使用 i 来计算， i - j - 1
            // 即 i - map(pre[i] - k)， 设置 k = 0， 简化为 序列长度  ans = i - map(pre[i] )
            preSum = preSum + tmp;
            if (pre.containsKey(preSum)) {
                ans = max(ans, i - pre.get(preSum));
            }
            pre.put(preSum, pre.getOrDefault(preSum, i));
        }
        return ans;
    }
    private int max(int a, int b) {
        return a > b? a:b;
    }
}
