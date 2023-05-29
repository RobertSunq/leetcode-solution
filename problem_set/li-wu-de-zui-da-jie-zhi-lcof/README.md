
| [English](README_EN.md) | 简体中文 |

# [剑指 Offer 47. 礼物的最大价值](https://leetcode.cn//problems/li-wu-de-zui-da-jie-zhi-lcof/)

## 题目描述

<p>在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 
<code>[
&nbsp; [1,3,1],
&nbsp; [1,5,1],
&nbsp; [4,2,1]
]</code>
<strong>输出:</strong> <code>12
</code><strong>解释:</strong> 路径 1&rarr;3&rarr;5&rarr;2&rarr;1 可以拿到最多价值的礼物</pre>

<p>&nbsp;</p>

<p>提示：</p>

<ul>
	<li><code>0 &lt; grid.length &lt;= 200</code></li>
	<li><code>0 &lt; grid[0].length &lt;= 200</code></li>
</ul>


## 题解


### Java

```Java
// @Title: 礼物的最大价值 (礼物的最大价值 LCOF)
// @Author: robert.sunq
// @Date: 2021-05-29 23:34:25
// @Runtime: 5 ms
// @Memory: 41.2 MB

class Solution {
    int max = 0;
    public int maxValue(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(i == 0 && j == 0){
                    temp[i][j] = grid[i][j];
                }else if(i == 0){
                    temp[i][j] = grid[i][j] + temp[i][j-1];
                }else if(j == 0){
                    temp[i][j] = grid[i][j] + temp[i-1][j];
                }else{
                    temp[i][j] = grid[i][j] + Math.max(temp[i-1][j],temp[i][j-1]);
                }
            }
        }
        return temp[grid.length-1][grid[0].length-1];
    }
}
```



## 相关话题

- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目


