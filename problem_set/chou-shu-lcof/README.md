
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 49. 丑数](https://leetcode.cn//problems/chou-shu-lcof/)

## 题目描述

<p>我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> n = 10
<strong>输出:</strong> 12
<strong>解释: </strong><code>1, 2, 3, 4, 5, 6, 8, 9, 10, 12</code> 是前 10 个丑数。</pre>

<p><strong>说明:&nbsp;</strong>&nbsp;</p>

<ol>
	<li><code>1</code>&nbsp;是丑数。</li>
	<li><code>n</code>&nbsp;<strong>不超过</strong>1690。</li>
</ol>

<p>注意：本题与主站 264 题相同：<a href="https://leetcode-cn.com/problems/ugly-number-ii/">https://leetcode-cn.com/problems/ugly-number-ii/</a></p>


## 题解


### Java

```Java
// @Title: 丑数 (丑数 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 01:19:59
// @Runtime: 2 ms
// @Memory: 37.7 MB

class Solution {
    public int nthUglyNumber(int n) {
        // t2,t3,t5 表示乘数对应的前一个数
        int i = 1,t2 = 0,t3=0,t5 = 0;
        int a , b , c;
        int[] dp = new int[n+1];
        dp[0] = 1;
        while(i<n){
            a = dp[t2]*2;
            b = dp[t3]*3;
            c = dp[t5]*5;
            // 如果乘2 最小，则指针后移
            dp[i] = Math.min(Math.min(a, b), c);
            // 采用连续的If而不是  if else 的原因在于 相等的时候，都往各自的标志位均往后移动，避免重复计算
            if(dp[i] == a) t2++;
            if(dp[i] == b) t3++;
            if(dp[i] == c) t5++;
            i++;
        }
        return dp[n-1];
    }
}
```



## 相关话题

- [哈希表](https://leetcode.cn//tag/hash-table)
- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [堆（优先队列）](https://leetcode.cn//tag/heap-priority-queue)

## 相似题目



