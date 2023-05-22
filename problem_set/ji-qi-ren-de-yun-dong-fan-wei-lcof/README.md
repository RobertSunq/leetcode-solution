
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 13. 机器人的运动范围](https://leetcode.cn//problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

## 题目描述

<p>地上有一个m行n列的方格，从坐标 <code>[0,0]</code> 到坐标 <code>[m-1,n-1]</code> 。一个机器人从坐标 <code>[0, 0] </code>的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>m = 2, n = 3, k = 1
<strong>输出：</strong>3
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>m = 3, n = 1, k = 0
<strong>输出：</strong>1
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n,m &lt;= 100</code></li>
	<li><code>0 &lt;= k&nbsp;&lt;= 20</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 机器人的运动范围 (机器人的运动范围  LCOF)
// @Author: robert.sunq
// @Date: 2021-05-25 21:45:20
// @Runtime: 1 ms
// @Memory: 35.3 MB

class Solution {

    int maxStep = 0;
    public int movingCount(int m, int n, int k) {
        // 默认值为 0
        boolean[][] stage = new boolean[m][n];
        recur(stage,0,0,k);  
        return maxStep;  
    }

    public void recur(boolean[][] stage , int row , int col,int k){
        if(row < 0 || row >= stage.length || col < 0 
        || col >= stage[0].length || stage[row][col] || sum(row,col) > k) return;
        maxStep++;
        // 标志位设置为 true 表示来到
        stage[row][col] = true;
        recur(stage,row-1,col,k);
        recur(stage,row+1,col,k);
        recur(stage,row,col-1,k);
        recur(stage,row,col+1,k);
        return;
    }
    


    // 计算数位之和
    public int sum(int row , int col){
        int result = 0;
        while(row > 0){
            result = result + (row % 10);
            row = row/10;
        }
        while(col > 0){
            result = result + (col % 10);
            col = col/10;
        }
        return result;
    }
}
```



## 相关话题

- [深度优先搜索](https://leetcode.cn//tag/depth-first-search)
- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)

## 相似题目



