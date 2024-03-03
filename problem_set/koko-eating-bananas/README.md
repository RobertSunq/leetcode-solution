
| [English](README_EN.md) | 简体中文 |

# [875. 爱吃香蕉的珂珂](https://leetcode.cn//problems/koko-eating-bananas/)

## 题目描述

<p>珂珂喜欢吃香蕉。这里有 <code>n</code> 堆香蕉，第 <code>i</code> 堆中有&nbsp;<code>piles[i]</code>&nbsp;根香蕉。警卫已经离开了，将在 <code>h</code> 小时后回来。</p>

<p>珂珂可以决定她吃香蕉的速度 <code>k</code> （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 <code>k</code> 根。如果这堆香蕉少于 <code>k</code> 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。&nbsp;&nbsp;</p>

<p>珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。</p>

<p>返回她可以在 <code>h</code> 小时内吃掉所有香蕉的最小速度 <code>k</code>（<code>k</code> 为整数）。</p>

<p>&nbsp;</p>

<ul>
</ul>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>piles = [3,6,7,11], h = 8
<strong>输出：</strong>4
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>piles = [30,11,23,4,20], h = 5
<strong>输出：</strong>30
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>piles = [30,11,23,4,20], h = 6
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 题解


### Java

```Java
// @Title: 爱吃香蕉的珂珂 (Koko Eating Bananas)
// @Author: robert.sunq
// @Date: 2023-09-18 22:09:45
// @Runtime: 7 ms
// @Memory: 42.8 MB

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, min = 1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int ans = max;
        // max 就是最快速度，即 每次吃最大堆的
        while (min < max) { // 注意不能相等， 否则可能会两者相等而进入死循环
            int mid = min + (max - min) / 2;
            if (getTime(piles, mid) <= h) {
                ans = mid;
                // 注意这里, 可以吃完的时候，将最大速度降低到当前的中值
                max = mid;
            } else {
                // 最小速度一步步提升，避免遗漏
                min = mid + 1;
            }
        }

        return ans;
    }

    private int getTime(int[] piles, int speed) {
        int ans = 0;
        for (int pile : piles) {
            ans = ans + (pile + speed - 1) / speed; // 注意这里如何做除法向上取整的
        }
        return ans;
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [二分查找](https://leetcode.cn//tag/binary-search)

## 相似题目


- [最小化去加油站的最大距离](../minimize-max-distance-to-gas-station/README.md)
