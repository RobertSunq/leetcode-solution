
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 010. 和为 k 的子数组](https://leetcode.cn//problems/QTMn0o/)

## 题目描述

<p>给定一个整数数组和一个整数&nbsp;<code>k</code><strong> ，</strong>请找到该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的连续子数组的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong>nums = [1,1,1], k = 2
<strong>输出:</strong> 2
<strong>解释:</strong> 此题 [1,1] 与 [1,1] 为两种不同的情况
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong>nums = [1,2,3], k = 3
<strong>输出:</strong> 2
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li>
	<p><code>-10<sup>7</sup>&nbsp;&lt;= k &lt;= 10<sup>7</sup></code></p>
	</li>
</ul>

<p>&nbsp;</p>

<p>注意：本题与主站 560&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">https://leetcode-cn.com/problems/subarray-sum-equals-k/</a></p>


## 题解


### Java

```Java
// @Title: 和为 k 的子数组 (和为 k 的子数组)
// @Author: robert.sunq
// @Date: 2023-06-06 23:51:29
// @Runtime: 1034 ms
// @Memory: 43.9 MB

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        // sums 中 i 表示前 i 个数的和
        for(int i = 1 ; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        // 以每个数字为基准，直接遍历查找和位k的数字
        for (int i = 0; i < sums.length;i++) {
            int target = k + sums[i];
            for ( int j = i+1; j < sums.length; j++) {
                if (target == sums[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [前缀和](https://leetcode.cn//tag/prefix-sum)

## 相似题目



