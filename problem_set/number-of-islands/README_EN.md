
| English | [简体中文](README.md) |

# [200. Number of Islands](https://leetcode.cn//problems/number-of-islands/)

## Description

<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>&#39;1&#39;</code>s (land) and <code>&#39;0&#39;</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  [&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;1&quot;]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>grid[i][j]</code> is <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>


## Solutions


### Java

```Java
// @Title: 岛屿数量 (Number of Islands)
// @Author: robert.sunq
// @Date: 2021-06-15 23:40:15
// @Runtime: 2 ms
// @Memory: 41.1 MB

class Solution {
    public int numIslands(char[][] grid) {
        int cur = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    cur++;
                    recur(grid,i,j);
                }
            }
        }
        return cur;
    }

    /**
        将dps访问到的点这是为海，这样一个“岛”就只放问一次
     */
    public void recur(char[][] grid,int i,int j){
        if(i < 0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] == '0') return ;
        // 将陆地设置为海
        grid[i][j] = '0';
        // 访问四周可以访问的点
        recur(grid,i-1,j);
        recur(grid,i,j-1);
        recur(grid,i+1,j);
        recur(grid,i,j+1);
    }
}
```



## Related Topics

- [Depth-First Search](https://leetcode.cn//tag/depth-first-search)
- [Breadth-First Search](https://leetcode.cn//tag/breadth-first-search)
- [Union Find](https://leetcode.cn//tag/union-find)
- [Array](https://leetcode.cn//tag/array)
- [Matrix](https://leetcode.cn//tag/matrix)

## Similar Questions

- [Surrounded Regions](../surrounded-regions/README_EN.md)
- [Walls and Gates](../walls-and-gates/README_EN.md)
- [Number of Islands II](../number-of-islands-ii/README_EN.md)
- [Number of Connected Components in an Undirected Graph](../number-of-connected-components-in-an-undirected-graph/README_EN.md)
- [Number of Distinct Islands](../number-of-distinct-islands/README_EN.md)
- [Max Area of Island](../max-area-of-island/README_EN.md)
