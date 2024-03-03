
```
// @Title: 咒语和药水的成功对数 (Successful Pairs of Spells and Potions)
// @Author: robert.sunq
// @Date: 2023-11-10 21:41:39
// @Runtime: 49 ms
// @Memory: 55.2 MB

class Solution {

    // 对 pontions 排序， 然后利用二分法，找到 potinons 中最小满足 spell * potion >= success
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            // 这里必须初始化，因为可能没有满足需求的，所以有个默认值进行计算
            int index = m;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                long sum = 1L * spells[i] * potions[mid];
                if (sum >= success) {
                    right = mid - 1;
                    index = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 注意这里计算个数的方式， m 是整个长度， index 是下标
            ans[i] = m - index;
        }
        return ans;
    }
}
