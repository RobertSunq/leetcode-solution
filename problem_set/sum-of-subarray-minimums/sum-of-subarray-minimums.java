
```
// @Title: 子数组的最小值之和 (Sum of Subarray Minimums)
// @Author: robert.sunq
// @Date: 2023-11-27 22:15:34
// @Runtime: 23 ms
// @Memory: 44.7 MB

class Solution {
    public int sumSubarrayMins(int[] arr) {
        // 即最小元素 i， 
        // 其左边元素都大于等于 arr[i] 的位置为 j
        // 其右侧元素都大于等于 arr[i] 的位置为 k, 则以 arr[i] 为最小值的所有可能为 （i - j） * （k - i）

        // 参考  https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/

        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();

        // 保存到 左右边界 的长度
        int[] left = new int[n];
        int[] right = new int[n];

        // 单调栈
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();

        for(int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        } 

        long ans = 0;
        final int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % mod;
        }

        return (int) ans;

    }
}
