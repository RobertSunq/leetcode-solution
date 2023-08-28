
| English | [简体中文](README.md) |

# [1732. Find the Highest Altitude](https://leetcode.cn//problems/find-the-highest-altitude/)

## Description

<p>There is a biker going on a road trip. The road trip consists of <code>n + 1</code> points at different altitudes. The biker starts his trip on point <code>0</code> with altitude equal <code>0</code>.</p>

<p>You are given an integer array <code>gain</code> of length <code>n</code> where <code>gain[i]</code> is the <strong>net gain in altitude</strong> between points <code>i</code>​​​​​​ and <code>i + 1</code> for all (<code>0 &lt;= i &lt; n)</code>. Return <em>the <strong>highest altitude</strong> of a point.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> gain = [-5,1,5,0,-7]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> gain = [-4,-3,-2,-1,4,3,2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == gain.length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>-100 &lt;= gain[i] &lt;= 100</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 找到最高海拔 (Find the Highest Altitude)
// @Author: robert.sunq
// @Date: 2023-08-20 22:59:24
// @Runtime: 0 ms
// @Memory: 39 MB

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int hight = 0;
        int n = gain.length;
        for (int i = 0; i < n ; i++) {
            hight = hight + gain[i];
            ans = Math.max(ans, hight);
        }

        return ans;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)

## Similar Questions

