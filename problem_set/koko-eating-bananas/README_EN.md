
| English | [简体中文](README.md) |

# [875. Koko Eating Bananas](https://leetcode.cn//problems/koko-eating-bananas/)

## Description

<p>Koko loves to eat bananas. There are <code>n</code> piles of bananas, the <code>i<sup>th</sup></code> pile has <code>piles[i]</code> bananas. The guards have gone and will come back in <code>h</code> hours.</p>

<p>Koko can decide her bananas-per-hour eating speed of <code>k</code>. Each hour, she chooses some pile of bananas and eats <code>k</code> bananas from that pile. If the pile has less than <code>k</code> bananas, she eats all of them instead and will not eat any more bananas during this hour.</p>

<p>Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.</p>

<p>Return <em>the minimum integer</em> <code>k</code> <em>such that she can eat all the bananas within</em> <code>h</code> <em>hours</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,6,7,11], h = 8
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 5
<strong>Output:</strong> 30
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> piles = [30,11,23,4,20], h = 6
<strong>Output:</strong> 23
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 10<sup>4</sup></code></li>
	<li><code>piles.length &lt;= h &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= piles[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## Solutions


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



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Binary Search](https://leetcode.cn//tag/binary-search)

## Similar Questions

- [Minimize Max Distance to Gas Station](../minimize-max-distance-to-gas-station/README_EN.md)
