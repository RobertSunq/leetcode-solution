
| English | [简体中文](README.md) |

# [374. Guess Number Higher or Lower](https://leetcode.cn//problems/guess-number-higher-or-lower/)

## Description

<p>We are playing the Guess Game. The game is as follows:</p>

<p>I pick a number from <code>1</code> to <code>n</code>. You have to guess which number I picked.</p>

<p>Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.</p>

<p>You call a pre-defined API <code>int guess(int num)</code>, which returns three possible results:</p>

<ul>
	<li><code>-1</code>: Your guess is higher than the number I picked (i.e. <code>num &gt; pick</code>).</li>
	<li><code>1</code>: Your guess is lower than the number I picked (i.e. <code>num &lt; pick</code>).</li>
	<li><code>0</code>: your guess is equal to the number I picked (i.e. <code>num == pick</code>).</li>
</ul>

<p>Return <em>the number that I picked</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10, pick = 6
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1, pick = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 2, pick = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>1 &lt;= pick &lt;= n</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 猜数字大小 (Guess Number Higher or Lower)
// @Author: robert.sunq
// @Date: 2023-09-16 16:38:09
// @Runtime: 0 ms
// @Memory: 38 MB

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int ans;
        while (true) {
            ans = left + (right - left) / 2;
            int tmp = guess(ans);
            if (tmp == 0) {
                break;
            } else if (tmp < 0) {
                right = ans - 1;
            } else {
                left = ans + 1;
            }
        }
        return ans;
    }
}
```



## Related Topics

- [Binary Search](https://leetcode.cn//tag/binary-search)
- [Interactive](https://leetcode.cn//tag/interactive)

## Similar Questions

- [First Bad Version](../first-bad-version/README_EN.md)
- [Guess Number Higher or Lower II](../guess-number-higher-or-lower-ii/README_EN.md)
- [Find K Closest Elements](../find-k-closest-elements/README_EN.md)
