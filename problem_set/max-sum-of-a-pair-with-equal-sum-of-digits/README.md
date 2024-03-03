
| [English](README_EN.md) | 简体中文 |

# [2342. 数位和相等数对的最大和](https://leetcode.cn//problems/max-sum-of-a-pair-with-equal-sum-of-digits/)

## 题目描述

<p>给你一个下标从 <strong>0</strong> 开始的数组 <code>nums</code> ，数组中的元素都是 <strong>正</strong> 整数。请你选出两个下标 <code>i</code> 和 <code>j</code>（<code>i != j</code>），且 <code>nums[i]</code> 的数位和 与&nbsp; <code>nums[j]</code> 的数位和相等。</p>

<p>请你找出所有满足条件的下标 <code>i</code> 和 <code>j</code> ，找出并返回<em> </em><code>nums[i] + nums[j]</code><em> </em>可以得到的 <strong>最大值</strong> <em>。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [18,43,36,13,7]
<strong>输出：</strong>54
<strong>解释：</strong>满足条件的数对 (i, j) 为：
- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
所以可以获得的最大和是 54 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [10,12,19,14]
<strong>输出：</strong>-1
<strong>解释：</strong>不存在满足条件的数对，返回 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 数位和相等数对的最大和 (Max Sum of a Pair With Equal Sum of Digits)
// @Author: robert.sunq
// @Date: 2023-11-18 21:44:17
// @Runtime: 44 ms
// @Memory: 55 MB

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int n : nums) {
            int len = getLength(n);
            int[] tmp = map.getOrDefault(len, new int[]{0, 0});
            int max1 = n, max2 = tmp[0];
            if (max1 < max2) {
                int t = max1;
                max1 = max2;
                max2 = t;
            }
            tmp[0] = max1;

            max1 = tmp[1];
            if (max1 < max2) {
                int t = max1;
                max1 = max2;
                max2 = t;
            }
            tmp[1] = max1;

            map.put(len, tmp);
        }


        int ans = -1;
        for (int[] tmp : map.values()) {
            if (tmp[0] == 0 || tmp[1] == 0) {
                continue;
            }
            ans = Math.max(ans, tmp[0] + tmp[1]);
        }

        return ans;
    }

    private int getLength(int num) {
        int ans = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            ans += (c - '0');
        }
        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [哈希表](https://leetcode.cn//tag/hash-table)
- [排序](https://leetcode.cn//tag/sorting)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



