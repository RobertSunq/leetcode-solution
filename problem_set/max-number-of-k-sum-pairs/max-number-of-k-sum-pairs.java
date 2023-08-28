
```
// @Title: K 和数对的最大数目 (Max Number of K-Sum Pairs)
// @Author: robert.sunq
// @Date: 2023-08-15 22:08:24
// @Runtime: 47 ms
// @Memory: 55.9 MB

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int num : nums) {
            if (map.get(num) > 0) {
                int tmp = k - num;
                int size = tmp == num ? 1 : 0;
                if (map.containsKey(tmp) && map.get(tmp) > size) {
                    ans++;
                    map.put(num, map.get(num) - 1);
                    map.put(tmp, map.get(tmp) - 1);
                }
            }
        }

        return ans;

    }
}
