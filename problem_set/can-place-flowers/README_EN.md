
| English | [简体中文](README.md) |

# [605. Can Place Flowers](https://leetcode.cn//problems/can-place-flowers/)

## Description

<p>You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in <strong>adjacent</strong> plots.</p>

<p>Given an integer array <code>flowerbed</code> containing <code>0</code>&#39;s and <code>1</code>&#39;s, where <code>0</code> means empty and <code>1</code> means not empty, and an integer <code>n</code>, return <code>true</code>&nbsp;<em>if</em> <code>n</code> <em>new flowers can be planted in the</em> <code>flowerbed</code> <em>without violating the no-adjacent-flowers rule and</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 1
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> flowerbed = [1,0,0,0,1], n = 2
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= flowerbed.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>flowerbed[i]</code> is <code>0</code> or <code>1</code>.</li>
	<li>There are no two adjacent flowers in <code>flowerbed</code>.</li>
	<li><code>0 &lt;= n &lt;= flowerbed.length</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 种花问题 (Can Place Flowers)
// @Author: robert.sunq
// @Date: 2023-08-09 22:43:29
// @Runtime: 1 ms
// @Memory: 42.6 MB

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                // 从右侧空位开始， 可用种植的数量为 空位 / 2
                if (prev < 0) {
                    count = count + (i / 2);
                } else {
                    // 非边界， 种植数量为 (空位置 - 1) / 2, 因为最左，最有都无法种植
                    // 空位 (j - i - 1) 
                    count = count + (i - prev - 2) / 2;
                }
                prev = i;
            } 
        }

        // 都是空的
        if (prev < 0) {
            count = count + (m + 1) / 2;
        } else {
            count = count + (m - prev - 1) / 2;
        }

        return count >= n;
    }
}
```



## Related Topics

- [Greedy](https://leetcode.cn//tag/greedy)
- [Array](https://leetcode.cn//tag/array)

## Similar Questions

- [Teemo Attacking](../teemo-attacking/README_EN.md)
- [Asteroid Collision](../asteroid-collision/README_EN.md)
