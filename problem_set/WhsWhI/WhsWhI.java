
```
// @Title: 最长连续序列 (最长连续序列)
// @Author: robert.sunq
// @Date: 2023-08-06 21:23:52
// @Runtime: 257 ms
// @Memory: 53.1 MB

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            // 存在比当前数值在小一位的数字， 则不需要重复计算，其被包含在小一位的序列长度中
            if (!numSet.contains(num - 1)) {
                int cur = num;
                int curAns = 1;
                while (numSet.contains(cur + 1)) {
                    cur++;
                    curAns++;
                }
                ans = Math.max(ans, curAns);
            }
        }

        return ans;

    }
}
