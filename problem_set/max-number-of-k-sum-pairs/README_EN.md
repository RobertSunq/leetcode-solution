
| English | [简体中文](README.md) |

# [1679. Max Number of K-Sum Pairs](https://leetcode.cn//problems/max-number-of-k-sum-pairs/)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>In one operation, you can pick two numbers from the array whose sum equals <code>k</code> and remove them from the array.</p>

<p>Return <em>the maximum number of operations you can perform on the array</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4], k = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,3,4,3], k = 6
<strong>Output:</strong> 1
<strong>Explanation:</strong> Starting with nums = [3,1,3,4,3]:
- Remove the first two 3&#39;s, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Two Pointers](https://leetcode.cn//tag/two-pointers)
- [Sorting](https://leetcode.cn//tag/sorting)

## Similar Questions


