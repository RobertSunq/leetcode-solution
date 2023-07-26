
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer II 091. 粉刷房子](https://leetcode.cn//problems/JEj789/)

## 题目描述

<p>假如有一排房子，共 <code>n</code> 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。</p>

<p>当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个&nbsp;<code>n x 3</code><em>&nbsp;</em>的正整数矩阵 <code>costs</code> 来表示的。</p>

<p>例如，<code>costs[0][0]</code> 表示第 0 号房子粉刷成红色的成本花费；<code>costs[1][2]</code>&nbsp;表示第 1 号房子粉刷成绿色的花费，以此类推。</p>

<p>请计算出粉刷完所有房子最少的花费成本。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>costs = [[17,2,17],[16,16,5],[14,3,19]]
<strong>输出: </strong>10
<strong>解释: </strong>将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色<strong>。</strong>
&nbsp;    最少花费: 2 + 5 + 3 = 10。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入: </strong>costs = [[7,6,2]]
<strong>输出: 2</strong>
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>costs.length == n</code></li>
	<li><code>costs[i].length == 3</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= costs[i][j] &lt;= 20</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 256&nbsp;题相同：<a href="https://leetcode-cn.com/problems/paint-house/">https://leetcode-cn.com/problems/paint-house/</a></p>


## 题解


### Java

```Java
// @Title: 粉刷房子 (粉刷房子)
// @Author: robert.sunq
// @Date: 2023-07-26 23:51:56
// @Runtime: 0 ms
// @Memory: 40.3 MB

class Solution {
    public int minCost(int[][] costs) {

        // 当前颜色涂为 红， 则从前面的颜色中选取低的一个涂色

        // 分别保存前一节房子涂抹颜色的最低价
        int[] cost = new int[3];
        cost[0] = costs[0][0];
        cost[1] = costs[0][1];
        cost[2] = costs[0][2];

        int n = costs.length;
        for (int i = 1; i < n; i++) {

            // 注意要先给与临时变量，最后赋值，避免下一个颜色计算被上一个的结果干扰
            // 红
            int tmp0 = Math.min(cost[1], cost[2]) + costs[i][0];
            // 蓝
            int tmp1 = Math.min(cost[0], cost[2]) + costs[i][1];
            // 绿
            int tmp2 = Math.min(cost[0], cost[1]) + costs[i][2];

            // 注意，
            cost[0] = tmp0;
            cost[1] = tmp1;
            cost[2] = tmp2;
        }


        return Math.min(Math.min(cost[0], cost[1]), cost[2]);
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



