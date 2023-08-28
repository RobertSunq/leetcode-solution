
| [English](README_EN.md) | 简体中文 |

# [1679. K 和数对的最大数目](https://leetcode.cn//problems/max-number-of-k-sum-pairs/)

## 题目描述

<p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> 。</p>

<p>每一步操作中，你需要从数组中选出和为 <code>k</code> 的两个整数，并将它们移出数组。</p>

<p>返回你可以对数组执行的最大操作数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4], k = 5
<strong>输出：</strong>2
<strong>解释：</strong>开始时 nums = [1,2,3,4]：
- 移出 1 和 4 ，之后 nums = [2,3]
- 移出 2 和 3 ，之后 nums = []
不再有和为 5 的数对，因此最多执行 2 次操作。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,1,3,4,3], k = 6
<strong>输出：</strong>1
<strong>解释：</strong>开始时 nums = [3,1,3,4,3]：
- 移出前两个 3 ，之后nums = [1,4,3]
不再有和为 6 的数对，因此最多执行 1 次操作。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>9</sup></code></li>
	<li><code>1 <= k <= 10<sup>9</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: K 和数对的最大数目 (Max Number of K-Sum Pairs)
// @Author: robert.sunq
// @Date: 2023-08-15 22:08:24
// @Runtime: 47 ms
// @Memory: 55.9 MB

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int num : nums) {
            if (map.get(num) > 0) {
                int tmp = k - num;
                int size = tmp == num ? 1 : 0;
                if (map.containsKey(tmp) && map.get(tmp) > size) {
                    ans++;
                    map.put(num, map.get(num) - 1);
                    map.put(tmp, map.get(tmp) - 1);
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
- [双指针](https://leetcode.cn//tag/two-pointers)
- [排序](https://leetcode.cn//tag/sorting)

## 相似题目



