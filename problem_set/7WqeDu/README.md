
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 057. 值和下标之差都在给定的范围内](https://leetcode.cn//problems/7WqeDu/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> 和两个整数&nbsp;<code>k</code> 和 <code>t</code> 。请你判断是否存在 <b>两个不同下标</b> <code>i</code> 和 <code>j</code>，使得&nbsp;<code>abs(nums[i] - nums[j]) &lt;= t</code> ，同时又满足 <code>abs(i - j) &lt;= k</code><em> </em>。</p>

<p>如果存在则返回 <code>true</code>，不存在返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,1], k<em> </em>= 3, t = 0
<strong>输出：</strong>true</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,1,1], k<em> </em>=<em> </em>1, t = 2
<strong>输出：</strong>true</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,9,1,5,9], k = 2, t = 3
<strong>输出：</strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= t &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 220&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/contains-duplicate-iii/">https://leetcode-cn.com/problems/contains-duplicate-iii/</a></p>


## 题解


### Java

```Java
// @Title: 值和下标之差都在给定的范围内 (值和下标之差都在给定的范围内)
// @Author: robert.sunq
// @Date: 2023-07-11 22:45:07
// @Runtime: 33 ms
// @Memory: 44 MB

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (n < 2 || k == 0) {
            return false;
        }
        // 只保留 [x - t, x + t] 的数据
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // 从排序数组中查找大于或等于的数据。  找到大于下限的数据
            Long tmp = set.ceiling((long) nums[i] - (long) t );
            
            // 找到了，检查数据 是否满足小于上线，否则不符合题意
            if (tmp != null && tmp <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 没找到，将当前元素放入有序集合
            set.add((long) nums[i]);

            // 当i大于k之后，再放入元素，要同时删除窗口外的数据
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [桶排序](https://leetcode.cn//tag/bucket-sort)
- [有序集合](https://leetcode.cn//tag/ordered-set)
- [排序](https://leetcode.cn//tag/sorting)
- [滑动窗口](https://leetcode.cn//tag/sliding-window)

## 相似题目



