
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 63. 股票的最大利润](https://leetcode.cn//problems/gu-piao-de-zui-da-li-run-lcof/)

## 题目描述

<p>假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [7,1,5,3,6,4]
<strong>输出:</strong> 5
<strong>解释: </strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> [7,6,4,3,1]
<strong>输出:</strong> 0
<strong>解释: </strong>在这种情况下, 没有交易完成, 所以最大利润为 0。</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>0 &lt;= 数组长度 &lt;= 10^5</code></p>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 121 题相同：<a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/</a></p>


## 题解


### Java

```Java
// @Title: 股票的最大利润 (股票的最大利润  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-30 23:35:31
// @Runtime: 2 ms
// @Memory: 38.3 MB

class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        if(prices.length < 1) return 0;
        // 前几日最低股价
        int min = prices[0];
        dp[0] = 0;
        for(int i = 1;i<prices.length;i++){
            dp[i] = Math.max(dp[i-1],prices[i]-min);
            // 前几日的最低股价
            min = Math.min(min,prices[i]);
        }
        return dp[prices.length -1];
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



