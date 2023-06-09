
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 14- I. 剪绳子](https://leetcode.cn//problems/jian-sheng-zi-lcof/)

## 题目描述

<p>给你一根长度为 <code>n</code> 的绳子，请把绳子剪成整数长度的 <code>m</code> 段（m、n都是整数，n&gt;1并且m&gt;1），每段绳子的长度记为 <code>k[0],k[1]...k[m-1]</code> 。请问 <code>k[0]*k[1]*...*k[m-1]</code> 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入: </strong>2
<strong>输出: </strong>1
<strong>解释: </strong>2 = 1 + 1, 1 &times; 1 = 1</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入: </strong>10
<strong>输出: </strong>36
<strong>解释: </strong>10 = 3 + 3 + 4, 3 &times;&nbsp;3 &times;&nbsp;4 = 36</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 58</code></li>
</ul>

<p>注意：本题与主站 343 题相同：<a href="https://leetcode-cn.com/problems/integer-break/">https://leetcode-cn.com/problems/integer-break/</a></p>


## 题解


### Java

```Java
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 22:22:22
// @Runtime: 1 ms
// @Memory: 35.1 MB

class Solution {
    public int cuttingRope(int n) {
        if(n<3) return 1;
        int[] dp = new int[n+1];
        dp[1]=1;dp[2]=1;
        for (int i = 3;i<=n;i++){
            for (int j = 2 ;j<i;j++){
                // 及长度为i是，最大长度应该是 (i-j) 还是 （j*dp[i-j]）绳子长为i-j的最大值 还是当前剪j不是最优解
                dp[i] = Math.max(dp[i],Math.max((j*(i-j)) ,(j*dp[i-j])));
            }
        }
        return dp[n];
    }
}
```



### C++

```C++
// @Title: 剪绳子 (剪绳子  LCOF)
// @Author: robert.sunq
// @Date: 2020-05-14 13:25:51
// @Runtime: 0 ms
// @Memory: 5.9 MB

class Solution {
public:
    int cuttingRope(int n) {
        vector <int> dp(n+1,0);
        if(n<3) return 1;
        dp[0] = 1;
        for(int i=1;i<=(n+1)/2;i++){
            for(int j=i;j<=n;j++)
                {   
                    dp[j] = max(dp[j],dp[j-i]*i);
                }
        }
        return dp[n];
    }
};
```



## 相关话题

- [数学](https://leetcode.cn//tag/math)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



