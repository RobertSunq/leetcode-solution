
| [English](README_EN.md) | 简体中文 |

# [735. 行星碰撞](https://leetcode.cn//problems/asteroid-collision/)

## 题目描述

<p>给定一个整数数组 <code>asteroids</code>，表示在同一行的行星。</p>

<p>对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。</p>

<p>找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [5,10,-5]
<strong>输出：</strong>[5,10]
<b>解释：</b>10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [8,-8]
<strong>输出：</strong>[]
<b>解释：</b>8 和 -8 碰撞后，两者都发生爆炸。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>asteroids = [10,2,-5]
<strong>输出：</strong>[10]
<b>解释：</b>2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= asteroids.length&nbsp;&lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
	<li><code>asteroids[i] != 0</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 行星碰撞 (Asteroid Collision)
// @Author: robert.sunq
// @Date: 2023-08-26 22:01:39
// @Runtime: 1 ms
// @Memory: 43.1 MB

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        // 表示保留下来的行星的坐标 + 1；
        int left = 1;
        int right = 1;
        int n = asteroids.length;
        while (right < n) {
            // 发生相撞
            if (left > 0 && (asteroids[left - 1] > 0 && asteroids[right] < 0)) {
                int le = Math.abs(asteroids[left - 1]);
                int ri = Math.abs(asteroids[right]);
                if (le == ri) {
                    left--;
                    right++;
                } else if (le > ri) {
                    right++;
                } else {
                    left--;
                }
            } else {
                asteroids[left++] = asteroids[right++];
            }
        }

        int[] ans = new int[left];
        for (int i = 0; i < left; i++) {
            ans[i] = asteroids[i];
        }

        return ans;
    }
}
```



## 相关话题

- [栈](https://leetcode.cn//tag/stack)
- [数组](https://leetcode.cn//tag/array)
- [模拟](https://leetcode.cn//tag/simulation)

## 相似题目


- [种花问题](../can-place-flowers/README.md)
