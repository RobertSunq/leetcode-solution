
| English | [简体中文](README.md) |

# [338. Counting Bits](https://leetcode.cn//problems/counting-bits/)

## Description

<p>Given an integer <code>n</code>, return <em>an array </em><code>ans</code><em> of length </em><code>n + 1</code><em> such that for each </em><code>i</code><em> </em>(<code>0 &lt;= i &lt;= n</code>)<em>, </em><code>ans[i]</code><em> is the <strong>number of </strong></em><code>1</code><em><strong>&#39;s</strong> in the binary representation of </em><code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> [0,1,1]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> [0,1,1,2,1,2]
<strong>Explanation:</strong>
0 --&gt; 0
1 --&gt; 1
2 --&gt; 10
3 --&gt; 11
4 --&gt; 100
5 --&gt; 101
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>It is very easy to come up with a solution with a runtime of <code>O(n log n)</code>. Can you do it in linear time <code>O(n)</code> and possibly in a single pass?</li>
	<li>Can you do it without using any built-in function (i.e., like <code>__builtin_popcount</code> in C++)?</li>
</ul>


## Solutions


### Java

```Java
// @Title: 比特位计数 (Counting Bits)
// @Author: robert.sunq
// @Date: 2021-06-20 00:32:51
// @Runtime: 2 ms
// @Memory: 42.3 MB

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            // 奇数的一个数，是其前一个1个数 + 1
            if(i % 2 == 1){
                dp[i] = dp[i-1]+1;
            }else{
                // 偶数的一的个数  与 其右移后一的个数相同， 因为出去了最后的0
                dp[i] = dp[i>>1];
            }
        }
        return dp;
    }
}
```



## Related Topics

- [Bit Manipulation](https://leetcode.cn//tag/bit-manipulation)
- [Dynamic Programming](https://leetcode.cn//tag/dynamic-programming)

## Similar Questions

- [Number of 1 Bits](../number-of-1-bits/README_EN.md)
