
```
// @Title: 数位和相等数对的最大和 (Max Sum of a Pair With Equal Sum of Digits)
// @Author: robert.sunq
// @Date: 2023-11-18 21:44:17
// @Runtime: 44 ms
// @Memory: 55 MB

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int n : nums) {
            int len = getLength(n);
            int[] tmp = map.getOrDefault(len, new int[]{0, 0});
            int max1 = n, max2 = tmp[0];
            if (max1 < max2) {
                int t = max1;
                max1 = max2;
                max2 = t;
            }
            tmp[0] = max1;

            max1 = tmp[1];
            if (max1 < max2) {
                int t = max1;
                max1 = max2;
                max2 = t;
            }
            tmp[1] = max1;

            map.put(len, tmp);
        }


        int ans = -1;
        for (int[] tmp : map.values()) {
            if (tmp[0] == 0 || tmp[1] == 0) {
                continue;
            }
            ans = Math.max(ans, tmp[0] + tmp[1]);
        }

        return ans;
    }

    private int getLength(int num) {
        int ans = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            ans += (c - '0');
        }
        return ans;
    }
}
