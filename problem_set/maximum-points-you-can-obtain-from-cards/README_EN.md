
| English | [简体中文](README.md) |

# [1423. Maximum Points You Can Obtain from Cards](https://leetcode.cn//problems/maximum-points-you-can-obtain-from-cards/)

## Description

<p>There are several cards <strong>arranged in a row</strong>, and each card has an associated number of points. The points are given in the integer array <code>cardPoints</code>.</p>

<p>In one step, you can take one card from the beginning or from the end of the row. You have to take exactly <code>k</code> cards.</p>

<p>Your score is the sum of the points of the cards you have taken.</p>

<p>Given the integer array <code>cardPoints</code> and the integer <code>k</code>, return the <em>maximum score</em> you can obtain.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [1,2,3,4,5,6,1], k = 3
<strong>Output:</strong> 12
<strong>Explanation:</strong> After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [2,2,2], k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Regardless of which two cards you take, your score will always be 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [9,7,7,9,7,7,9], k = 7
<strong>Output:</strong> 55
<strong>Explanation:</strong> You have to take all the cards. Your score is the sum of points of all cards.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cardPoints.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= cardPoints[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= cardPoints.length</code></li>
</ul>


## Solutions


### Java

```Java
// @Title: 可获得的最大点数 (Maximum Points You Can Obtain from Cards)
// @Author: robert.sunq
// @Date: 2023-12-03 18:25:20
// @Runtime: 5 ms
// @Memory: 54 MB

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // 通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值
        
        int n = cardPoints.length;
        int windowSize = n - k;

        int sum = 0;

        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        int minSum = sum;
        for (int i = windowSize; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }

        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
```



## Related Topics

- [Array](https://leetcode.cn//tag/array)
- [Prefix Sum](https://leetcode.cn//tag/prefix-sum)
- [Sliding Window](https://leetcode.cn//tag/sliding-window)

## Similar Questions

