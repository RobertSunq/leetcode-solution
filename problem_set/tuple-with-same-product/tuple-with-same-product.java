
```
// @Title: 同积元组 (Tuple with Same Product)
// @Author: robert.sunq
// @Date: 2023-10-19 22:58:36
// @Runtime: 176 ms
// @Memory: 60.9 MB

class Solution {
    public int tupleSameProduct(int[] nums) {

        // 注意，这里基于 a != b != c != d
        
        // 假设有四个数 a * b = c * d, 此时不同的组合方式有 8 种
        // 假设先找到了一个组 a * b = sum, 数组中其他元素选取两个 乘积为 sum， 就可以和已有的组合成一对
        // 所以，可以记乘积为 sum 的数组对的个数为 cnt 个，那么从者写组合种随机选取 2 组，就可以组成符合题意的元组
        // 那么 和为 sum 的这些数组对可以组合的结果有 (cnt * (cnt - 1)) / 2 * 8 = (cnt * (cnt - 1)) * 4


        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = nums[i] * nums[j];
                cnt.put(tmp, cnt.getOrDefault(tmp, 0) + 1);
            }
        }

        for (Integer value : cnt.values()) {
            ans = ans + (value * (value - 1)) * 4;
        }

        return ans;
    }
}
