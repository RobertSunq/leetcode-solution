
| [English](README_EN.md) | 简体中文 |

# [2542. 最大子序列的分数](https://leetcode.cn//problems/maximum-subsequence-score/)

## 题目描述

<p>给你两个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;，两者长度都是&nbsp;<code>n</code>&nbsp;，再给你一个正整数&nbsp;<code>k</code>&nbsp;。你必须从&nbsp;<code>nums1</code>&nbsp;中选一个长度为 <code>k</code>&nbsp;的 <strong>子序列</strong>&nbsp;对应的下标。</p>

<p>对于选择的下标&nbsp;<code>i<sub>0</sub></code>&nbsp;，<code>i<sub>1</sub></code>&nbsp;，...，&nbsp;<code>i<sub>k - 1</sub></code>&nbsp;，你的&nbsp;<strong>分数</strong>&nbsp;定义如下：</p>

<ul>
	<li><code>nums1</code>&nbsp;中下标对应元素求和，乘以&nbsp;<code>nums2</code>&nbsp;中下标对应元素的&nbsp;<strong>最小值</strong>&nbsp;。</li>
	<li>用公式表示：&nbsp;<code>(nums1[i<sub>0</sub>] + nums1[i<sub>1</sub>] +...+ nums1[i<sub>k - 1</sub>]) * min(nums2[i<sub>0</sub>] , nums2[i<sub>1</sub>], ... ,nums2[i<sub>k - 1</sub>])</code>&nbsp;。</li>
</ul>

<p>请你返回 <strong>最大</strong>&nbsp;可能的分数。</p>

<p>一个数组的 <strong>子序列</strong>&nbsp;下标是集合&nbsp;<code>{0, 1, ..., n-1}</code>&nbsp;中删除若干元素得到的剩余集合，也可以不删除任何元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
<b>输出：</b>12
<b>解释：</b>
四个可能的子序列分数为：
- 选择下标 0 ，1 和 2 ，得到分数 (1+3+3) * min(2,1,3) = 7 。
- 选择下标 0 ，1 和 3 ，得到分数 (1+3+2) * min(2,1,4) = 6 。
- 选择下标 0 ，2 和 3 ，得到分数 (1+3+2) * min(2,3,4) = 12 。
- 选择下标 1 ，2 和 3 ，得到分数 (3+3+2) * min(1,3,4) = 8 。
所以最大分数为 12 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
<b>输出：</b>30
<b>解释：</b>
选择下标 2 最优：nums1[2] * nums2[2] = 3 * 10 = 30 是最大可能分数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums1.length == nums2.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums1[i], nums2[j] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>


## 题解


### Java

```Java
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
```



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



