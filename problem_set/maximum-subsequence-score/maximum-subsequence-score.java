
```
// @Title: 最大子序列的分数 (Maximum Subsequence Score)
// @Author: robert.sunq
// @Date: 2023-09-14 23:03:46
// @Runtime: 74 ms
// @Memory: 60.2 MB

class Solution {
    /**
    有约束，多维求最佳常用的一种方式。其中 A 可以是 除法/加法等，B 为单个元素（最大/最小值）
    1. 让 B 保持和题目最佳渐远的方式变化，比如题目要最大值，那么就降序
    2. 每次移除 A 中的最差结果，换一个更好的结果，也就是在 B 变差的情况下，A需要变好，才能让答案更优
    3. 比较获得最优解
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long ans = 0L;
        Integer[] sorts = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorts[i] = i;
        }
        // 按照 num2 的大小降序排列，将 下标 记录
        Arrays.sort(sorts, (a, b) -> nums2[b] - nums2[a]);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0L;
        // 排序后的 sorts 前 k 个值和保留， 此时，可知道 nums2 序列k 的最小值为 nums2[sorts[k-1]]
        // 相当于固定了 序列2 选取的最小值
        for (int i = 0; i < k - 1 ; i++) {
            sum += nums1[sorts[i]];
            q.offer(nums1[sorts[i]]);
        }

        for (int i = k - 1; i < n; i++) {
            sum += nums1[sorts[i]];
            q.offer(nums1[sorts[i]]);
            ans = Math.max(ans, nums2[sorts[i]] * sum);
            // 移除，nums1（sort[j....k]）和中的最小的一个，这样下一轮的时候，新的和才可能更大
            // 注意区分，这里时移除num1 中的元素， sorts是比较nums2的降序，向后走， nums2 的k个数最小的数是新的
            // 但是对于 nums1 来说， 不是按照sorts排序的，所以下一个元素可能比现在的 k 个数最小值，大小不确定

            // 还有，为什么要在这里先移除最小值，因为到下一轮，使用 sorts[i + 1] 作为乘数，则nums1 中选取出来的序列也要包含下标 sorts[i+1]
            sum  -= q.poll();
        }

        return ans;
    }
}
