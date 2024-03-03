
| English | [简体中文](README.md) |

# [2342. Max Sum of a Pair With Equal Sum of Digits](https://leetcode.cn//problems/max-sum-of-a-pair-with-equal-sum-of-digits/)

## Description

<p>You are given a <strong>0-indexed</strong> array <code>nums</code> consisting of <strong>positive</strong> integers. You can choose two indices <code>i</code> and <code>j</code>, such that <code>i != j</code>, and the sum of digits of the number <code>nums[i]</code> is equal to that of <code>nums[j]</code>.</p>

<p>Return <em>the <strong>maximum</strong> value of </em><code>nums[i] + nums[j]</code><em> that you can obtain over all possible indices </em><code>i</code><em> and </em><code>j</code><em> that satisfy the conditions.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [18,43,36,13,7]
<strong>Output:</strong> 54
<strong>Explanation:</strong> The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,12,19,14]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no two numbers that satisfy the conditions, so we return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)
- [Sorting](https://leetcode.cn//tag/sorting)
- [Heap (Priority Queue)](https://leetcode.cn//tag/heap-priority-queue)

## Similar Questions


