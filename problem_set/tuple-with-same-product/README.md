
| [English](README_EN.md) | 简体中文 |

# [1726. 同积元组](https://leetcode.cn//problems/tuple-with-same-product/)

## 题目描述

<p>给你一个由 <strong>不同</strong> 正整数组成的数组 <code>nums</code> ，请你返回满足&nbsp;<code>a * b = c * d</code> 的元组<em> </em><code>(a, b, c, d)</code><em> </em>的数量。其中 <code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> 都是 <code>nums</code> 中的元素，且 <code>a != b != c != d</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,4,6]
<strong>输出：</strong>8
<strong>解释：</strong>存在 8 个满足题意的元组：
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,4,5,10]
<strong>输出：</strong>16
<strong>解释：</strong>存在 16 个满足题意的元组：
(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
</ul>


## 题解


### Java

```Java
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
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [计数](https://leetcode.cn//tag/counting)

## 相似题目



