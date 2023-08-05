
| [English](README_EN.md) | 简体中文 |

# [LCR 107. 01 矩阵](https://leetcode.cn//problems/2bCMpM/)

## 题目描述

<p>给定一个由 <code>0</code> 和 <code>1</code> 组成的矩阵 <code>mat</code>&nbsp;，请输出一个大小相同的矩阵，其中每一个格子是 <code>mat</code> 中对应位置元素到最近的 <code>0</code> 的距离。</p>

<p>两个相邻元素间的距离为 <code>1</code> 。</p>

<p>&nbsp;</p>

<p><b>示例 1：</b></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626667201-NCWmuP-image.png" style="width: 150px; " /></p>

<pre>
<strong>输入：</strong>mat =<strong> </strong>[[0,0,0],[0,1,0],[0,0,0]]
<strong>输出：</strong>[[0,0,0],[0,1,0],[0,0,0]]
</pre>

<p><b>示例 2：</b></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626667205-xFxIeK-image.png" style="width: 150px; " /></p>

<pre>
<b>输入：</b>mat =<b> </b>[[0,0,0],[0,1,0],[1,1,1]]
<strong>输出：</strong>[[0,0,0],[0,1,0],[1,2,1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
	<li><code>mat[i][j] is either 0 or 1.</code></li>
	<li><code>mat</code> 中至少有一个 <code>0&nbsp;</code></li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 542&nbsp;题相同：<a href="https://leetcode-cn.com/problems/01-matrix/">https://leetcode-cn.com/problems/01-matrix/</a></p>


## 题解


### Java

```Java
// @Title: 01 矩阵 (01 矩阵)
// @Author: robert.sunq
// @Date: 2023-08-04 00:44:54
// @Runtime: 1928 ms
// @Memory: 46.2 MB

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[][] move = {{-1, 0},{0, -1},{ 1, 0},{0, 1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int mo = 0; mo < 4; mo++) {
                            int ii = cur[0] + move[mo][0];
                            int jj = cur[1] + move[mo][1];
                            if (ii < n && ii >= 0 && jj < m && jj >= 0) {
                                if (ans[ii][jj] > ans[cur[0]][cur[1]] + 1) {
                                    ans[ii][jj] = ans[cur[0]][cur[1]] + 1;
                                    q.offer(new int[]{ii,jj});
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
```



## 相关话题

- [广度优先搜索](https://leetcode.cn//tag/breadth-first-search)
- [数组](https://leetcode.cn//tag/array)
- [动态规划](https://leetcode.cn//tag/dynamic-programming)
- [矩阵](https://leetcode.cn//tag/matrix)

## 相似题目



