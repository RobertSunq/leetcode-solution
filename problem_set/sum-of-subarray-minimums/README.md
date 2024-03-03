
| [English](README_EN.md) | 简体中文 |

# [907. 子数组的最小值之和](https://leetcode.cn//problems/sum-of-subarray-minimums/)

## 题目描述

<p>给定一个整数数组 <code>arr</code>，找到 <code>min(b)</code> 的总和，其中 <code>b</code> 的范围为 <code>arr</code> 的每个（连续）子数组。</p>

<p>由于答案可能很大，因此<strong> 返回答案模 <code>10^9 + 7</code></strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,1,2,4]
<strong>输出：</strong>17
<strong>解释：
</strong>子数组为<strong> </strong>[3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [11,81,94,43,3]
<strong>输出：</strong>444
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>1 <= arr[i] <= 3 * 10<sup>4</sup></code></li>
</ul>

<p> </p>


## 题解


### Java

```Java
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
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [单调栈](https://leetcode.cn//tag/monotonic-stack)

## 相似题目



