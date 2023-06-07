
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 011. 0 和 1 个数相同的子数组](https://leetcode.cn//problems/A1NYOS/)

## 题目描述

<p>给定一个二进制数组 <code>nums</code> , 找到含有相同数量的 <code>0</code> 和 <code>1</code> 的最长连续子数组，并返回该子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> nums = [0,1,0]
<strong>输出:</strong> 2
<strong>说明:</strong> [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> 不是 <code>0</code> 就是 <code>1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 525&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contiguous-array/">https://leetcode-cn.com/problems/contiguous-array/</a></p>


## 题解


### Java

```Java
// @Title: 0 和 1 个数相同的子数组 (0 和 1 个数相同的子数组)
// @Author: robert.sunq
// @Date: 2023-06-08 00:45:20
// @Runtime: 44 ms
// @Memory: 52.8 MB

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // 记录前 i 位和 -> i
        Map<Integer, Integer> pre = new HashMap<>();

        int preSum = 0;
        int ans = 0;
        // 这样初始化的原因在于，  初始时，前 i 位 和为 0 时的 i 的索引为 -1; 这样遇到后续第一次出现和为0时的j位时， j - (-1) 就是这个序列的长度
        pre.put(0, -1);
        for (int i = 0; i < n; i++) {
            int tmp = nums[i] > 0 ? 1 : -1;
            // 依据解析 https://leetcode.cn/problems/QTMn0o/solution/he-wei-k-de-zi-shu-zu-by-leetcode-soluti-1169/
            // 设 pre[i] 为 前 i 位和， [j, i] 的序列和为 k
            // 则 pre[j - 1] + k = pre[i]  ---> pre[i] - k = pre[j - 1] 
            // 使用 map 来保存这前序和到最初的 j - 1 的索引， 这样 使用 [j, i] 的长度就可以使用 i 来计算， i - j - 1
            // 即 i - map(pre[i] - k)， 设置 k = 0， 简化为 序列长度  ans = i - map(pre[i] )
            preSum = preSum + tmp;
            if (pre.containsKey(preSum)) {
                ans = max(ans, i - pre.get(preSum));
            }
            pre.put(preSum, pre.getOrDefault(preSum, i));
        }
        return ans;
    }
    private int max(int a, int b) {
        return a > b? a:b;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目



