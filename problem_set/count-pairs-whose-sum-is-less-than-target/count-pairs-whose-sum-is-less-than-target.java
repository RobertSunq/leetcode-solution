
```
// @Title: 统计和小于目标的下标对数目 (Count Pairs Whose Sum is Less than Target)
// @Author: robert.sunq
// @Date: 2023-11-24 21:06:58
// @Runtime: 2 ms
// @Memory: 40.5 MB

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
