
| English | [简体中文](README.md) |

# [461. Hamming Distance](https://leetcode.cn//problems/hamming-distance/)

## Description

<p>The <a href="https://en.wikipedia.org/wiki/Hamming_distance" target="_blank">Hamming distance</a> between two integers is the number of positions at which the corresponding bits are different.</p>

<p>Given two integers <code>x</code> and <code>y</code>, return <em>the <strong>Hamming distance</strong> between them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> x = 1, y = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong>
1   (0 0 0 1)
4   (0 1 0 0)
       &uarr;   &uarr;
The above arrows point to positions where the corresponding bits are different.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> x = 3, y = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;=&nbsp;x, y &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 汉明距离 (Hamming Distance)
// @Author: robert.sunq
// @Date: 2021-06-21 22:39:09
// @Runtime: 0 ms
// @Memory: 35.4 MB

class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        while(temp!=0){
            res += (temp & 1);
            temp >>= 1;
        }
        return res;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)

## Similar Questions

- [Number of 1 Bits](../number-of-1-bits/README_EN.md)
- [Total Hamming Distance](../total-hamming-distance/README_EN.md)
