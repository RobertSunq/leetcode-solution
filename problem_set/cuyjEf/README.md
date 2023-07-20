
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 071. 按权重生成随机数](https://leetcode.cn//problems/cuyjEf/)

## 题目描述

<p>给定一个正整数数组&nbsp;<code>w</code> ，其中&nbsp;<code>w[i]</code>&nbsp;代表下标 <code>i</code>&nbsp;的权重（下标从 <code>0</code> 开始），请写一个函数&nbsp;<code>pickIndex</code>&nbsp;，它可以随机地获取下标 <code>i</code>，选取下标 <code>i</code>&nbsp;的概率与&nbsp;<code>w[i]</code>&nbsp;成正比。</p>

<ol>
</ol>

<p>例如，对于 <code>w = [1, 3]</code>，挑选下标 <code>0</code> 的概率为 <code>1 / (1 + 3)&nbsp;= 0.25</code> （即，25%），而选取下标 <code>1</code> 的概率为 <code>3 / (1 + 3)&nbsp;= 0.75</code>（即，75%）。</p>

<p>也就是说，选取下标 <code>i</code> 的概率为 <code>w[i] / sum(w)</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>
inputs = [&quot;Solution&quot;,&quot;pickIndex&quot;]
inputs = [[[1]],[]]
<strong>输出：</strong>
[null,0]
<strong>解释：</strong>
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>
inputs = [&quot;Solution&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;,&quot;pickIndex&quot;]
inputs = [[[1,3]],[],[],[],[],[]]
<strong>输出：</strong>
[null,1,1,1,1,0]
<strong>解释：</strong>
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
诸若此类。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= w.length &lt;= 10000</code></li>
	<li><code>1 &lt;= w[i] &lt;= 10^5</code></li>
	<li><code>pickIndex</code>&nbsp;将被调用不超过&nbsp;<code>10000</code>&nbsp;次</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 528&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/random-pick-with-weight/">https://leetcode-cn.com/problems/random-pick-with-weight/</a></p>


## 题解


### Java

```Java
// @Title: 按权重生成随机数 (按权重生成随机数)
// @Author: robert.sunq
// @Date: 2023-07-17 22:46:59
// @Runtime: 24 ms
// @Memory: 46.8 MB

class Solution {
    int[] preSum;
    Random ran;
    int n;

    public Solution(int[] w) {
        ran = new Random();
        n = w.length;
        preSum = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int r = ran.nextInt(preSum[n]);
        // 在前缀和数组中，查找随机数，  注意 r 属于前缀和数组中 [a[i - 1], a[i]) ， 是在下标 i 的概率范围
        int a = searchInsert(preSum, r);
        // 注意，返回的是下标
        return a - 1;
    }

    private int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int tmp = 0;
        while (start <= end) {
            tmp = (start + end) /2;
            if (nums[tmp] == target) {
                return tmp + 1;
            } else if (nums[tmp] > target) {
                end = tmp - 1;
            } else {
                start = tmp + 1;
            }
        }
        return nums[tmp] < target ? tmp + 1: tmp;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [数学](https://leetcode.cn//tag/math)
- [二分查找](https://leetcode.cn//tag/binary-search)
- [前缀和](https://leetcode.cn//tag/prefix-sum)
- [随机化](https://leetcode.cn//tag/randomized)

## 相似题目


