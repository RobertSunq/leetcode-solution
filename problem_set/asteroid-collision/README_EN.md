
| English | [简体中文](README.md) |

# [735. Asteroid Collision](https://leetcode.cn//problems/asteroid-collision/)

## Description

<p>We are given an array <code>asteroids</code> of integers representing asteroids in a row.</p>

<p>For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.</p>

<p>Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> asteroids = [5,10,-5]
<strong>Output:</strong> [5,10]
<strong>Explanation:</strong> The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> asteroids = [8,-8]
<strong>Output:</strong> []
<strong>Explanation:</strong> The 8 and -8 collide exploding each other.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> asteroids = [10,2,-5]
<strong>Output:</strong> [10]
<strong>Explanation:</strong> The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= asteroids.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= asteroids[i] &lt;= 1000</code></li>
	<li><code>asteroids[i] != 0</code></li>
</ul>


## Solutions


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



## Related Topics

- [Stack](https://leetcode.cn//tag/stack)
- [Array](https://leetcode.cn//tag/array)
- [Simulation](https://leetcode.cn//tag/simulation)

## Similar Questions

- [Can Place Flowers](../can-place-flowers/README_EN.md)
