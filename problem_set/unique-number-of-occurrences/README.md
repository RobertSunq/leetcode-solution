
| [English](README_EN.md) | 简体中文 |

# [1207. 独一无二的出现次数](https://leetcode.cn//problems/unique-number-of-occurrences/)

## 题目描述

<p>给你一个整数数组&nbsp;<code>arr</code>，请你帮忙统计数组中每个数的出现次数。</p>

<p>如果每个数的出现次数都是独一无二的，就返回&nbsp;<code>true</code>；否则返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [1,2,2,1,1,3]
<strong>输出：</strong>true
<strong>解释：</strong>在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [1,2]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [-3,0,1,-3,1,1,1,-3,10,0]
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length&nbsp;&lt;= 1000</code></li>
	<li><code>-1000 &lt;= arr[i] &lt;= 1000</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 独一无二的出现次数 (Unique Number of Occurrences)
// @Author: robert.sunq
// @Date: 2023-08-22 22:12:52
// @Runtime: 2 ms
// @Memory: 39.3 MB

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int n : arr) {
            numCount.put(n, numCount.getOrDefault(n, 0) + 1);
        }

        Set<Integer> num = new HashSet<>();
        for (int n : numCount.values()) {
            if (num.contains(n)) {
                return false;
            }
            num.add(n);
        }

        return true;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)

## 相似题目



