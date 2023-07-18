
```
// @Title: 数组中的第 k 大的数字 (数组中的第 k 大的数字)
// @Author: robert.sunq
// @Date: 2023-07-18 23:29:35
// @Runtime: 6 ms
// @Memory: 41.6 MB

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.offer(n);
        }

        int n = nums.length;
        while (n-- > k) {
            q.poll();
        }

        return q.peek();
    }
}
