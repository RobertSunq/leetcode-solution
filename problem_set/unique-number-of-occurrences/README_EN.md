
| English | [简体中文](README.md) |

# [1207. Unique Number of Occurrences](https://leetcode.cn//problems/unique-number-of-occurrences/)

## Description

<p>Given an array of integers <code>arr</code>, return <code>true</code> <em>if the number of occurrences of each value in the array is <strong>unique</strong> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,2,1,1,3]
<strong>Output:</strong> true
<strong>Explanation:</strong>&nbsp;The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [-3,0,1,-3,1,1,1,-3,10,0]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>-1000 &lt;= arr[i] &lt;= 1000</code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Hash Table](https://leetcode.cn//tag/hash-table)

## Similar Questions


