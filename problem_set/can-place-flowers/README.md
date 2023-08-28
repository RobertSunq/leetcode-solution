
| [English](README_EN.md) | 简体中文 |

# [605. 种花问题](https://leetcode.cn//problems/can-place-flowers/)

## 题目描述

<p>假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。</p>

<p>给你一个整数数组&nbsp;<code>flowerbed</code> 表示花坛，由若干 <code>0</code> 和 <code>1</code> 组成，其中 <code>0</code> 表示没种植花，<code>1</code> 表示种植了花。另有一个数&nbsp;<code>n</code><strong> </strong>，能否在不打破种植规则的情况下种入&nbsp;<code>n</code><strong>&nbsp;</strong>朵花？能则返回 <code>true</code> ，不能则返回 <code>false</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>flowerbed = [1,0,0,0,1], n = 1
<strong>输出：</strong>true
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>flowerbed = [1,0,0,0,1], n = 2
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= flowerbed.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>flowerbed[i]</code> 为 <code>0</code> 或 <code>1</code></li>
	<li><code>flowerbed</code> 中不存在相邻的两朵花</li>
	<li><code>0 &lt;= n &lt;= flowerbed.length</code></li>
</ul>

## 题解


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



## 相关话题

- [贪心](https://leetcode.cn//tag/greedy)
- [数组](https://leetcode.cn//tag/array)

## 相似题目


- [提莫攻击](../teemo-attacking/README.md)
- [行星碰撞](../asteroid-collision/README.md)